package com.rafbur.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueGodzinaSeansuValidator implements ConstraintValidator<UniqueGodzinaSeansu, Object> {
	  private String poleRok;
	  private String poleSymbol;
	  @Autowired
	 // private KlasaRepository klasaRepository;
	  @Override
	  public void initialize(UniqueGodzinaSeansu constraintAnnotation) {
		this.poleRok = constraintAnnotation.poleRok();
	    this.poleSymbol = constraintAnnotation.poleSymbol();
	  }
	  public boolean isValid(Object wpisanaWartosc, ConstraintValidatorContext context) {
//	    if(klasaRepository==null) {
//	    	return true;
//	    }
//	    try {
//			Integer rok = (Integer) PropertyUtils.getProperty(wpisanaWartosc, poleRok);
//			String symbol = (String) PropertyUtils.getProperty(wpisanaWartosc, poleSymbol);
//			return klasaRepository.findByRokAndSymbol(rok, symbol) == null;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		} 
		  return false;
	  }
}
