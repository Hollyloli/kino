package com.rafbur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafbur.entity.Nauczyciele;

public interface NauczycieleRepository extends JpaRepository<Nauczyciele, Integer>{

	Nauczyciele findByLogin(String login);


}
