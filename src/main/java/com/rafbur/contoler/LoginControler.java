package com.rafbur.contoler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginControler {
	
	@RequestMapping("login")
	public String logowanie() {
		return "login";
	}
}
