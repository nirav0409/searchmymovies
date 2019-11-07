package com.in28minutes.springboot.tutorial.basics.application.configuration.homePageManager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontRestController {

	
	@RequestMapping("/rest")
	public String rootPage(){
		return "i got you finally";
	}
	
}
