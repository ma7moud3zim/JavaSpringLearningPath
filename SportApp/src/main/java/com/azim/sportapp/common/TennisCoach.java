package com.azim.sportapp.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		return "Practise backend volley";
	}

}
