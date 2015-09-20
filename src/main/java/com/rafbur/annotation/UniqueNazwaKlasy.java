package com.rafbur.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueNazwaKlasyValidator.class)
@Documented
public @interface UniqueNazwaKlasy {
	
	String message() default "{Taka klasa ju¿ istnieje. Wprowadz inne wartoœci.}";

	  Class<?>[] groups() default {};

	  Class<? extends Payload>[] payload() default {};

	  String poleRok();

	  String poleSymbol();

}
