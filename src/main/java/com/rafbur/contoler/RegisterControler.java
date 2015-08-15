package com.rafbur.contoler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterControler {
	
	public RegisterControler() {
		System.out.println("Konstruktor registerContoler");
	}
	
	@RequestMapping("rejestracja")
	public String rejestracja(){
		System.out.print("dupa rejestracja");
		return "rejestracja";
	}
}
