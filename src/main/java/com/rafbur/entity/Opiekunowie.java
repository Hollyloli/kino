package com.rafbur.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Opiekunowie {


	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idOpiekuna;
	
	private String login;
	
	@ManyToMany(mappedBy="opiekunowie")
	private List<Uczniowie> uczniowie;

	public List<Uczniowie> getUczniowie() {
		return uczniowie;
	}

	public void setUczniowie(List<Uczniowie> uczniowie) {
		this.uczniowie = uczniowie;
	}

	public Integer getIdOpiekuna() {
		return idOpiekuna;
	}

	public void setIdOpiekuna(Integer idOpiekuna) {
		this.idOpiekuna = idOpiekuna;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
