package org.chrismaloney.controller;

import java.util.List;

import org.chrismaloney.model.Activity;
import org.chrismaloney.model.Exercise;
import org.chrismaloney.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentsController {
	
	@Autowired
	private ExerciseService exerciseService;
	
	@RequestMapping(value = "/addStudents")
	// The @ModelAttribute here declares a binding from the JSP <form:form commandName="exercise">
	// Then, the <form:input path="minutes"/> is automagically bound to the `minutes` attribute
	// of that object.
	public String addStudents(@ModelAttribute("exercise") Exercise exercise) {
		int m = exercise.getMinutes();
		System.out.println("exercise: " + m);
		System.out.println("activity: " + exercise.getActivity());
		
		
		// Contrived example to show the different things that a controller can do
		
		
		if (m == 1)
			// If the number of minutes is 1, forward this request to somewhere else.  
			// The ".html" here is indicative of the fact
			// that we're going outside of the framework and back in.
			return "forward:addMoreStudents.html";
		else if (m == 2)
			// Redirect:  similar to forward, but goes all the way back out to the client.
			// This causes the exercise value to be lost.
			return "redirect:addMoreStudents.html";
		else
			return "addStudents";
	}
	
	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	// The @ResponseBody annotation here means that the we're returning the response body directly, not
	// a string that refers to a view.
	public @ResponseBody List<Activity> findAllActivities() {
		return exerciseService.findAllActivities();
	}

	@RequestMapping(value = "/addMoreStudents")
	public String addMoreStudents(@ModelAttribute("exercise") Exercise exercise) {
		System.out.println("More exercising: " + exercise.getMinutes());
		return "addStudents";
	}


}
