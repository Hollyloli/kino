<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
    
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:getAsString name="title" /></title>
	
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	
		<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
		
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<!-- <link href="scripts/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
		 -->
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Icons -->
    <link href="<c:url value="/resources/scripts/icons/general/stylesheets/general_foundicons.css" />" media="screen" rel="stylesheet" type="text/css" />  
    <link href="<c:url value="/resources/scripts/icons/social/stylesheets/social_foundicons.css" />" media="screen" rel="stylesheet"  type="text/css" />
    <!--[if lt IE 8]>
        <link href="scripts/icons/general/stylesheets/general_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="scripts/icons/social/stylesheets/social_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
    <![endif]-->
    <link rel="stylesheet" href="<c:url value="/resources/scripts/fontawesome/css/font-awesome.min.css" />" />
    <!--[if IE 7]>
        <link rel="stylesheet" href="scripts/fontawesome/css/font-awesome-ie7.min.css">
    <![endif]-->

    <link href="<c:url value="/resources/scripts/carousel/style.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/scripts/camera/css/camera.css" />" rel="stylesheet" type="text/css" />

    <link href="http://fonts.googleapis.com/css?family=Syncopate" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Pontano+Sans" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Oxygen" rel="stylesheet" type="text/css">

    <link href="<c:url value="/resources/styles/custom.css" />" rel="stylesheet" type="text/css" />
</head>

<body>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<tilesx:useAttribute name="current"/>

<div id="divBoxed" class="container">

    <div class="transparent-bg" style="position: absolute;top: 0;left: 0;width: 100%;height: 100%;z-index: -1;zoom: 1;"></div>

    <div class="divPanel notop nobottom">
            <div class="row">
              		

                    <div id="divLogo" class="pull-left">
                        <a href="index.php" id="divSiteTitle">Dziennik</a><br />
                        <a href="index.php" id="divTagLine">Szkolny</a>
                    </div>

                    <div id="divMenuRight" class="pull-right">
                    
	                    <nav class="navbar ">
					        <div class="container-fluid">
					          <div class="navbar-header">
					            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" >
					              <span class="sr-only">Toggle navigation</span>
					            </button>
					            
					          </div>
					          <div id="navbar" class="navbar-collapse collapse">
					          
					            <ul class="nav nav-pills ddmenu">
					              <li class="${current=='index' ? 'active' : ''} "><a href='<spring:url value="/" />'>Home</a></li>
					             <security:authorize access="hasRole('ROLE_UCZEN')">
					              	<li class="${current=='users' ? 'active' : ''}"><a href='<spring:url value="/users.html" />'>Uczen</a></li>
					             </security:authorize>
			       		        <security:authorize access="hasRole('ROLE_DYREKTOR')">
					              	<li class="dropdown">
						                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" >Dyrektor<span class="caret"></span></a>
						                <ul class="dropdown-menu">
						                  <li><a href="<spring:url value="/zarzadzanieUzytkownikami.html" /> ">Aktywacja konta</a></li>
						                  <li><a href="<spring:url value="/dodaniePrzedmiotu.html" />">Dodanie przedmiotu</a></li>
						                  <li><a href="<spring:url value="/przypPrzedNaucz.html" />">Przyporządkowanie przedmiotu nauczycielowi</a></li>
						                  <li><a href="<spring:url value="/dodanieKlasy.html" />">Dodanie klasy</a></li>
						                  <li><a href="<spring:url value="/dodanieUczniaDoKlasy.html" />">Dodanie ucznia do klasy</a></li>
						                  <li><a href="<spring:url value="/przypPrzedUczn.html" />">Przyporządkowanie przedmiotu uczniom</a></li>
						                  <li><a href="<spring:url value="/zakonczenieRokuSzkolnego.html" /> ">Zakończenie roku szkolnego</a></li>
						                  <li role="separator" class="divider"></li>
						                  <li class="dropdown-header">Prowadzone zajecia</li>
						                
						                </ul>
						              </li>
					             </security:authorize>
			                    <security:authorize access="hasRole('ROLE_OPIEKUN')">
					              	<li class="${current=='users' ? 'active' : ''}"><a href='<spring:url value="/opiekun.html" />'>Dyrektor</a></li>
					             </security:authorize>
					             <security:authorize access="hasRole('ROLE_NAUCZYCIEL')">
								 	 <li class="dropdown">
						                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" >Nauczyciel<span class="caret"></span></a>
						                <ul class="dropdown-menu">
						                  <li><a href="#">Prowadzone zajęcia</a></li>
						                  <li><a href="#">Another action</a></li>
						                  <li><a href="#">Something else here</a></li>
						                  <li role="separator" class="divider"></li>
						                  <li class="dropdown-header">Prowadzone zajecia</li>
						                  <c:forEach items="${przedmiotNauczyciela.przedmiotyNauczycieli}" var="przedmiot" varStatus="loop">
	            							<li class="${current=='index' ? 'active' : ''}"><a href='<spring:url value="/przedmiot-${przedmiot.nazwa}.html" /> '>${przedmiot.nazwa}</a></li>
	           							 </c:forEach>
						                </ul>
						              </li>
					              </security:authorize>
					              <security:authorize access="!isAuthenticated()">
					              	<li><a href='<spring:url value="/login.html" />'>Logowanie</a></li>
					              	<li><a href='<spring:url value="/rejestracja.html" />'>Rejestracja</a></li>
					              </security:authorize>
					              <li><a href='<spring:url value="/kontakt.html" />'>Kontakt</a></li>
					              <security:authorize access="isAuthenticated()">
									<li><a href='<spring:url value="/edycjaKonta.html" />'>Edycja Konta</a></li>
									<li><a href='<spring:url value="/logout" />'>Wyloguj</a></li>
								  </security:authorize>
					            </ul>
					
					          </div><!--/.nav-collapse -->
					        </div><!--/.container-fluid -->
					    </nav>
                    </div>
            </div>
            <c:if test="${current=='index'}">
            	 <tiles:insertAttribute name="slider"/>
            </c:if>
    </div>
    <div class="contentArea">

        <div class="divPanel notop page-content">
            
            <c:if test="${current!='index'}">
            	<div class="breadcrumbs">
                	<a href="index.php">Home</a> &nbsp;/&nbsp; <span>${current}</span>
            	</div>
            </c:if>
            <c:forEach items="${nauczyciel.przedmiotyNauczycieli}" var="przedmiot" varStatus="loop">
            	${przedmiot.nazwa}
            </c:forEach>
            <!-- dodac w dziedziczonych 
            <div class="breadcrumbs">
                <a href="index.php">Home</a> &nbsp;/&nbsp; <span>Edycja konta</span>
            </div>
			 -->
            
            <div class="row">
            
            	<tiles:insertAttribute name="body"/>
            </div>
            <div id="footerInnerSeparator"></div> 
        </div> 
    </div>

	<tiles:insertAttribute name="footer"/>
  
</div>
<br /><br /><br />




<script src="<c:url value="/resources/scripts/carousel/jquery.carouFredSel-6.2.0-packed.js" />" type="text/javascript"></script>
<script type="text/javascript">$('#list_photos').carouFredSel({ responsive: true, width: '100%', scroll: 2, items: {width: 320,visible: {min: 2, max: 6}} });</script>
<script src="<c:url value="/resources/scripts/camera/scripts/camera.min.js" /> " type="text/javascript"></script>
<script src="<c:url value="/resources/scripts/easing/jquery.easing.1.3.js" />" type="text/javascript"></script>
<script type="text/javascript">function startCamera() {$('#camera_wrap').camera({ fx: 'scrollLeft', time: 2000, loader: 'none', playPause: false, navigation: true, height: '35%', pagination: true });}$(function(){startCamera()});</script>


</body>
</html>