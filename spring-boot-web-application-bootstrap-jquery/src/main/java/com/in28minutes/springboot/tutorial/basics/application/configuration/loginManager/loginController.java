package com.in28minutes.springboot.tutorial.basics.application.configuration.loginManager;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class loginController {
	
	@Autowired
	UserManagerService userManagerService;
	
	@RequestMapping("/login")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping("/createUser")
	public String createUserPage(){
		return "createUser";
	}
	
	@RequestMapping(value="/addNewUser"  , method= RequestMethod.POST)
	public void addnewUser(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse){
	    String user  = httpServletRequest.getParameter("User");
	    String password  = httpServletRequest.getParameter("Password");
	    String name  = httpServletRequest.getParameter("Names");

	    userManagerService.addUser(new Person(user,name,password));
	}
	
	@RequestMapping(value="/dologin"  , method= RequestMethod.POST)
	public void doLogin(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse){
		System.out.println("hello  do login ! how are you");
	    String user  = httpServletRequest.getParameter("User");
	    String password  = httpServletRequest.getParameter("Password");
	    String finalJSON="";
	    if(userManagerService.getUser(user,password)) {
	    	finalJSON = "{\"status\":\"success\","+"\"message\":\""+"message"+"\"}";
	    }else {
	    	finalJSON = "{\"status\":\"fail\","+"\"message\":\""+"message"+"\"}";
	    }
	   
		try {
			httpServletResponse.getWriter().print(finalJSON);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

