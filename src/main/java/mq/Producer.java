package mq;

import com.lefu.astrotrain.client.ATMessage;
import com.lefu.astrotrain.client.ATProducer;
import com.lefu.astrotrain.client.message.ObjectMessage;
import com.lefu.astrotrain.client.message.StringMessage;
import com.lefu.astrotrain.client.producer.DefaultATProducer;
import com.lefu.commons.utils.lang.JsonUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.HttpClientUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Deflater;

/**
 * asdfsadgsdfgsdfhasdasdasdfasdf
 */
public class Producer {
	private static Logger logger = LoggerFactory.getLogger(Producer.class);

	public static void main(String[] args){


		DefaultATProducer defaultATProducer = null;
		/*logger.info("==========================");
		while(true){*/
			try {
				//Thread.sleep(200);
				/*String a = null;
				a.split(",");*/
				defaultATProducer = new DefaultATProducer();
				//Lock lock = new ReentrantLock();
				defaultATProducer.setGroupName("payinterface-interactiveprocess");
				defaultATProducer.setInstanceName("ProducerAT");
				defaultATProducer.setNamesrvAddr("10.10.129.43:9876");//
				//defaultATProducer.setNamesrvAddr("10.10.111.43:9876");
				defaultATProducer.setMaxMessageSize(1310720);
				defaultATProducer.start();
				//ATProducer atProducer=defaultATProducer.createProducer("reverseInterfaceRequestQueue");
				//ATProducer atProducer=defaultATProducer.createProducer("complex_trade");
				//ATProducer atProducer=defaultATProducer.createProducer("mdsettle-channel_settle_remit");
				ATProducer atProducer=defaultATProducer.createProducer("REMIT_INTERATIVE_THEME");
				ObjectMessage msg = new ObjectMessage();
				//for(int i = 0;i<5;i++) {
				String batchCode="B"+System.currentTimeMillis();
				//String dataJson="{\"class\":\".RemitTradeContext\",\"interfaceInfoCode\":\"REMIT_CMBC_731001\",\"batchCode\":\""+batchCode+"\",\"totalNumber\":1,\"totalAmount\":0.01,\"interfaceRemitBills\":[{\"class\":\".InterfaceRemitBill\",\"billCode\":\"RB007139715644\",\"requestSeriaNum\":\"R"+batchCode+"\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"8611300496\",\"product\":\"P_SETTLE_LFB_SSFMD\",\"accountName\":\"毕朝华\",\"accountNo\":\"6212262402007639640\",\"bankCode\":\"ICBC\",\"bankName\":\"中国工商银行股份有限公司贵安支行\",\"amount\":0.01,\"fee\":0.0,\"use\":\"乐富打款\",\"memo\":\"\",\"province\":\"贵州\",\"city\":\"贵阳市\",\"cnapsCode\":\"102701000842\",\"sabkCode\":\"102100099996\",\"ownBankCode\":\"\"}]}";
				//String dataJson="{\"interfaceInfoCode\":\"REMIT_GWF_100001\",\"batchCode\":\""+batchCode+"\","
				//      + "\"totalNumber\":4,\"totalAmount\":1.03,\"interfaceRemitBills\":"
				//    + "[{\"class\":\".InterfaceRemitBill\",\"institNo\":\"PAY\",\"billCode\":\"RB007139715645\",\"requestSeriaNum\":\"R"+batchCode+"1\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"8619183595\",\"product\":\"P_SETTLE_LFB_SSFMD\",\"accountName\":\"????\",\"accountNo\":\"6226090000000048\",\"bankCode\":\"ICBC\",\"bankName\":\"?й????????й?????????????????????????\",\"amount\":0.01,\"fee\":0.0,\"use\":\"??????\",\"memo\":\"\",\"province\":\"????\",\"city\":\"????\",\"cnapsCode\":\"102100000021\",\"sabkCode\":\"102100000021\",\"ownBankCode\":\"\"}"
				//+ ",{\"class\":\".InterfaceRemitBill\",\"institNo\":\"PAY\",\"billCode\":\"RB007139715646\",\"requestSeriaNum\":\"R"+batchCode+"2\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"8611300496\",\"product\":\"P_SETTLE_LFB_SSFMD\",\"accountName\":\"????\",\"accountNo\":\"6226660204026278\",\"bankCode\":\"ICBC\",\"bankName\":\"?????????????\",\"amount\":1,\"fee\":0.0,\"use\":\"??????\",\"memo\":\"\",\"province\":\"???\",\"city\":\"??????\",\"cnapsCode\":\"303100000014 \",\"sabkCode\":\"303100000006\",\"ownBankCode\":\"\"}"
				//+ ",{\"class\":\".InterfaceRemitBill\",\"institNo\":\"PAY\",\"billCode\":\"RB007139715647\",\"requestSeriaNum\":\"R"+batchCode+"3\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"8611300496\",\"product\":\"P_SETTLE_LFB_SSFMD\",\"accountName\":\"????\",\"accountNo\":\"6226660204026278\",\"bankCode\":\"ICBC\",\"bankName\":\"?й???????б???????\",\"amount\":0.01,\"fee\":0.0,\"use\":\"??????\",\"memo\":\"\",\"province\":\"?????\",\"city\":\"???\",\"cnapsCode\":\"303100000014 \",\"sabkCode\":\"303100000006\",\"ownBankCode\":\"\"}"
				//+ ",{\"class\":\".InterfaceRemitBill\",\"institNo\":\"PAY\",\"billCode\":\"RB007139715648\",\"requestSeriaNum\":\"R"+batchCode+"4\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"8611300496\",\"product\":\"P_SETTLE_LFB_SSFMD\",\"accountName\":\"????\",\"accountNo\":\"6226660204026278\",\"bankCode\":\"ICBC\",\"bankName\":\"?й???????б???????\",\"amount\":0.01,\"fee\":0.0,\"use\":\"??????\",\"memo\":\"\",\"province\":\"????\",\"city\":\"????????\",\"cnapsCode\":\"303100000014 \",\"sabkCode\":\"303100000006\",\"ownBankCode\":\"\"}"
				//+ "]}";
				// REMIT_JL_584001,REMIT_YS_290002  86301002522 ???????  REMIT_GWF_100001
				//String dataJson = "{\"interfaceInfoCode\":\"REMIT_PAB_393001\",\"batchCode\":\""+batchCode+"\",\"totalNumber\":1,\"totalAmount\":27.48,\"interfaceRemitBills\":[{\"class\":\".InterfaceRemitBill\",\"billCode\":\"B20180820001\",\"requestSeriaNum\":\"R"+batchCode+"1\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"8619183595\",\"product\":\"D0YISHI\",\"accountName\":\"???\",\"accountNo\":\"6227002921190314417\",\"bankCode\":\"CCB\",\"bankName\":\"?й????????й??????????????ü????????????\",\"amount\":27.48,\"fee\":0.0,\"use\":\"XX???\",\"memo\":\"\",\"province\":\"????\",\"city\":\"?????\",\"cnapsCode\":\"105551009051\",\"sabkCode\":\"105100000017\",\"ownBankCode\":\"\",\"institNo\":null,\"clearanceTime\":null,\"idCode\":null,\"clearingMerchantCode\":null,\"billType\":null,\"clearingMerchantName\":null,\"settleType\":null,\"acctType\":null,\"transDate\":1534728040000,\"attachFee\":1.23,\"oriRefNo\":\"000000447074\",\"channel
				//
				//
				//
				// MerId\":null}]}";

				String dataJson = "{\"interfaceInfoCode\":\"REMIT_YZH_100001\",\"batchCode\":\""+batchCode+"\",\"totalNumber\":1,\"totalAmount\":1,\"interfaceRemitBills\":[{\"class\":\".InterfaceRemitBill\",\"billCode\":\"RB"+batchCode+"\",\"requestSeriaNum\":\"R"+batchCode+"\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"36301920522 \",\"product\":\"D0YISHI\",\"accountName\":\"王亚恒\",\"accountNo\":\"gywdlx2352@sandbox.com\",\"bankCode\":\"BOC\",\"bankName\":\"1234\",\"amount\":1,\"fee\":0.0,\"use\":\"123\",\"memo\":\"123\",\"province\":\"123\"," +
						"\"cnapsCode\":\"103100000026\",\"sabkCode\":\"103100000026\",\"ownBankCode\":\"\",\"institNo\":null,\"clearanceTime\":null,\"idCode\":\"120108198408080123\",\"clearingMerchantCode\":null,\"billType\":null,\"clearingMerchantName\":null,\"settleType\":null,\"acctType\":null,\"transDate\":1590645153000,\"attachFee\":0,\"oriRefNo\":\"000000447074\",\"channelMerId\":\"10027950865\",\"orderNo\":\"BL8TWRLWJ105GTPD4UKG\",\"phoneNo\":\"13833333333\"}]}";
				String openAccdataJson1 = "{\"requestCode\":\""+batchCode+"\",\"requestTime\":\"123\",\"paytradeType\":\"OPEN_ACC\",\"conTradeBean\":{\"enterprise_business_license\":\"123\",\"enterprise_tax_no\":\"123\",\"enterprise_unified_code\":\"123\",\"enterprise_credit_code\":\"123\",\"trade_password\":\"123\",\"random_client\":\"123\",\"need_notify\":\"123\",\"notify_url\":\"123\",\"protocol_list\":null,\"individual_reserved_phone_no\":\"123\",\"additional_virtual_acct_type\":\"123\",\"individual_cvn2\":\"123\",\"biz_no\":\"123\",\"individual_valid_date\":\"123\",\"open_virtual_acct_type\":\"123\",\"enterprise_legal_name\":\"123\",\"appId\":\"123\",\"enterprise_legal_id_card_type\":\"123\",\"enterprise_legal_id_card_no\":\"123\",\"enterprise_contact_name\":\"123\",\"enterprise_contact_phone\":\"123\",\"enterprise_bank_name\":\"123\",\"enterprise_bank_code\":\"123\",\"version\":\"123\",\"platform_no\":\"123\",\"message_captcha\":\"123\",\"unit_type\":\"123\",\"customer_type\":\"123\",\"platform_customer_no\":\"123\",\"customer_full_name\":\"123\",\"individual_id_card_no\":\"123\",\"individual_bank_card_no\":\"123\",\"individual_id_card_front_id\":\"123\",\"individual_id_card_back_id\":\"123\",\"individual_id_card_valid_date\":\"123\",\"individual_nationality\":\"123\",\"individual_sex\":\"123\",\"individual_company\":\"123\",\"individual_website\":\"123\",\"individual_mail\":\"123\",\"individual_vocation\":\"123\",\"enterprise_business_scope\":\"123\",\"enterprise_license_name\":\"123\",\"enterprise_license_valid_date\":\"123\",\"enterprise_license_file_id\":\"123\",\"enterprise_trade\":\"123\",\"enterprise_legal_id_card_valid_date\":\"123\",\"enterprise_legal_id_card_front_id\":\"123\",\"enterprise_legal_id_card_back_id\":\"123\",\"enterprise_shareholder_id_card_type\":\"123\",\"enterprise_shareholder_id_card_no\":\"123\",\"enterprise_shareholder_id_card_valid_date\":\"123\",\"enterprise_shareholder_id_card_file_id\":\"123\",\"enterprise_oprator_name\":\"123\",\"enterprise_oprator_conctact_phone\":\"123\",\"enterprise_oprator_id_card_type\":\"123\",\"enterprise_oprator_id_card_no\":\"123\",\"enterprise_oprator_id_card_valid_date\":\"123\",\"enterprise_oprator_id_card_front_id\":\"123\",\"enterprise_oprator_id_card_back_id\":\"123\",\"enterprise_beneficiary_name\":\"123\",\"enterprise_beneficiary_conctact_phone\":\"123\",\"enterprise_beneficiary_id_card_type\":\"123\",\"enterprise_beneficiary_id_card_no\":\"123\",\"enterprise_beneficiary_id_card_valid_date\":\"123\",\"enterprise_beneficiary_id_card_front_id\":\"123\",\"enterprise_beneficiary_id_card_back_id\":\"123\",\"enterprise_bank_card_no\":\"123\",\"enterprise_org_no\":\"123\",\"trust_account_flag\":\"123\",\"employer_customer_full_name\":\"123\",\"employer_enterprise_legal_name\":\"123\",\"employer_enterprise_unified_code\":\"123\",\"employer_enterprise_contact_id_card_no\":\"123\",\"employer_enterprise_contact_name\":\"123\",\"employer_enterprise_contact_phone\":\"123\"},\"interfaceInfoCode\":\"REMIT_XW_100001\",\"properties\":\"123\"}";
				String transfer = "{\"requestCode\":\""+batchCode+"\",\"requestTime\":\"123\",\"paytradeType\":\"TRANS_ACCOUNT\",\"conTradeBean\":{\"interfaceInfoCode\":\"123\",\"status\":null,\"bankRespCode\":\"123\",\"bankRespMsg\":\"123\",\"orderNo\":\"123\",\"bankRequestNo\":\"123\",\"bankRespNo\":\"123\",\"lastUpdateTime\":\"123\",\"bankRespResult\":\"123\",\"transAmountType\":\"VIRTUAL_MUTUAL\",\"tran_no\":\"123\",\"payer_platform_customer_no\":\"123\",\"payer_virtual_acct_no\":\"123\",\"payee_platform_customer_no\":\"123\",\"payee_virtual_acct_no\":\"123\",\"ccy\":\"123\",\"amt\":\"123\",\"commission\":\"123\",\"remark\":\"123\",\"summary\":\"123\",\"need_notify\":\"123\",\"notify_url\":\"123\",\"tran_type\":\"123\",\"biz_no\":\"123\",\"trade_password\":\"123\",\"random_client\":\"123\"},\"interfaceInfoCode\":\"REMIT_XW_100001\"}";
				String createProtol = "{\"requestCode\":\""+batchCode+"\",\"requestTime\":\"123\",\"paytradeType\":\"CREATE_PROTOCAL_NUMBER\",\"conTradeBean\":{\"version\":\"123\",\"platform_no\":\"123\",\"platform_customer_no\":\"123\",\"scene_code\":\"123\",\"virtual_acct_no\":\"123\",\"protocol_list\":[{\"protocol_name\":\"456\",\"protocol_item\":\"1234\"}]},\"interfaceInfoCode\":\"REMIT_XW_100001\",\"properties\":\"123\"}";
				//String dataJson = "{\"interfaceInfoCode\":\"REMIT_GWF_100002\",\"batchCode\":\""+batchCode+"\",\"totalNumber\":1,\"totalAmount\":0.19,\"interfaceRemitBills\":[{\"class\":\".InterfaceRemitBill\",\"billCode\":\"B201908220051\",\"requestSeriaNum\":\"-RBD0029517187\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"8619183510\",\"product\":\"LFB_MDSMYIBAOX58500401\",\"accountName\":\"?????\",\"accountNo\":\"6226192300338050\",\"bankCode\":\"CMBC\",\"bankName\":\"?й????????й????????????????\",\"amount\":0.19,\"fee\":0.0,\"use\":\"?????\",\"memo\":\"\",\"province\":\"????\",\"city\":\"?????\",\"cnapsCode\":\"305397823084\",\"sabkCode\":\"305100000013\",\"ownBankCode\":\"\",\"institNo\":null,\"clearanceTime\":null,\"idCode\":null,\"clearingMerchantCode\":null,\"billType\":null,\"clearingMerchantName\":null,\"settleType\":null,\"acctType\":null,\"transDate\":1566454271000,\"attachFee\":0.0,\"oriRefNo\":\"79BMF33XQ00L\",\"channelMerId\":null,\"terminalNo\":null,\"bankRequestNo\":null,\"orderNo\":\"BMF33XLH4E47JM0R331G\",\"channelCost\":0.0}],\"preRemitRecordBean\":null}";
				byte[] data = compress(dataJson.getBytes("UTF-8"));
				msg.putObject(data);
				msg.setProperty(ATMessage.MSG_KEYS,batchCode);
				atProducer.send(msg);
				Map<String, Object> callBack = new HashMap<String, Object>();
				callBack.put("orderNo", "1323456");
				Date date = new Date();
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = format.format(date);
				callBack.put("sendTime", time);
				callBack.put("httpUrl", "www.baidu.com?amount=61.0&status=SUCCESS&transType=PURCHASE&createTime=1471852710921&orderOptimistic=1&customerFee=2.75&posBatch=000030&posRequestId=100183&pan=622424*0139&agentNo=8615292557&completeTime=1471852718858&sign=FFC285DAB1412507A501BDE00884D484");

				StringMessage strmessage = new StringMessage();
				//String json = "{\"orderNo\":\"1234\",\"httpUrl\":\"www.baidu.com\",\"sendTime\":\"2016-08-23 13:35:30\"}";
				String json = JsonUtils.toJsonString(callBack);
				//String json = "{orderNo=1132, httpUrl=www.baidu2.com?amount=61.0&status=SUCCESS&transType=PURCHASE&createTime=1471852710921&orderOptimistic=1&customerFee=2.75&posBatch=000030&posRequestId=100183&pan=622424*0139&agentNo=8615292557&completeTime=1471852718858&sign=FFC285DAB1412507A501BDE00884D484, sendTime=2016-08-23 16:29:52}";
				strmessage.setMsg(json);
				//atProducer.send(strmessage);
				System.out.println("batchCode:"+batchCode);


				System.out.println(dataJson);
				//}

			} catch (Exception e) {
				//e.printStackTrace();
				String stackTrace = ExceptionUtils.getStackTrace(e);
				System.out.println("==="+stackTrace);
				logger.error("",e.getMessage());
			}finally{
				defaultATProducer.shutdown();
			}
		}


	//}
	/**
	 *
	 * @param data
	 * @return byte[]
	 * @throws Exception
	 */
	public static byte[] compress(byte[] data) throws Exception {
		byte[] output = new byte[0];

		Deflater compresser = new Deflater();

		compresser.reset();
		compresser.setInput(data);
		compresser.finish();
		ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length);
		try {
			byte[] buf = new byte[1024];
			while (!compresser.finished()) {
				int i = compresser.deflate(buf);
				bos.write(buf, 0, i);
			}
			output = bos.toByteArray();
		} catch (Exception e) {
			throw new Exception("?????????", e);
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				throw new Exception("ByteArrayOutputStream error", e);
			}
		}
		compresser.end();
		return output;
	}
}