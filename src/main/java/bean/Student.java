package bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Student {
	private static final Map<String, String> city = new HashMap<>();
	private static final Map<String, String> zzq = new HashMap<>();

	static {
		city.put("����", "������");
		city.put("�Ϻ�", "�Ϻ���");
		city.put("����", "������");
		city.put("���", "�����");

		zzq.put("����", "����׳��������");
		zzq.put("���ɹ�", "���ɹ�������");
		zzq.put("����", "����������");
		zzq.put("����", "���Ļ���������");
		zzq.put("�½�", "�½�ά���������");
	}

	
	public static void main(String[] args) {
		String bankName = "�������п����۰��� ֧��";
		System.out.println(formatBankName(bankName));
	}
	
	public static String formatBankName(String bankName){
		
		if(bankName.contains("����")) bankName=bankName.substring(0, bankName.indexOf("����")+2);
		return bankName;
	}
	
	public static String formatProvince(String province) {

	

		Set<String> keySet = city.keySet();
		for (String str : keySet) {
			if (province.contains(str)) return city.get(str);
		}

		Set<String> zzqSet = zzq.keySet();
		for (String z : zzqSet) {
			if (province.contains(z)) return zzq.get(z);
		}
		if (province.contains("ʡ")) {
			return province;
		}

		return province + "ʡ";
	}


	 
	private int age = 10;
	@Test
	public void demo(){
		age = 20;
		System.out.println(age);
	}
	@Test
	public void test2(){
		System.out.println(age);
	}

}
