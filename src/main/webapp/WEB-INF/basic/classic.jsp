<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- <link href="scripts/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
		 -->
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Icons -->
<link
	href="<c:url value="/resources/scripts/icons/general/stylesheets/general_foundicons.css" />"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/resources/scripts/icons/social/stylesheets/social_foundicons.css" />"
	media="screen" rel="stylesheet" type="text/css" />
<!--[if lt IE 8]>
        <link href="scripts/icons/general/stylesheets/general_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="scripts/icons/social/stylesheets/social_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
    <![endif]-->
<link rel="stylesheet"
	href="<c:url value="/resources/scripts/fontawesome/css/font-awesome.min.css" />" />
<!--[if IE 7]>
        <link rel="stylesheet" href="scripts/fontawesome/css/font-awesome-ie7.min.css">
    <![endif]-->

<link href="<c:url value="/resources/scripts/carousel/style.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/scripts/camera/css/camera.css" />"
	rel="stylesheet" type="text/css" />

<link href="http://fonts.googleapis.com/css?family=Syncopate"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Abel"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Pontano+Sans"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Oxygen"
	rel="stylesheet" type="text/css">

<link href="<c:url value="/resources/styles/custom.css" />"
	rel="stylesheet" type="text/css" />
	
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
    </script>
</head>

<body>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.rafbur.service.text" />

	<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
		prefix="tilesx"%>
	<tilesx:useAttribute name="current" />

	<div id="divBoxed" class="container">
		
		<div class="transparent-bg"
			style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; z-index: -1; zoom: 1;"></div>
		<div class="divPanel notop nobottom">
			
    		<div class="row">
    			<div id="divMenuRight" class="pull-right">
    				<form>
    					<input name="language" type="image" value="pl" ${language == 'pl' ? 'selected' : ''} src="./resources\styles\flaga.png" style="height:20px; width: 30px">
				        <input name="language" type="image" value="en" ${language == 'en' ? 'selected' : ''} src="./resources\styles\usa.png" style="height:20px; width: 30px">
				        
			    	</form>	
    			</div>
    		</div>
			<div class="row">
				<div id="divLogo" class="pull-left">
					<a href="<spring:url value="/" />" id="divSiteTitle"><fmt:message key="glowne.tytul1" /></a><br />
					<a href="<spring:url value="/" />" id="divTagLine"><fmt:message key="glowne.tytul2" /></a>
				</div>
				<div id="divMenuRight" class="pull-right">
					<nav class="navbar ">
						<div class="container-fluid">
							<div class="navbar-header">
								<button type="button" class="navbar-toggle collapsed"
									data-toggle="collapse" data-target="#navbar">
									<span class="sr-only">Toggle navigation</span>
								</button>
							</div>
							<div id="navbar" class="navbar-collapse collapse">

								<ul class="nav nav-pills ddmenu">
									<li class="${current=='index' ? 'active' : ''} "><a
										href='<spring:url value="/" />'><fmt:message key="glowne.dom" /></a></li>
									
									
									<security:authorize access="hasRole('ROLE_ADMIN')">
										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button"><fmt:message key="glowne.admin" /><span
												class="caret"></span></a>
											<ul class="dropdown-menu">
												<li><a
													href="<spring:url value="/dodanieFilmu.html" />"><fmt:message key="glowne.dodajFilm" /></a></li>
												<li><a
													href="<spring:url value="/dodanieSali.html" />"><fmt:message key="glowne.dodajSale" /></a></li>
												<li><a
													href="<spring:url value="/znalezieniaSali.html" />"><fmt:message key="glowne.dodajSeans" /></a></li>
												
											</ul></li>
									</security:authorize>
								
									
									<security:authorize access="!isAuthenticated()">
										<li><a href='<spring:url value="/login.html" />'><fmt:message key="glowne.logowanie" /></a></li>
										<li><a href='<spring:url value="/rejestracja.html" />'><fmt:message key="glowne.rejestracja" /></a></li>
									</security:authorize>
									<security:authorize access="isAuthenticated()">
									<li><a href='<spring:url value="/wyborSeansu.html" />'><fmt:message key="glowne.rezerwacja" /></a></li>
										<li><a href='<spring:url value="/edycjaKonta.html" />'><fmt:message key="glowne.edycjaKonta" /></a></li>
										
										<li><a href='<spring:url value="/logout" />'><fmt:message key="glowne.wyloguj" /></a></li>
									</security:authorize>
								</ul>
								
								
							</div>
							<!--/.nav-collapse -->
						</div>
						<!--/.container-fluid -->
					</nav>
				</div>
			</div>
			<c:if test="${current=='index'}">
				<tiles:insertAttribute name="slider" />
			</c:if>
		</div>
		<div class="contentArea">

			<div class="divPanel notop page-content">

				<c:if test="${current!='index'}">
					<div class="breadcrumbs">
						<a href="<spring:url value="/" />">Home</a> &nbsp;/&nbsp; <span>${current}</span>
					</div>
				</c:if>


				<div class="row">

					<tiles:insertAttribute name="body" />
				</div>
				<div id="footerInnerSeparator"></div>
			</div>
		</div>

		<tiles:insertAttribute name="footer" />

	</div>
	<br />
	<br />
	<br />


</body>
</html>