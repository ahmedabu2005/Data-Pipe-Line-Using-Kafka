package com.demo.SpringBatchCsvProcessor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:kafka.properties")
public class SpringBatchCsvProcessorApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchCsvProcessorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserFilterKafkaStream.filterUserBySalary();
		
	}

}
