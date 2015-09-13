package com.rafbur.contoler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rafbur.service.NauczycielService;
import com.rafbur.service.PrzedmiotyService;
import com.rafbur.service.UserService;

@Controller
public class IndexControler {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NauczycielService nauczycielService;
	
	@Autowired
	private PrzedmiotyService przedmiotyService;
	
	@RequestMapping("/index")
	public String index(SecurityContextHolderAwareRequestWrapper rolaUyztkownika,HttpSession sesja) {
//		if(principal != null) {
//			System.out.println("wypisuje uzytkownika " + principal.getName());
//			List<Role> listaRoli = userService.znajdzTypRoliUzytkownika(principal.getName());
			
			//principal.getName().
			
			//System.out.println("wypisuje czy jest rola dyektor " + rolaUyztkownika.isUserInRole("NA"));
			
			//userService.znajdzRole(rolaUyztkownika.getUserPrincipal().getName());
	
			if(rolaUyztkownika.isUserInRole("ROLE_NAUCZYCIEL")) {
				sesja.setAttribute("przedmiotNauczyciela", nauczycielService.znajdzPrzedmioty(rolaUyztkownika.getUserPrincipal().getName()));
			}
			if(rolaUyztkownika.isUserInRole("ROLE_DYREKTOR")) {
				rolaUyztkownika.getSession().setAttribute("uzytkownicyBezRoli", userService.znajdzNieaktywowanychUzytkownikow());
				sesja.setAttribute("nauczyciele", userService.znajdzNauczycieli());
				sesja.setAttribute("przedmioty", przedmiotyService.znajdzPrzedmioty());
				
			}
//			System.out.println("wypisuje typ roli " + listaRoli.get(1).getTypRoli());
//			
//			for(int i = 0; i < listaRoli.size(); i++) {
//				System.out.println("wchodzi w liste roli " +i);
//				if(listaRoli.get(i).getTypRoli().equals("ROLE_NAUCZYCIEL")) {
//					System.out.println("znajduje role nauczyciel");
//	//				model.addAttribute("uzytkownik",userService.znajdUzytkownika(principal.getName()));
//	//				Nauczyciele nauczyciel = nauczycielService.znajdzPrzedmioty(principal.getName());
//			//		System.out.println(nauczyciel.getPrzedmiotyNauczycieli().get(0).getNazwa());
//					//musze znajdowac za pomoca id nauczyciela
//					model.addAttribute("nauczyciel",nauczycielService.znajdzPrzedmioty(principal.getName()));
//				}
//			}
		//}
		return "index";
	}
	

}
