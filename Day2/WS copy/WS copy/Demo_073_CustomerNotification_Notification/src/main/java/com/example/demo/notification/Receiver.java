package com.example.demo.notification;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@Autowired
	private Mailer mailer;

	@Bean
	Queue queue() {
		return new Queue("CustomerQ");
	}

	@RabbitListener(queues = "CustomerQ")
	public void processMessage(String email) {
		System.out.println(email);
		System.out.println("Preparing to send email to " + email);
		mailer.sendMail(email);
	}

}
