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

	<form:form commandName="opiekunowie" class="form-horizontal" action="/PracaInz/formularzPrzypUczniaOpiek.html">
		<div class="form-group">
			<div class="form-group">
				<label for="labelWyborKlasy">Wybor opiekuna</label>
				<form:select path="login" class="form-control">
					<c:forEach items="${opiekunowie1}" var="opiekun">
						<form:option value="${opiekun.imie} ${opiekun.nazwisko} : ${opiekun.login}" />
					</c:forEach>
				</form:select>
			</div>
			<div class="form-group">
				<label for="labelWyborKlasy">Wybor ucznia</label>
				<form:select path="uczniowie[0].login" class="form-control">
					<c:forEach items="${uczniowie}" var="uczen">
						<form:option value="${uczen.imie} ${uczen.nazwisko} : ${uczen.login}" />
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
