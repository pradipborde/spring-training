package com.example.demo.notification;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	
	@RabbitListener(queues = "CustomerQ")
	public void processMessage(String content) {
		System.out.println(content);
	}

}
