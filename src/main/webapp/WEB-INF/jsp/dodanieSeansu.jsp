<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring2" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="col-sm-12" id="divMain">
	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Dodanie seansu powiodło się</div>
	</c:if>
	<c:choose>
		<c:when test="${fn:length(sale)>0}">
			<form:form commandName="sala" class="form-horizontal" action="/PracaInz/formularzDodaniaSeansu.html">
					
					<div class="form-group">
						<label for="labelWyborKlasy">Wybór sali</label>
						<form:select path="nazwaSali" class="form-control">
							<c:forEach items="${sale}" var="sala">
								<form:option value="${sala.nazwaSali}" />
							</c:forEach>
						</form:select>
					</div>
					
				<button class="btn btn-primary btn-lg" type="submit">Dodaj</button>
			</form:form>
		</c:when>
		<c:otherwise>
			Brak sal do zarezerowania w tych godzinach
		</c:otherwise>
	</c:choose>
	<br /> <br />
	<hr>
	<br>
</div>
