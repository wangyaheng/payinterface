package mq;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;

import com.lefu.commons.utils.lang.JsonUtils;

class EnTask implements Runnable{
	CyclicBarrier cyclicBarrier;
	public  EnTask(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+":线程开始执行");
		Map<String,String> map = new HashMap<>();
		for(int i=0;i<6;i++){
			map.put(i+"", System.currentTimeMillis()+"");
		}
		try {
			cyclicBarrier.await();
			String encrypt = RSAUtils.encrypt(JsonUtils.toJsonString(map));
			System.out.println(encrypt);
			String decrypt = RSAUtils.decrypt(encrypt);
			System.out.println(decrypt);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
		
	
	
}	