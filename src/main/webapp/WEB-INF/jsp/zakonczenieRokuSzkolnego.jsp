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

	<div class="table-responsive">
		<table class="table table-bordered">
			<thead>
				<tr>
					<td align="center"><strong>lp.</strong></td>
					<td align="center"><strong>Nazwa klasy</strong></td>
					<td align="center"><strong>Status wpisania ocen</strong></td>
				</tr>
			</thead>
			<tbody>
				<c:set var="liczbaKlas" value="${0}" />
				<c:set var="liczbaWpisanychWszystkichOcen" value="${0}" />
				<c:forEach var="klasa" items="${klasy}" varStatus="status">
					<p>
					<tr>
						<td>${status.index+1}</td>
						<td>${klasa.rok}${klasa.symbol}</td>
						<c:choose>
							<c:when test="${statusOcen[status.index]==0}">
								<td>Wpisano wszystkie oceny</td>
								<c:set var="liczbaWpisanychWszystkichOcen"
									value="${liczbaWpisanychWszystkichOcen+1}" />
								<c:set var="liczbaKlas" value="${liczbaKlas+1}" />
							</c:when>
							<c:otherwise>
								<td>Nie wpisano wszystkich ocen</td>
								<c:set var="liczbaKlas" value="${liczbaKlas+1}" />
							</c:otherwise>


						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<c:if test="${liczbaKlas==liczbaWpisanychWszystkichOcen}">
		<form:form commandName="klasa" class="form-horizontal"
			action="/PracaInz/formularzZakonczeniaRoku.html">

			<button class="btn btn-primary btn-lg" type="submit">Dodaj</button>
		</form:form>
	</c:if>

	<br /> <br />
	<hr>
	<br>







</div>
<!--End Main Content-->
