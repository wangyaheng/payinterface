package other;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;

public class TestOther {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="zookeeper://10.10.110.58:2181";

		System.out.println(str.substring(12));
		System.out.println(TestOther.getLocalServerIP());
		if(1458273372796L==1458273372796L){
			System.out.print("1");
		}
		if(Long.valueOf("1458273372796")==1458273372796L){
			System.out.print("2");
		}
	}
	public static String getLocalServerIP(){
        InetAddress addr = null;
         try {
                      addr = InetAddress.getLocalHost();
         } catch (UnknownHostException e) {
                        e.printStackTrace();
         }

         byte[] ipAddr = addr.getAddress();
          StringBuilder ipAddrStr = new StringBuilder();
           for (int i = 0; i < ipAddr.length; i++) {
                    if (i > 0) {
                        ipAddrStr .append( ".");
                    }
                    ipAddrStr.append(ipAddr[i] & 0xFF);
            }
            return ipAddrStr.toString();
        }

}
