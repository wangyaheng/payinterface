package zookeeper;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZkTest2 {
	public static void main(String[] args) throws Exception {

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					ZooKeeper zooKeeper = new ZooKeeper("10.10.110.58:2181",
							5000, new Watcher() {
								public void process(WatchedEvent event) {

								}
							});
					try {

						Thread.sleep(30000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					ZkTest2 zkTest2 = new ZkTest2();
					zkTest2.set(zooKeeper);
				} catch (KeeperException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					while (true) {
						Thread.sleep(1000L);

					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t.start();
		while (true) {
			Thread.sleep(1000L);

		}
	}

	public void set(final ZooKeeper zooKeeper) throws KeeperException,
			InterruptedException {
		final ZKWatcherService z = new ZKWatcherService();
		Stat stat = zooKeeper.exists("/payinterface-core-register",
				new Watcher() {
					public void process(WatchedEvent event) {
						if (event.getType().getIntValue() == 3) {
							z.handle();
							try {
								set(zooKeeper);
							} catch (KeeperException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				});
	}
}
