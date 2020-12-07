package br.com.rabbitmq.producer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rabbitmq.producer.api.dto.input.MessageInput;
import br.com.rabbitmq.producer.core.amqp.ProducerAmqp;
import br.com.rabbitmq.producer.service.AmpqService;

@Service
public class ProducerRabbitMQServiceImpl implements AmpqService {

	@Autowired
	private ProducerAmqp<MessageInput> amqp;
	
	@Override
	public void sendToConsumer(MessageInput message) {
		amqp.producer(message);
	}

}
