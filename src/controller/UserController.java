package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	


	@RequestMapping(value="/logout.html",method = RequestMethod.GET)
	public ModelAndView Logout(HttpSession session) {
		ModelAndView model = new ModelAndView("redirect:/");
		session.setAttribute("curuser",null);
		return model;
	}
	
	
	
}
