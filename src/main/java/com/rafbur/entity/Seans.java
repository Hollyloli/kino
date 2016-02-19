package com.rafbur.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Seans {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idSeansu;
	
	@ManyToOne
	@JoinColumn(name = "film_id")
	private Filmy film;
	
	@OneToMany(mappedBy="seans")
	private List<Bilet> bilety;
	
	@ManyToOne
	@JoinColumn(name = "sala_id")
	private Sala sala;
}
