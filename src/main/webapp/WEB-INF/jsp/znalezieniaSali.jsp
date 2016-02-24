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
	<form:form commandName="seans" class="form-horizontal" action="/PracaInz/formularzZnalezieniaSali.html">
			<div class="form-group">
				<label for="labelWyborKlasy">Wybór filmu</label>
				<form:select path="film.tytulFilmu" class="form-control">
					<c:forEach items="${filmy}" var="film">
						<form:option value="${film.tytulFilmu}" />
						
					</c:forEach>
				</form:select>
			</div>
			
			
			<div class="form-group">
				<label for="labelWyborKlasy">Poczatek filmu</label>
				<form:input  path="poczatekFilmu" cssClass="form-control"/>
				<form:errors path="poczatekFilmu" />
			</div>
			<div class="form-group">
				<label for="labelWyborKlasy">Koniec filmu</label>
				<form:input  path="koniecFilmu" cssClass="form-control"/>
				<form:errors path="koniecFilmu" />
			</div>
		<button class="btn btn-primary btn-lg" type="submit">Dodaj</button>
	</form:form>
	<br /> <br />
	<hr>
	<br>
</div>

