<%@page import="com.rafbur.entity.Nauczyciele"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring2" uri="http://www.springframework.org/tags" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

 <!--Edit Main Content Area here-->
 <div class="col-sm-12" id="divMain">
        
        <h1>Nazwa przedmiotu: ${nazwaPrzedmiotu}</h1>
                    <hr>
                        <form:form commandName="wspolne" class="form-horizontal" action="/PracaInz/formularzKlasIczynnosci.html">
	                        <div class="form-group">
	                            
	                            <label for="labelWyborKlasy">Wybor Klasy</label>
	                            <form:select path="nauczyciel.klasaNauczyciel[0].symbol" class="form-control" >
		                            <c:forEach items="${nauczyciel.klasaNauczyciel}" var="klasa" varStatus="loop">
		                            	<form:option value="${klasa.rok} ${klasa.symbol}"/>
		                            </c:forEach>
		                            </form:select>
	                            <label for="labelWyborCzynnosci">Wybór czynności</label>
	                            <form:select path="wyborCZynnosci" class="form-control">
	                                <form:option value="czynnosci zwiazane z edycja ocen" />
	                                <form:option value="czynnosci zwiazane z edycja frekfencji" />
	                                <form:option value="czynnosci zwiazane z podgladaniem ocen" />
	                                <form:option value="czynnosci zwiazane z podgladaniem frekfencji" />
	                            </form:select>
	                            
	                        </div>
	                        <button class="btn btn-primary btn-lg" type="submit" >Akceptuj</button>
                    </form:form>
                    
                                                            
                       <br />                  
                    <br />                                    
                    <hr>
                    <br>
                    
                    
                    
                    

        
                
    </div>
 <!--End Main Content-->
