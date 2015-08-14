package com.rafbur.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {
	
	@Id
	@GeneratedValue
	private Integer idRoli;
	
	private String typRoli;
	
	public String getTypRoli() {
		return typRoli;
	}

	public void setTypRoli(String typRoli) {
		this.typRoli = typRoli;
	}

	@ManyToMany(mappedBy="role")
	private List<User> uzytkownicy;

	public Integer getIdRoli() {
		return idRoli;
	}

	public void setIdRoli(Integer idRoli) {
		this.idRoli = idRoli;
	}

	public List<User> getUzytkownicy() {
		return uzytkownicy;
	}

	public void setUzytkownicy(List<User> uzytkownicy) {
		this.uzytkownicy = uzytkownicy;
	}
	
}
