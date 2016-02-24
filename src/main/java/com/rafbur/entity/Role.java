package com.rafbur.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idRoli;
	
	private String typRoli;
	
	public String getTypRoli() {
		return typRoli;
	}

	public void setTypRoli(String typRoli) {
		this.typRoli = typRoli;
	}

	@ManyToMany(mappedBy="role")
	private List<Uzytkownicy> uzytkownicy;

	public Integer getIdRoli() {
		return idRoli;
	}

	public void setIdRoli(Integer idRoli) {
		this.idRoli = idRoli;
	}

	public List<Uzytkownicy> getUzytkownicy() {
		return uzytkownicy;
	}

	public void setUzytkownicy(List<Uzytkownicy> uzytkownicy) {
		this.uzytkownicy = uzytkownicy;
	}
	
}
