package com.rafbur.contoler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KontaktKontroler {
	
	@RequestMapping("/kontakt")
	public String kontaktWidok() {
		return "kontakt";
	}
	

}
