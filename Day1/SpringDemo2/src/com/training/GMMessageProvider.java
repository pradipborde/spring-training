package com.training;

import org.springframework.stereotype.Component;

@Component("gmProvider")
public class GMMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		return "Good Morning 2!";
	}

}
