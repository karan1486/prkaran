package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableAutoConfiguration
public class CobolToJavaPocApplication {
	@Autowired
	private static Environment env;
	

	public static void main(String[] args) {
		SpringApplication.run(CobolToJavaPocApplication.class, args);
		
	}
}
