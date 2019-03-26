package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import Model.Blog;
import Model.User;
import dbhelpers.BlogHelper;
//import dbhelpers.CommentHelper;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogController {
//	@RequestMapping(value="/",method = RequestMethod.GET)
//	public ModelAndView getAllBlogs(HttpSession session) {
//		ModelAndView model = new ModelAndView("Blog/AllBlogs");
//		BlogHelper bh = new BlogHelper();
//		if(bh.select()!=null) {
//			model.addObject("blogs",bh.select());
//			model.addObject("edublogs",bh.select1());
//			model.addObject("entblogs",bh.select2());
//			model.addObject("msg","");
//		
//		}
//		else {
//			model.addObject("msg","No Blog Entries");
//		}
//			return model;
//		}
	@RequestMapping(value="/allBlogs.html",method = RequestMethod.GET)
	public ModelAndView getAllBlogs(HttpSession session) {
		ModelAndView model = new ModelAndView("Blog/AllBlogs");
		BlogHelper bh = new BlogHelper();
		if(bh.select()!=null) {
			model.addObject("blogs",bh.select());
			model.addObject("edublogs",bh.select1());
			model.addObject("entblogs",bh.select2());
			model.addObject("msg","");
			
		}
		else {
			model.addObject("msg","No Blog Entries");
		}
		return model;
	}
	
	@RequestMapping(value="/educational.html",method = RequestMethod.GET)
	public ModelAndView getAllBlogsed(HttpSession session) {
		ModelAndView model = new ModelAndView("Blog/educational");
		BlogHelper bh = new BlogHelper();
		if(bh.select()!=null) {

			model.addObject("edublogs",bh.select1());
			model.addObject("entblogs",bh.select2());
			model.addObject("msg","");
			
		}
		else {
			model.addObject("msg","No Blog Entries");
		}
		return model;
	}
	
	@RequestMapping(value="/entertainment.html",method = RequestMethod.GET)
	public ModelAndView getAllBlogsent(HttpSession session) {
		ModelAndView model = new ModelAndView("Blog/entertainment");
		BlogHelper bh = new BlogHelper();
		if(bh.select()!=null) {

			model.addObject("edublogs",bh.select1());
			model.addObject("entblogs",bh.select2());
			model.addObject("msg","");
			
		}
		else {
			model.addObject("msg","No Blog Entries");
		}
		return model;
	}
	
	@RequestMapping(value="/new-blog-entry.html",method = RequestMethod.GET)
	public ModelAndView getBlog(HttpSession session) {
		if(session.getAttribute("curuser")==null) {
			System.out.println("khgjhgj");
			ModelAndView model= new ModelAndView("redirect:/");
			return model;
		}
		ModelAndView model = new ModelAndView("Blog/NewBlogEntry");
		return model;
	}
	
	@RequestMapping(value="/add-blog-entry.html",method=RequestMethod.POST)
	public ModelAndView savesBlog(@ModelAttribute("blog") Blog blog,HttpSession session) {
		if(session.getAttribute("curuser")==null) {
			System.out.println("khgjhgj");
			ModelAndView model= new ModelAndView("redirect:/LoginForm.html");
			return model;
		}
		User u = (User) session.getAttribute("curuser");
		ModelAndView model= new ModelAndView("redirect:/");
		BlogHelper uh = new BlogHelper();
		if(uh.insert(blog,u.getUsername())) {
			model.addObject("msg"," The Blog has been added successfully.");
		}
		return model;
	}

	@RequestMapping(value="/blog-{blogid}.html",method = RequestMethod.GET)
	public ModelAndView displayBlog(@PathVariable("blogid") int blogid,HttpSession session) {
		ModelAndView model = new ModelAndView("Blog/BlogDisplay");
		BlogHelper uh = new BlogHelper();
		if(uh.getById(blogid)!=null) {
			model.addObject("blog",uh.getById(blogid));
//			CommentHelper ch = new CommentHelper();
//			model.addObject("comment",ch.getByBlogid(blogid));
			model.addObject("msg","");
		}
		else {
			model.addObject("msg","Blog does not exist");
		}
		return model;
	}
	


}
