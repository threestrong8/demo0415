package com.zsz.music.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zsz.music.po.Song;
import com.zsz.music.service.SongService;
import com.zsz.music.vo.SongView;

@Controller
@Scope("prototype")
public class SongController {
	@Autowired
	SongService service;
	@RequestMapping(value="/allsong",method=RequestMethod.GET)
   public ModelAndView getAllSong(){
	   ModelAndView mv=new ModelAndView();
	   int pc=1;
		int ps=2;
		List<SongView> list=service.getAllSongList(pc, ps);
		int totalPages=service.getAllTotalPages(ps);
		mv.addObject("list", list);
		mv.addObject("tp", totalPages);
		mv.addObject("pc",pc);
		mv.setViewName("allsong");
		return mv;
   }
	@RequestMapping(value="/allsong",method=RequestMethod.POST)
	   public ModelAndView getAllSong(int pc){
		 ModelAndView mv=new ModelAndView();
		int ps=2;
		List<SongView> list=service.getAllSongList(pc, ps);
		int totalPages=service.getAllTotalPages(ps);
		mv.addObject("list", list);
		mv.addObject("tp", totalPages);
		mv.addObject("pc",pc);
		mv.setViewName("allsong");
		return mv;
	}
	@RequestMapping(value="/download",method=RequestMethod.GET)
	public void downloadsong(HttpServletRequest request,int songId,HttpServletResponse response) throws Exception{
		Song song=service.getMySongById(songId);
		String path=song.getPath();
		String filepath = request.getServletContext().getRealPath("/"+path);
		File file=new File(filepath);
		if(!file.exists()){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("对不起歌曲不存在！");
			return;
		}
		String contentType = request.getServletContext()
				.getMimeType(filepath);
		System.out.println(contentType);
		//解决下载文件名乱码问题
		String fileName = new String(song.getSongName().getBytes("GBK"), "iso-8859-1");
		response.setHeader("Content-Type",contentType);
		response.addHeader("content-disposition", "attachment;filename="+fileName);
		IOUtils.copy(new FileInputStream(filepath), response.getOutputStream());
	}
	@RequestMapping(value="/play",method=RequestMethod.GET)
	public ModelAndView play(int songId){
		 ModelAndView mv=new ModelAndView();
		Song song=service.getMySongById(songId);
		mv.setViewName("play");
		 mv.addObject("song", song);
		 return mv;
	}
}
