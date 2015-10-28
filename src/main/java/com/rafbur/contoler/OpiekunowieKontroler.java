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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rafbur.entity.Oceny;
import com.rafbur.entity.Opiekunowie;
import com.rafbur.entity.Uzytkownicy;
import com.rafbur.service.OpiekunowieService;
import com.rafbur.service.UczniowieService;

@Controller
public class OpiekunowieKontroler {
	
	@Autowired
	private OpiekunowieService opiekunowieService;
	
	@Autowired
	private UczniowieService uczniowieService;
	
	@ModelAttribute("opiekunowie")
	public Opiekunowie constructOpiekun() {
		return new Opiekunowie();
	}
	
	@ModelAttribute("ocena")
	public Oceny constructUser() {
		return new Oceny();
	}
	
	@RequestMapping("przypUczniowOpiek")
	public String OcenyUczniow(Model model,Principal principal, HttpSession session) {
		List<Uzytkownicy> listaOpiekunow = opiekunowieService.znajdzWszystkichOpiekunow();
		model.addAttribute("opiekunowie1", listaOpiekunow);
		model.addAttribute("uczniowie", uczniowieService.znajdzWszystkichUczniow());
		return "przypUczniowOpiek";
	}
	
	@RequestMapping("dziecko-{id}")
	public String widokOcenDziecka(Model model,@PathVariable String id,Principal principal, HttpSession session) {
		session.setAttribute("loginDziecka", id);
		List<String> lataIsemestryZOcenami = uczniowieService.lataISemestryZWpisanymiOcenami(id);
		for (String rokISemest : lataIsemestryZOcenami) {
			System.out.println(rokISemest);
		}
		model.addAttribute("lataISemestryZOcenami", lataIsemestryZOcenami);
		return "ocenyDziecka";
	}
	
	@RequestMapping(value="/formularzOcenDziecka", method=RequestMethod.POST)
	public String formularzOcenUcznia(@Valid @ModelAttribute("ocena") Oceny ocena, BindingResult result, HttpSession session)
	{
		session.setAttribute("ocenySemestr",uczniowieService.znajdzOcenyUcznia((String)session.getAttribute("loginDziecka"),Integer.parseInt(ocena.getTyp().substring(4, 5)),Integer.parseInt(ocena.getTyp().substring(14, 15))));
		return  "redirect:/dziecko-"+(String)session.getAttribute("loginDziecka")+".html";
	}
	
	@RequestMapping(value="/formularzPrzypUczniaOpiek", method=RequestMethod.POST)
	public String formularzOcenUcznia(@Valid @ModelAttribute("opiekunowie") Opiekunowie opiekunowie, BindingResult result,Principal principal, HttpSession session) {
		String[] login = opiekunowie.getLogin().split(" ");
		String[] imieINazwiskoUcznia = opiekunowie.getUczniowie().get(0).getLogin().split(" ");
		uczniowieService.przypiszOpiekunaDziecku(login[login.length-1], imieINazwiskoUcznia[imieINazwiskoUcznia.length-1]);
		return  "redirect:/przypUczniowOpiek.html";
	}
}
