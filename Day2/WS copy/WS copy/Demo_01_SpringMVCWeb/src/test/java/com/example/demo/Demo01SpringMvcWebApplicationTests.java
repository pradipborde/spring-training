package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo01SpringMvcWebApplicationTests {

	@Test
	public void contextLoads() {
		
	}

	@Test
	public void testGreetService() {
		RestTemplate restTemplate = new RestTemplate();
		String greet = restTemplate.getForObject("http://localhost:8080", String.class);
		Assert.assertEquals("Hello World!", greet);
	}

}
