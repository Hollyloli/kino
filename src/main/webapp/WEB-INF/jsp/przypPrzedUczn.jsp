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

	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Rejestracja uztkownika
			powiodła się</div>
	</c:if>
	<form:form commandName="uczen" class="form-horizontal"
		action="/PracaInz/formularzPrzypPrzedUczniom.html">
		<div class="form-group">
			<div class="form-group">
				<label for="labelWyborKlasy">Wybor ucznia</label>
				<form:select path="login" class="form-control">
					<c:forEach items="${uczniowie}" var="uczen">
						<form:option value="${uczen.imie} ${uczen.nazwisko}" />
					</c:forEach>
				</form:select>
			</div>
			<div class="form-group">
				<label for="labelWyborKlasy">Wybor przedmioty</label>
				<form:select path="przedmioty[0].nazwa" class="form-control">
					<c:forEach items="${przedmioty}" var="przedmiot">
						<form:option value="${przedmiot.nazwa}" />
					</c:forEach>
				</form:select>
			</div>

		</div>
		<button class="btn btn-primary btn-lg" type="submit">Akceptuj</button>
	</form:form>


	<br /> <br />
	<hr>
	<br>







</div>
<!--End Main Content-->
