<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring2" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.rafbur.service.text" />

<form:form commandName="uczen" cssClass="form-horizontal">

	<div class="form-group">
		<c:if test="${param.success eq true}">
				<div class="alert alert-success">Rejestracja uztkownika
					powiodła się</div>
			</c:if>
		<label for="login" class="col-sm-2 control-label">Login</label>
		<div class="col-sm-10">
			<form:input path="login" cssClass="form-control" />
			<form:errors path="login" />
		</div>
	</div>
	<div class="form-group">
		<label for="imie" class="col-sm-2 control-label"><fmt:message key="rejestracja.imie" /></label>
		<div class="col-sm-10">
			<form:input path="imie" cssClass="form-control" />
			<form:errors path="imie" />
		</div>
	</div>
	<div class="form-group">
		<label for="nazwisko" class="col-sm-2 control-label"><fmt:message key="rejestracja.nazwisko" /></label>
		<div class="col-sm-10">
			<form:input path="nazwisko" cssClass="form-control" />
			<form:errors path="nazwisko" />
		</div>
	</div>
	<div class="form-group">
		<label for="nazwisko" class="col-sm-2 control-label"><fmt:message key="rejestracja.haslo" /></label>
		<div class="col-sm-10">
			<form:password path="haslo" cssClass="form-control" />
			<form:errors path="haslo" />
		</div>
	</div>
	<div class="form-group">
		<label for="nazwisko" class="col-sm-2 control-label"><fmt:message key="rejestracja.adres" /></label>
		<div class="col-sm-3">
			<form:input path="adresy[0].miasto" cssClass="form-control"	placeholder="<fmt:message key="rejestracja.adres" />" />
			<form:errors path="adresy[0].miasto" />
		</div>
		<div class="col-sm-3">
			<form:input path="adresy[0].ulica" cssClass="form-control"
				placeholder=<fmt:message key="rejestracja.ulica" /> />
			<form:errors path="adresy[0].ulica" />
		</div>
		<div class="col-sm-2">
			<form:input path="adresy[0].numerMieszkania" cssClass="form-control"
				placeholder=<fmt:message key="rejestracja.nrMieszkania" /> />
			<form:errors path="adresy[0].numerMieszkania" />
		</div>
		<div class="col-sm-2">
			<form:input path="adresy[0].kodPocztowy" cssClass="form-control"
				placeholder=<fmt:message key="rejestracja.kodPocztowy" /> />
			<form:errors path="adresy[0].kodPocztowy" />
		</div>

	</div>
	<div class="form-group">
		<label for="nazwisko" class="col-sm-2 control-label"><fmt:message key="rejestracja.daneKontaktowe" /></label>
		<div class="col-sm-5">
			<form:input path="kontakty[0].email" cssClass="form-control"
				placeholder=<fmt:message key="rejestracja.email" /> />
			<form:errors path="kontakty[0].email" />
		</div>
		<div class="col-sm-5">
			<form:input path="kontakty[0].telefon" cssClass="form-control"
				placeholder="<fmt:message key="rejestracja.numerTel" />" />
			<form:errors path="kontakty[0].telefon" />
		</div>
	</div>
	<div class="form-group">

		<div class="col-sm-2">
			<input type="submit" value="<fmt:message key="rejestracja.klawisz" />" class="btn btn-lg btn-primary" />
		</div>
	</div>

</form:form>

<script>
	$(document).ready(function() {
		$(".registrationForm").validate({

		});
	});
</script>