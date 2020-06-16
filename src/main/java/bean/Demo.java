package bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class Demo {
public static void main(String[] args) {
	ProvisionsScheduleTrade scheduleTrade = new ProvisionsScheduleTrade();
	FundAccountBean accountBean = new FundAccountBean();
	/** 璁剧疆澶囦粯閲戣处鍙� */
	accountBean.setAccountNo("600065332");
	/** 澶囦粯閲戣处鎴峰悕 */
	accountBean.setAccountName("娈靛墤閿嬪鎴峰浠橀噾");
	scheduleTrade.setFundAccountBean(accountBean);
	/**璁剧疆鎿嶄綔绫诲瀷*/
	scheduleTrade.setMessageType(MessageType.TRADE);
	ProvisionsScheduleBatch scheduleBatch = new ProvisionsScheduleBatch();
	scheduleBatch.setBatchCode("BC201605131525");
	scheduleBatch.setTotalAmount(689.32);
	scheduleBatch.setTotalNumber(1);
	scheduleTrade.setProvisionsSchedulebatch(scheduleBatch);
	Map<String,Date> map = new HashMap<String,Date>();
	scheduleTrade.setParams(map);
	List<ProvisionsScheduleBill> billList = new ArrayList<ProvisionsScheduleBill>();
	ProvisionsScheduleBill scheduleBill = new ProvisionsScheduleBill();
	/**鎵规鍙�*/
	scheduleBill.setBatchCode("BC201605131525");
	scheduleBill.setBillCode("BC000001");
	/** 澶囦粯閲戣处鎴疯处鍙� */
	scheduleBill.setPayeraccount("600065332");
	/** 澶囦粯閲戣处鎴锋埛鍚� */
	scheduleBill.setPayerAcctName("娈靛墤閿嬪鎴峰浠橀噾");
	/** 澶囦粯閲戣处鎴风被鍨� */
	scheduleBill.setPayerAccountType("0");
	/** 姹囪矾 */
	scheduleBill.setPathCode("I");
	/** 浜ゆ槗閲戦 */
	scheduleBill.setAmount(689.32);
	/** 鏀舵璐︽埛鎴峰悕 */
	scheduleBill.setPayeeAcctName("姹熺幉鑺�");
	/** 鏀舵璐︽埛璐﹀彿 */
	scheduleBill.setPayeeaccount("600065076");
	/** 鏀舵浜哄紑鎴疯鍚� */
	scheduleBill.setPayeeAcctBranchName("");
	/** 鏀舵浜哄紑鎴疯鍙� */
	scheduleBill.setPayeeacctBankid("");
	/** 鐢ㄩ�� */
	scheduleBill.setPurpose("0");
	/** 涓氬姟绫诲瀷 */
	scheduleBill.setBusitype("01");
	/** 闄勮█ */
	scheduleBill.setDetail("涔愬瘜鎵撴");
	billList.add(scheduleBill);
	scheduleTrade.setProvisionsScheduleBillList(billList);
	Properties tradeConfig = new Properties();
	/** 鍗曠瑪浜ゆ槗缂栧彿 */
	tradeConfig.setProperty("singlePay", "15001");
	/** 鏈烘瀯鏀粯搴忓彿 */
	tradeConfig.setProperty("corpId", "10011");
	/** 鏀粯鏈烘瀯鍚嶇О */
	tradeConfig.setProperty("corpName", "娈靛墤閿�");
	/** 鍙戦�佸湴鍧�Uri */
	//tradeConfig.setProperty("uri", "http://111.205.207.118:55003/epay/pvDirectAccess.do");
	//tradeConfig.setProperty("uri", "http://10.10.116.42:80");
	tradeConfig.setProperty("uri", "http://111.205.207.118:55003/epay/pvDirectAccess.do");
	tradeConfig.setProperty("hostIp","10.10.116.42" );
	tradeConfig.setProperty("hostPort", "80");
	scheduleTrade.setProp(tradeConfig);
	JSONObject json = new JSONObject();
	json.put("provisionsScheduleTrade",scheduleTrade );
	
	System.out.println(json);
}


	@Test
	public void testDemo(){
		/*String batchCode = "RB123456";
		String dataJson="{\"class\":\".RemitTradeContext\",\"interfaceInfoCode\":\"REMIT_PRIVATE_CMB_430000\",\"batchCode\":\"rB789456123\",\"totalNumber\":1,\"totalAmount\":12924.1,\"interfaceRemitBills\":[{\"class\":\".InterfaceRemitBill\",\"billCode\":\"RB0071397154\",\"requestSeriaNum\":\"R"+batchCode+"\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"8611300496\",\"product\":\"P_SETTLE_LFB_SSFMD\",\"accountName\":\"姣曟湞鍗嶾\",\"accountNo\":\"6212262402007639640\",\"bankCode\":\"ICBC\",\"bankName\":\"涓浗宸ュ晢閾惰鑲′唤鏈夐檺鍏徃璐靛畨鏀\",\"amount\":12924.1,\"fee\":0.0,\"use\":\"涔愬瘜鎵撴\",\"memo\":\"\",\"province\":\"璐靛窞\",\"city\":\"璐甸槼甯俓\",\"cnapsCode\":\"102701000842\",\"sabkCode\":\"102100099996\",\"ownBankCode\":\"\"}]}";
		JSONObject jo = new JSONObject();
		jo.parse(dataJson);
		System.out.println(System.currentTimeMillis());*/
	}
//38746987  38763489 38784030

	@Test
	public  void createMsgId() {
		StringBuilder sb = new StringBuilder();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String dateFormat = sdf.format(date);
		System.out.println(dateFormat);
		sb.append(dateFormat);
		sb.append("00");
		String millis = String.valueOf(System.currentTimeMillis());
		String mills = millis.substring(millis.length() - 8, millis.length());
		sb.append(mills);
		//System.out.println(sb.toString());
	}


	@Test
	public void testaa(){
		int i = 0;
		for(;i<5;i++){
			if(i>3){
				break;
			}
		}
		System.out.println(i);
	}



}
