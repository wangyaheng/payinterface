package zookeeper;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;
import org.apache.zookeeper.data.Stat;



public class ZkTest {
	public static void main(String[] args) throws Exception{
		new ZkTest().ZKClientBean();
	}
	
	public ZooKeeper ZKClientBean() throws Exception {
		  CountDownLatch connectedLatch = new CountDownLatch(1);
        Watcher watcher = new ConnectedWatcher(connectedLatch);

		 ZooKeeper zooKeeper = new ZooKeeper("10.10.110.58:2181",
			        5000, watcher);

		 if (States.CONNECTING == zooKeeper.getState()) {
	            try {
	                connectedLatch.await();
	            } catch (InterruptedException e) {
	                throw new IllegalStateException(e);
	            }
	     }

		 try{
			 Stat stat=zooKeeper.exists("/payinterface-core-register", new Watcher() {
		            public void process(WatchedEvent event) {
		               System.out.println("宸茬粡瑙﹀彂浜�" + event.getType() + "浜嬩欢锛�");
		               if(event.getType().getIntValue()==3){
		            	   System.out.println("宸茬粡瑙﹀彂浜�3浜嬩欢锛�");
		               }
		            }
		        });
			 Integer version=stat.getVersion();
			 zooKeeper.setData("/payinterface-core-register", "9".getBytes(), version);
//			 if(stat==null){
			 
			List<String> list= zooKeeper.getChildren("/payinterface-core-register",   new Watcher() {
		            public void process(WatchedEvent event) {
		               System.out.println("宸茬粡瑙﹀彂浜�" + event.getType() + "浜嬩欢锛�");
		            }
		        });

			for(String str:list){
				System.out.println(str);
			}
//			 }
			// 鍒涘缓涓�涓瓙鐩綍鑺傜偣
//			String nodeName=	 zooKeeper.create("/payinterface-core-register"+"/serverip"
//					, this.getLocalServerIP().getBytes(),
//			   Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
//			System.out.println("Server Ip IP_REGISTER_PATH:"+nodeName);
		 }catch(Exception e){
			 e.printStackTrace();
		 }

		return zooKeeper;
	}
	 static class ConnectedWatcher implements Watcher {

	        private CountDownLatch connectedLatch;

	        ConnectedWatcher(CountDownLatch connectedLatch) {
	            this.connectedLatch = connectedLatch;
	        }

	        @Override
	        public void process(WatchedEvent event) {
	        	System.out.println("宸茬粡瑙﹀彂浜�" + event.getType() + "浜嬩欢锛�");
	           if (event.getState() == KeeperState.SyncConnected) {
	               connectedLatch.countDown();
	           }
	        }
	    }
	 private  String getLocalServerIP(){
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
