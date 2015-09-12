package com.rafbur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafbur.entity.Kontakty;
import com.rafbur.entity.Uzytkownicy;

public interface KontaktyRepository extends JpaRepository<Kontakty, Integer>{

	List<Kontakty> findByUzytkownicy(Uzytkownicy uzytkownik);

//	@Modifying
//	@Query("UPDATE kontakty k SET k.email = ?1 where k.idkontaktu = ?2'")
//	void setEmailByIdkontakty(String email, String idkontaktu);
}
