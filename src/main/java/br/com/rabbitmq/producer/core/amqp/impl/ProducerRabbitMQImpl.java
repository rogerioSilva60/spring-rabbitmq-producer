package br.com.rabbitmq.producer.core.amqp.impl;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rabbitmq.producer.api.dto.input.MessageInput;
import br.com.rabbitmq.producer.core.amqp.ProducerAmqp;
import br.com.rabbitmq.producer.core.properties.ProducerRabbitMQProperties;

@Component
public class ProducerRabbitMQImpl implements ProducerAmqp<MessageInput>{

	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private ProducerRabbitMQProperties mqProperties;
	
	@Override
	public void producer(MessageInput message) {
		try {
			rabbitTemplate.convertAndSend(mqProperties.getExchange(), mqProperties.getRoutingKey(), message);
		} catch (Exception e) {
			//Essa excessao caso seja lancada o dado com a falha será armazenada no deadletter.
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}

}
