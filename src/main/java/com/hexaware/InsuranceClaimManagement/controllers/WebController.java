package com.hexaware.InsuranceClaimManagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping("claim")
@Controller
public class WebController {
	public WebController() {
		
	}
	
//	@RequestMapping(path="/claim")
    public String index() { 
         
        return "index";
    }
	
}
