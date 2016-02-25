package com.rafbur.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafbur.entity.Miejsce;
import com.rafbur.entity.Rzad;
import com.rafbur.entity.Sala;
import com.rafbur.repository.MiejsceRepository;
import com.rafbur.repository.RzadRepository;
import com.rafbur.repository.SalaRepository;

@Service
public class RzadService {

	@Autowired
	private RzadRepository rzadRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private MiejsceRepository miejsceRepository;
	
	public List<Rzad> znajdzDstepnerzêdy(Integer id) {
		System.out.println("wypisuje ID sali " + id);
		Sala sala = salaRepository.findByIdSali(id);
		ArrayList<Rzad> rzedy = rzadRepository.findBySala(sala);
		
		for(Rzad rzad: rzedy) {
			System.out.println("wypisuje id rzedu " + rzad.getIdRzedu());
			List<Miejsce> miejsca = miejsceRepository.findByRzad(rzad);
			
			for(Miejsce miejsce: miejsca) {
				System.out.println("wypisuje miejsca " +  miejsce.getNumerMiejsca() + " typ miejsca " + miejsce.getZajetoscMiejsca());
			}
			int temp;
			Boolean temp2;
			int zmiana = 1;
			while(zmiana > 0){
				zmiana = 0;
				for(int i=0; i<miejsca.size()-1; i++){
					if(miejsca.get(i).getNumerMiejsca()>miejsca.get(i+1).getNumerMiejsca()){
						
						temp = miejsca.get(i+1).getNumerMiejsca();
						temp2 = miejsca.get(i+1).getZajetoscMiejsca();
						
						miejsca.get(i+1).setNumerMiejsca(miejsca.get(i).getNumerMiejsca());
						miejsca.get(i+1).setZajetoscMiejsca(miejsca.get(i).getZajetoscMiejsca());
						miejsca.get(i).setNumerMiejsca(temp);
						miejsca.get(i).setZajetoscMiejsca(temp2);
						zmiana++;
					}
				}
			}
			
			for(Miejsce miejsce: miejsca) {
				System.out.println("wypisuje miejsca " +  miejsce.getNumerMiejsca() + " typ miejsca " + miejsce.getZajetoscMiejsca());
			}
			
			rzad.setMiejsca(miejsca);
		}
//		System.out.println("wypisuje rzedy " + rzedy.get(0).getNumerRzedu());
//		System.out.println("ilosc wolnych miejsc " + rzedy.get(0).getMiejsca().size());
		
		return rzedy;
	}

	public ArrayList<Miejsce> znajdzMiejsca(Integer numerRzedu, Integer idSali) {
		Sala sala = salaRepository.findByIdSali(idSali);
		Rzad rzad = rzadRepository.findBySalaAndNumerRzedu(sala,numerRzedu);
		
		
//		System.out.println("wypisuje numer rzedu " + idRzedu);
//		Rzad rzad = rzadRepository.findByIdRzedu(idRzedu);
		System.out.println("wypisuje numer rzedu" + rzad.getIdRzedu());
		System.out.println("wypisuje numer rzedu");
		ArrayList<Miejsce> miejsca = miejsceRepository.findByRzadAndZajetoscMiejsca(rzad,false);

		System.out.println("rozmiar miejsc " +miejsca.size());
		return miejsceRepository.findByRzadAndZajetoscMiejsca(rzad,false);
	}

	

}
