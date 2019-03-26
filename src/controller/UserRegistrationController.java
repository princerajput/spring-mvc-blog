package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import Model.User;
import dbhelpers.UserHelper;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserRegistrationController {
	
	@RequestMapping(value="/RegistrationForm.html",method = RequestMethod.GET)
	public ModelAndView getRegistrationForm() {
		ModelAndView model = new ModelAndView("User/RegistrationForm");
		return model;
	}
	
	@RequestMapping(value="/submitRegistrationForm.html",method=RequestMethod.POST)
	public ModelAndView submitRegistrationForm(@ModelAttribute("user") User user) {
		ModelAndView model= new ModelAndView("User/RegistrationSuccess");
		UserHelper uh = new UserHelper();
		if(uh.insert(user)) {
			model.addObject("msg","Hi "+user.getUsername()+", you have been registered successfully.");
		}
		else {
			ModelAndView model1 = new ModelAndView("User/RegistrationForm");
			model1.addObject("msg", "Username not available.");
			return model1;
		}
		return model;
	}
}
