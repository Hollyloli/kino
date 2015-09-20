package com.rafbur.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.rafbur.repository.PrzedmiotyRepository;

public class UniqueNazwaPrzedmiotuValidator implements ConstraintValidator<UniqueNazwaPrzedmiotu, String> {

	@Autowired
	private PrzedmiotyRepository przedmiotyRepository;
	
	@Override
	public void initialize(UniqueNazwaPrzedmiotu constraintAnnotation) {
	}

	@Override
	public boolean isValid(String nazwaPrzedmiotu, ConstraintValidatorContext context) {
		if(przedmiotyRepository == null) {
			return true;
		}
		return przedmiotyRepository.findByNazwa(nazwaPrzedmiotu) == null;
	}

}
