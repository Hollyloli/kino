<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.rafbur.service.text" />
<!--Edit Main Content Area here-->
<div class="span12" id="divMain">
	<h1><fmt:message key="glowne.witamy" /> !</h1>
	<br /> <br />
</div>
<!--End Main Content-->
