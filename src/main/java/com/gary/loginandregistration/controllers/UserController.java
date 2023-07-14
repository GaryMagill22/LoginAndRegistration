package com.gary.loginandregistration.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gary.loginandregistration.models.LoginUser;
import com.gary.loginandregistration.models.User;
import com.gary.loginandregistration.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



// All Routes pre-pended with "/users".
@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String renderLogregForm(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
        // require empty User() & empty LoginUser() for 2 form:form
		return "logreg.jsp";
	}
	
	
	// process register
	@PostMapping("/register")
	public String processRegister(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result, Model model, HttpSession session 
			) {
		User registeredUser = userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "logreg.jsp";
		} else {
			session.setAttribute("userId", registeredUser.getId());
			session.setAttribute("userName", registeredUser.getUserName());
			return "dashboard.jsp";
		}
      
	}
	
	
	 @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        // Add once service is implemented:
	         User loggedUser = userService.login(newLogin, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "logreg.jsp";
	        } else {
	        	session.setAttribute("userId", loggedUser.getId());
				session.setAttribute("userName", loggedUser.getUserName());
				return "dashboard.jsp";
	        }
	    
	        // No errors! 
	        // TO-DO Later: Store their ID from the DB in session, 
	        // in other words, log them in.
	    
	    }

	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
        // clear session using session.invalidate()
		return "redirect:/users/login";
	}
	

	
	
	
}