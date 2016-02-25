package com.rafbur.contoler;

	import java.security.Principal;
	import java.util.Date;

	import javax.servlet.http.HttpSession;
	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;

	import com.rafbur.entity.Miejsce;
	import com.rafbur.entity.Rzad;
	import com.rafbur.entity.Seans;
	import com.rafbur.service.BiletyService;
	import com.rafbur.service.RzadService;
	import com.rafbur.service.SalaService;
	import com.rafbur.service.SeansService;

@Controller
public class RezerwacjaBiletowController {
	
		@Autowired
		private SeansService seansService;
		
		@Autowired
		private SalaService salaService;
		
		@Autowired
		private RzadService rzadService;
		
		@Autowired
		private BiletyService biletyService;
		
		@ModelAttribute("seans")
		public Seans constructSeans() {
			return new Seans();
		}
		
		@ModelAttribute("rzad")
		public Rzad constructRzad() {
			return new Rzad();
		}
		
		@ModelAttribute("miejsce")
		public Miejsce constructMiejsce() {
			return new Miejsce();
		}
		
		
		
		@RequestMapping("wyborSeansu")
		public String wyborSeansu(Model model) {
			model.addAttribute("seanse", seansService.znajdzWszystkieSeanse());
			return "wyborSeansu";
		}
		@RequestMapping("wyborRzedu")
		public String wybranieRzedu(Model model, HttpSession sesja) {
			Integer id = (Integer) sesja.getAttribute("idSesji");
			model.addAttribute("rzedy", rzadService.znajdzDstepnerzedy(id));
			return "wyborRzedu";
		}
		
		@RequestMapping("wyborMiejsca")
		public String wybranieMiejsc() {
			return "wybranieMiejsc";
		}
		
		
		@RequestMapping(value="/formularzWyboruRzedu", method=RequestMethod.POST)
		public String formularzWyboruRzedu(@Valid @ModelAttribute("rzad") Rzad rzad, BindingResult result,HttpSession sesja) {
			if(result.hasErrors()) {
				return "dodanieFilmu";
			}
			Integer idSali = (Integer) sesja.getAttribute("idSesji");
			sesja.setAttribute("numerRzedu", rzad.getNumerRzedu());
			sesja.setAttribute("miejsca", rzadService.znajdzMiejsca(rzad.getNumerRzedu(),idSali));
			return "redirect:/wyborMiejsca.html";
		}
		
		
		
		@RequestMapping(value="/formularzDodaniaBiletu", method=RequestMethod.POST)
		public String formularzDodaniaBiletu(@Valid @ModelAttribute("miejsce") Miejsce miejsce,Principal user, BindingResult result,HttpSession sesja) {
			if(result.hasErrors()) {
				return "wyborMiejsca";
			}
			Integer idSali = (Integer) sesja.getAttribute("idSesji");
			Integer numerRzedu =  (Integer) sesja.getAttribute("numerRzedu");
			Integer idSeansu = (Integer) sesja.getAttribute("idSeansu");
			biletyService.zarezerwujBilet(idSeansu, idSali, numerRzedu, miejsce.getNumerMiejsca(), user.getName());
			return "redirect:/wyborSeansu.html?success=true";
		}
		
		@RequestMapping(value="/formularzWyboruSeansu", method=RequestMethod.POST)
		public String formularzWyboruSeansu(@Valid @ModelAttribute("seans") Seans seans, BindingResult result,HttpSession sesja) {
			if(result.hasErrors()) {
				return "dodanieFilmu";
			}
			String[] tablica = seans.getFilm().getTytulFilmu().split(" ");
			String data[] = tablica[5].split("-");
			String godzina[] = tablica[6].split(":");
			Date obiektData = new Date(Integer.parseInt(data[0])-1900, Integer.parseInt(data[1])-1,Integer.parseInt(data[2]),Integer.parseInt(godzina[0]),Integer.parseInt(godzina[1]));
			sesja.setAttribute("idSeansu", seansService.znajdzIdSeansu(obiektData, tablica[tablica.length-1]));
			sesja.setAttribute("idSesji", salaService.znajdzIdSaliPoNazwie(tablica[tablica.length-1]));
			return "redirect:/wyborRzedu.html";
		}
	}


