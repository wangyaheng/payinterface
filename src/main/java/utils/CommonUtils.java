package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * ʵ����֤������
 * @author congxiang.bai
 * @since 2015��7��7��
 */
public class CommonUtils {

	/** ���ַ����м䲿���滻��*�� */
	public static String replaceWithStar(String str, int start, int end) {
		String startValue = str.substring(0, start);
		String middleValue = str.substring(start, end).replaceAll("\\d", "*");
		String endValue = str.substring(end);
		return startValue + middleValue + endValue;
	}

	/**
	 * ����
	 * @param value ԭ�Ĵ�
	 * @param start ��ʼλ��
	 * @param end ��ֹλ��
	 * @return ���Ĵ�
	 */
	public static String encrypt(String value) {
		String key = "908";
		return AESUtil.encryptToHex(value, key);
	}

	/**
	 * ����
	 * @param value ���Ĵ�
	 * @return ԭ�Ĵ�
	 */
	public static String deEncrypt(String value) {
		String key = "908";
		return AESUtil.decryptByHex(value, key);
	}

	/**
	 * ���ż���
	 * @param cardNo ����
	 */
	public static Map<String, String> cardNoEncrypt(String cardNo) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("bankCardNo", replaceWithStar(cardNo, 4, cardNo.length() - 4));
		map.put("bankCardNoEncrypt", encrypt(cardNo));
		return map;
	}

	/**
	 * ���֤����
	 * @param certNo ���֤��
	 */
	public static Map<String, String> certNoEncrypt(String certNo) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("certNo", replaceWithStar(certNo, 6, 14));
		map.put("certNoEncrypt", encrypt(certNo));
		return map;
	}
}
