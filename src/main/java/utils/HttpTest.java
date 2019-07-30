/*
package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import utils.HttpClientUtils.Method;

import com.lefu.commons.utils.lang.JsonUtils;



public class HttpTest {
	
	public static void main(String[] args) throws IOException {
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("customerNo", "86211155035");
		params.put("queryDate", "2019-03-08 00:00:00");

		Map<String,String> heads = new HashMap<String,String>();
		Properties prop = new Properties();
		prop.put("proxyIp", "127.0.0.1");
		prop.put("proxyPort", "8888");
		heads.put("dealer-id", "1233425243");
		heads.put("request-id", "122235324");
		String send = send(prop, JsonUtils.toJsonString(params), "http://10.10.129.56:8081/customer-buss-service/CustomerBuss/findEffectedCustExt" , Method.POST, heads);
		System.out.println(send);
	}
	
	*/
/**
	 * @Description ���ͱ���
	 * @param prop
	 * @param message
	 * @param uriName
	 * @return
	 * @throws IOException
	 * @see ��Ҫ�ο�����򷽷�
	 *//*

	public static String send(Properties prop, String message, String uriName,Method method,Map<String,String> heads) throws IOException {
		HashMap<String, String> msg = JsonUtils.toObject(message, HashMap.class);
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		Iterator iterator = msg.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> elem = (Entry<String, String>) iterator.next();
			nameValuePairs.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
		}

		*/
/*StringEntity entity = new StringEntity(message, "utf-8");// ���������������
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/x-www-form-urlencoded");*//*

		// ����������URL��ַ
		String proxyip = prop.getProperty("proxyIp");
		int proxyport = Integer.valueOf(prop.getProperty("proxyPort"));
		HttpHost proxy = new HttpHost(proxyip, proxyport);
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(180000).setConnectTimeout(20000).setSocketTimeout(20000)
				.build();
		String response = HttpClientUtils.send(method, uriName, heads, null, nameValuePairs, true, "UTF-8", stringResponseHandler, null, requestConfig);

		return response;
	}

	static {
		stringResponseHandler = new ResponseHandler<String>() {
			@Override
			public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode >= 200 && statusCode < 300) {
					HttpEntity entity = response.getEntity();
					return entity != null ? EntityUtils.toString(entity, "UTF-8") : null;
				} else {
					throw new ClientProtocolException("Unexpected response status: " + statusCode);
				}
			}
		};
	}
	
	private static ResponseHandler stringResponseHandler;

}
*/
