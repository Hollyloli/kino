package com.rafbur.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafbur.entity.Rzad;
import com.rafbur.entity.Sala;

public interface RzadRepository extends JpaRepository<Rzad, Integer>{

	ArrayList<Rzad> findBySala(Sala sala);

	Rzad findByIdRzedu(Integer idRzedu);

	Rzad findBySalaAndNumerRzedu(Sala sala, Integer numerRzedu);

}
