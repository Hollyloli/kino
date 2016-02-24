<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring2" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="col-sm-12" id="divMain">
	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Dodanie sali powiodło się</div>
	</c:if>
	<form:form commandName="sala" class="form-horizontal" action="/PracaInz/formularzDodaniaSali.html">
		<div class="form-group">
			<div class="form-group">
				<label for="labelWyborKlasy">Nazwa sali</label>
				<form:input path="nazwaSali" cssClass="form-control" />
				<form:errors path="nazwaSali" />
			</div>
			<div class="form-group">
				<label for="labelWyborKlasy">Ilosc rzedow</label>
				<form:input path="rzedy[0].numerRzedu" cssClass="form-control" />
				<form:errors path="rzedy[0].numerRzedu" />
			</div>
			<div class="form-group">
				<label for="labelWyborKlasy">Ilosc miejsc w kazdym rzedzie</label>
				<form:input path="rzedy[0].miejsca[0].numerMiejsca" cssClass="form-control" />
				<form:errors path="rzedy[0].miejsca[0].numerMiejsca" />
			</div>
			
			<button class="btn btn-primary btn-lg" type="submit">Dodaj</button>
		</div>
		
	</form:form>
	<br /> <br />
	<hr>
	<br>
</div>