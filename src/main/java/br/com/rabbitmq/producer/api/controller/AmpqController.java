package br.com.rabbitmq.producer.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rabbitmq.producer.api.dto.input.MessageInput;
import br.com.rabbitmq.producer.service.AmpqService;

@RestController
@RequestMapping("api/v1/amqp")
public class AmpqController {

	@Autowired
	private AmpqService amqpService;
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("send")
	public void send(@RequestBody MessageInput message) {
		amqpService.sendToConsumer(message);
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("send-second")
	public void send(@RequestBody String message) {
		amqpService.sendToConsumer(message);
	}
}
