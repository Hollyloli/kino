<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring2" uri="http://www.springframework.org/tags" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    
      
    <form:form commandName="polaczone" cssClass="form-horizontal">
    	
    	<div class="form-group">
		 <label for="login" class="col-sm-2 control-label">Login</label>
			 <div class="col-sm-10">
  			    <form:input path="uzytkownicy.login" cssClass="form-control" />
  			    <form:errors path="uzytkownicy.login"/>
 			 </div>
		</div>
		<div class="form-group">
		 <label for="imie" class="col-sm-2 control-label">Imię</label>
			 <div class="col-sm-10">
  			    <form:input path="uzytkownicy.imie" cssClass="form-control" />
  			    <form:errors path="uzytkownicy.imie"/>
 			 </div>
		</div>
		<div class="form-group">
		 <label for="nazwisko" class="col-sm-2 control-label">Name</label>
			 <div class="col-sm-10">
  			    <form:input path="uzytkownicy.nazwisko" cssClass="form-control" />
 			 	<form:errors path="uzytkownicy.nazwisko"/>
 			 </div>
		</div>
		<div class="form-group">
		 <label for="nazwisko" class="col-sm-2 control-label">Hasło</label>
			 <div class="col-sm-10">
  			    <form:input path="uzytkownicy.haslo" cssClass="form-control" />
  			    <form:errors path="uzytkownicy.haslo"/>
 			 </div>
		</div>
		<div class="form-group">
		 <label for="nazwisko" class="col-sm-2 control-label">Adres</label>
			 <div class="col-sm-3">
  			    <form:input path="adresy.miasto" cssClass="form-control" placeholder="Miasto" />
  			    <form:errors path="adresy.miasto"/>
 			 </div>
 			 <div class="col-sm-3">
  			    <form:input path="adresy.ulica" cssClass="form-control" placeholder="ulica"/>
 			 </div>
 			 <div class="col-sm-2">
  			    <form:input path="adresy.numerMieszkania" cssClass="form-control" placeholder="nr mieszkania"/>
 			 </div>
 			 <div class="col-sm-2">
  			    <form:input path="adresy.kodPocztowy" cssClass="form-control" placeholder="kod pocztowy"/>
 			 </div>
 			  			 
		</div>
		<div class="form-group">
		 	<label for="nazwisko" class="col-sm-2 control-label">Dane kontaktowe</label>
			 	<div class="col-sm-5">
  			    	<form:input path="kontakty.email" cssClass="form-control" placeholder="adres email" />
 			 	</div>
 			 	<div class="col-sm-5">
  			    	<form:input path="kontakty.telefon" cssClass="form-control" placeholder="numer telefonu"/>
 			 	</div>
		</div>
		<div class="form-group">
		
			 <div class="col-sm-2">
				<input type="submit" value="Save" class="btn btn-lg btn-primary" />
 			 </div>
	</div>
		
		

	</form:form>

<script>
$(document).ready(function() {
	$(".registrationForm").validate( {

		
	});
});

</script>