package com.example.demo.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Mailer {

	@Autowired
	private JavaMailSender javaMailSenderService;

	public void sendMail(String email) {
		System.out.println("Creating Mail Message to "+ email);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(email);
		mailMessage.setSubject("Registration");
		mailMessage.setText("New Customer Successfully Registered");
		javaMailSenderService.send(mailMessage);

	}
}
