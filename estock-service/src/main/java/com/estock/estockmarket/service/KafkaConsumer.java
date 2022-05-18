package com.estock.estockmarket.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.estock.estockmarket.entity.Company;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaConsumer {

	@KafkaListener(topics="kafka_topic_name", groupId="group_id", containerFactory="userKafkaListenerFactory")
	public void consumeData(Company comp) {
	  log.info("Data received by consumer ");
	  log.info("Company" +comp);
	}
}
