package mq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.lefu.astrotrain.client.ATMessage;
import com.lefu.astrotrain.client.MessageListener;
import com.lefu.astrotrain.client.consumer.DefaultATPushConsumer;

public class Consumer {
	public static void main(String[] args) throws Exception {
		DefaultATPushConsumer atPushConsumer = new DefaultATPushConsumer();
		atPushConsumer.setGroupName("payinterface-core");
		atPushConsumer.setInstanceName("ProducerAT_STT2");
		atPushConsumer.setNamesrvAddr("10.10.111.43:9876");
		/*atPushConsumer.setGroupName("reverse-core");
		atPushConsumer.setInstanceName("reverse-core-ProducerAT_STT");
		atPushConsumer.setNamesrvAddr("10.10.110.51:9876");*/
		atPushConsumer.subscribe("test2", new MessageListener() {

			@Override
			public void onMessage(ATMessage arg0) {
				// TODO Auto-generated method stub
				System.out.println(arg0);
			}
			
		});
		atPushConsumer.start();
	}
}
