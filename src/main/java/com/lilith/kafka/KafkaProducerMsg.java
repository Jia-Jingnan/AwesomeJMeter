package com.lilith.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @Author:JiaJingnan
 * @Date: 上午11:36 2021/8/24
 */
public class KafkaProducerMsg {

    public static void main(String[] args) {

        // 指定kafka配置
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.1.9:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        //创建生产者
        Producer producer = new KafkaProducer(properties);
        // 发送消息
        producer.send(new ProducerRecord("test","message111"));
        // 关闭
        producer.close();
    }
}
