package br.com.rabbitmq.producer.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
@ConfigurationProperties("producer.rabbitmq")
public class ProducerRabbitMQProperties {

	private String exchange="";
	private String routingKey="";
	private String deadLetter="";
}
