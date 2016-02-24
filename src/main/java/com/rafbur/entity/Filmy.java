package com.rafbur.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Filmy implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idFilmu;	
	
	@Size(min=4,max=30, message="tytul filmu ma nieodpowiedni rozmiar")
	private String tytulFilmu;
	
	@NotNull(message="Brak dlugosc filmu")
	@Min(value=10,message="Dlugosc filmu nie moze byc mniejssza niz 10 min")
	@Max(value=400,message="Dlugosc filmu nie moze byc wieksza niz 400 min")
	private Integer dlugsc;

	@OneToMany(mappedBy="film")
	private List<Seans> seanse;
	
//	@Value(Min=1, Max=400, message="Dlugosc filmu o 10 min do 400 min")
	
	public Integer getIdFilmu() {
		return idFilmu;
	}

	public void setIdFilmu(Integer idFilmu) {
		this.idFilmu = idFilmu;
	}

	public String getTytulFilmu() {
		return tytulFilmu;
	}

	public void setTytulFilmu(String tytulFilmu) {
		this.tytulFilmu = tytulFilmu;
	}

	public Integer getDlugsc() {
		return dlugsc;
	}

	public void setDlugsc(Integer dlugsc) {
		this.dlugsc = dlugsc;
	}
	
	
}
