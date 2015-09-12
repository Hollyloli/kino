<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring2" uri="http://www.springframework.org/tags" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <style type="text/css">

label {font-size:20px;
		font-weight: normal;
		}

</style>
<div class="col-sm-12">

	<h1>Dane użytkownika:</h1>
	<br>

	 <form:form commandName="polaczone" class="form-horizontal">
    		<div class="form-group">
    			<div class="col-sm-4">
		 			<label for="labelImie"><strong>Imię:</strong></label>
		 			<label for="labelImie">${uzytkownik.imie}</label>
     			</div>
     		</div>
			<div class="form-group">
				<div class="col-sm-4">
	            	<label for="labelImie"><strong>Nazwisko:</strong></label>
	            	<label for="labelImie">${uzytkownik.nazwisko}</label>
            	</div>
            </div>
            <div class="form-group">
            	<div class="col-sm-4">
        			<label for="labelImie"><strong>Data Urodzenia:</strong></label>
           			<label for="labelImie">${uzytkownik.dataUrodzenia}</label> 
           		</div>>
           	</div>
           	<div class="form-group">
           		<div class="col-sm-1">
           			<label for="labelImie"><strong>Hasło:</strong></label>
           		</div>
           		<div class="col-sm-2">
				  	<form:password path="haslo" cssClass="form-control"  />
				  	<form:errors path="haslo" />
				 </div>
           	</div>
            
                
            <div class="form-group ">
            	<div class="col-sm-4">
            		<label for="labelImie"><strong>Adresy:</strong></label> 
            	</div>   
            </div>
            	<c:forEach items="${uzytkownik.adresy}" var="adres" varStatus="loop">
            		
	            	 <div class="form-group">
						 <label for="adres" class="col-sm-2 control-label">Adres</label>
							 <div class="col-sm-2">
				  			    <form:input path="adresy[${loop.index}].miasto" cssClass="form-control" value="${adres.miasto}" />
				  			    <form:errors path="adresy[${loop.index}].miasto" />
				 			 </div>
				 			 <div class="col-sm-3">
				  			    <form:input path="adresy[${loop.index}].ulica" cssClass="form-control" value="${adres.ulica}"/>
				  			    <form:errors path="adresy[${loop.index}].ulica" />
				 			 </div>
				 			 <div class="col-sm-1">
				  			    <form:input path="adresy[${loop.index}].numerMieszkania" cssClass="form-control" value="${adres.numerMieszkania}"/>
				 			 	<form:errors path="adresy[${loop.index}].numerMieszkania" />
				 			 </div>
				 			 <div class="col-sm-2">
				  			    <form:input path="adresy[${loop.index}].kodPocztowy" cssClass="form-control" value="${adres.kodPocztowy}"/>
				 			 	<form:errors path="adresy[${loop.index}].kodPocztowy" />
				 			 </div>
	 						<a href="<spring2:url value="/adres/remove/${adres.idAdresy}.html"  /> " class="btn btn-danger">Usuniecie adresu</a>
					</div>
				</c:forEach>
				<div class="form-group" align="center">
					<button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
					 	Dodaj Adres
					</button>
				</div>
			<br>
			<div class="form-group">
				<div class="col-sm-4">
					<label for="labelImie"><strong>Kontakty:</strong></label>
				</div>
            </div>
            <c:forEach items="${uzytkownik.kontakty}" var="kontakt" varStatus="loop">
        	  	<div class="form-group">
				 	<label for="daneKontaktowe" class="col-sm-2 control-label">Dane kontaktowe</label>
					 	<div class="col-sm-4">
		  			    	<form:input path="kontakty[${loop.index}].email" cssClass="form-control" value="${kontakt.email}" />
		  			    	<form:errors path="kontakty[${loop.index}].email" />
		 			 	</div>
		 			 	<div class="col-sm-4">
		  			    	<form:input path="kontakty[${loop.index}].telefon" cssClass="form-control" value="${kontakt.telefon}"/>
		  			    	<form:errors path="kontakty[${loop.index}].telefon" />
		 			 	</div>
		 			 	<a href="<spring2:url value="/kontakty/remove/${kontakt.idKontaktu}.html"  /> " class="btn btn-danger">Usuniecie kontaktu</a>
				</div> 
            	
            </c:forEach>      
            <br>
            <div class="form-group" align="center">
	            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal2">
					 	Dodaj kontakt
				</button>
			</div>
		<div class="form-group">
		
			 <div class="col-sm-2">
				<input type="submit" value="Zapisz zmiany" class="btn btn-lg btn-primary" />
 			 </div>
	</div>

	</form:form>
		
		
	<!-- Modal -->
	<form:form commandName="polaczone2" class="form-horizontal" action="/PracaInz/edycjaKonta2.html">
	
	
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Dodaj adres</h4>
	      </div>
	      <div class="modal-body">
	        	<div class="form-group">
					 <label for="miasto" class="col-sm-2 control-label">Miasto</label>
						 <div class="col-sm-10">
				  			    <form:input path="adresy[0].miasto" cssClass="form-control" />
				  			    <form:errors path="adresy[0].miasto" /> 
			 			 </div>
				</div>
				<div class="form-group">
					 <label for="miasto" class="col-sm-2 control-label">Numer mieszkania</label>
						 <div class="col-sm-10">
				  			    <form:input path="adresy[0].ulica" cssClass="form-control" />
				  			    <form:errors path="adresy[0].ulica" /> 
			 			 </div>
				</div>
				<div class="form-group">
					 <label for="miasto" class="col-sm-2 control-label">Numer mieszkania</label>
						 <div class="col-sm-10">
				  			    <form:input path="adresy[0].numerMieszkania" cssClass="form-control" />
				  			    <form:errors path="adresy[0].numerMieszkania" /> 
			 			 </div>
				</div>
				<div class="form-group">
					 <label for="miasto" class="col-sm-2 control-label">Kod pocztowy</label>
						 <div class="col-sm-10">
				  			    <form:input path="adresy[0].kodPocztowy" cssClass="form-control" />
				  			    <form:errors path="adresy[0].kodPocztowy" /> 
			 			 </div>
				</div>
				
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <input type="submit"  class="btn btn-primary" value="Save" />
	      </div>
	    </div>
	  </div>
	</div>
	</form:form>
	
	<form:form commandName="polaczone" class="form-horizontal" action="/PracaInz/edycjaKonta3.html">
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Dodaj adres</h4>
	      </div>
	      <div class="modal-body">
	        	<div class="form-group">
					 <label for="email" class="col-sm-2 control-label">Email</label>
						 <div class="col-sm-10">
				  			    <form:input path="kontakty[0].email" cssClass="form-control" />
				  			    <form:errors path="kontakty[0].email" /> 
			 			 </div>
				</div>
				<div class="form-group">
					 <label for="ulica" class="col-sm-2 control-label">Numer Telefonu</label>
						 <div class="col-sm-10">
				  			    <form:input path="kontakty[0].telefon" cssClass="form-control" />
				  			    <form:errors path="kontakty[0].telefon" /> 
			 			 </div>
				</div>				
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <input type="submit"  class="btn btn-primary" value="Save" />
	      </div>
	    </div>
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