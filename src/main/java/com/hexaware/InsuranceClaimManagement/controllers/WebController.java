package com.hexaware.InsuranceClaimManagement.controllers;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@RequestMapping("claim")
@Controller
//@PropertySource("classpath:views.properties")
public class WebController {
	public WebController() {
		
	}
	
	@RequestMapping(path="/claim")
    public String index() { 
		return "index.html";
    }
//	@RequestMapping(path="/claim")
//    public ModelAndView index() { 
//		ModelAndView modelAndView = new ModelAndView();
//	    modelAndView.setViewName("index");
//	    return modelAndView;
//    }
}
