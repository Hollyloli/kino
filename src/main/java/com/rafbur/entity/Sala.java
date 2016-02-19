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
	
	@OneToMany(mappedBy="sala")
	private List<Rzad> rzedy;

	public Integer getIdSeansu() {
		return idSeansu;
	}

	public void setIdSeansu(Integer idSeansu) {
		this.idSeansu = idSeansu;
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
