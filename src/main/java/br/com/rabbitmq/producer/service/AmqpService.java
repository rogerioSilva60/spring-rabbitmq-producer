package br.com.rabbitmq.producer.service;

import java.util.List;

import br.com.rabbitmq.producer.api.dto.input.MessageInput;

public interface AmqpService {

	void sendToConsumer(MessageInput message);
	
	void sendToConsumer(String message);
	
	void sendToConsumer(List<String> messages);
}
