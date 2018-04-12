package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("renderer")
public class MessageRenderer {
	@Autowired
	//@Qualifier("gmProvider")
	private MessageProvider messageProvider;
/*	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}
	*/
	public void render() {
		System.out.println(messageProvider.getMessage());
	}
}
