package com.rafbur.contoler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rafbur.service.UserService;

@Controller
public class IndexControler {
	
	@Autowired
	private UserService userService;
	

	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}
