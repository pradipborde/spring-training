package com.example.demo.notification;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class Sender {
	@Autowired
	RabbitMessagingTemplate template;

	@Bean
	public Queue queue() {
		return new Queue("CustomerQ");
	}

	public void send(String message) {
		System.out.println("Sending message to Queue "+message);
		template.convertAndSend("CustomerQ", message);
	}
}
