package mq;

import com.lefu.astrotrain.client.ATMessage;
import com.lefu.astrotrain.client.ATProducer;
import com.lefu.astrotrain.client.message.ObjectMessage;
import com.lefu.astrotrain.client.message.StringMessage;
import com.lefu.astrotrain.client.producer.DefaultATProducer;
import com.lefu.commons.utils.lang.JsonUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Deflater;

public class Producer3 {
    public static void main(String[] args){

        DefaultATProducer defaultATProducer = null;
        try {
            Thread.sleep(3000);
            defaultATProducer = new DefaultATProducer();
            //Lock lock = new ReentrantLock();
		/*defaultATProducer.setGroupName("payinterface-core");
		defaultATProducer.setInstanceName("ProducerAT_STT2");*/
            defaultATProducer.setGroupName("payinterface-interactiveprocess");
            defaultATProducer.setInstanceName("ProducerAT");

            defaultATProducer.setNamesrvAddr("10.10.129.43:9876");//
            //defaultATProducer.setNamesrvAddr("10.10.111.43:9876");

		 /*defaultATProducer.setGroupName("reverse-core");
			defaultATProducer.setInstanceName("ProducerAT_STT2");
			defaultATProducer.setNamesrvAddr("10.10.111.43:9876");*/
            defaultATProducer.setMaxMessageSize(1310720);
            defaultATProducer.start();
            //ATProducer atProducer=defaultATProducer.createProducer("reverseInterfaceRequestQueue");
            //ATProducer atProducer=defaultATProducer.createProducer("extOrderService");
            //ATProducer atProducer=defaultATProducer.createProducer("mdsettle-channel_settle_remit");
            ATProducer atProducer=defaultATProducer.createProducer("fee_channel_split_account");
            ObjectMessage msg = new ObjectMessage();
            //for(int i = 0;i<10;i++) {
            String batchCode="B"+System.currentTimeMillis();


            //String dataJson="{\"class\":\".RemitTradeContext\",\"interfaceInfoCode\":\"REMIT_CMBC_731001\",\"batchCode\":\""+batchCode+"\",\"totalNumber\":1,\"totalAmount\":0.01,\"interfaceRemitBills\":[{\"class\":\".InterfaceRemitBill\",\"billCode\":\"RB007139715644\",\"requestSeriaNum\":\"R"+batchCode+"\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"8611300496\",\"product\":\"P_SETTLE_LFB_SSFMD\",\"accountName\":\"姣曟湞鍗嶾",\"accountNo\":\"6212262402007639640\",\"bankCode\":\"ICBC\",\"bankName\":\"涓浗宸ュ晢閾惰鑲′唤鏈夐檺鍏徃璐靛畨鏀\",\"amount\":0.01,\"fee\":0.0,\"use\":\"涔愬瘜鎵撴\",\"memo\":\"\",\"province\":\"璐靛窞\",\"city\":\"璐甸槼甯俓",\"cnapsCode\":\"102701000842\",\"sabkCode\":\"102100099996\",\"ownBankCode\":\"\"}]}";
            //String dataJson="{\"interfaceInfoCode\":\"REMIT_GWF_100001\",\"batchCode\":\""+batchCode+"\","
            //      + "\"totalNumber\":4,\"totalAmount\":1.03,\"interfaceRemitBills\":"
            //    + "[{\"class\":\".InterfaceRemitBill\",\"institNo\":\"PAY\",\"billCode\":\"RB007139715645\",\"requestSeriaNum\":\"R"+batchCode+"1\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"8619183595\",\"product\":\"P_SETTLE_LFB_SSFMD\",\"accountName\":\"张三\",\"accountNo\":\"6226090000000048\",\"bankCode\":\"ICBC\",\"bankName\":\"中国工商银行股份有限公司北京通州支行新华分理处\",\"amount\":0.01,\"fee\":0.0,\"use\":\"卡友打款\",\"memo\":\"\",\"province\":\"北京\",\"city\":\"北京\",\"cnapsCode\":\"102100000021\",\"sabkCode\":\"102100000021\",\"ownBankCode\":\"\"}"
            //+ ",{\"class\":\".InterfaceRemitBill\",\"institNo\":\"PAY\",\"billCode\":\"RB007139715646\",\"requestSeriaNum\":\"R"+batchCode+"2\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"8611300496\",\"product\":\"P_SETTLE_LFB_SSFMD\",\"accountName\":\"王二\",\"accountNo\":\"6226660204026278\",\"bankCode\":\"ICBC\",\"bankName\":\"江苏农村信用社\",\"amount\":1,\"fee\":0.0,\"use\":\"乐富打款\",\"memo\":\"\",\"province\":\"新疆\",\"city\":\"北京市\",\"cnapsCode\":\"303100000014 \",\"sabkCode\":\"303100000006\",\"ownBankCode\":\"\"}"
            //+ ",{\"class\":\".InterfaceRemitBill\",\"institNo\":\"PAY\",\"billCode\":\"RB007139715647\",\"requestSeriaNum\":\"R"+batchCode+"3\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"8611300496\",\"product\":\"P_SETTLE_LFB_SSFMD\",\"accountName\":\"王二\",\"accountNo\":\"6226660204026278\",\"bankCode\":\"ICBC\",\"bankName\":\"中国光大银行北京分行\",\"amount\":0.01,\"fee\":0.0,\"use\":\"乐富打款\",\"memo\":\"\",\"province\":\"江西省\",\"city\":\"南昌\",\"cnapsCode\":\"303100000014 \",\"sabkCode\":\"303100000006\",\"ownBankCode\":\"\"}"
            //+ ",{\"class\":\".InterfaceRemitBill\",\"institNo\":\"PAY\",\"billCode\":\"RB007139715648\",\"requestSeriaNum\":\"R"+batchCode+"4\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"8611300496\",\"product\":\"P_SETTLE_LFB_SSFMD\",\"accountName\":\"王二\",\"accountNo\":\"6226660204026278\",\"bankCode\":\"ICBC\",\"bankName\":\"中国光大银行北京分行\",\"amount\":0.01,\"fee\":0.0,\"use\":\"乐富打款\",\"memo\":\"\",\"province\":\"江西\",\"city\":\"南昌市辖区\",\"cnapsCode\":\"303100000014 \",\"sabkCode\":\"303100000006\",\"ownBankCode\":\"\"}"
            //+ "]}";
            // REMIT_JL_584001,REMIT_YS_290002  86301002522 海科商户  REMIT_GWF_100001
            //String dataJson = "{\"interfaceInfoCode\":\"REMIT_PAB_393001\",\"batchCode\":\""+batchCode+"\",\"totalNumber\":1,\"totalAmount\":27.48,\"interfaceRemitBills\":[{\"class\":\".InterfaceRemitBill\",\"billCode\":\"B20180820001\",\"requestSeriaNum\":\"R"+batchCode+"1\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"8619183595\",\"product\":\"D0YISHI\",\"accountName\":\"罗展\",\"accountNo\":\"6227002921190314417\",\"bankCode\":\"CCB\",\"bankName\":\"中国建设银行股份有限公司长沙经济技术开发区支行\",\"amount\":27.48,\"fee\":0.0,\"use\":\"XX打款\",\"memo\":\"\",\"province\":\"湖南\",\"city\":\"长沙市\",\"cnapsCode\":\"105551009051\",\"sabkCode\":\"105100000017\",\"ownBankCode\":\"\",\"institNo\":null,\"clearanceTime\":null,\"idCode\":null,\"clearingMerchantCode\":null,\"billType\":null,\"clearingMerchantName\":null,\"settleType\":null,\"acctType\":null,\"transDate\":1534728040000,\"attachFee\":1.23,\"oriRefNo\":\"000000447074\",\"channel
            //
            //
            //
            // MerId\":null}]}";
            String code = System.currentTimeMillis()+"";
            String dataJson = "{\"code\":\"SABMDU4W1LEV0HWQN9QD94\",\"attachFee\":0.01,\"orderNo\":\"BMDRGULH4E457N80VK10\",\"interfaceInfoCode\":\"REMIT_YB_100002\",\"institNo\":\"NPAY\",\"sentTime\":1566296584901,\"transSeriNo\":\"1001201908210000001046605257\",\"ownerID\":\"8619183510\",\"oriRefNo\":\"79BMEHN9000G\"}";
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
        System.out.println("");
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
            throw new Exception("压缩数据异常", e);
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
