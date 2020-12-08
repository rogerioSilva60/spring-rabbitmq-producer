package br.com.rabbitmq.producer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rabbitmq.producer.api.dto.input.MessageInput;
import br.com.rabbitmq.producer.core.amqp.ProducerAmqp;
import br.com.rabbitmq.producer.service.AmqpService;

@Service
public class ProducerRabbitMQServiceImpl implements AmqpService {

	@Autowired
	private ProducerAmqp<MessageInput> amqpMessageInput;
	@Autowired
	private ProducerAmqp<String> amqpString;
	
	@Override
	public void sendToConsumer(MessageInput message) {
		amqpMessageInput.producer(message);
	}

	@Override
	public void sendToConsumer(String message) {
		amqpString.producer(message);
	}

	@Override
	public void sendToConsumer(List<String> messages) {
		messages.forEach(message -> amqpString.producer(message));
	}

}
