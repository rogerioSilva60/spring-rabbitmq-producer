package br.com.rabbitmq.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.rabbitmq.producer.core.properties.ProducerRabbitMQProperties;

@Configuration
public class ProducerRabbitMQConfig {

	@Autowired
	ProducerRabbitMQProperties mqProperties;
	
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(mqProperties.getExchange());
	}
	
	@Bean
	public Queue deadLetter() {
		return new Queue(mqProperties.getDeadLetter());
	}
	
	@Bean
    public Queue queue() {
        Map<String , Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", mqProperties.getExchange());
        args.put("x-dead-letter-routing-key", mqProperties.getRoutingKey());
        return new Queue(mqProperties.getRoutingKey(), true, false, false, args);
    }
	
	@Bean
	public Binding bindingQueue() {
		return BindingBuilder
					.bind(queue())
					.to(directExchange())
					.with(mqProperties.getRoutingKey());
	}
	
	@Bean
	public Binding bindingDeadLetter() {
		return BindingBuilder
					.bind(deadLetter())
					.to(directExchange())
					.with(mqProperties.getDeadLetter());
	}
}
