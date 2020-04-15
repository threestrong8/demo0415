package com.zsz.music.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zsz.music.po.Collect;
import com.zsz.music.po.User;
import com.zsz.music.service.CollectService;
import com.zsz.music.vo.SongView;
@Controller
@Scope("prototype")
public class CollectController {
	@Autowired
	 CollectService service;
	@RequestMapping(value="/collections",method=RequestMethod.GET)
	public ModelAndView getMyCollection(HttpSession session){
		ModelAndView  mv=new ModelAndView();
		int pc=1;
		int ps=2;
		User user=(User) session.getAttribute("currentUser");
		if(user==null){
			mv.addObject("msg", "你还没有登录，请登录!!!");
			mv.setViewName("redirect:/login");
			return mv;
		}
		List<SongView> list=service.getMyCollectionList(user.getId(), pc, ps);
		int totalPages=service.getMyCollectionspages(user.getId(), ps);
		mv.addObject("list", list);
		mv.addObject("tp", totalPages);
		mv.addObject("pc",pc);
		mv.setViewName("collections");
		return mv;
	}
	@RequestMapping(value="/collections",method=RequestMethod.POST)
	public ModelAndView getMyCollection(HttpSession session,int pc){
		ModelAndView  mv=new ModelAndView();
		int ps=2;
		User user=(User) session.getAttribute("currentUser");
		List<SongView> list=service.getMyCollectionList(user.getId(), pc, ps);
		int totalPages=service.getMyCollectionspages(user.getId(), ps);
		mv.addObject("list", list);
		mv.addObject("tp", totalPages);
		mv.addObject("pc",pc);
		mv.setViewName("collections");
		return mv;
	}
	@RequestMapping(value="/deletecollection",method=RequestMethod.GET)
	public String deleteCollection(int collectionId,HttpSession session){
		service.delete(collectionId);
		return "redirect:/collections";
	}
	@RequestMapping(value="/addcollection",method=RequestMethod.GET)
	public String addCollection(int songId,HttpSession session){
		User user=(User) session.getAttribute("currentUser");
		Collect collection=new Collect();
		collection.setSongId(songId);
		collection.setUserId(user.getId());
		service.addCollection(collection);
		return "redirect:/collections";
	}
}
