package br.com.rabbitmq.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.rabbitmq.producer.core.properties.ProducerRabbitMQProperties;

@Configuration
public class QueueRabbitMQConfig {

	@Autowired
	ProducerRabbitMQProperties mqProperties;
	
	@Bean
	public Queue deadLetterFirst() {
		return new Queue(mqProperties.getDeadLetterFirst());
	}
	
	@Bean
    public Queue queueFirst() {
        Map<String , Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", mqProperties.getDirectExchangeTest());
        args.put("x-dead-letter-routing-key", mqProperties.getRoutingKeyFirst());
        return new Queue(mqProperties.getQueueNameFirst(), true, false, false, args);
    }
	
	@Bean
	public Queue deadLetterSecond() {
		return new Queue(mqProperties.getDeadLetterSecond());
	}
	
	@Bean
    public Queue queueSecond() {
        Map<String , Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", mqProperties.getDirectExchangeTest());
        args.put("x-dead-letter-routing-key", mqProperties.getRoutingKeySecond());
        return new Queue(mqProperties.getQueueNameSecond(), true, false, false, args);
    }
}
