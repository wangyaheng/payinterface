package utils;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;


public class StringUtils extends org.apache.commons.lang3.StringUtils {


	public static byte[] serialize(final String string, final Charset charset) {
		return (string == null ? null : string.getBytes(charset));
	}


	public static String deserialize(final byte[] bytes, final Charset charset) {
		return (bytes == null ? null : new String(bytes, charset));
	}


	public static boolean notEmpty(String str) {
		return !isEmpty(str);
	}


	public static boolean notBlank(String str) {
		return !isBlank(str);
	}

	public static StringBuilder concatToSB(String... strings) {
		StringBuilder builder = new StringBuilder();
		if (strings != null) {
			for (String str : strings) {
				builder.append(str);
			}
		}
		return builder;
	}


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


	public static String getLimitLengthString(String str, int maxLen) {
		return getLimitLengthString(str, maxLen, Charset.defaultCharset().name());
	}


	public static String getLimitLengthString(String str, int maxLen, String charsetName) {
		if (str == null) {
			return "";
		}
		try {
			byte b[] = str.getBytes(charsetName);
			if (b.length <= maxLen) {
				return str;
			}


			int len = maxLen;


			int index = 0;

			int lower = 0;

			int higher = str.length() - 1;
			while (lower <= higher) {

				index = (lower + higher) / 2;
				int tmpLen = str.substring(0, index).getBytes(charsetName).length;
				if (tmpLen == len) {

					break;
				} else if (tmpLen < len) {

					lower = index + 1;
				} else {

					higher = index - 1;
				}
			}
			if (lower > higher) {
				index = higher;
			}


			return new String(str.substring(0, index));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
		}
	}

	public static String trim(String str) {
		if (str == null || str.equals("")) {
			return "";
		} else {
			return str.replaceAll("^[�� ]+|[�� ]+$", "");
		}
	}


	public static String trimAll(String str) {
		if (str == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!Character.isWhitespace(ch)) {
				sb.append(ch);
			}
		}

		return sb.toString();
	}
}
