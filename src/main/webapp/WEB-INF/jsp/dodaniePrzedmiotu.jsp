<%@page import="com.rafbur.entity.Nauczyciele"%>
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
		<div class="alert alert-success">Dodanie przedmiotu powiodło się</div>
	</c:if>
	<form:form commandName="przedmiot" class="form-horizontal"
		action="/PracaInz/formularzDodaniaPrzedmiotu.html">
		<div class="form-group">
			<div class="form-group">
				<label for="labelWyborKlasy">Wpisanie przedmiotu</label>
				<form:input path="nazwa" cssClass="form-control" />
				<form:errors path="nazwa" />
			</div>
		</div>
		<button class="btn btn-primary btn-lg" type="submit">Dodaj</button>
	</form:form>
	<br /> <br />
	<hr>
	<br>
</div>
<!--End Main Content-->
