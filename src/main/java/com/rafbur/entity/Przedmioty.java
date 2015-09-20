package com.rafbur.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.rafbur.annotation.UniqueNazwaPrzedmiotu;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"nazwa" })})
public class Przedmioty implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1557546110216720236L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idPrzedmiotu;
	
	@Size(min=2, max=30, message="nieodpowiednia d³ugoœæ nazwy przedmiotu")
	@UniqueNazwaPrzedmiotu
	@Column(unique=true)
	private String nazwa;
	
	@ManyToMany(mappedBy="przedmioty")
	private List<Uczniowie> uczniowie;
	
	@ManyToMany(mappedBy="przedmiotyNauczycieli")
	private List<Nauczyciele> nauczyciele;
	
	@ManyToMany
	@JoinTable
	private List<Oceny> oceny;
	
	public List<Oceny> getOceny() {
		return oceny;
	}


	public void setOceny(List<Oceny> oceny) {
		this.oceny = oceny;
	}


	public List<Nauczyciele> getNauczyciele() {
		return nauczyciele;
	}


	public void setNauczyciele(List<Nauczyciele> nauczyciele) {
		this.nauczyciele = nauczyciele;
	}


	public List<Uczniowie> getUczniowie() {
		return uczniowie;
	}


	public void setUczniowie(List<Uczniowie> uczniowie) {
		this.uczniowie = uczniowie;
	}


	public Integer getIdPrzedmiotu() {
		return idPrzedmiotu;
	}
	

	public void setIdPrzedmiotu(Integer idPrzedmiotu) {
		this.idPrzedmiotu = idPrzedmiotu;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
}
