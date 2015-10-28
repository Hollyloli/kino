<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring2" uri="http://www.springframework.org/tags" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    
      
    <form:form commandName="uczen" cssClass="form-horizontal">
    	
    	<div class="form-group">
		 <label for="login" class="col-sm-2 control-label">Login</label>
			 <div class="col-sm-10">
  			    <form:input path="login" cssClass="form-control" />
  			    <form:errors path="login"/>
 			 </div>
		</div>
		<div class="form-group">
		 <label for="imie" class="col-sm-2 control-label">Imię</label>
			 <div class="col-sm-10">
  			    <form:input path="imie" cssClass="form-control" />
  			    <form:errors path="imie"/>
 			 </div>
		</div>
		<div class="form-group">
		 <label for="nazwisko" class="col-sm-2 control-label">Nazwisko</label>
			 <div class="col-sm-10">
  			    <form:input path="nazwisko" cssClass="form-control" />
 			 	<form:errors path="nazwisko"/>
 			 </div>
		</div>
		<div class="form-group">
		 <label for="nazwisko" class="col-sm-2 control-label">Hasło</label>
			 <div class="col-sm-10">
  			    <form:input path="haslo" cssClass="form-control" />
  			    <form:errors path="haslo"/>
 			 </div>
		</div>
		<div class="form-group">
		 <label for="nazwisko" class="col-sm-2 control-label">Adres</label>
			 <div class="col-sm-3">
  			    <form:input path="adresy[0].miasto" cssClass="form-control" placeholder="Miasto" />
  			    <form:errors path="adresy[0].miasto"/>
 			 </div>
 			 <div class="col-sm-3">
  			    <form:input path="adresy[0].ulica" cssClass="form-control" placeholder="ulica"/>
  			    <form:errors path="adresy[0].ulica"/>
 			 </div>
 			 <div class="col-sm-2">
  			    <form:input path="adresy[0].numerMieszkania" cssClass="form-control" placeholder="nr mieszkania"/>
  			    <form:errors path="adresy[0].numerMieszkania"/>
 			 </div>
 			 <div class="col-sm-2">
  			    <form:input path="adresy[0].kodPocztowy" cssClass="form-control" placeholder="kod pocztowy"/>
  			    <form:errors path="adresy[0].kodPocztowy"/>
 			 </div>
 			  			 
		</div>
		<div class="form-group">
		 	<label for="nazwisko" class="col-sm-2 control-label">Dane kontaktowe</label>
			 	<div class="col-sm-5">
  			    	<form:input path="kontakty[0].email" cssClass="form-control" placeholder="adres email" />
  			    	<form:errors path="kontakty[0].email"/>
 			 	</div>
 			 	<div class="col-sm-5">
  			    	<form:input path="kontakty[0].telefon" cssClass="form-control" placeholder="numer telefonu"/>
 			 		<form:errors path="kontakty[0].telefon"/>
 			 	</div>
		</div>
		<div class="form-group">
		
			 <div class="col-sm-2">
				<input type="submit" value="Zapisz" class="btn btn-lg btn-primary" />
 			 </div>
	</div>
		
		

	</form:form>

<script>
$(document).ready(function() {
	$(".registrationForm").validate( {

		
	});
});

</script>