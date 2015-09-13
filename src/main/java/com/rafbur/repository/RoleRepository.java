package com.rafbur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafbur.entity.Role;
import com.rafbur.entity.Uzytkownicy;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	List<Role> findByUzytkownicy(Uzytkownicy uzytkownik);

	Role findByTypRoli(String wyborRoli);

}
