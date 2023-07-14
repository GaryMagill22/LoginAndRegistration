package com.gary.loginandregistration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping("/")
	public String renderDashboard() {
		return "dashboard.jsp";
	}
	
	
	
	
	
	
	
}
