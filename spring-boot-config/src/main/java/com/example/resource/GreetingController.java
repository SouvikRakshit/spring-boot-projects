package com.example.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@Value("${my.greeting : default value}")
	private String greetingMessage;
	
	@Autowired
	private DBSettings dbsettings;
	
	@RequestMapping("/hello")
	public String hello() {
		return dbsettings.getConnection() + " " + dbsettings.getHost()+ " " + dbsettings.getPort();
	}

}
