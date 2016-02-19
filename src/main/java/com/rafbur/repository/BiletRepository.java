package com.rafbur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafbur.entity.Bilet;

public interface BiletRepository extends JpaRepository<Bilet, Integer> {

}
