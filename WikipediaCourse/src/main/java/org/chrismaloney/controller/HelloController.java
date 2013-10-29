package org.chrismaloney.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping(value = "/greeting")
	public String sayHello(Model model) {
		model.addAttribute("greeting", "Hello Crazy Planet");
		
		// Return the name of the JSP page to load.  This is not an arbitrary string, this 
		// points to hello.jsp.
		return "hello";
	}
}
