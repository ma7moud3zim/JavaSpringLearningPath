package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecConfig {
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails ahmed = User.builder()
				.username("ahmed")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();
		UserDetails mariam = User.builder()
				.username("mariam")
				.password("{noop}test123")
				.roles("EMPLOYEE" , "MANAGER")
				.build();
		UserDetails dapoor = User.builder()
				.username("dapoor")
				.password("{noop}test123")
				.roles("EMPLOYEE" , "MANAGER", "ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(ahmed,mariam,dapoor);
	}
}
