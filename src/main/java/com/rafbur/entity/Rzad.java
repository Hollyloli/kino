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
public class Rzad {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idRzedu;
	
	private Integer numerRzedu;
	
	private Boolean zajetoscRzedu;
	
	public Boolean getZajetoscRzedu() {
		return zajetoscRzedu;
	}


	public void setZajetoscRzedu(Boolean zajetoscRzedu) {
		this.zajetoscRzedu = zajetoscRzedu;
	}


	public Integer getIdRzedu() {
		return idRzedu;
	}


	public void setIdRzedu(Integer idRzedu) {
		this.idRzedu = idRzedu;
	}


	public List<Miejsce> getMiejsca() {
		return miejsca;
	}


	public void setMiejsca(List<Miejsce> miejsca) {
		this.miejsca = miejsca;
	}


	public Integer getNumerRzedu() {
		return numerRzedu;
	}


	public void setNumerRzedu(Integer numerRzedu) {
		this.numerRzedu = numerRzedu;
	}


	public Sala getSala() {
		return sala;
	}


	public void setSala(Sala sala) {
		this.sala = sala;
	}


	@ManyToOne
	@JoinColumn(name = "sala_id")
	private Sala sala;
	
	@OneToMany(mappedBy="rzad")
	private List<Miejsce> miejsca;
	
}