<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:getAsString name="title" /></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">

		<link href="<c:url value="/resources/scripts/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" />
		<link href="<c:url value="/resources/scripts/bootstrap/css/bootstrap-responsive.min.css" />" rel="stylesheet" />
		
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

<body id="pageBody">


<div id="divBoxed" class="container">

    <div class="transparent-bg" style="position: absolute;top: 0;left: 0;width: 100%;height: 100%;z-index: -1;zoom: 1;"></div>

    <div class="divPanel notop nobottom">
            <div class="row-fluid">
                <div class="span12">

                    <div id="divLogo" class="pull-left">
                        <a href="index.php" id="divSiteTitle">Dziennik</a><br />
                        <a href="index.php" id="divTagLine">Szkolny</a>
                    </div>

                    <div id="divMenuRight" class="pull-right">
                    <div class="navbar">
                        <button type="button" class="btn btn-navbar-highlight btn-large btn-primary" data-toggle="collapse" data-target=".nav-collapse">
                            NAVIGATION <span class="icon-chevron-down icon-white"></span>
                        </button>
                        <div class="nav-collapse collapse">
                            <ul class="nav nav-pills ddmenu">
                            <li class="active"><a href="index.php">Home</a></li>
                             
							<li class="dropdown">
		                        <a href="page.html" class="dropdown-toggle">Nauczyciel <b class="caret"></b></a>
		                        <ul class="dropdown-menu">
                                            <li class="dropdown">
                                            <a href="#" class="dropdown-toggle">Prowadzone zajecia &nbsp;&raquo;</a>
                                            <ul class="dropdown-menu sub-menu">
                                            
                                                    
                                                    <li><a href="prowadzoneZajecia.php?przedmiot=<?php echo $przedmioty['nazwa']?>"><?php echo $przedmioty['nazwa']?></a></li>
                                                
						                </ul>
		                        	</li>
                                    <li class="dropdown">
    					                <a href="#" class="dropdown-toggle">Oceny uczniow &nbsp;&raquo;</a>
						                <ul class="dropdown-menu sub-menu">
								                <?php
                                                
                                                $result = mysql_query("SELECT nazwa FROM przedmioty");
    						
                                                while( $przedmioty = mysql_fetch_array($result) )
                                                { 	
                                                 //   echo $przedmioty['nazwa'];
                                                ?>
                                                <li><a href="Przedmiot.php?przedmiot=<?php echo $przedmioty['nazwa']?>"><?php echo $przedmioty['nazwa']?></a></li>
                                                <?php
                                                }
                                                ?>
                                            
						                </ul>
		                        	</li>
                                           <li class="dropdown">
                                                <a href="#" class="dropdown-toggle">Obecności uczniow &nbsp;&raquo;</a>
                                                <ul class="dropdown-menu sub-menu">
								                <?php
                                                
                                                $result = mysql_query("SELECT nazwa FROM przedmioty");
    						
                                                while( $przedmioty = mysql_fetch_array($result) )
                                                { 	
                                                 //   echo $przedmioty['nazwa'];
                                                ?>
                                                <li><a href="Przedmiot.php?przedmiot=<?php echo $przedmioty['nazwa']?>"><?php echo $przedmioty['nazwa']?></a></li>
                                                <?php
                                                }
                                                ?>
                                            
                                                </ul>
                                            </li>     
                                    <li><a href="full.html">Kontakt z opiekunem</a></li>
                                    <li><a href="full.html">kontakt z uczniem</a></li>
		                        </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle">Uczen <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="full.html">Obecnosci</a></li>
                                    <li><a href="OcenyUczniow.php">Oceny</a></li>
                                    <li><a href="3-column.html">Kontakt z nauczycielem</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
    	                        <a href="page.html" class="dropdown-toggle">Opiekun <b class="caret"></b></a>
		                        <ul class="dropdown-menu">
                                    <li><a href="full.html">Obecnosci ucznia</a></li>
				                    <li><a href="2-column.html">Oceny ucznia</a></li>
				                    <li><a href="3-column.html">Kontakt z nauczycielem</a></li>

		                        </ul>
                            </li>
							<li class="dropdown">
                                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Sekretariat <span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="#tab_d1" data-toggle="tab">Informacje o szkole</a></li>
                                            <li><a href="#tab_d1" data-toggle="tab">Uczniowie</a></li>
                                            <li><a href="#tab_d2" data-toggle="tab">Klasy</a></li>
                                            <li><a href="#tab_d2" data-toggle="tab">Nauczyciele</a></li>
                                            
                                         </ul>
                            </li>
						    <li><a href="services.html">Kontakt</a></li>
						    <li><a href="logowanie/logowanie.php" >Rejestracja</a></li>
                            <li><a href="logowanie/logowanie.php" >Logowanie</a></li>
                            <li><a href="EdycjaKonta.php" class="nav">Edycja konta</a></li>
                            <li><a href="logout.php" class="nav">Wyloguj</a></li>
                            </ul>
                            </div>
                    </div>
                    </div>

                </div>
            </div>
            
			 <tiles:insertAttribute name="slider"/>
    </div>

    <div class="contentArea">

        <div class="divPanel notop page-content">
            
            <!-- dodac w dziedziczonych 
            <div class="breadcrumbs">
                <a href="index.php">Home</a> &nbsp;/&nbsp; <span>Edycja konta</span>
            </div>
			 -->
            
            <div class="row-fluid">
            
            	<tiles:insertAttribute name="body"/>
            </div>
            <div id="footerInnerSeparator"></div> 
        </div> 
    </div>

	<tiles:insertAttribute name="footer"/>
  
</div>
<br /><br /><br />

<script src="<c:url value="/resources/scripts/jquery.min.js" />" type="text/javascript"></script> 
<script src="<c:url value="/resources/scripts/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/scripts/default.js" />" type="text/javascript"></script>


<script src="<c:url value="/resources/scripts/carousel/jquery.carouFredSel-6.2.0-packed.js" />" type="text/javascript"></script>
<script type="text/javascript">$('#list_photos').carouFredSel({ responsive: true, width: '100%', scroll: 2, items: {width: 320,visible: {min: 2, max: 6}} });</script>
<script src="<c:url value="/resources/scripts/camera/scripts/camera.min.js" /> " type="text/javascript"></script>
<script src="<c:url value="/resources/scripts/easing/jquery.easing.1.3.js" />" type="text/javascript"></script>
<script type="text/javascript">function startCamera() {$('#camera_wrap').camera({ fx: 'scrollLeft', time: 2000, loader: 'none', playPause: false, navigation: true, height: '35%', pagination: true });}$(function(){startCamera()});</script>


</body>
</html>