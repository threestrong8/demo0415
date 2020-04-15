package com.zsz.music.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zsz.music.po.Song;
import com.zsz.music.po.User;
import com.zsz.music.service.SongService;
@Controller
@Scope("prototype")
public class MySongController {
	@Autowired
	SongService service;
	@RequestMapping(value="/mysong",method=RequestMethod.GET)
   public ModelAndView getMysong(HttpSession session){
	   ModelAndView mv=new ModelAndView();
		User user=(User) session.getAttribute("currentUser");
		if(user==null){
			mv.addObject("msg", "你还没有登录，请登录!!!");
			mv.setViewName("login");
			return mv;
		}
		int pc=1;
		int ps=2;
		List<Song> list=service.getMySongList(user.getId(), pc, ps);
		int totalPages=service.getMyTotalPages(user.getId(), ps);
		mv.addObject("list", list);
		mv.addObject("tp", totalPages);
		mv.addObject("pc",pc);
		mv.setViewName("mysong");
		return mv;
   }
	@RequestMapping(value="/mysong",method=RequestMethod.POST)
	   public ModelAndView getAllSong(int pc,HttpSession session){
		  ModelAndView mv=new ModelAndView();
			User user=(User) session.getAttribute("currentUser");
			int ps=2;
			List<Song> list=service.getMySongList(user.getId(), pc, ps);
			int totalPages=service.getMyTotalPages(user.getId(), ps);
			mv.addObject("list", list);
			mv.addObject("tp", totalPages);
			mv.addObject("pc",pc);
			mv.setViewName("mysong");
			return mv;
	}
	@RequestMapping(value="/uploads",method=RequestMethod.GET)
	   public String upload(){
		return "uploads";
	}
	@RequestMapping(value="/uploads",method=RequestMethod.POST)
	   public ModelAndView upload(HttpSession session,HttpServletResponse response,HttpServletRequest request){
		System.out.println(",.......");
		ModelAndView mv=new ModelAndView();
		response.setContentType("text/html;charset=utf-8");
		//是否上传成功标志，默认为上传成功
		Boolean flag=true;
		//保存错误信息
		String message=null;
		String songName=null;
		String singer=null;
		String special=null;
		User user=(User) session.getAttribute("currentUser");
		System.out.println(user);
		//上传代码处理。。。
		   DiskFileItemFactory factory=new DiskFileItemFactory();
		   ServletFileUpload sfu=new ServletFileUpload(factory);
		   sfu.setFileSizeMax(1024*1024*1024*9);
		   List<FileItem> list=null;
		   String filename=null;
		   FileItem file=null;
		   String kind=null;
		    try {
				list=sfu.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
				flag=false;
			}
		    for(FileItem item:list){
		    	if(!item.isFormField()){
		    		file=item;
		    		filename=item.getName();
		    	}
		    	else{
		    		String name=item.getFieldName();
		    		try {
						switch(name){
						case "name":songName=item.getString("utf-8");
						break;
						case "singer":singer=item.getString("utf-8");
						break;
						case "special":special=item.getString("utf-8");
						break;
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
		    	}
		    }
		    //获取文件后缀名,得到文件类型
		   int index=filename.lastIndexOf(".");
		   if(index!=-1){
			   kind=filename.substring(index+1);
		   }
		   //这里可以进行文件类型判断保留。。。。
		   
		   
		   //解决文件重名问题,相对于根目录。
		   String savaFileName=UUID.randomUUID().toString().replace("-", "").toLowerCase()+"."+kind;
		   //解决文件打散问题,哈希打散
		   String hash=Integer.toHexString(filename.hashCode());
		   String sonpath= hash.charAt(0)+"/"+hash.charAt(1);
		   //写入文件项目中。。
		   String fileRootpath=request.getServletContext().getRealPath("/upload");
		   File saveRootPath=new File(fileRootpath,sonpath);
		   File save=new File(saveRootPath,savaFileName);
		   if(!saveRootPath.exists()){
			   saveRootPath.mkdirs();
		   }
		   try {
			file.write(save);
			System.out.println("hello");
		} catch (Exception e) {
			flag=false;
			message="sorry,你的文件大小超出9G";
			e.printStackTrace();
		}
	   if(flag){
	    System.out.println(flag);
		//将路径相关信息保存到数据库中
		Song song=new Song();
		song.setTime(new Date());
		song.setSongName(songName+"."+kind);
		song.setSinger(singer);
		song.setSpecial(special);
		song.setUserId(user.getId());
		song.setPath("upload/"+sonpath+"/"+savaFileName);
		service.uploadSong(song);
		mv.setViewName("redirect:/mysong");
		return mv;
		   }
		   mv.setViewName("upload");
		   mv.addObject("message", message);
		   return mv;
	}
	@RequestMapping(value="/deletesong",method=RequestMethod.GET)
	   public String deletesong(int songId){
		service.deleteMySong(songId);
		return "redirect:/mysong";
	}
}
