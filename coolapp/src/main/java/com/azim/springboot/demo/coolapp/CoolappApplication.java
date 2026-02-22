package com.azim.springboot.demo.coolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class CoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoolappApplication.class, args);
	}
	
    @GetMapping("/hello")  // Visit http://localhost:8080/hello
    public String hello() {
        return "Hello from CoolApp! 🎉";
    }
}
