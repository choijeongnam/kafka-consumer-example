package com.lottecard.myd.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerExample1 {
	
	private final Logger logger = LoggerFactory.getLogger(KafkaConsumerExample1.class);
	
	@KafkaListener(topics = "test", groupId = "kafka-consumer-group1")
	public void listener(ConsumerRecord<String, String> record) {
		logger.info("record: {}", record);
	}
}
