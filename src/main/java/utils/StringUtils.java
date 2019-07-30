package utils;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

/**
 * �ַ�������������
 * @author rui.wang
 * @since 2013��9��5��
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

	/**
	 * ���л��ַ���
	 * @param string �ַ���
	 * @return ���л�����ֽ�����
	 */
	public static byte[] serialize(final String string, final Charset charset) {
		return (string == null ? null : string.getBytes(charset));
	}

	/**
	 * �����л��ַ���
	 * @param bytes ���л��ֽ�����
	 * @return �����л�����ַ���
	 */
	public static String deserialize(final byte[] bytes, final Charset charset) {
		return (bytes == null ? null : new String(bytes, charset));
	}

	/**
	 * �ж�str��Ϊnull��Ϊ""
	 * @param str
	 * @return
	 */
	public static boolean notEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * �ж�str��Ϊnull��Ϊ""��trim֮��Ϊ""
	 * @param str
	 * @return
	 */
	public static boolean notBlank(String str) {
		return !isBlank(str);
	}

	/**
	 * ʹ��StringBuilder����ƴ��
	 * @param strings
	 * @return
	 */
	public static StringBuilder concatToSB(String... strings) {
		StringBuilder builder = new StringBuilder();
		if (strings != null) {
			for (String str : strings) {
				builder.append(str);
			}
		}
		return builder;
	}

	/**
	 * ȥ��ΪNULL�����
	 * @param str
	 * @return
	 */
	public static String safeValue(String str) {
		if (str == null) return "";
		return str;
	}

	/**
	 * object to string
	 * @param r
	 * @return
	 */
	public static String objectToStr(Object obj) {
		if (obj == null) return "";
		return String.valueOf(obj);
	}

	/**
	 * �ִ�
	 * @param str Ҫ�ִʵ��ַ���
	 * @param smartFlag Ϊtrue��ʹ�����ִܷʲ��� �����ִܷʣ�ϸ����������п��ܵ��зֽ�� ���ִܷʣ� �ϲ����ʺ����ʣ��Էִʽ�����������ж�
	 * @return ��ֺõĴ���
	 */
	public static String[] splitByWord(String str, boolean smartFlag) {
		List<String> words = new ArrayList<>();
		try {
			IKSegmenter ikSegmenter = new IKSegmenter(new StringReader(str), smartFlag);
			for (Lexeme Lexeme = ikSegmenter.next(); Lexeme != null; Lexeme = ikSegmenter.next()) {
				words.add(Lexeme.getLexemeText());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		String[] wordsStrArray = new String[words.size()];
		return words.toArray(wordsStrArray);
	}

	/**
	 * �ض��ַ��������س��Ȳ�����maxLen���Ӵ�.
	 * �������Դ�ַ������ȹ��������maxLen�ĺ��沿���á������滻
	 * @param str Դ�ַ�
	 * @param maxLen �ض̺����󳤶�(���ֽڼ��㣬һ�����ֻ�ȫ�Ǳ�㳤��2��һ��Ӣ�ġ����ֻ��Ǳ�㳤��1)
	 * @return �ض̺���ַ���
	 */
	public static String getLimitLengthString(String str, int maxLen) {
		return getLimitLengthString(str, maxLen, Charset.defaultCharset().name());
	}

	/**
	 * �ض��ַ��������س��Ȳ�����maxLen���Ӵ�.
	 * �������Դ�ַ������ȹ��������maxLen�ĺ��沿����symbol�滻��
	 * ���Ϊ��(null)�򷵻�""��
	 * @param str Դ�ַ�
	 * @param maxLen �ض̺����󳤶�(���ֽڼ��㣬һ�����ֻ�ȫ�Ǳ�㳤��2��һ��Ӣ�ġ����ֻ��Ǳ�㳤��1)
	 * @param charsetName �ַ���
	 * @return �ض̺���ַ���
	 */
	public static String getLimitLengthString(String str, int maxLen, String charsetName) {
		if (str == null) {
			return "";
		}
		try {
			byte b[] = str.getBytes(charsetName);
			if (b.length <= maxLen) {
				return str;
			}

			// �����ַ����ĳ���ӦС�ڻ���ڴ˳���
			int len = maxLen;

			// ʹ�ö��ַ������㷨
			int index = 0;
			// ��¼��һ��Ԫ��
			int lower = 0;
			// ��¼���һ��Ԫ��
			int higher = str.length() - 1;
			while (lower <= higher) {
				// ��¼�м�Ԫ�أ�������֮�ͳ�2
				index = (lower + higher) / 2;
				int tmpLen = str.substring(0, index).getBytes(charsetName).length;
				if (tmpLen == len) {
					// ����õ�����Ҫ���ҵ���ȣ���break�˳�
					break;
				} else if (tmpLen < len) {
					// ����õ���ҪС�ڲ��ҵģ������±��1
					lower = index + 1;
				} else {
					// ����õ���Ҫ���ڲ��ҵģ������±��1
					higher = index - 1;
				}
			}
			if (lower > higher) {
				index = higher;
			}

			// ����String���췽���Ա���substring���µ��ڴ�й¶
			return new String(str.substring(0, index));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * ȥ���ַ������˵�ȫ�ǿո�Ͱ�ǿո�.
	 * ���Ϊ��(null)�򷵻�""
	 * @param str �ַ���
	 * @return �����ҿո���ַ���
	 */
	public static String trim(String str) {
		if (str == null || str.equals("")) {
			return "";
		} else {
			return str.replaceAll("^[�� ]+|[�� ]+$", "");
		}
	}

	/**
	 * ȥ���ַ�����β�ո��Լ��м�����пո񣬰����հ׷������з����������ȫ�ǿո��
	 * ���Ϊ��(null)�򷵻�""
	 * @param str Դ�ַ�
	 * @return �������ո���ַ���
	 * @see java.lang.Character#isWhitespace(char)
	 */
	public static String trimAll(String str) {
		if (str == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			// ���˵����ֿհ׷�
			if (!Character.isWhitespace(ch)) {
				sb.append(ch);
			}
		}

		return sb.toString();
	}
}
