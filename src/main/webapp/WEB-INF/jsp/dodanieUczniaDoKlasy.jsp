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

	<form:form commandName="uczen" class="form-horizontal" action="/PracaInz/formularzUczniaDoKlasy.html">
		<div class="form-group">
			<div class="form-group">
				<label for="labelWyborKlasy">Wybór ucznia</label>
				<form:select path="imie" class="form-control">
					<c:forEach items="${uczniowie}" var="uczen">
						<form:option value="${uczen.imie} ${uczen.nazwisko}" />
					</c:forEach>
				</form:select>
			</div>
		</div>
		<div class="form-group">
			<label for="labelWyborKlasy">Wybor Klasy</label>
            <form:select path="klasa.symbol" class="form-control" >
             <c:forEach items="${klasy}" var="klasa" varStatus="loop">
             	<form:option value="${klasa.rok} ${klasa.symbol}"/>
             </c:forEach>
             </form:select>
        </div>
		<button class="btn btn-primary btn-lg" type="submit">Dodaj</button>
	</form:form>


	<br /> <br />
	<hr>
	<br>







</div>
<!--End Main Content-->
