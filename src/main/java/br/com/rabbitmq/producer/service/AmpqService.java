package br.com.rabbitmq.producer.service;

import br.com.rabbitmq.producer.api.dto.input.MessageInput;

public interface AmpqService {

	void sendToConsumer(MessageInput message);
	
	void sendToConsumer(String message);
}
