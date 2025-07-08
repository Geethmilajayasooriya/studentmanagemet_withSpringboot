package com.example.stumanagement;

import com.example.stumanagement.controller.test.TestTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StumanagementApplication {
	@Bean
	public TestTask testTask()
	{
		return new TestTask();
	}

	public static void main(String[] args) {

		SpringApplication.run(StumanagementApplication.class, args);
		//var TestTask = new TestTask();
	}

}
