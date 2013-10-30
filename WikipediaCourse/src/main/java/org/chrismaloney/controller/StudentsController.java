package org.chrismaloney.controller;

import org.chrismaloney.model.Exercise;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentsController {
	
	@RequestMapping(value = "/addStudents")
	// The @ModelAttribute here declares a binding from the JSP <form:form commandName="exercise">
	// Then, the <form:input path="minutes"/> is automagically bound to the `minutes` attribute
	// of that object.
	public String addStudents(@ModelAttribute("exercise") Exercise exercise) {
		int m = exercise.getMinutes();
		System.out.println("exercise: " + m);
		
		
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

	@RequestMapping(value = "/addMoreStudents")
	public String addMoreStudents(@ModelAttribute("exercise") Exercise exercise) {
		System.out.println("More exercising: " + exercise.getMinutes());
		return "addStudents";
	}


}
