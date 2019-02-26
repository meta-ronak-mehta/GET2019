package com.metacube.ead5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebSiteController {

	
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String home() {     
	        return "welcome";
	    }
	    
}
