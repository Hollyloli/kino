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

	<form:form commandName="ocena" class="form-horizontal"
		action="/PracaInz/formularzOcenUcznia.html">

		<div class="form-group">
			<label for="labelWyborKlasy">Wybór roku i semestru</label>
			<form:select path="typ" class="form-control">
				<c:forEach items="${lataISemestryZOcenami}" var="rokIsemestr">
					<form:option value="${rokIsemestr}" />
				</c:forEach>
			</form:select>
		</div>
		<button class="btn btn-primary btn-lg" type="submit">Wyświetl</button>

		<c:if test="${ocenySemestr != null}">
			<c:set var="waga1" value="${0}" />
			<c:set var="waga2" value="0" />
			<c:set var="waga3" value="0" />
			<c:set var="liczbaOcenWag1" value="${0}" />
			<c:set var="liczbaOcenWag2" value="${0}" />
			<c:set var="liczbaOcenWag3" value="${0}" />

			<c:forEach items="${ocenySemestr}" var="przedmiot" varStatus="loop">
				<c:set var="TliczbaOcenWag1" value="${0}" />
				<c:set var="TliczbaOcenWag2" value="${0}" />
				<c:set var="TliczbaOcenWag3" value="${0}" />
				<c:forEach items="${przedmiot.value}" var="pojOcena">
					<c:choose>
						<c:when
							test="${(pojOcena.wagaOceny==1) && pojOcena.typ=='czastkowa'}">
							<c:set var="TliczbaOcenWag1" value="${TliczbaOcenWag1+1}"></c:set>
						</c:when>
						<c:when
							test="${(pojOcena.wagaOceny==2) && pojOcena.typ=='czastkowa'}">
							<c:set var="TliczbaOcenWag2" value="${TliczbaOcenWag2+1}"></c:set>
						</c:when>
						<c:when
							test="${(pojOcena.wagaOceny==3) && pojOcena.typ=='czastkowa'}">
							<c:set var="TliczbaOcenWag3" value="${TliczbaOcenWag3+1}"></c:set>
						</c:when>
					</c:choose>
				</c:forEach>
				<c:if test="${TliczbaOcenWag1>liczbaOcenWag1}">
					<c:set var="liczbaOcenWag1" value="${TliczbaOcenWag1}" />
				</c:if>
				<c:if test="${TliczbaOcenWag2>liczbaOcenWag2}">
					<c:set var="liczbaOcenWag2" value="${TliczbaOcenWag2}" />
				</c:if>
				<c:if test="${TliczbaOcenWag3>liczbaOcenWag3}">
					<c:set var="liczbaOcenWag3" value="${TliczbaOcenWag3}" />
				</c:if>

			</c:forEach>
			<c:set var="maxLiczbaOcen"
				value="${liczbaOcenWag1+liczbaOcenWag2+liczbaOcenWag3}" />
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead>
						<tr>
							<td rowspan="3" align="center"><strong>lp.</strong></td>

							<td rowspan="3" align="center"><strong>Nazwa
									przedmiotu</strong></td>

							<td colspan="${maxLiczbaOcen}" align="center"><strong>Oceny
									i wagi</strong></td>

							<td rowspan="3" align="center"><strong>Średnia</strong></td>

							<td rowspan="3" align="center"><strong>Ocena
									semestralna</strong></td>
						</tr>
						<tr>
							<c:if test="${liczbaOcenWag1!=0}">
								<td colspan="${liczbaOcenWag1}" align="center"><strong>waga1</strong></td>
							</c:if>
							<c:if test="${liczbaOcenWag2!=0}">
								<td colspan="${liczbaOcenWag2}" align="center"><strong>waga2</strong></td>
							</c:if>
							<c:if test="${liczbaOcenWag3!=0}">
								<td colspan="${liczbaOcenWag3}" align="center"><strong>waga3</strong></td>
							</c:if>
						</tr>
						<tr>
							<c:forEach var="i" begin="1" end="${liczbaOcenWag1}">
								<td align="center"><strong>oc${i}</strong></td>
							</c:forEach>
							<c:forEach var="i" begin="1" end="${liczbaOcenWag2}">
								<td align="center"><strong>oc${i}</strong></td>
							</c:forEach>
							<c:forEach var="i" begin="1" end="${liczbaOcenWag3}">
								<td align="center"><strong>oc${i}</strong></td>
							</c:forEach>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ocenySemestr}" var="przedmiot"
							varStatus="loop">
							<tr>
								<c:set var="sredniaOcen" value="${0}" />
								<c:set var="wagaOcen" value="${0}" />
								<c:set var="iloscKolumn" value="${1}" />
								<td align="center">${loop.index+1}</td>
								<td align="center">${przedmiot.key.nazwa}</td>

								<c:forEach items="${przedmiot.value}" var="pojedynczaOcena">
									<c:if
										test="${pojedynczaOcena.wagaOceny==1 && pojedynczaOcena.typ=='czastkowa'}">
										<td align="center">${pojedynczaOcena.ocena}</td>
										<c:set var="sredniaOcen"
											value="${sredniaOcen+pojedynczaOcena.ocena}" />
										<c:set var="wagaOcen" value="${wagaOcen+1}" />
										<c:set var="iloscKolumn" value="${iloscKolumn+1}" />
									</c:if>
								</c:forEach>

								<c:forEach begin="${iloscKolumn}" end="${liczbaOcenWag1}">
									<td></td>
								</c:forEach>
								<c:set var="iloscKolumn" value="${1}" />
								<c:forEach items="${przedmiot.value}" var="pojedynczaOcena">
									<c:if
										test="${pojedynczaOcena.wagaOceny==2 && pojedynczaOcena.typ=='czastkowa'}">
										<td align="center">${pojedynczaOcena.ocena}</td>
										<c:set var="sredniaOcen"
											value="${sredniaOcen+2*pojedynczaOcena.ocena}" />
										<c:set var="wagaOcen" value="${wagaOcen+2}" />
										<c:set var="iloscKolumn" value="${iloscKolumn+1}" />
									</c:if>
								</c:forEach>
								<c:forEach begin="${iloscKolumn}" end="${liczbaOcenWag2}">
									<td></td>
								</c:forEach>
								<c:set var="iloscKolumn" value="${1}" />
								<c:forEach items="${przedmiot.value}" var="pojedynczaOcena">
									<c:if
										test="${pojedynczaOcena.wagaOceny==3 && pojedynczaOcena.typ=='czastkowa'}">
										<td align="center">${pojedynczaOcena.ocena}</td>
										<c:set var="sredniaOcen"
											value="${sredniaOcen+3*pojedynczaOcena.ocena}" />
										<c:set var="wagaOcen" value="${wagaOcen+3}" />
										<c:set var="iloscKolumn" value="${iloscKolumn+1}" />
									</c:if>
								</c:forEach>
								<c:forEach begin="${iloscKolumn}" end="${liczbaOcenWag3}">
									<td></td>
								</c:forEach>
								<td align="center"><c:choose>
										<c:when test="${sredniaOcen==0}">
			                                    			brak ocen
			                                    		</c:when>
										<c:otherwise>
			                                    			${sredniaOcen/wagaOcen}
			                                    		</c:otherwise>
									</c:choose></td>
								<td align="center"><c:forEach items="${przedmiot.value}"
										var="pojedynczaOcena">
										<c:if
											test="${pojedynczaOcena.typ=='semestralna' || pojedynczaOcena.typ=='koncowa'}">
											<strong>${pojedynczaOcena.ocena}</strong>
										</c:if>
									</c:forEach></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</c:if>
	</form:form>
	<br /> <br />
	<hr>
	<br>







</div>
<!--End Main Content-->
