package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import Model.User;
import dbhelpers.BlogHelper;
import dbhelpers.UserHelper;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/LoginForm.html",method = RequestMethod.GET)
	public ModelAndView getLoginForm(HttpSession session) {
		System.out.print("sfdlfjdfkd");
		ModelAndView model = new ModelAndView("User/LoginForm");
		return model;
	}
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public ModelAndView getAllBlogs(HttpSession session) {
		ModelAndView model = new ModelAndView("Blog/AllBlogs");
		BlogHelper bh = new BlogHelper();
		if(bh.select()!=null) {
			model.addObject("blogs",bh.select());
			model.addObject("msg","");
		}
		else {
			model.addObject("msg","No Blog Entries");
		}
		return model;
	}
	
	@RequestMapping(value="/submitLoginForm.html",method=RequestMethod.POST)
	public ModelAndView submitRegistrationForm(@ModelAttribute("user") User user,HttpSession session) {
		UserHelper uh = new UserHelper();
		User temp = uh.getById(user.getUsername());
		if(temp != null && temp.getPassword().equals(user.getPassword())){
			ModelAndView model= new ModelAndView("redirect:/allBlogs.html");
			session.setAttribute("curuser", temp);
			model.addObject("user",temp);
			return model;
		}
		else {
			ModelAndView model= new ModelAndView("User/LoginForm");
			model.addObject("msg","Invalid Credentials");
			return model;
		}
	}
}
