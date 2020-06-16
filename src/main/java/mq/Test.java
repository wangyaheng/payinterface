package mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import utils.HttpClientUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        String batchCode="B"+System.currentTimeMillis();
       // String data = "{\"requestCode\":\""+batchCode+"\",\"requestTime\":\"2020-03-12 15:18:44\",\"paytradeType\":\"TAX_SOURCE_REMIT_CHANNELPAY\",\"conTradeBean\":{\"custBatchNo\":\"2131414141212\",\"batchNum\":1,\"batchAmt\":1000.00,\"remitDetailList\":[{\"custOrderNo\":\"PD2020031100002\",\"orderAmt\":1000.00,\"recvCustName\":\"123\",\"recvMobile\":\"18683860570\",\"recvIdType\":\"510623198809216118\",\"recvIdNo\":\"510623198809216118\",\"recvCardNo\":\"6227003811540285178\",\"recvBankName\":\"健身银行\",\"remark\":\"hello\"}],\"request_business_no\":\"2131414141212\"},\"interfaceInfoCode\":\"REMIT_FQB_100001\"}";
        String data = "{\"requestCode\":\""+batchCode+"\",\"requestTime\":\"123\",\"paytradeType\":\"OPEN_ACC\",\"conTradeBean\":{\"enterprise_business_license\":\"123\",\"enterprise_tax_no\":\"123\",\"enterprise_unified_code\":\"123\",\"enterprise_credit_code\":\"123\",\"trade_password\":\"123\",\"random_client\":\"123\",\"need_notify\":\"123\",\"notify_url\":\"123\",\"protocol_list\":null,\"individual_reserved_phone_no\":\"123\",\"additional_virtual_acct_type\":\"123\",\"individual_cvn2\":\"123\",\"biz_no\":\"123\",\"individual_valid_date\":\"123\",\"open_virtual_acct_type\":\"123\",\"enterprise_legal_name\":\"123\",\"appId\":\"123\",\"enterprise_legal_id_card_type\":\"123\",\"enterprise_legal_id_card_no\":\"123\",\"enterprise_contact_name\":\"123\",\"enterprise_contact_phone\":\"123\",\"enterprise_bank_name\":\"123\",\"enterprise_bank_code\":\"123\",\"version\":\"123\",\"platform_no\":\"123\",\"message_captcha\":\"123\",\"unit_type\":\"123\",\"customer_type\":\"123\",\"platform_customer_no\":\"123\",\"customer_full_name\":\"123\",\"individual_id_card_no\":\"123\",\"individual_bank_card_no\":\"123\",\"individual_id_card_front_id\":\"123\",\"individual_id_card_back_id\":\"123\",\"individual_id_card_valid_date\":\"123\",\"individual_nationality\":\"123\",\"individual_sex\":\"123\",\"individual_company\":\"123\",\"individual_website\":\"123\",\"individual_mail\":\"123\",\"individual_vocation\":\"123\",\"enterprise_business_scope\":\"123\",\"enterprise_license_name\":\"123\",\"enterprise_license_valid_date\":\"123\",\"enterprise_license_file_id\":\"123\",\"enterprise_trade\":\"123\",\"enterprise_legal_id_card_valid_date\":\"123\",\"enterprise_legal_id_card_front_id\":\"123\",\"enterprise_legal_id_card_back_id\":\"123\",\"enterprise_shareholder_id_card_type\":\"123\",\"enterprise_shareholder_id_card_no\":\"123\",\"enterprise_shareholder_id_card_valid_date\":\"123\",\"enterprise_shareholder_id_card_file_id\":\"123\",\"enterprise_oprator_name\":\"123\",\"enterprise_oprator_conctact_phone\":\"123\",\"enterprise_oprator_id_card_type\":\"123\",\"enterprise_oprator_id_card_no\":\"123\",\"enterprise_oprator_id_card_valid_date\":\"123\",\"enterprise_oprator_id_card_front_id\":\"123\",\"enterprise_oprator_id_card_back_id\":\"123\",\"enterprise_beneficiary_name\":\"123\",\"enterprise_beneficiary_conctact_phone\":\"123\",\"enterprise_beneficiary_id_card_type\":\"123\",\"enterprise_beneficiary_id_card_no\":\"123\",\"enterprise_beneficiary_id_card_valid_date\":\"123\",\"enterprise_beneficiary_id_card_front_id\":\"123\",\"enterprise_beneficiary_id_card_back_id\":\"123\",\"enterprise_bank_card_no\":\"123\",\"enterprise_org_no\":\"123\",\"trust_account_flag\":\"123\",\"employer_customer_full_name\":\"123\",\"employer_enterprise_legal_name\":\"123\",\"employer_enterprise_unified_code\":\"123\",\"employer_enterprise_contact_id_card_no\":\"123\",\"employer_enterprise_contact_name\":\"123\",\"employer_enterprise_contact_phone\":\"123\"},\"interfaceInfoCode\":\"REMIT_XW_100001\",\"properties\":\"123\"}";
        try {
           // String send = HttpClientUtils.send(HttpClientUtils.Method.POST, "http://10.10.129.193:8885/payinterface-front/complexRequest/complexTrade", data, false, "UTF-8");
            StringEntity stringEntity = new StringEntity(data,"UTF-8");
            stringEntity.setContentType("text/json");

            Map<String,String> header  = new HashMap<>();
           header.put("Content-Type", "text/html");
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();
            //nameValuePairs.add(new BasicNameValuePair("requestData", data));
           String send =  HttpClientUtils.send(HttpClientUtils.Method.POST ,"http://10.10.129.193:8885/tax-payinterface-front/complexTrade" , header,stringEntity ,nameValuePairs,false ,"UTF-8" , stringResponseHandler,null );
            System.out.println(send);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static ResponseHandler<String> stringResponseHandler = new ResponseHandler<String>() {
        @Override
        public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println(statusCode);
            if (statusCode >= 200 && statusCode < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + statusCode);
            }
        }
    };
}
