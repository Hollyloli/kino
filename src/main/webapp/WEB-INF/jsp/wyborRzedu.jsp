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
	
	Graficzna ilustracja miejsc w kinie
	<c:set var="iloscMiejsc" value="0" />
	<table class="table table-bordered">
		<tbody>
			<c:forEach items="${rzedy}" var="rzad" varStatus="loop">
				<tr>
					<c:forEach items="${rzad.miejsca}" var="miejsce" varStatus="loop2">
						<c:choose>
							
							<c:when	test="${miejsce.zajetoscMiejsca==false}">
									<c:set var="iloscMiejsc" value="${iloscMiejsc+1}" />
								<td bgcolor="white">${miejsce.numerMiejsca}</td>
							</c:when>
							<c:when	test="${miejsce.zajetoscMiejsca==true}">
								<td bgcolor="red">${miejsce.numerMiejsca}</td>
							</c:when>
						</c:choose>
							
						
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:choose>
		<c:when test="${iloscMiejsc>0}">
			<form:form commandName="rzad" class="form-horizontal" action="/PracaInz/formularzWyboruRzedu.html">
					<div class="form-group">
						<label for="labelWyborKlasy">Numer rzedu</label>
						<form:select path="numerRzedu" class="form-control">
							<c:forEach items="${rzedy}" var="rzad">
								<form:option value="${rzad.numerRzedu}" />
							</c:forEach>
						</form:select>
					</div>
				<button class="btn btn-primary btn-lg" type="submit">Dodaj</button>
			</form:form>
		</c:when>
		<c:otherwise>
			Aktualnie brak wolnych miejsc w tej sali
		</c:otherwise>	
	</c:choose>
	<br /> <br />
	<hr>
	<br>
</div>

