package com.rafbur.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Rzad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idRzedu;
	
	@NotNull(message="Brak numeru rzedu")
	@Min(value=1,message="Ilosc rzedow nie moze byc mniejsza niz 0")
	@Max(value=15,message="Ilosc rzedow nie moze byc wieksza niz 15")
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
	@Valid
	private List<Miejsce> miejsca;
	
}