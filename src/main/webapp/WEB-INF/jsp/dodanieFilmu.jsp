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
		<div class="alert alert-success">Dodanie filmu powiodło się</div>
	</c:if>
	<form:form commandName="film" class="form-horizontal" action="/PracaInz/formularzDodaniaFilmu.html">
		<div class="form-group">
			<div class="form-group">
				<label for="labelWyborKlasy">Tytul filmu</label>
				<form:input path="tytulFilmu" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="labelWyborKlasy">Dlugosc Filmu</label>
				<form:input path="dlugsc" cssClass="form-control" />
			</div>
		</div>
		<button class="btn btn-primary btn-lg" type="submit">Dodaj</button>
	</form:form>
	<br /> <br />
	<hr>
	<br>
</div>