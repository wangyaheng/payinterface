package mq;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;

import com.lefu.commons.utils.lang.JsonUtils;



/**
 * RSAUtils - 对RSA 签名&验签/分段加密&分段解密 的包装
 * 签名算法: "SHA1withRSA", 私钥进行签名; 公钥进行验签.
 * 加密算法: "RSA/ECB/PKCS1Padding", 公钥进行加密; 私钥进行解密.
 * [PrivKey]是自己的私钥, 自己的公钥给通信对方.
 * [PubKey]是对方的公钥, 对方的私钥在对方那边.
 * 为了方便, 这里假定双方的密钥长度一致, 签名和加密的规则也一致.
 * 以`Base64Str`结尾的参数表示内容是Base64编码的字符串, 其他情况都是raw字符串.
 * @author sangechen
 */
public class RSAUtils {
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(RSAUtils.class);

	public static final String KEY_ALGORITHM = "RSA";
	public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
	public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding"; // 加密block需要预留11字节
	public static final int KEYBIT = 2048;
	public static final int RESERVEBYTES = 11;
	private static KeyFactory keyFactory;
	private static Signature signature;
	//private static Cipher cipher;

	private static int encryptBlock;
	private static int decryptBlock;
	private static PrivateKey localPrivKey;
	private static PublicKey peerPubKey;

	static {
		try {
			keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
			signature = Signature.getInstance(SIGNATURE_ALGORITHM);
			//cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			decryptBlock = KEYBIT / 8; // 256 bytes
			encryptBlock = decryptBlock - RESERVEBYTES; // 245 bytes
		} catch (Exception e) {
			logger.error("初始化加密数据失败");
		}
	}

	/**
	 * 签名
	 * @param plaintext 要签名的字符串
	 * @param privateKey 私钥
	 * @return 返回签名后的结果
	 * @throws UnsupportedEncodingException 异常
	 */
	public static String sign(String plaintext) throws UnsupportedEncodingException {
		String signBase64Str = "";
		try {

			// 载入秘钥
			signature.initSign(localPrivKey);
			signature.update(plaintext.getBytes("GBK"));
			// base64编码
			signBase64Str = Base64.encodeBase64String(signature.sign());
		} catch (Exception e) {
			logger.error("签名异常", e);
		}
		return signBase64Str;
	}

	/**
	 * 验签
	 * @param plaintext 验签的字符串
	 * @param signBase64Str验签的签名
	 * @param publicKey 公钥
	 * @return 验证成功或失败
	 * @throws UnsupportedEncodingException 异常
	 */
	public static boolean verify(String plaintext, String signBase64Str) throws UnsupportedEncodingException {
		boolean isValid = false;
		try {
			// 载入公钥
			signature.initVerify(peerPubKey);
			signature.update(plaintext.getBytes("GBK"));
			// 执行验签函数及base64解码
			isValid = signature.verify(Base64.decodeBase64(signBase64Str));
		} catch (Exception e) {
			logger.error("验签异常", e);
		}
		return isValid;
	}

	/**
	 * 加密
	 * @param str_data 加密字符串
	 * @param publicKey 公钥
	 * @return 加密后的密文
	 * @throws UnsupportedEncodingException异常
	 */
	public static String encrypt(String str_data) throws Exception {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			DeflaterOutputStream zos = new DeflaterOutputStream(bos);
			zos.write(str_data.getBytes("GBK"));
			zos.close();
			byte[] data = bos.toByteArray();
			// 计算分段加密的block数 (向上取整)
			int nBlock = (data.length / encryptBlock);
			if ((data.length % encryptBlock) != 0) // 余数非0block数再加1
			{
				nBlock += 1;
			}
			// 输出buffer, 大小为nBlock个decryptBlock
			ByteArrayOutputStream outbuf = new ByteArrayOutputStream(nBlock * decryptBlock);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, peerPubKey);
			// 分段加密
			for (int offset = 0; offset < data.length; offset += encryptBlock) {
				// block大小: encryptBlock 或 剩余字节数
				int inputLen = (data.length - offset);
				if (inputLen > encryptBlock) {
					inputLen = encryptBlock;
				}
				// 得到分段加密结果
				byte[] encryptedBlock = cipher.doFinal(data, offset, inputLen);
				// 追加结果到输出buffer中
				outbuf.write(encryptedBlock);
			}
			return Base64.encodeBase64String(outbuf.toByteArray()); // ciphertext
		} catch (Exception e) {
			logger.error("加密异常", e);
			throw new Exception(e);
		}

	}

	/**
	 * 解密
	 * @param cryptedBase64Str 解密密文
	 * @param localPrivKey 私钥
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String cryptedBase64Str) throws Exception {
		// 转换得到字节流
		byte[] data = Base64.decodeBase64(cryptedBase64Str);
		// 计算分段解密的block数 (理论上应该能整除)
		int nBlock = (data.length / decryptBlock);
		// 输出buffer, , 大小为nBlock个encryptBlock
		ByteArrayOutputStream outbuf = new ByteArrayOutputStream(nBlock * encryptBlock);
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, localPrivKey);
			// 分段解密
			for (int offset = 0; offset < data.length; offset += decryptBlock) {
				// block大小: decryptBlock 或 剩余字节数
				int inputLen = (data.length - offset);
				if (inputLen > decryptBlock) {
					inputLen = decryptBlock;
				}
				// 得到分段解密结果
				byte[] decryptedBlock = cipher.doFinal(data, offset, inputLen);
				// 追加结果到输出buffer中
				outbuf.write(decryptedBlock);
			}
			outbuf.flush();// ---写完成后，需要刷新缓冲区，并且关闭缓冲
			outbuf.close();
		} catch (Exception e) {
			logger.error("解密异常", e);
			throw new Exception(e);
		}

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		InflaterOutputStream zos = new InflaterOutputStream(bos);
		try {
			zos.write(outbuf.toByteArray());
			zos.close();
			return new String(bos.toByteArray(), "GBK");
		} catch (IOException e) {
			logger.error("解密异常", e);

		}
		return null;
	}

	public static void main(String[] args) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(20);
		CyclicBarrier cyclicBarrier = new CyclicBarrier(19);
		String str = "dKJnEZI4/8EfPuedVjEWi/zauQkHnhDIFxEoXDeIzAvKdcWQs0KIvDAxIaUMnLP0K9KwdhCZpPnum1a3YspdKmJoQ5o1BXOKfSi/kL2Yfk/Qv3cHzOUXV5mdSCGTuQKkdu63JXF5SqkRMtadeonjc5YYWBqh2D+YQ1Ts07GjNZgQq9481+SaOM1dP6vDait/amJBbLSQT3joljw6c07ZEsaP+HfTsiDzczdUJuPcsPhN0PLareW3Lo9xFcttdJuBjRuFu/4sldoRRQsadfni6Li+GAfb9+5UoB2QmQ0FZHaYMfThGU2rTdqWWpxwcWvGB5kGSLpxgG/7XmugGR5KCSD63z7bKSMzt4995LBmN2HF0LNZW/l05XAMhnIZEpmJSQTo33wZWfbHg5QKBj78uuBC6NjWrWcPAf2tM9drSJg8VxNq3/vECxCjQrJdElJhmJpAW2xg7MV1aDphUs/fqvS5CKrnuEJBCS3bp5WOd/QUEnotMiUpghTDrEHkq1gwnJGGCaMyrxjQzRi8yz7Nnlxa7YSJ+g5xY58lzNWCPmt/f9JRmOfjZqtH7yhjmiZVNsqHWYPNTTJ5eCd5ZnMcf0bZaJstkYI/72Jgl5+gPjIwcvRS+lfVl9ypPLrEtjrkpnwHBJIr77RLvDhFkOEJRCPMnbiGCCRCcoDUl9JnG8W5zew/HM1k528YV9WhQAeRaWiVyhEdDiRLx6X8vlLAudp0hJkRPvolf/WZjwXvwHbG/xFmJ41ao92ezMmGjRrPlfKHPGe9w/3XIh/6y2FkTanuJ25CgAfbq44DxV5rR/lz+K4BLjehQbsjhYjZtJPzUzn1gTngBoMj5FKOUxA8RHNG8Vor/uX2O63OjZ+HKmo8j2RRmFRN76RghcskoK/zwjK3zKrxQ4aMHXglDTPYFlqcSIkIkr1oV3QP3jeZTePUI7PcbmOlVOvCeqge5tb2PeH8cJrXp0wl33vzlk6CEai4quewmuvG+Pj1Wwl+kxydBZJwoxsUw0Kkm+CmMRwY";
		initKey("C:/Users/hasee/Desktop/pkcs8.pem", "C:/Users/hasee/Desktop/rsa_2048_pub.pem");
		try {
			String encrypt = RSAUtils.encrypt(JsonUtils.toJsonString(str));
			System.out.println(encrypt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			for(int i=0;i<19;i++){
				newFixedThreadPool.execute(new EnTask(cyclicBarrier));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	/**
	 * 初始化自己的私钥
	 * `openssl genrsa -out rsa_2048.key 2048` #指定生成的密钥的位数: 2048
	 * `openssl pkcs8 -topk8 -inform PEM -in rsa_2048.key -outform PEM -nocrypt -out pkcs8.txt` #for Java 转换成PKCS#8编码
	 * `openssl rsa -in rsa_2048.key -pubout -out rsa_2048_pub.key` #导出pubkey
	 * @param privKeyPath 私钥路径
	 * @param pubKeyPath 公钥路径
	 * @param keysize 密钥长度, 默认2048
	 */
	public static void initKey(String privKeyPath, String pubKeyPath) {

		if (localPrivKey == null || peerPubKey == null) {
			logger.info("privKeyPath,{} privKeyPath,{}", privKeyPath, pubKeyPath);
			// 读取私钥
			localPrivKey = initPrivateKey(privKeyPath);
			// 读取公钥
			peerPubKey = initPublicKey(pubKeyPath);
		}
	}

	/**
	 * 读取私钥
	 */
	private static PrivateKey initPrivateKey(String privKeyPath) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(privKeyPath));
			String s = br.readLine();
			StringBuffer privatekey = new StringBuffer();
			s = br.readLine();
			while (s.charAt(0) != '-') {
				privatekey.append(s + "\r");
				s = br.readLine();
			}
			BASE64Decoder base64decoder = new BASE64Decoder();
			byte[] keybyte = base64decoder.decodeBuffer(privatekey.toString());
			KeyFactory kf = KeyFactory.getInstance("RSA");
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keybyte);

			return kf.generatePrivate(keySpec);
		} catch (Exception e) {
			logger.error("初始化私钥异常", e);

		}
		return null;
	}

	/**
	 * 读取公钥
	 */
	private static PublicKey initPublicKey(String pubKeyPath) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(pubKeyPath));
			String s = br.readLine();
			StringBuffer publickey = new StringBuffer();
			s = br.readLine();
			while (s.charAt(0) != '-') {
				publickey.append(s + "\r");
				s = br.readLine();
			}
			BASE64Decoder base64decoder = new BASE64Decoder();
			byte[] keybyte = base64decoder.decodeBuffer(publickey.toString());
			KeyFactory kf = KeyFactory.getInstance("RSA");
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keybyte);
			return kf.generatePublic(keySpec);
		} catch (Exception e) {
			logger.error("初始化公钥异常", e);
		}
		return null;
	}
}
