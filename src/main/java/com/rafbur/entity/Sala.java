package com.rafbur.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Size;

@Entity
public class Sala implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idSali;
	
	@Size(min=4,max=30, message="nazwa sali za dluga badz za krutka przedzial od 4 do 30")
	private String nazwaSali; 
	
	@OneToMany(mappedBy="sala")
	@Valid
	private List<Seans> seanse;
	
	@OneToMany(mappedBy="sala")
	@Valid
	private List<Rzad> rzedy;

	public Integer getIdSali() {
		return idSali;
	}

	public void setIdSali(Integer idSali) {
		this.idSali = idSali;
	}

	public String getNazwaSali() {
		return nazwaSali;
	}

	public void setNazwaSali(String nazwaSali) {
		this.nazwaSali = nazwaSali;
	}

	public List<Seans> getSeanse() {
		return seanse;
	}

	public void setSeanse(List<Seans> seanse) {
		this.seanse = seanse;
	}

	public List<Rzad> getRzedy() {
		return rzedy;
	}

	public void setRzedy(List<Rzad> rzedy) {
		this.rzedy = rzedy;
	}
}
