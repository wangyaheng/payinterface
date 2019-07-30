package mq;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Deflater;

import com.lefu.astrotrain.client.ATMessage;
import com.lefu.astrotrain.client.ATProducer;
import com.lefu.astrotrain.client.message.ObjectMessage;
import com.lefu.astrotrain.client.message.StringMessage;
import com.lefu.astrotrain.client.producer.DefaultATProducer;
import com.lefu.commons.utils.lang.JsonUtils;

public class Producer1 {
	
	
	public static void main(String[] args){
		
		DefaultATProducer defaultATProducer = null;
		try {
		 defaultATProducer = new DefaultATProducer();
		 //Lock lock = new ReentrantLock();
		defaultATProducer.setGroupName("promotionFeeDeduction-core");
		defaultATProducer.setInstanceName("ProducerAT_STT2");
		defaultATProducer.setNamesrvAddr("10.10.129.43:9876");//
		//defaultATProducer.setNamesrvAddr("10.10.111.43:9876");
		 
		 /*defaultATProducer.setGroupName("reverse-core");
			defaultATProducer.setInstanceName("ProducerAT_STT2");
			defaultATProducer.setNamesrvAddr("10.10.111.43:9876");*/
		defaultATProducer.setMaxMessageSize(1310720);
		defaultATProducer.start();
		//ATProducer atProducer=defaultATProducer.createProducer("reverseInterfaceRequestQueue");
		//ATProducer atProducer=defaultATProducer.createProducer("extOrderService");
		//ATProducer atProducer=defaultATProducer.createProducer("CUST_POS_RELATION_TOPIC");
		ATProducer atProducer=defaultATProducer.createProducer("lynx_order_act_succeed_order");
		
		//ATProducer atProducer=defaultATProducer.createProducer("REMIT_INTERATIVE_THEME");
		StringMessage msg = new StringMessage();
		//for(int i = 0;i<50;i++) {
			String batchCode="B"+System.currentTimeMillis();
			

			//String dataJson="{\"class\":\".RemitTradeContext\",\"interfaceInfoCode\":\"REMIT_CMBC_731001\",\"batchCode\":\""+batchCode+"\",\"totalNumber\":1,\"totalAmount\":0.01,\"interfaceRemitBills\":[{\"class\":\".InterfaceRemitBill\",\"billCode\":\"RB007139715644\",\"requestSeriaNum\":\"R"+batchCode+"\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"8611300496\",\"product\":\"P_SETTLE_LFB_SSFMD\",\"accountName\":\"姣曟湞鍗嶾",\"accountNo\":\"6212262402007639640\",\"bankCode\":\"ICBC\",\"bankName\":\"涓浗宸ュ晢閾惰鑲′唤鏈夐檺鍏徃璐靛畨鏀\",\"amount\":0.01,\"fee\":0.0,\"use\":\"涔愬瘜鎵撴\",\"memo\":\"\",\"province\":\"璐靛窞\",\"city\":\"璐甸槼甯俓",\"cnapsCode\":\"102701000842\",\"sabkCode\":\"102100099996\",\"ownBankCode\":\"\"}]}";
			//8621506659
			//String data="{\"posSn\":\"6682017031625902\",\"activityCode\":\"KY_YOUSHUA_20181001_MPOS\",\"bindType\":\"BIND\",\"customerNo\":\"86301076522\",\"posType\":\"G2S-SR\",\"operationTime\":1515554162990,\"posCati\":\"92878130\"}";       
			//String data="{\"posSn\":\"6682017031952833\",\"activityCode\":\"HDBH-20180302174408\",\"bindType\":\"BIND\",\"customerNo\":\"86301293522\",\"posType\":\"G2S-SR\",\"operationTime\":1515554162990,\"posCati\":\"92878130\",\"agentNo\":\"123456\",\"brandCode\":\"X58500401\"}";
			String data="{\"activityAmount\":98.0,\"orderNo\":\"BKCNWVXALGJ1RLA09GD0\",\"channelActivityCode\":\"ACTERM\",\"completeTime\":1557753726000,\"transAmount\":115.0,\"activityCode\":\"HDBH-201901181113\",\"createTime\":1557753719000,\"actOutBusCode\":\"BK74LF2AL595430AQ2H0\",\"activityStatus\":\"SUCCESS\",\"bankExternalId\":\"000050408039\",\"interfaceCode\":\"P310013\",\"activityType\":\"ACT_MAC_FEE\",\"customerNo\":\"86251908515\"}";
			
			//byte[] data = compress(dataJson.getBytes("UTF-8"));
			msg.setMsg(data);
			msg.setProperty(ATMessage.MSG_KEYS,batchCode);
			atProducer.send(msg);
			Map<String, Object> callBack = new HashMap<String, Object>();
			callBack.put("orderNo", "1323456");
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);
			callBack.put("sendTime", time);
			callBack.put("httpUrl", "www.baidu.co2m?amount=61.0&status=SUCCESS&transType=PURCHASE&createTime=1471852710921&orderOptimistic=1&customerFee=2.75&posBatch=000030&posRequestId=100183&pan=622424*0139&agentNo=8615292557&completeTime=1471852718858&sign=FFC285DAB1412507A501BDE00884D484");
			
			StringMessage strmessage = new StringMessage();
			//String json = "{\"orderNo\":\"1234\",\"httpUrl\":\"www.baidu.com\",\"sendTime\":\"2016-08-23 13:35:30\"}";
			String json = JsonUtils.toJsonString(callBack);
			//String json = "{orderNo=1132, httpUrl=www.baidu2.com?amount=61.0&status=SUCCESS&transType=PURCHASE&createTime=1471852710921&orderOptimistic=1&customerFee=2.75&posBatch=000030&posRequestId=100183&pan=622424*0139&agentNo=8615292557&completeTime=1471852718858&sign=FFC285DAB1412507A501BDE00884D484, sendTime=2016-08-23 16:29:52}";
			strmessage.setMsg(json);
			//atProducer.send(strmessage);
			System.out.println("batchCode:"+batchCode);


			System.out.println(data);
		//}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			defaultATProducer.shutdown();
		}
		
	}
	/**
	 * 压缩数据
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
			throw new Exception("娑堟伅鍘嬬缉寮傚父锛�", e);
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				throw new Exception("ByteArrayOutputStream鍏抽棴寮傚父锛�", e);
			}
		}
		compresser.end();
		return output;
	}
}