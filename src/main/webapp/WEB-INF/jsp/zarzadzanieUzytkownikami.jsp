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
	<form:form commandName="uzytkownik" class="form-horizontal"
		action="/PracaInz/formularzDodatniaRoli.html">
		<div class="form-group">
			<c:if test="${param.success eq true}">
				<div class="alert alert-success">Nadanie uprawnień
					użytkownikowi powiodło się</div>
			</c:if>
			<label for="labelWyborKlasy">Wybor uzytkownika</label>
			<form:select path="imie" class="form-control">
				<c:forEach items="${uzytkownicyBezRoli}" var="uzytkownik"
					varStatus="loop">
					<form:option value="${uzytkownik.imie} ${uzytkownik.nazwisko}" />
				</c:forEach>
			</form:select>
		</div>
		<div class="form-group">
			<label for="labelWyborCzynnosci">Wybór roli</label>
			<form:select path="role[0].typRoli" class="form-control">
				<form:option value="Nauczyciel" />
				<form:option value="Opiekun" />
				<form:option value="Uczen" />
			</form:select>

		</div>
		<button class="btn btn-primary btn-lg" type="submit">Akceptuj</button>
	</form:form>
	<br /> <br />
</div>
<!--End Main Content-->
