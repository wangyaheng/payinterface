package kafka.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

public class ConsumerDemo {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        // 用来确认分区
        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer", StringDeserializer.class.getName());
        // 默认提交偏移量设置为false
        properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        properties.setProperty("group.id", "test-group");
        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Collections.singletonList("topic-test"), new ConsumerRebalanceListener() {
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> collection) {
                // 分区在均衡的时候进行回调，防止偏移量提交不及时，造成重复消费
            }

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> collection) {

            }
        });
        // kafka只能主动去拉取消息
        try{
            while(true){
                ConsumerRecords<String, String> poll = consumer.poll(500);
                for (ConsumerRecord<String, String> stringStringConsumerRecord : poll) {
                    System.out.println(stringStringConsumerRecord.key());
                    System.out.println(stringStringConsumerRecord.offset());
                    System.out.println(stringStringConsumerRecord.partition());
                    System.out.println(stringStringConsumerRecord.value());
                    System.out.println(stringStringConsumerRecord.key());
                }
                // 异步提交
                consumer.commitAsync();
            }
        }catch (Exception e){
            try{
                // 同步提交
                consumer.commitSync();
            }catch (Exception e1){
                consumer.close();
            }

        }

    }
}
