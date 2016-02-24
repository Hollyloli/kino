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
	<form:form commandName="miejsce" class="form-horizontal" action="/PracaInz/formularzDodaniaBiletu.html">
			<div class="form-group">
				<label for="labelWyborKlasy">Numer miejsca</label>
				<form:select path="numerMiejsca" class="form-control">
					<c:forEach items="${miejsca}" var="miejsce">
						<form:option value="${miejsce.numerMiejsca}" />
					</c:forEach>
				</form:select>
			</div>
		<button class="btn btn-primary btn-lg" type="submit">Dodaj</button>
	</form:form>
	
	<br /> <br />
	<hr>
	<br>
</div>

