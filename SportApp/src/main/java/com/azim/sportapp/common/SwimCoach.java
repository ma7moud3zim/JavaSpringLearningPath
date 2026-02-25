package com.azim.sportapp.common;


public class SwimCoach implements Coach {

	public SwimCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim 100 m as a warmup";
	}

}
