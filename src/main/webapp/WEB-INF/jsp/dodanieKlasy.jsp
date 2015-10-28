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

	<form:form commandName="klasa" class="form-horizontal"
		action="/PracaInz/formularzDodaniaKlasy.html">
		<div class="form-group">
			<c:if test="${param.success eq true}">
				<div class="alert alert-success">Dodanie klasy powidło się</div>
			</c:if>
			<label for="labelWyborKlasy">Proszę wpisać rok klasy</label>
			<form:input path="rok" cssClass="form-control" />
			<form:errors path="rok" />
			<form:errors />
			<label for="labelWyborKlasy">Proszę podac symbol klasy</label>
			<form:input path="symbol" cssClass="form-control" />
			<form:errors path="symbol" />
			<form:errors />
		</div>
		<button class="btn btn-primary btn-lg" type="submit">Dodaj</button>
	</form:form>
	<br /> <br />
	<hr>
	<br>

</div>
<!--End Main Content-->
