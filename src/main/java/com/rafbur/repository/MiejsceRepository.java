package com.rafbur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafbur.entity.Miejsce;
import com.rafbur.entity.Rzad;

public interface MiejsceRepository extends JpaRepository<Miejsce, Integer>{

	List<Miejsce> findByRzad(Rzad rzad);
	List<Miejsce> findByRzadAndZajetoscMiejsca(Rzad rzad, boolean b);
	Miejsce findByRzadAndNumerMiejsca(Rzad rzad, Integer numerMiejsca);

}
