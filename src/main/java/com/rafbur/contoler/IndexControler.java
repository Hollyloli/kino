package com.rafbur.contoler;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rafbur.entity.Nauczyciele;
import com.rafbur.entity.Role;
import com.rafbur.service.NauczycielService;
import com.rafbur.service.UserService;

@Controller
public class IndexControler {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NauczycielService nauczycielService;
	
	@RequestMapping("/index")
	public String index(Model model, Principal principal) {
		if(principal != null) {
			System.out.println("wypisuje uzytkownika " + principal.getName());
			List<Role> listaRoli = userService.znajdzTypRoliUzytkownika(principal.getName());
			
			System.out.println("wypisuje typ roli " + listaRoli.get(1).getTypRoli());
			
			for(int i = 0; i < listaRoli.size(); i++) {
				System.out.println("wchodzi w liste roli " +i);
				if(listaRoli.get(i).getTypRoli().equals("ROLE_NAUCZYCIEL")) {
					System.out.println("znajduje role nauczyciel");
	//				model.addAttribute("uzytkownik",userService.znajdUzytkownika(principal.getName()));
	//				Nauczyciele nauczyciel = nauczycielService.znajdzPrzedmioty(principal.getName());
			//		System.out.println(nauczyciel.getPrzedmiotyNauczycieli().get(0).getNazwa());
					//musze znajdowac za pomoca id nauczyciela
					model.addAttribute("nauczyciel",nauczycielService.znajdzPrzedmioty(principal.getName()));
				}
			}
		}
		return "index";
	}
	

}
