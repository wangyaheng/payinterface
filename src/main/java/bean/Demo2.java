package bean;
import java.math.BigDecimal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import entity.FeeFrozenRecord;
import org.junit.Test;

public class Demo2 {

	public static void main(String[] args) {
		FeeFrozenRecord feeFrozenRecord = new FeeFrozenRecord();


	}

	/**
	 * @param args1463642480674
	 * 			  1463642529701
	 * 			  1463642576403
	 */
//	public static void main(String[] args) {
//		
////		System.out.println(System.currentTimeMillis());
////		System.out.println(String.valueOf(System.currentTimeMillis()).substring(5, 11));
//		String localReqDir = "F:/aaa";
//		String yyyyMMdd = "bbb";
//		File localReqPath = new File(localReqDir, yyyyMMdd);
//		if (!localReqPath.exists()) {
//			if (!localReqPath.mkdirs()) {
//				if (!localReqPath.exists()) {
//					localReqPath.mkdirs();
//				}
//			}
//		}
//		File file = new File(localReqPath,"zjy.txt");
//		FileOutputStream plainStream = null;
//		String bodyContent = "abcde,3232zjiyijij\r\nehijilliwoejw";
//		try {
//			/** 将付款单内容写入到本地备份文件中 */
//			plainStream = new FileOutputStream(file);
//			plainStream.write(bodyContent.getBytes("GBK"));
//			plainStream.flush();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				if (plainStream != null) plainStream.close();
//			} catch (IOException ioe) {
//				System.out.println(ioe.getMessage());
//			}
//		}
//		String fileName = "20150512/400121000058/REQ/REQ_DF_400121000058_20150512_000001.txt";
//		String batchCode = fileName.substring(fileName.lastIndexOf("_") + 1, fileName.length() - 4);
//		String date = fileName.substring(46, 54);
////		String aaa = fileName.substring(fileName.length()-19, fileName.lastIndexOf("-"));
////		System.out.println(aaa);
//		int a = fileName.length()-19;
//		System.out.println(batchCode+"===="+a);
//		int b = fileName.lastIndexOf("_");
//		System.out.println(b);
//		String aaa = fileName.substring(a,b);
//		System.out.println(aaa);
		
//		String s = "RB0027431284";
//		//System.out.println(s.substring(2));
//		StringBuilder sb = new StringBuilder();
//		sb.append("aaa").append(",").append("").append(",").append("bbb").append(",");
//		System.out.println(sb.toString());
	
	@Test
	public void testTime(){
		double a = 2.0;
		String b = String.valueOf(a);
		System.out.println(a+b);
	}
}
