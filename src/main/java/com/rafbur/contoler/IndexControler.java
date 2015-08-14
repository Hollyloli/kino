package com.rafbur.contoler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControler {
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("dupa");
		return "/WEB-INF/jsp/index.jsp";
	}
}
