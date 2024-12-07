package com.jfsd.sdp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jfsd.sdp.model.Admin;
import com.jfsd.sdp.model.Nutritionist;
import com.jfsd.sdp.model.User;
import com.jfsd.sdp.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController
{
	@Autowired
	private AdminService adminService;
	@PostMapping("checkadminlogin")
	  //@ResponseBody
	  public ModelAndView checkadminlogin(HttpServletRequest request)
	  {
	    
	    ModelAndView mv=new ModelAndView();
	    String auname=  request.getParameter("auname");
	    String apwd = request.getParameter("apwd");
	    Admin admin=  adminService.checkadminlogin(auname, apwd);
	    
	    if(admin!=null)
	    {
	      //return "Admin Login Success";
	      mv.setViewName("adminhome");
	    }
	    else
	    {
	      //return "Admin login fail";
	      mv.setViewName("adminloginfail");
	      mv.addObject("message", "Login Failed");
	    }
	    return mv;
	  }
	

	  @GetMapping("viewallusers")
	    public ModelAndView viewallusers()
	    {
	      ModelAndView mv = new ModelAndView();
	      List<User> userlist = adminService.viewallUsers();
	      mv.setViewName("viewallusers");
	      mv.addObject("userlist",userlist);
	      return mv;
	    }
	  
	  @GetMapping("viewallnutrisionists")
	    public ModelAndView viewallnutrisiosinists()
	    {
	      ModelAndView mv = new ModelAndView();
	      List<Nutritionist> nutrilist = adminService.viewallnutrisiosinists();
	      mv.setViewName("viewallnutrisionists");
	      mv.addObject("nutrilist",nutrilist);
	      return mv;
	    }
	  
	  @GetMapping("delete")
	  public String deleteoperation(@RequestParam("id")  int uid)
	  {
	    adminService.deleteuser(uid);
	    return "redirect:/viewallusers";//redirection to specific path URI
	  }
	  
	  
	  
	  @GetMapping("deletenutri")
	  public String deletenutrioperation(@RequestParam("id")  int nid)
	  {
	    adminService.deleteNutrisionist(nid);
	    return "redirect:/viewallnutrisionists";//redirection to specific path URI
	  }
	  
	  

}
