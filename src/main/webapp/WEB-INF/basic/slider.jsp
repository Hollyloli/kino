<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="row-fluid">
	<div class="span12">

		<div id="headerSeparator"></div>
		<div id="carousel-example-generic2" class="carousel slide"
			data-interval="3000" data-pause="hover" data-wrap="true">
			<!-- Wskaźniki w postaci kropek -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic2" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-generic2" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic2" data-slide-to="2"></li>
			</ol>
			<!-- Slajdy -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="<c:url value="/resources/slider-images/starwars.jpg" />"
						alt="" style="width: 100%; height: 400px">
					<!-- Opis slajdu -->
					<div class="carousel-caption">
						<h3>"Gwiezdne Wojny przebudzenie mocy."</h3>
						<p>J.J. Abrams</p>
					</div>
				</div>

				<div class="item">
					<img
						src="<c:url value="/resources/slider-images/dead2.jpg" />"
						alt="" style="width: 100%; height: 400px">
					<!-- Opis slajdu -->
				</div>

				<div class="item">
					<img src="<c:url value="/resources/slider-images/cywil.jpg" />"
						alt="" style="width: 100%; height: 400px">
					<!-- Opis slajdu -->
					<div class="carousel-caption">
						<h4>"Kapitan Ameryka wojna bohaterow"</h4>
						<p>Anthony Russo</p>
					</div>
				</div>
			</div>
			<!-- Strzałki do przewijania -->
			<a class="left carousel-control" href="#carousel-example-generic2"
				data-slide="prev"> <span class="icon-prev"></span>
			</a> <a class="right carousel-control" href="#carousel-example-generic2"
				data-slide="next"> <span class="icon-next"></span>
			</a>
		</div>

		<div id="headerSeparator2"></div>

	</div>
</div>