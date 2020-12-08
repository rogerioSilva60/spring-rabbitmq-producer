package br.com.rabbitmq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringRabbitmqProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitmqProducerApplication.class, args);
	}

}
