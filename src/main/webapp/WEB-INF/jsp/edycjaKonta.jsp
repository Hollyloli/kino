<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring2" uri="http://www.springframework.org/tags" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="col-sm-4">
	<h1>Dane użytkownika:</h1>
	<c:forEach items="${uzytkownicy}" var="uzytkownik">
		
	  	<table class="table">
			<tbody >
				
					<tr >
						<td class="col-sm-2"><label for="nazwisko" class="control-label">Login:</label></td>
						<td class="col-sm-2">rafal</td>
						<td class="col-sm-8">rafal</td>
					</tr>
					<tr >
						<td class="col-sm-1"><label for="nazwisko" class="control-label">Imię:</label> </td>
						<td class="col-sm-2">rafal</td>
					</tr>
					<tr >
						<td class="col-sm-1"><label for="nazwisko" class="control-label">Nazwisko:</label> </td>
						<td class="col-sm-2">rafal</td>
					</tr>
					<tr >
						<td class="col-sm-1"><label for="nazwisko" class="control-label">:</label> </td>
						<td class="col-sm-2">rafal</td>
					</tr>
			</tbody>
		</table>
	</c:forEach>
</div>

<script>
$(document).ready(function() {
	$(".registrationForm").validate( {

		
	});
});

	



</script>