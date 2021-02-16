package com.example.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiApp {

	public static void main(String[] args) {
		//it does all the stuff including creation of servlet container
		SpringApplication.run(CourseApiApp.class, args);
	}
}
