package com.rafbur.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rafbur.entity.Sala;
import com.rafbur.entity.Seans;

public interface SeansRepository extends JpaRepository<Seans, Integer>{
	@Query("SELECT s FROM Seans s where ((s.poczatekFilmu between :poczatekFilmu and :koniecFilmu or s.koniecFilmu between :poczatekFilmu and :koniecFilmu) or (s.poczatekFilmu < :poczatekFilmu and s.koniecFilmu > :koniecFilmu))")
	List<Seans> findByPoczatekFilmuAndKoniecFilmu(@Param("poczatekFilmu") Date poczatekFilmu, @Param("koniecFilmu") Date koniecFilmu);
	Seans findByPoczatekFilmuAndSala(Date poczatekFilmu, Sala sala);
	Seans findBySala(Sala sala);
	Seans findByPoczatekFilmu(Date poczatekFilmu);
	Seans findByIdSeansu(Integer idSeansu);
}

