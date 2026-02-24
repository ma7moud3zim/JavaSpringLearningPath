package com.azim.sportapp.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

	public TrackCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run A hard 5k!";
	}

}
