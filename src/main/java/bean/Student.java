package bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Student {
	private static final Map<String, String> city = new HashMap<>();
	private static final Map<String, String> zzq = new HashMap<>();

	static {
		city.put("北京", "北京市");
		city.put("上海", "上海市");
		city.put("重庆", "重庆市");
		city.put("天津", "天津市");

		zzq.put("广西", "广西壮族自治区");
		zzq.put("内蒙古", "内蒙古自治区");
		zzq.put("西藏", "西藏自治区");
		zzq.put("宁夏", "宁夏回族自治区");
		zzq.put("新疆", "新疆维吾尔自治区");
	}

	
	public static void main(String[] args) {
		String bankName = "北京银行卡降价啊的 支行";
		System.out.println(formatBankName(bankName));
	}
	
	public static String formatBankName(String bankName){
		
		if(bankName.contains("银行")) bankName=bankName.substring(0, bankName.indexOf("银行")+2);
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
		if (province.contains("省")) {
			return province;
		}

		return province + "省";
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
