package org.chrismaloney.service;

import java.util.ArrayList;
import java.util.List;

import org.chrismaloney.model.Activity;
import org.springframework.stereotype.Service;

@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

	public List<Activity> findAllActivities() {
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity run = new Activity("Run");
		activities.add(run);
		
		Activity swim = new Activity("Swim");
		activities.add(swim);
		
		Activity bike = new Activity("Bike");
		activities.add(bike);

		return activities;
	}
}
