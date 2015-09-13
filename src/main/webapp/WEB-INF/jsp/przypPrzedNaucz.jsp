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

	<form:form commandName="nauczyciel" class="form-horizontal" action="/PracaInz/formularzPrzypPrzedNaucz.html">
		<div class="form-group">

			<div class="form-group">
				<label for="labelWyborKlasy">Wybor uzytkownika</label>
				<form:select path="login" class="form-control">
					<c:forEach items="${nauczyciele}" var="nauczyciel1">
						<form:option value="${nauczyciel1.imie} ${nauczyciel1.nazwisko}" />
					</c:forEach>
				</form:select>
			</div>
			<div class="form-group">
				<label for="labelWyborKlasy">Wybor przedmioty</label>
				<form:select path="przedmiotyNauczycieli[0].nazwa" class="form-control">
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
