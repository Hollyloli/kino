package com.rafbur.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Sala {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idSeansu;
	
	private String nazwaSali; 
	
	@OneToMany(mappedBy="sala")
	private List<Seans> seanse;
	
//	@ManyToMany
//	@JoinTable
//	private List<Rzad> rzedy ;
//	
//	@ManyToOne
//	@JoinColumn(name = "sala_id")
//	private Sala sala;
	
	@OneToMany(mappedBy="sala")
	private List<Rzad> rzedy;
	
	
	
	
}
