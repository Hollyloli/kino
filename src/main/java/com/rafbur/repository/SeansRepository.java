package com.rafbur.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rafbur.entity.Sala;
import com.rafbur.entity.Seans;

public interface SeansRepository extends JpaRepository<Seans, Integer>{

	
//	  @Query("SELECT t FROM Todo t where t.title = :title AND t.description = :description")
//	  @Query("SELECT s FROM Seans s where s.idSeansu = :idSeansu")
//	  ArrayList<Seans> findByIdSeansu(@Param("idSeansu") Integer idSeansu);
//	  
//	  @Query("SELECT s FROM Seans s where not (s.poczatekFilmu > :poczatekFilmu and s.koniecFilmu < :koniecFilmu)")
	  @Query("SELECT s FROM Seans s where ((s.poczatekFilmu between :poczatekFilmu and :koniecFilmu or s.koniecFilmu between :poczatekFilmu and :koniecFilmu) or (s.poczatekFilmu < :poczatekFilmu and s.koniecFilmu > :koniecFilmu))")
	  ArrayList<Seans> findByPoczatekFilmuAndKoniecFilmu(@Param("poczatekFilmu") Date poczatekFilmu, @Param("koniecFilmu") Date koniecFilmu);

	Seans findByPoczatekFilmuAndSala(Date poczatekFilmu, Sala sala);

	Seans findBySala(Sala sala);
	
	Seans findByPoczatekFilmu(Date poczatekFilmu);

	Seans findByIdSeansu(Integer idSeansu);
	  
}

//select * from Seans where poczatekfilmu > TIMESTAMP '2035-03-25 08:00:00'
//@Query("SELECT t FROM Todo t where t.title = :title AND t.description = :description")
//public Optional<Todo> findByTitleAndDescription(@Param("title") String title, @Param("description") String description);

