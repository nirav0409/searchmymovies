package com.in28minutes.springboot.tutorial.basics.application.configuration.homePageManager;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class homePageController {

	@Autowired
	MovieSearchService movieSearchService;
	@RequestMapping("/home")
	public String createUserPage(){
		return "home";
	}
	

	@RequestMapping("/")
	public String rootPage(){
		return "home";
	}
	
	
	@RequestMapping(value="/searchMovie"  , method= RequestMethod.POST)
	public void searchMovie(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse){
	    String movie  = httpServletRequest.getParameter("Movie");
	   //  String movie =   httpServletRequest.getHeader("Movie");
	    System.out.println("i am searching for "+movie);
	    String response = movieSearchService.searchMovie(movie);
	    try {
			httpServletResponse.getWriter().print(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
