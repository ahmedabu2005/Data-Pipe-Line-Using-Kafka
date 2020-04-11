package com.demo.SpringBatchCsvProcessor.service.consumer;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import com.demo.SpringBatchCsvProcessor.model.User;

@Service
public class KafkaConsumerService {

	private static final Logger logger = Logger.getLogger(KafkaConsumerService.class);


	@KafkaListener(topics= "${kafka.csv.topic}", containerFactory = "kafkaListenerContainerFactory", groupId = ("${kafka.csv.group.id}"))
	public void consume(User user){
		logger.info("Consuming new message: " + user.getName() + " -> " + user);
	}
	
	
	@KafkaListener(topics= "USERS_BY_SALARY", containerFactory = "kafkaListenerContainerFactory", groupId = ("${kafka.csv.group.id}"))
	public void consumeUserBySalary(User user){
		logger.info("Consuming new message from USERS_BY_SALARY: " + user.getName() + " -> " + user);
	}


}
