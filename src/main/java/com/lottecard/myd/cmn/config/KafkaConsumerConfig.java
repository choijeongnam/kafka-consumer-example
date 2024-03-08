package com.lottecard.myd.cmn.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	@Value("${spring.kafka.bootstrap-servers}")
	private String servers;

	@Value("${spring.kafka.group-id}")
	private String groupId;

//	@Bean
//	public ProducerFactory<String, KafkaMsgVO> msgProducerFactory() {
//		Map<String, Object> config = new HashMap<>();
//		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
//		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//		return new DefaultKafkaProducerFactory<>(config);
//	}
//
//	@Bean
//	public KafkaTemplate<String, KafkaMsgVO> msgKafkaTemplate(){
//		return new KafkaTemplate<>(msgProducerFactory());
//	}

	@Bean
	public ConsumerFactory<String, String> msgConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		return new DefaultKafkaConsumerFactory<>(props);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListener() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory =
				new ConcurrentKafkaListenerContainerFactory<>();

		// 기본 팩토리 설정
		factory.setConsumerFactory(msgConsumerFactory());
		return factory;
	}
}
