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
		for(int i=1; i <= 100; i++) {
			list.add("Mensagem " + i +"...");
		}
		list.add("---------------");
		return list;
	}
}
