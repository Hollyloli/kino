package com.rafbur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafbur.entity.Kontakty;
import com.rafbur.entity.Role;

public interface KontaktyRepository extends JpaRepository<Kontakty, Integer>{

}
