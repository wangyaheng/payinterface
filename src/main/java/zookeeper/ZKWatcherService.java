package zookeeper;

import java.util.Date;

public class ZKWatcherService {
	public void handle(){
		System.out.println(new Date(System.currentTimeMillis())+"执行ZKWatcherService.handle()");
	}
}
