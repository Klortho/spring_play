package org.chrismaloney.controller;

import javax.validation.Valid;

import org.chrismaloney.model.Goal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
// The following annotation specifies that the `goal` attribute (see below) should be persisted
// with the session.
@SessionAttributes("goal")
public class GoalController {
	
	// The `RequestMethod.GET` means that this will only respond to GET requests.
	// This method is called the first time we ever come to the addGoal page, and
	// displays the form, with a default value for the goal.
	@RequestMapping(value = "/addGoal", method = RequestMethod.GET)
	public String addGoal(Model model) {
		Goal goal = new Goal();
		goal.setMinutes(10);
		model.addAttribute("goal", goal);
		return "addGoal";
	}

	// This method handles POST requests of the form, after the user has added a
	// goal and clicked submit.  It will get the goal from the form (ModelAttribute)
	// and persist it (how?) and then redirect to another page.
	// This is where we add validation, since it's a user-created object.
	@RequestMapping(value = "addGoal", method= RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("goal") Goal goal,
			                 BindingResult result) 
	{
		System.out.println("result has errors: " + result.hasErrors());
		System.out.println("goal is " + goal.getMinutes());
		return "redirect:addStudents.html";
	}
}
