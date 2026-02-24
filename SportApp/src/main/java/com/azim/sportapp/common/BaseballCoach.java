package com.azim.sportapp.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

	
	public BaseballCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
	@Override
	public String getDailyWorkout() {
		return "Make a 30 minutes running around the field.";
	}

}
