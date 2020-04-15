package com.zsz.music.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zsz.music.po.User;
import com.zsz.music.service.UserService;
@Controller
@Scope("prototype")
public class UserController {
	@Autowired
	UserService service;
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String toindex(){
		return "index";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(String post,String pwd,HttpSession session){
		ModelAndView mv=new ModelAndView();
		String email=post.trim();
		 pwd=pwd.trim();
		User user=service.getUser(email, pwd);
		if(user!=null){
			session.setAttribute("currentUser", user);
			mv.setViewName("redirect:/index");
			return mv;
		}
		    mv.addObject("msg", "邮箱或者密码错误");
		    mv.setViewName("login");
		    return mv;
	}
	@RequestMapping(value="/regist",method=RequestMethod.GET)
	public String regist(){
		return "regist";
	}
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public ModelAndView login(String post,String pwd,HttpSession session,String rename,String repwd){
		ModelAndView mv=new ModelAndView();
		if(!repwd.equals(pwd)){
			mv.addObject("msg", "俩次密码不一致，请重新输入");
			mv.setViewName("regist");
			return mv;
		}
		User user=new User();
		user.setUserName(rename);
		user.setEmail(post);
		user.setPwd(pwd);
		service.add(user);
		mv.setViewName("redirect:/login");
		return mv;
	}
	@RequestMapping(value="/clearlogin",method=RequestMethod.GET)
	public ModelAndView clearlogin(HttpSession session){
		session.invalidate();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/login");
		return mv;
	}
}
