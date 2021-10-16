package com.example.kitchenengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableKafka
@EnableScheduling
public class KitchenEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitchenEngineApplication.class, args);
	}

}
