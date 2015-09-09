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
                    ${wybor2}
                    <c:choose>
	                    <c:when test="${wybor2=='wpisywanie_oceny'}">
	        				<form:form commandName="ocena" class="form-horizontal" action="/PracaInz/wpisanieOceny.html" >
		                        <div class="form-group">
		                            <label for="adres" class="control-label">Wybrana uczeń</label>
	                            	<input class="form-control" value="${uczen.imie} ${uczen.nazwisko}" disabled="disabled" />
		                        </div>
		                        <div class="form-group">
		                            <label for="labelWyborKlasy">Wybor oceny</label>
		                            <form:select path="ocena" class="form-control" >
			                            <form:option value="1" />
			                            <form:option value="2" />
			                            <form:option value="3" />
			                            <form:option value="4" />
			                            <form:option value="5" />
			                            <form:option value="6" />
		                            </form:select>
		                       </div>
		                       <div class="form-group">
		                            <label for="labelWyborCzynnosci">Wybór wagi</label>
		                            <form:select path="wagaOceny" class="form-control" >
			                            <form:option value="1" />
			                            <form:option value="2" />
			                            <form:option value="3" />
		                            </form:select>
		                        </div>
		                        <button class="btn btn-primary btn-lg" type="submit" >Akceptuj</button>
	                    	</form:form>		
	        			</c:when>
	        			<c:when test="${wybor2=='edycja_oceny'}">
							<c:set var="waga1" value="${0}" />
                            	<c:set var="waga2" value="0" />
                            	<c:set var="waga3" value="0" />
                            	<c:set var="liczbaOcenWag1" value="${0}" />
                            	<c:set var="liczbaOcenWag2" value="${0}" />
                            	<c:set var="liczbaOcenWag3" value="${0}" />
		    					<c:set var="maxLiczbaOcen" value="0" />
                            		
                            		<c:forEach items="${uczen.oceny}" var="pojedynczaWaga" >
                            			wykonuke
                            				<c:if test="${pojedynczaWaga.wagaOceny==1}">
                            					wypisuje wagi ${pojedynczaWaga.wagaOceny} koniec WAGI
                            					${liczbaOcenWag1=liczbaOcenWag1+1}
                            				</c:if>
                            				<c:if test="${pojedynczaWaga.wagaOceny==2}">
                            					lol
                            					${liczbaOcenWag2=liczbaOcenWag2+1}
                            				</c:if>
                            				<c:if test="${pojedynczaWaga.wagaOceny==3}">
                            					lol2
                            					${liczbaOcenWag3=liczbaOcenWag3+1}
                            				</c:if>
                            		</c:forEach>
                           		
                           		wypisuje liczbe ocenWAg ${liczbaOcenWag1} po
                           		wypisuje liczbe ocenWAg2 ${liczbaOcenWag2} po
                           		wypisuje liczbe ocenWAg3 ${liczbaOcenWag3} po
                           		${maxLiczbaOcen=liczbaOcenWag1+liczbaOcenWag2+liczbaOcenWag3}
                           		wypisuje max liczbe ocen ${maxLiczbaOcen} 
           						wypisuje max liczbe ocen ${maxLiczbaOcen}  koniec  
							<table  border="1" >
	        				 	<tr>
	                              
	                              
	                              	<td width="200" rowspan="3"><strong>Imie i Nazwisko</strong></td>
								  
	                              <td width="522" colspan="${maxLiczbaOcen}"><strong>Oceny i wagi</strong></td>
	                              
	                          	  <td width="52" rowspan="3"><strong>Średnia</strong></td>
	                            </tr>
	                            	<tr>
                           				<c:if test="${liczbaOcenWag1!=0}">
                           					<td colspan="${liczbaOcenWag1}">waga1</td>
                           				</c:if>
                           				<c:if test="${liczbaOcenWag2!=0}">
                           					<td colspan="${liczbaOcenWag2}">waga2</td>
                           				</c:if>
                           				<c:if test="${liczbaOcenWag3!=0}">
                           					<td colspan="${liczbaOcenWag3}">waga3</td>
                           				</c:if>
	                            	</tr>
	                            	
	                           		<tr>
		                           		<c:forEach var="i" begin="1" end="${liczbaOcenWag1}">
		                           			<td>oc${i}</td>
		                           		</c:forEach>
		                           		<c:forEach var="i" begin="1" end="${liczbaOcenWag2}">
		                           			<td>oc${i}</td>
		                           		</c:forEach>
		                           		<c:forEach var="i" begin="1" end="${liczbaOcenWag3}">
		                           			<td>oc${i}</td>
		                           		</c:forEach>
	                           		</tr>
										
									 		<tr>
									 			<c:set var="sredniaOcen" value="${0}" />
									 			<c:set var="wagaOcen" value="${0}" />
									 			<c:set var="iloscKolumn" value="${1}" />
									 			
	                                    		<td width="122">${uczen.imie} ${uczen.nazwisko}</td>
	                                    		
	                                    		<c:forEach items="${uczen.oceny}" var="pojedynczaOcena" varStatus="loop">
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==1}">
	                                    				<td width="122">${pojedynczaOcena.ocena} <br>
	                                    				<button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#exampleModal" data-whatever="${uczen.oceny[loop.index].idOceny}">Zmien</button></td>
	                                    				<c:set var="sredniaOcen" value="${sredniaOcen+pojedynczaOcena.ocena}" />
	                                    				<c:set var="wagaOcen" value="${wagaOcen+1}" />
	                                    				<c:set var="iloscKolumn" value="${iloscKolumn+1}" />
	                                    				
	                                    			</c:if>
	                                    		</c:forEach>
	                                    		<c:forEach items="${uczen.oceny}" var="pojedynczaOcena">
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==2}">
	                                    				<td width="122">${pojedynczaOcena.ocena} <br>
   					                         				<button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#exampleModal" data-whatever="${uczen.oceny[loop.index].idOceny}">Zmien</button></td>
	                                    				</td>
	                                    				<c:set var="sredniaOcen" value="${sredniaOcen+2*pojedynczaOcena.ocena}" />
	                                    				<c:set var="wagaOcen" value="${wagaOcen+2}" />
	                                    				<c:set var="iloscKolumn" value="${iloscKolumn+1}" />
	                                    			</c:if>
	                                    		</c:forEach>
	                                    		<c:forEach items="${uczen.oceny}" var="pojedynczaOcena">
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==3}">
	                                    				<td width="122">${pojedynczaOcena.ocena} <br>
	                                    					<button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#exampleModal" data-whatever="${uczen.oceny[loop.index].idOceny}">Zmien</button></td>
	                                    				</td>
	                                    				<c:set var="sredniaOcen" value="${sredniaOcen+3*pojedynczaOcena.ocena}" />
	                                    				<c:set var="wagaOcen" value="${wagaOcen+3}" />
	                                    				<c:set var="iloscKolumn" value="${iloscKolumn+1}" />
	                                    			</c:if>
	                                    		</c:forEach>
	                                    		<c:if test="${iloscKolumn==1}">
			                           					<td> </td>
	                                    		</c:if>
	                                    		<td>
	                                    		<c:choose>
		                                    		<c:when test="${sredniaOcen==0}">
		                                    			brak ocen
		                                    		</c:when>
		                                    		<c:otherwise>
		                                    			${sredniaOcen/wagaOcen}
		                                    		</c:otherwise>
		                                    		
	                                    		</c:choose>
	                                    		</td>
	                                    	</tr>
	                                 		
                    			</table> 
	        				dipa blada
	                    		${uczen.oceny[0].ocena}
	                    		
	                    		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Zmien</button>
	        					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@fat">Open modal for @fat</button>
								<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@${uczen.oceny[0].ocena}">Open modal for @getbootstrap</button>
	        			
	        					<form:form commandName="ocena" action="/PracaInz/edycjaOcen.html">
	        					
	        					<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-header">
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								        <h4 class="modal-title" id="exampleModalLabel">Panel zmiany oceny</h4>
								      </div>
								      <div class="modal-body">
								        	
								          <div class="form-group">
								            <label for="recipient-name" class="control-label">Recipient:</label>
								            <form:input path="idOceny" value="1" type="hidden"/>
								          </div>
								          <div class="form-group">
					                            <label for="labelWyborKlasy">Wprowadź nowa ocene</label>
					                            <form:select path="ocena" class="form-control" >
						                            <form:option value="1" />
						                            <form:option value="2" />
						                            <form:option value="3" />
						                            <form:option value="4" />
						                            <form:option value="5" />
						                            <form:option value="6" />
					                            </form:select>
					                       </div>
					                       <div class="form-group">
					                            <label for="labelWyborCzynnosci">Wprowadź nową wagę</label>
					                            <form:select path="wagaOceny" class="form-control" >
						                            <form:option value="1" />
						                            <form:option value="2" />
						                            <form:option value="3" />
					                            </form:select>
					                        </div>
								        
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								        <input type="submit"  class="btn btn-primary" value="Save" />
								      </div>
								    </div>
								  </div>
								</div>
								
								</form:form>
	        				<a href="/PracaInz/przedmiot-${nazwaPrzedmiotu}.html">powrot</a>
	        			</c:when>
        			</c:choose>
        			
        			<script>
        			$('#exampleModal').on('show.bs.modal', function (event) {
        				  var button = $(event.relatedTarget) // Button that triggered the modal
        				  var recipient = button.data('whatever') // Extract info from data-* attributes
        				  
        				  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        				  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        				  var modal = $(this)
        				  modal.find('#idOceny').val(recipient)
        				
        				})
        			</script>
        			
                    <br />                  
                    <br />                                    
                    <hr>
                    <br>
    </div>
 <!--End Main Content-->
