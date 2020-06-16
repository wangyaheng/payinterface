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

 * ��`Base64Str`��β�Ĳ�����ʾ������Base64������ַ���, �����������raw�ַ���.
 * @author sangechen
 */
public class RSAUtils {
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(RSAUtils.class);

	public static final String KEY_ALGORITHM = "RSA";
	public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
	public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding"; // ����block��ҪԤ��11�ֽ�
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
			logger.error("��ʼ����������ʧ��");
		}
	}

	/**
	 * ǩ��
	 * @param plaintext Ҫǩ�����ַ���
	 * @param privateKey ˽Կ
	 * @return ����ǩ����Ľ��
	 * @throws UnsupportedEncodingException �쳣
	 */
	public static String sign(String plaintext) throws UnsupportedEncodingException {
		String signBase64Str = "";
		try {

			// ������Կ
			signature.initSign(localPrivKey);
			signature.update(plaintext.getBytes("GBK"));
			// base64����
			signBase64Str = Base64.encodeBase64String(signature.sign());
		} catch (Exception e) {
			logger.error("ǩ���쳣", e);
		}
		return signBase64Str;
	}

	/**
	 * ��ǩ
	 * @param plaintext ��ǩ���ַ���
	 * @param signBase64Str��ǩ��ǩ��
	 * @param publicKey ��Կ
	 * @return ��֤�ɹ���ʧ��
	 * @throws UnsupportedEncodingException �쳣
	 */
	public static boolean verify(String plaintext, String signBase64Str) throws UnsupportedEncodingException {
		boolean isValid = false;
		try {
			// ���빫Կ
			signature.initVerify(peerPubKey);
			signature.update(plaintext.getBytes("GBK"));
			// ִ����ǩ������base64����
			isValid = signature.verify(Base64.decodeBase64(signBase64Str));
		} catch (Exception e) {
			logger.error("��ǩ�쳣", e);
		}
		return isValid;
	}

	/**
	 * ����
	 * @param str_data �����ַ���
	 * @param publicKey ��Կ
	 * @return ���ܺ������
	 * @throws UnsupportedEncodingException�쳣
	 */
	public static String encrypt(String str_data) throws Exception {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			DeflaterOutputStream zos = new DeflaterOutputStream(bos);
			zos.write(str_data.getBytes("GBK"));
			zos.close();
			byte[] data = bos.toByteArray();
			// ����ֶμ��ܵ�block�� (����ȡ��)
			int nBlock = (data.length / encryptBlock);
			if ((data.length % encryptBlock) != 0) // ������0block���ټ�1
			{
				nBlock += 1;
			}
			// ���buffer, ��СΪnBlock��decryptBlock
			ByteArrayOutputStream outbuf = new ByteArrayOutputStream(nBlock * decryptBlock);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, peerPubKey);
			// �ֶμ���
			for (int offset = 0; offset < data.length; offset += encryptBlock) {
				// block��С: encryptBlock �� ʣ���ֽ���
				int inputLen = (data.length - offset);
				if (inputLen > encryptBlock) {
					inputLen = encryptBlock;
				}
				// �õ��ֶμ��ܽ��
				byte[] encryptedBlock = cipher.doFinal(data, offset, inputLen);
				// ׷�ӽ�������buffer��
				outbuf.write(encryptedBlock);
			}
			return Base64.encodeBase64String(outbuf.toByteArray()); // ciphertext
		} catch (Exception e) {
			logger.error("�����쳣", e);
			throw new Exception(e);
		}

	}

	/**
	 * ����
	 * @param cryptedBase64Str ��������
	 * @param localPrivKey ˽Կ
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String cryptedBase64Str) throws Exception {
		// ת���õ��ֽ���
		byte[] data = Base64.decodeBase64(cryptedBase64Str);
		// ����ֶν��ܵ�block�� (������Ӧ��������)
		int nBlock = (data.length / decryptBlock);
		// ���buffer, , ��СΪnBlock��encryptBlock
		ByteArrayOutputStream outbuf = new ByteArrayOutputStream(nBlock * encryptBlock);
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, localPrivKey);
			// �ֶν���
			for (int offset = 0; offset < data.length; offset += decryptBlock) {
				// block��С: decryptBlock �� ʣ���ֽ���
				int inputLen = (data.length - offset);
				if (inputLen > decryptBlock) {
					inputLen = decryptBlock;
				}
				// �õ��ֶν��ܽ��
				byte[] decryptedBlock = cipher.doFinal(data, offset, inputLen);
				// ׷�ӽ�������buffer��
				outbuf.write(decryptedBlock);
			}
			outbuf.flush();// ---д��ɺ���Ҫˢ�»����������ҹرջ���
			outbuf.close();
		} catch (Exception e) {
			logger.error("�����쳣", e);
			throw new Exception(e);
		}

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		InflaterOutputStream zos = new InflaterOutputStream(bos);
		try {
			zos.write(outbuf.toByteArray());
			zos.close();
			return new String(bos.toByteArray(), "GBK");
		} catch (IOException e) {
			logger.error("�����쳣", e);

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
	 * ��ʼ���Լ���˽Կ
	 * `openssl genrsa -out rsa_2048.key 2048` #ָ�����ɵ���Կ��λ��: 2048
	 * `openssl pkcs8 -topk8 -inform PEM -in rsa_2048.key -outform PEM -nocrypt -out pkcs8.txt` #for Java ת����PKCS#8����
	 * `openssl rsa -in rsa_2048.key -pubout -out rsa_2048_pub.key` #����pubkey
	 * @param privKeyPath ˽Կ·��
	 * @param pubKeyPath ��Կ·��
	 * @param keysize ��Կ����, Ĭ��2048
	 */
	public static void initKey(String privKeyPath, String pubKeyPath) {

		if (localPrivKey == null || peerPubKey == null) {
			logger.info("privKeyPath,{} privKeyPath,{}", privKeyPath, pubKeyPath);
			// ��ȡ˽Կ
			localPrivKey = initPrivateKey(privKeyPath);
			// ��ȡ��Կ
			peerPubKey = initPublicKey(pubKeyPath);
		}
	}

	/**
	 * ��ȡ˽Կ
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
			logger.error("��ʼ��˽Կ�쳣", e);

		}
		return null;
	}

	/**
	 * ��ȡ��Կ
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
			logger.error("��ʼ����Կ�쳣", e);
		}
		return null;
	}
}
