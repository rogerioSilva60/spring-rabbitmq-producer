package br.com.rabbitmq.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.rabbitmq.producer.core.properties.ProducerRabbitMQProperties;

@Configuration
public class DirectRabbitMQConfig {

	@Autowired
	ProducerRabbitMQProperties mqProperties;
	@Autowired
	private QueueRabbitMQConfig queueConfig;
	
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(mqProperties.getDirectExchangeTest());
	}
	
	@Bean
	public Binding bindingQueueFirst() {
		return BindingBuilder
					.bind(queueConfig.queueFirst())
					.to(directExchange())
					.with(mqProperties.getRoutingKeyFirst());
	}
	
	@Bean
	public Binding bindingDeadLetterFirst() {
		return BindingBuilder
					.bind(queueConfig.deadLetterFirst())
					.to(directExchange())
					.with(mqProperties.getDeadLetterFirst());
	}
	
	@Bean
	public Binding bindingQueueSecond() {
		return BindingBuilder
					.bind(queueConfig.queueSecond())
					.to(directExchange())
					.with(mqProperties.getRoutingKeySecond());
	}
	
	@Bean
	public Binding bindingDeadLetterSecond() {
		return BindingBuilder
					.bind(queueConfig.deadLetterSecond())
					.to(directExchange())
					.with(mqProperties.getDeadLetterSecond());
	}
}
