package  other;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import  java.io.IOException;
import  java.io.UnsupportedEncodingException;
import  java.net.URLEncoder;
import  java.util.ArrayList;
import  java.util.Collections;
import  java.util.HashMap;
import  java.util.Iterator;
import  java.util.List;
import  java.util.Map;
import  java.util.Map.Entry;

import  org.apache.http.HttpEntity;
import  org.apache.http.HttpResponse;
import  org.apache.http.NameValuePair;
import  org.apache.http.client.HttpClient;
import  org.apache.http.client.entity.UrlEncodedFormEntity;
import  org.apache.http.client.methods.HttpPost;
import  org.apache.http.message.BasicNameValuePair;
import  org.apache.http.params.CoreConnectionPNames;
import  org.apache.http.util.EntityUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import  org.codehaus.jackson.JsonParseException;
import  org.codehaus.jackson.map.JsonMappingException;
import  org.codehaus.jackson.map.ObjectMapper;
import  org.slf4j.Logger;
import  org.slf4j.LoggerFactory;

import  com.lefu.commons.utils.lang.StringUtils;
import  com.lefu.commons.utils.security.DigestUtils;

public  class  TestAuth2  {
private  static  final  Logger  logger  =  LoggerFactory.getLogger(TestAuth.class);
public  static  void  main(String[]  args)  throws  Exception  {
	
	try {
		FileInputStream fis = new FileInputStream("C://Users//hasee//Desktop//5.xlsx");
		XSSFRow row = null;
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(5);
		int lastRowNum = sheet.getLastRowNum();
		for(int i=0;i<=lastRowNum;i++) {
			 row = sheet.getRow(i);
			String name = row.getCell(0).getStringCellValue();
			String cert = row.getCell(1).getStringCellValue();
			String card = row.getCell(2).getStringCellValue();
			
			//  
			 String  reutrnResult  =  "";

			 //  ƴװ����
			 Map<String,  String>  paramMap  =  new  HashMap<String,  String>();
			 paramMap.put("apiCode",  "directPay");
			 paramMap.put("versionCode",  "1.0");
			 paramMap.put("inputCharset",  "UTF-8");
			 paramMap.put("signType",  "MD5");
			 //paramMap.put("notifyURL","notifyURL=http://192.168.101.60:8080/agent/customerAuthNotify.action");  //  
			 paramMap.put("notifyURL","http://www.baidu.com/");
			 //paramMap.put("partner",  "86101961874");//  ��������
			 paramMap.put("partner",  "86191111139");  //  ���Ѳ���
			 //paramMap.put("partner",  "86101162845");  //  ���Ѳ���
			 //paramMap.put("partner",  "8627193115");//  
			 paramMap.put("requestCode",  "RQJHF3"  +  System.currentTimeMillis());
			 paramMap.put("busiType",  "BINDCARD_AUTH");//����֤
			 //paramMap.put("busiType",  "IDENTITY_AUTH");//  �����֤
			 paramMap.put("payerName",name);
			 paramMap.put("bankCardNo",card);
			 paramMap.put("certNo",cert);
			 //paramMap.put("payerMobNo",  "13764606069");
			 //paramMap.put("extParam",  "");
			 //paramMap.put("returnParam",  "");

			 //  sign
			 ArrayList<String>  paramNames  =  new  ArrayList<>(paramMap.keySet());
			 Collections.sort(paramNames);
			 //  ����
			 StringBuilder  signSource  =  new  StringBuilder();
			 Iterator<String>  iterator  =  paramNames.iterator();
			 String  payerName  = name;
			 while  (iterator.hasNext())  {
			 String  paramName  =  iterator.next();
			 if  (StringUtils.notBlank(paramMap.get(paramName)))  {
			 signSource.append(paramName).append("=").append(paramMap.get(paramName));
			 if  (iterator.hasNext())  signSource.append("&");
			 }
			 }
			 //  ǩ��
			 String  calSign  =  null;
			 //signSource.append("4AF07A08A1EDA969FF414AD6C8A1292F");//
			 //signSource.append("8709BA92BEA2072A060F5DA1F9E5E667");//
			 signSource.append("5E1524AABA00627C87DD2E28726AA785");//
			 logger.info(":{}", signSource.toString());
			 //int i = 1/0;
			 try {
			 calSign = DigestUtils.md5DigestAsHex(signSource.toString().getBytes("UTF-8")).toUpperCase();
			 } catch (UnsupportedEncodingException e) {}
			 // 
			 paramMap.put("sign", calSign);
			 payerName = URLEncoder.encode(paramMap.get("payerName"), "UTF-8");
			 paramMap.put("payerName", payerName);
			 System.out.println(paramMap);

			 //logger.info(":{}", paramMap.toString());

			 // auth-url
			 // String url = "http://127.0.0.1:7075/auth-core/hessian/authConfigHessianService";
			// String url = "http://10.10.129.49:8083/auth-front/auth/trade.htm";//���Ѳ���
			 //String url = "http://116.213.198.30/auth-front/auth/trade.htm";
			  String url = "https://jh.cardinfo.com.cn/auth-front/auth/trade.htm";//��������
			 try {
			 //reutrnResult = HttpClientUtils.send(Method.POST, url, paramMap, true, "UTF-8");
			 //reutrnResult = HttpClientUtils.send(Method.POST, url, paramMap, true, "UTF-8", 30000);
			 reutrnResult = doPost(url, paramMap, "UTF-8");
			 System.out.println(reutrnResult);
			 ResponseMsg json2Bean = json2Bean(reutrnResult);
			 //System.out.println(json2Bean);

			  FileWriter fw = new FileWriter("C://Users//hasee//Desktop//6.txt", true);
	            BufferedWriter bw = new BufferedWriter(fw);
	            bw.append(name+"   "+card+"   "+cert+ "   "+json2Bean.getResponseMsg());
	            bw.write("\r\n ");// �����е��ļ�������ַ���
	           
	            bw.close();
	            fw.close();
			 String responseMsg = json2Bean.getResponseMsg();
			 // 
			 } catch (Exception e) {
			 e.printStackTrace();
			 }
		}
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}







}



public static String doPost(String url,Map<String,String> map,String charset){  
        HttpClient httpClient = null;  
        HttpPost httpPost = null;  
        String result = null;  
        try{  
        	httpClient = new SSLClient(); 
        	httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 100000);
            httpPost = new HttpPost(url);  
            //����
            List<NameValuePair> list = new ArrayList<NameValuePair>();  
            Iterator iterator = map.entrySet().iterator();  
            while(iterator.hasNext()){  
                Entry<String,String> elem = (Entry<String, String>) iterator.next();  
                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));  
            }  
            if(list.size() > 0){  
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);  
                httpPost.setEntity(entity);  
            }  
            HttpResponse response = httpClient.execute(httpPost);  
            if(response != null){  
                HttpEntity resEntity = response.getEntity();  
                if(resEntity != null){  
                    result = EntityUtils.toString(resEntity,charset);  
                }  
            }  
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
        return result;  
    }  
public static ResponseMsg json2Bean(String jsonStr) throws JsonParseException, JsonMappingException, IOException {
ObjectMapper mapper = new ObjectMapper();
return mapper.readValue(jsonStr, ResponseMsg.class);
}
}