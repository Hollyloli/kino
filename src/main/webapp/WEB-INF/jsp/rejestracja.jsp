<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring2" uri="http://www.springframework.org/tags" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    
      
    <form:form commandName="uzytkownik" cssClass="form-horizontal registrationForm">
    
		<div class="form-group">
			 <label for="login" class="col-sm-2 control-label" >Login</label>
				 <div class="col-sm-10">
	  			    <form:input path="login" cssClass="form-control" />
	  			    <form:errors path="login"/>
	 			 </div>
		</div>
		<div class="form-group">
		 	<label for="imie" class="col-sm-2 control-label" >Imie</label>
				 <div class="col-sm-10">
	 			    <form:input path="imie" cssClass="form-control" />
	 			    <form:errors path="imie" />
				 </div>
		</div>
		<div class="form-group">
		 	<label for="nazwisko" class="col-sm-2 control-label" >Nazwisko</label>
			 	<div class="col-sm-10">
  			    	<form:input path="nazwisko" cssClass="form-control" />
 			 		<form:errors path="nazwisko" />
 			 	</div>
		</div>
		<div class="form-group lol">
		 	<label for="haslo" class="col-sm-2 control-label" >Hasło</label>
			 	<div class="col-sm-2">
  			    	<form:input name="book[0].title"  path="haslo" value="" cssClass="form-control" placeholder="Title"/>
 			 	</div>
 			 	<div class="col-sm-3">
  			    	<input name="book[0].isbn" class="form-control" placeholder="ISBN"/>
 			 	</div>
 			 	<div class="col-sm-2">
  			    	<input name="book[0].price" class="form-control" placeholder="Price"/>
 			 	</div>
 			 	<div class="col-sm-2">
            		<button type="button" class="btn btn-default addButton">dupa</button>
        		</div>
		</div>
		<div class="form-group hide" id="optionTemplate">
			<label for="haslo" class="col-sm-2 control-label" >Hasło</label>
	        
	        <div class="col-sm-2">
  			    	<form:input name="title" path="haslo" class="form-control" placeholder="Title" />
 			 	</div>
 			 	<div class="col-sm-3">
  			    	<input name="isbn" class="form-control" />
 			 	</div>
 			 	<div class="col-sm-2">
  			    	<input name="price" class="form-control" />
		 	</div>
	        
	        <div class="col-sm-2">
	            <button type="button" class="btn btn-default removeButton">dupa2</button>
	        </div>
	        
	
   		</div>
		
   		
		<div class="form-group">
			<div class="col-sm-2">
				<input type="submit" value="Zarejestruj" class="btn btn-lg btn-primary" />
 			 </div>
		</div>
</form:form>

<p>To jest paragraf.</p>




<script type="text/javascript">
$(document).ready(function() {
	bookIndex = 0;
	var rowNum = 0;
	$(".registrationForm").validate(
		{
			rules: {
				login: {
					required : true,
					minlength : 1 
				},
				imie: {
					required : true,
					minlength : 3 
				},
				nazwisko: {
					required : true,
					minlength : 3 
				},
				haslo: {
					required : true,
					minlength : 5 
				}
					
			},

		}
	
	)
		$(".addButton").click(function() { 	
    	//$('.lol').append('lol');

	    bookIndex++;
        var $template = $('#optionTemplate'),
            $clone    = $template
                            .clone()
                            .removeClass('hide')
                            .removeAttr('id')
                            .attr('data-book-index', bookIndex)
                            .insertBefore($template);

        // Update the name attributes
        $clone
            .find('[name="title"]').attr('name', 'book[' + bookIndex + '].title').end()
            .find('[name="isbn"]').attr('name', 'book[' + bookIndex + '].isbn').end()
            .find('[name="price"]').attr('name', 'book[' + bookIndex + '].price').end();

        // Add new fields
        // Note that we also pass the validator rules for new field as the third parameter
        $('.registrationForm')
            .formValidation('addField', 'book[' + bookIndex + '].title', titleValidators)
            .formValidation('addField', 'book[' + bookIndex + '].isbn', isbnValidators)
            .formValidation('addField', 'book[' + bookIndex + '].price', priceValidators);
	})
	;
});





</script>