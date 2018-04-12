package com.training;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("provider")
@Primary
public class HMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hello";
	}

}
