package com.kafkalearn.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.kafkalearn.partitioner.ProducerKafkaPartitioner;

public class ProducerKafka {
	public static void main(String[] args) {
		Properties properties=new Properties();
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("partitioner.class", ProducerKafkaPartitioner.class.getName());
		
		KafkaProducer<String,String> myProducer= new KafkaProducer<String,String>(properties);
		
			try {
			
			for(int i=-1;i<10000;i++){
				myProducer.send(new  ProducerRecord<String, String>("demo-topic", "Message Value : " + Integer.toString(i)));
				myProducer.send(new  ProducerRecord<String, String>("demo-topic", "url:<local-directory-path>/file"));

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			myProducer.close();
		}
}

}
