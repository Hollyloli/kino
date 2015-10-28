package com.rafbur.contoler;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rafbur.entity.Oceny;
import com.rafbur.service.UczniowieService;

@Controller
public class UczniowieKontroler {
	
	@Autowired
	private UczniowieService uczniowieService;
	
	@ModelAttribute("ocena")
	public Oceny constructUser() {
		return new Oceny();
	}
	
	@RequestMapping("ocenyUcznia")
	public String OcenyUczniow(Model model,Principal principal, HttpSession session) {
		List<String> lataIsemestryZOcenami = uczniowieService.lataISemestryZWpisanymiOcenami(principal.getName());
		for (String rokISemest : lataIsemestryZOcenami) {
			System.out.println(rokISemest);
		}
		model.addAttribute("lataISemestryZOcenami", lataIsemestryZOcenami);
		return "ocenyUcznia";
	}
	
	@RequestMapping(value="/formularzOcenUcznia", method=RequestMethod.POST)
	public String formularzOcenUcznia(@Valid @ModelAttribute("ocena") Oceny ocena, BindingResult result,Principal principal, HttpSession session)
	{
		session.setAttribute("ocenySemestr",uczniowieService.znajdzOcenyUcznia(principal.getName(),Integer.parseInt(ocena.getTyp().substring(4, 5)),Integer.parseInt(ocena.getTyp().substring(14, 15))));
		return  "redirect:/ocenyUcznia.html";
	}
}
