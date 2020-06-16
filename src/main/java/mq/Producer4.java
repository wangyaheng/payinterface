package mq;

import com.lefu.astrotrain.client.ATMessage;
import com.lefu.astrotrain.client.ATProducer;
import com.lefu.astrotrain.client.message.ObjectMessage;
import com.lefu.astrotrain.client.message.StringMessage;
import com.lefu.astrotrain.client.producer.DefaultATProducer;
import com.lefu.commons.utils.lang.JsonUtils;
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
public class Producer4 {


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
            //ATProducer atProducer=defaultATProducer.createProducer("complex_trade");
            //ATProducer atProducer=defaultATProducer.createProducer("mdsettle-channel_settle_remit");
            ATProducer atProducer=defaultATProducer.createProducer("YJ_REMIT_INTERATIVE_THEME");
            StringMessage msg = new StringMessage();

            String batchCode="B"+System.currentTimeMillis();

            String dataJson = "{\"interfaceInfoCode\":\"REMIT_MOCK_100001\",\"batchCode\":\""+batchCode+"\",\"totalNumber\":1,\"totalAmount\":1,\"interfaceRemitBills\":[{\"class\":\".InterfaceRemitBill\",\"billCode\":\"RB"+batchCode+"\",\"requestSeriaNum\":\"R"+batchCode+"\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"36301920522 \",\"product\":\"D0YISHI\",\"accountName\":\"123\",\"accountNo\":\"gywdlx2352@sandbox.com\",\"bankCode\":\"BOC\",\"bankName\":\"1234\",\"amount\":1,\"fee\":0.0,\"use\":\"123\",\"memo\":\"123\",\"province\":\"123\"," +
                    "\"cnapsCode\":\"103100000026\",\"sabkCode\":\"103100000026\",\"ownBankCode\":\"\",\"institNo\":null,\"clearanceTime\":null,\"idCode\":\"120108198408080123\",\"clearingMerchantCode\":null,\"billType\":null,\"clearingMerchantName\":null,\"settleType\":null,\"acctType\":null,\"transDate\":1534728040000,\"attachFee\":0,\"oriRefNo\":\"000000447074\",\"channelMerId\":\"10027950865\",\"orderNo\":\"BL8TWRLWJ105GTPD4UKG\",\"phoneNo\":\"13833333333\"}]}";
            String openAccdataJson1 = "{\"requestCode\":\""+batchCode+"\",\"requestTime\":\"123\",\"paytradeType\":\"OPEN_ACC\",\"conTradeBean\":{\"enterprise_business_license\":\"123\",\"enterprise_tax_no\":\"123\",\"enterprise_unified_code\":\"123\",\"enterprise_credit_code\":\"123\",\"trade_password\":\"123\",\"random_client\":\"123\",\"need_notify\":\"123\",\"notify_url\":\"123\",\"protocol_list\":null,\"individual_reserved_phone_no\":\"123\",\"additional_virtual_acct_type\":\"123\",\"individual_cvn2\":\"123\",\"biz_no\":\"123\",\"individual_valid_date\":\"123\",\"open_virtual_acct_type\":\"123\",\"enterprise_legal_name\":\"123\",\"appId\":\"123\",\"enterprise_legal_id_card_type\":\"123\",\"enterprise_legal_id_card_no\":\"123\",\"enterprise_contact_name\":\"123\",\"enterprise_contact_phone\":\"123\",\"enterprise_bank_name\":\"123\",\"enterprise_bank_code\":\"123\",\"version\":\"123\",\"platform_no\":\"123\",\"message_captcha\":\"123\",\"unit_type\":\"123\",\"customer_type\":\"123\",\"platform_customer_no\":\"123\",\"customer_full_name\":\"123\",\"individual_id_card_no\":\"123\",\"individual_bank_card_no\":\"123\",\"individual_id_card_front_id\":\"123\",\"individual_id_card_back_id\":\"123\",\"individual_id_card_valid_date\":\"123\",\"individual_nationality\":\"123\",\"individual_sex\":\"123\",\"individual_company\":\"123\",\"individual_website\":\"123\",\"individual_mail\":\"123\",\"individual_vocation\":\"123\",\"enterprise_business_scope\":\"123\",\"enterprise_license_name\":\"123\",\"enterprise_license_valid_date\":\"123\",\"enterprise_license_file_id\":\"123\",\"enterprise_trade\":\"123\",\"enterprise_legal_id_card_valid_date\":\"123\",\"enterprise_legal_id_card_front_id\":\"123\",\"enterprise_legal_id_card_back_id\":\"123\",\"enterprise_shareholder_id_card_type\":\"123\",\"enterprise_shareholder_id_card_no\":\"123\",\"enterprise_shareholder_id_card_valid_date\":\"123\",\"enterprise_shareholder_id_card_file_id\":\"123\",\"enterprise_oprator_name\":\"123\",\"enterprise_oprator_conctact_phone\":\"123\",\"enterprise_oprator_id_card_type\":\"123\",\"enterprise_oprator_id_card_no\":\"123\",\"enterprise_oprator_id_card_valid_date\":\"123\",\"enterprise_oprator_id_card_front_id\":\"123\",\"enterprise_oprator_id_card_back_id\":\"123\",\"enterprise_beneficiary_name\":\"123\",\"enterprise_beneficiary_conctact_phone\":\"123\",\"enterprise_beneficiary_id_card_type\":\"123\",\"enterprise_beneficiary_id_card_no\":\"123\",\"enterprise_beneficiary_id_card_valid_date\":\"123\",\"enterprise_beneficiary_id_card_front_id\":\"123\",\"enterprise_beneficiary_id_card_back_id\":\"123\",\"enterprise_bank_card_no\":\"123\",\"enterprise_org_no\":\"123\",\"trust_account_flag\":\"123\",\"employer_customer_full_name\":\"123\",\"employer_enterprise_legal_name\":\"123\",\"employer_enterprise_unified_code\":\"123\",\"employer_enterprise_contact_id_card_no\":\"123\",\"employer_enterprise_contact_name\":\"123\",\"employer_enterprise_contact_phone\":\"123\"},\"interfaceInfoCode\":\"REMIT_XW_100001\",\"properties\":\"123\"}";
            String transfer = "{\"requestCode\":\""+batchCode+"\",\"requestTime\":\"123\",\"paytradeType\":\"TRANS_ACCOUNT\",\"conTradeBean\":{\"interfaceInfoCode\":\"123\",\"status\":null,\"bankRespCode\":\"123\",\"bankRespMsg\":\"123\",\"orderNo\":\"123\",\"bankRequestNo\":\"123\",\"bankRespNo\":\"123\",\"lastUpdateTime\":\"123\",\"bankRespResult\":\"123\",\"transAmountType\":\"VIRTUAL_MUTUAL\",\"tran_no\":\"123\",\"payer_platform_customer_no\":\"123\",\"payer_virtual_acct_no\":\"123\",\"payee_platform_customer_no\":\"123\",\"payee_virtual_acct_no\":\"123\",\"ccy\":\"123\",\"amt\":\"123\",\"commission\":\"123\",\"remark\":\"123\",\"summary\":\"123\",\"need_notify\":\"123\",\"notify_url\":\"123\",\"tran_type\":\"123\",\"biz_no\":\"123\",\"trade_password\":\"123\",\"random_client\":\"123\"},\"interfaceInfoCode\":\"REMIT_XW_100001\"}";
            String createProtol = "{\"requestCode\":\""+batchCode+"\",\"requestTime\":\"123\",\"paytradeType\":\"CREATE_PROTOCAL_NUMBER\",\"conTradeBean\":{\"version\":\"123\",\"platform_no\":\"123\",\"platform_customer_no\":\"123\",\"scene_code\":\"123\",\"virtual_acct_no\":\"123\",\"protocol_list\":[{\"protocol_name\":\"456\",\"protocol_item\":\"1234\"}]},\"interfaceInfoCode\":\"REMIT_XW_100001\",\"properties\":\"123\"}";
            //String dataJson = "{\"interfaceInfoCode\":\"REMIT_GWF_100002\",\"batchCode\":\""+batchCode+"\",\"totalNumber\":1,\"totalAmount\":0.19,\"interfaceRemitBills\":[{\"class\":\".InterfaceRemitBill\",\"billCode\":\"B201908220051\",\"requestSeriaNum\":\"-RBD0029517187\",\"ownerRole\":\"CUSTOMER\",\"ownerID\":\"8619183510\",\"product\":\"LFB_MDSMYIBAOX58500401\",\"accountName\":\"?????\",\"accountNo\":\"6226192300338050\",\"bankCode\":\"CMBC\",\"bankName\":\"?й????????й????????????????\",\"amount\":0.19,\"fee\":0.0,\"use\":\"?????\",\"memo\":\"\",\"province\":\"????\",\"city\":\"?????\",\"cnapsCode\":\"305397823084\",\"sabkCode\":\"305100000013\",\"ownBankCode\":\"\",\"institNo\":null,\"clearanceTime\":null,\"idCode\":null,\"clearingMerchantCode\":null,\"billType\":null,\"clearingMerchantName\":null,\"settleType\":null,\"acctType\":null,\"transDate\":1566454271000,\"attachFee\":0.0,\"oriRefNo\":\"79BMF33XQ00L\",\"channelMerId\":null,\"terminalNo\":null,\"bankRequestNo\":null,\"orderNo\":\"BMF33XLH4E47JM0R331G\",\"channelCost\":0.0}],\"preRemitRecordBean\":null}";
            byte[] data = compress(dataJson.getBytes("UTF-8"));
            msg.setMsg(dataJson);
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
            String json = JsonUtils.toJsonString(callBack);
            strmessage.setMsg(json);
            System.out.println("batchCode:"+batchCode);
            System.out.println(dataJson);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            defaultATProducer.shutdown();
        }

    }

    public static byte[] compress(byte[] data) throws Exception {
        byte[] output = new byte[0];

        Deflater compresser = new Deflater();
        System.out.println();
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
            System.out.println();
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