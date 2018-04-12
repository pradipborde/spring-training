package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		MessageRenderer messageRenderer =(MessageRenderer) context.getBean("renderer");
		messageRenderer.render();
	}
	
}
