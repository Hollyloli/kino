package com.rafbur.service;

import java.util.List;

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
	
	public List<Rzad> znajdzDstepnerzedy(Integer id) {
		Sala sala = salaRepository.findByIdSali(id);
		List<Rzad> rzedy = rzadRepository.findBySala(sala);
		for(Rzad rzad: rzedy) {
			List<Miejsce> miejsca = miejsceRepository.findByRzad(rzad);
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
			
			rzad.setMiejsca(miejsca);
		}
		return rzedy;
	}

	public List<Miejsce> znajdzMiejsca(Integer numerRzedu, Integer idSali) {
		Sala sala = salaRepository.findByIdSali(idSali);
		Rzad rzad = rzadRepository.findBySalaAndNumerRzedu(sala,numerRzedu);
		return miejsceRepository.findByRzadAndZajetoscMiejsca(rzad,false);
	}

	

}
