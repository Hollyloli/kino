<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring2" uri="http://www.springframework.org/tags" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="col-sm-12">
	<h1>Dane użytkownika:</h1>

	 <form:form commandName="polaczone" class="form-horizontal">
    	
		 	<label for="labelImie"><strong>Imie:</strong></label>
            ${uzytkownik.imie}
            <br>
            <label for="labelImie"><strong>Nazwisko:</strong></label>
            ${uzytkownik.nazwisko}
            <br>
        	<label for="labelImie"><strong>Data Urodzenia:</strong></label>
            ${uzytkownik.dataUrodzenia}
           	<br>
           	<label for="labelImie"><strong>Zmiana hasla:</strong></label>
             <br>
                
            <label for="labelImie"><strong>Adresy:</strong></label>    
            <c:forEach items="${uzytkownik.adresy}" var="adres">
          		<!-- <label for="labelImie"><strong>Miasto</strong></label>
            	${adres.miasto}<br>
            	<label for="labelImie"><strong>Ulica</strong></label>
            	${adres.ulica}<br>
            	<label for="labelImie"><strong>Numer mieszkania</strong></label>
            	${adres.numerMieszkania}<br>
            	<label for="labelImie"><strong>KodPocztowy</strong></label>
            	${adres.kodPocztowy}<br>  -->
            	<div class="form-group">
					 <label for="adres" class="col-sm-2 control-label">Adres</label>
						 <div class="col-sm-3">
			  			    <form:input path="adresy.miasto" cssClass="form-control" value="${adres.miasto}" />
			 			 </div>
			 			 <div class="col-sm-3">
			  			    <form:input path="adresy.ulica" cssClass="form-control" value="${adres.ulica}"/>
			 			 </div>
			 			 <div class="col-sm-2">
			  			    <form:input path="adresy.numerMieszkania" cssClass="form-control" value="${adres.numerMieszkania}"/>
			 			 </div>
			 			 <div class="col-sm-2">
			  			    <form:input path="adresy.uzytkownicy[0].imie" cssClass="form-control" value="${adres.kodPocztowy}"/>
			 			 </div>
				</div>
            </c:forEach>

			<label for="labelImie"><strong>Kontakty:</strong></label>    
            <c:forEach items="${uzytkownik.kontakty}" var="kontakt">
         <!--  		<label for="labelImie"><strong>Email:</strong></label>
            	${kontakt.email}<br>
            	<label for="labelImie"><strong>Telefon:</strong></label>
            	${kontakt.telefon}<br>  -->
        	 	<div class="form-group">
				 	<label for="nazwisko" class="col-sm-2 control-label">Dane kontaktowe</label>
					 	<div class="col-sm-5">
		  			    	<input class="form-control" placeholder="${kontakt.email}" />
		 			 	</div>
		 			 	<div class="col-sm-5">
		  			    	<input class="form-control" placeholder="${kontakt.telefon}"/>
		 			 	</div>
				</div>
            	
            </c:forEach>      
            
		<div class="form-group">
		
			 <div class="col-sm-2">
				<input type="submit" value="Save" class="btn btn-lg btn-primary" />
 			 </div>
	</div>
		
		

	</form:form>
		

</div>

<script>
$(document).ready(function() {
	$(".registrationForm").validate( {

		
	});
});

	



</script>