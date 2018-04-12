package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Greet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo01SpringMvcWebApplicationTests {

	@Test
	public void contextLoads() {
		
	}

	@Test
	public void testGreetService() {
		RestTemplate restTemplate = new RestTemplate();
		Greet greet = restTemplate.getForObject("http://localhost:8080", Greet.class);
		Assert.assertEquals("Hello World!", greet.getMessage());
	}

}
