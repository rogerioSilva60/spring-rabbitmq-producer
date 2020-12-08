package br.com.rabbitmq.producer.cron;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.rabbitmq.producer.service.AmqpService;

@Component
public class AmqpCron {

	@Autowired
	private AmqpService amqpService;
	
	@Scheduled(cron = "0 0/1 * * * *")
	public void execute() {
		amqpService.sendToConsumer(fakeList());
	}
	
	private List<String> fakeList() {
		List<String> list = new ArrayList<>();
		list.add("Mensagem 1...");
		list.add("Mensagem 2...");
		list.add("Mensagem 3...");
		list.add("Mensagem 4...");
		list.add("Mensagem 5...");
		list.add("Mensagem 6...");
		list.add("Mensagem 7...");
		list.add("Mensagem 8...");
		list.add("Mensagem 9...");
		list.add("Mensagem 10...");
		return list;
	}
}
