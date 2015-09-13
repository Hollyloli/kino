<%@page import="com.rafbur.entity.Nauczyciele"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring2" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!--Edit Main Content Area here-->
<div class="col-sm-12" id="divMain">

	<form:form commandName="przedmiot" class="form-horizontal" action="/PracaInz/formularzDodaniaPrzedmiotu.html">
		<div class="form-group">

			<div class="form-group">
				<label for="labelWyborKlasy">Wybor uzytkownika</label>
				<form:input path="nazwa" cssClass="form-control"  />
			</div>
		</div>
		
		
		<button class="btn btn-primary btn-lg" type="submit">Dodaj</button>
	</form:form>


	<br /> <br />
	<hr>
	<br>







</div>
<!--End Main Content-->
