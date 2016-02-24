package com.rafbur.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafbur.entity.Miejsce;
import com.rafbur.entity.Rzad;

public interface MiejsceRepository extends JpaRepository<Miejsce, Integer>{

	ArrayList<Miejsce> findByRzad(Rzad rzad);

	ArrayList<Miejsce> findByRzadAndZajetoscMiejsca(Rzad rzad, boolean b);

	Miejsce findByRzadAndNumerMiejsca(Rzad rzad, Integer numerMiejsca);

}
