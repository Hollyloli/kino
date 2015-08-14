package com.rafbur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafbur.entity.Opiekunowie;
import com.rafbur.entity.Role;

public interface OpiekunowieRepository extends JpaRepository<Opiekunowie, Integer>{

}
