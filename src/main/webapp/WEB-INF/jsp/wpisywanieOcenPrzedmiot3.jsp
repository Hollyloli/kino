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
                     <c:choose>
	                    <c:when test="${wpisanaOcena=='semestralna'}">
	                    	<h2>Brak możliwości wpisywania/edycji/usunięcia/wystawiania oceny.Wystawiono już ocenę semestralną, a kolejny semestr jeszcze się nie zaczął.</h2>
	                    
	                    </c:when>
                    	<c:when test="${wpisanaOcena=='koncowa'}">
                    		<h2>Brak możliwości wpisywania/edycji/usunięcia/wystawiania oceny. Wystawiono już ocenę końcową</h2>
                    	
                    	</c:when>
                    	<c:otherwise>
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
	        			<c:when test="${wybor2=='edycja_oceny' || wybor2=='usuniecie_oceny' || wybor2=='wystawienie_oceny_sem_lub_rocznej'}">
       							<c:set var="sredniaOcen " value="0" />
								<c:set var="waga1" value="${0}" />
                            	<c:set var="waga2" value="0" />
                            	<c:set var="waga3" value="0" />
                            	<c:set var="liczbaOcenWag1" value="${0}" />
                            	<c:set var="liczbaOcenWag2" value="${0}" />
                            	<c:set var="liczbaOcenWag3" value="${0}" />
		    					<c:set var="maxLiczbaOcen" value="0" />
                            		<c:forEach items="${uczen.oceny}" var="pojedynczaWaga" >
                            				<c:if test="${pojedynczaWaga.wagaOceny==1}">
                            					<c:set var="liczbaOcenWag1" value="${liczbaOcenWag1+1}" /> 
                            				</c:if>
                            				<c:if test="${pojedynczaWaga.wagaOceny==2}">
                            					<c:set var="liczbaOcenWag2" value="${liczbaOcenWag2+1}" /> 
                            				</c:if>
                            				<c:if test="${pojedynczaWaga.wagaOceny==3}">
                            					<c:set var="liczbaOcenWag3" value="${liczbaOcenWag3+1}" /> 
                            				</c:if>
                            		</c:forEach>
                            		<c:set var="maxLiczbaOcen" value="${liczbaOcenWag1+liczbaOcenWag2+liczbaOcenWag3}" /> 
							<div class="table-responsive">
							<table class="table table-bordered">
								<thead>
	        				 	<tr>
	                              
	                              
	                              	<td  rowspan="3" align="center"><strong>Imie i Nazwisko</strong></td>
								  
	                              <td colspan="${maxLiczbaOcen}" align="center"><strong>Oceny i wagi</strong></td>
	                              
	                          	  <td rowspan="3" align="center"><strong>Średnia</strong></td>
	                          	  
	                          	  <c:if test="${wybor2=='wystawienie_oceny_sem_lub_rocznej'}" >
	                          	  	<td rowspan="3" align="center"><strong>Ocena końcowa</strong></td>
	                          	  </c:if>
	                            </tr>
	                            	<tr>
                           				<c:if test="${liczbaOcenWag1!=0}">
                           					<td colspan="${liczbaOcenWag1}" align="center">waga1</td>
                           				</c:if>
                           				<c:if test="${liczbaOcenWag2!=0}">
                           					<td colspan="${liczbaOcenWag2}" align="center">waga2</td>
                           				</c:if>
                           				<c:if test="${liczbaOcenWag3!=0}">
                           					<td colspan="${liczbaOcenWag3}" align="center">waga3</td>
                           				</c:if>
	                            	</tr>
	                            	
	                           		<tr>
		                           		<c:forEach var="i" begin="1" end="${liczbaOcenWag1}">
		                           			<td align="center">oc${i}</td>
		                           		</c:forEach>
		                           		<c:forEach var="i" begin="1" end="${liczbaOcenWag2}">
		                           			<td align="center">oc${i}</td>
		                           		</c:forEach>
		                           		<c:forEach var="i" begin="1" end="${liczbaOcenWag3}">
		                           			<td align="center">oc${i}</td>
		                           		</c:forEach>
	                           		</tr>
								</thead>
								<tbody>
									 		<tr>
									 			
									 			<c:set var="wagaOcen" value="${0}" />
									 			<c:set var="iloscKolumn" value="${1}" />
									 			
	                                    		<td align="center">${uczen.imie} ${uczen.nazwisko}</td>
	                                    		
	                                    		<c:forEach items="${uczen.oceny}" var="pojedynczaOcena" varStatus="loop">
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==1 && pojedynczaOcena.typ=='czastkowa'}">
	                                    				<td align="center">${pojedynczaOcena.ocena}
	                                    				<c:choose>
	                                    				<c:when test="${wybor2=='edycja_oceny'}" >
	                                    					<button type="button"  class="btn btn-primary btn-xs" data-toggle="modal" data-target="#exampleModal" data-whatever="${uczen.oceny[loop.index].idOceny}">Zmien</button>
	                                    				</c:when>
	                                    				<c:when test="${wybor2=='usuniecie_oceny'}">
	                                    					 <a href="<spring:url value="/usuniecieOceny/${uczen.oceny[loop.index].idOceny}.html"  /> " class="btn btn-danger btn-xs" >usuń ocene</a>
	                                    				</c:when>
	                                    				</c:choose>
	                                    				</td>
	                                    				<c:set var="sredniaOcen" value="${sredniaOcen+pojedynczaOcena.ocena}" />
	                                    				<c:set var="wagaOcen" value="${wagaOcen+1}" />
	                                    				<c:set var="iloscKolumn" value="${iloscKolumn+1}" />
	                                    				
	                                    			</c:if>
	                                    		</c:forEach>
	                                    		<c:forEach items="${uczen.oceny}" var="pojedynczaOcena" varStatus="loop">
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==2 && pojedynczaOcena.typ=='czastkowa'}">
	                                    				<td align="center">${pojedynczaOcena.ocena} 
		                                    				<c:choose>
	   					         				                <c:when test="${wybor2=='edycja_oceny'}" >
			                                    					<button type="button"  class="btn btn-primary btn-xs" data-toggle="modal" data-target="#exampleModal" data-whatever="${uczen.oceny[loop.index].idOceny}">Zmien</button>
			                                    				</c:when>
			                                    				<c:when test="${wybor2=='usuniecie_oceny'}">
			                                    					 <a href="<spring:url value="/usuniecieOceny/${uczen.oceny[loop.index].idOceny}.html"  /> " class="btn btn-danger btn-xs" >usuń ocene</a>
			                                    				</c:when>
		                                    				</c:choose>                			
   					                         			</td>
	                                    				<c:set var="sredniaOcen" value="${sredniaOcen+2*pojedynczaOcena.ocena}" />
	                                    				<c:set var="wagaOcen" value="${wagaOcen+2}" />
	                                    				<c:set var="iloscKolumn" value="${iloscKolumn+1}" />
	                                    			</c:if>
	                                    		</c:forEach>
	                                    		<c:forEach items="${uczen.oceny}" var="pojedynczaOcena" varStatus="loop">
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==3 && pojedynczaOcena.typ=='czastkowa'}">
	                                    				<td align="center">${pojedynczaOcena.ocena} 
	                                    					<c:choose>
	   					         				                <c:when test="${wybor2=='edycja_oceny'}" >
			                                    					<button type="button"  class="btn btn-primary btn-xs" data-toggle="modal" data-target="#exampleModal" data-whatever="${uczen.oceny[loop.index].idOceny}">Zmien</button>
			                                    				</c:when>
			                                    				<c:when test="${wybor2=='usuniecie_oceny'}">
			                                    					 <a href="<spring:url value="/usuniecieOceny/${uczen.oceny[loop.index].idOceny}.html"  /> " class="btn btn-danger btn-xs" >usuń ocene</a>
			                                    				</c:when>
		                                    				</c:choose>                			
   					                         			</td>
	                                    				
	                                    				<c:set var="sredniaOcen" value="${sredniaOcen+3*pojedynczaOcena.ocena}" />
	                                    				<c:set var="wagaOcen" value="${wagaOcen+3}" />
	                                    				<c:set var="iloscKolumn" value="${iloscKolumn+1}" />
	                                    			</c:if>
	                                    		</c:forEach>
	                                    		<c:if test="${iloscKolumn==1}">
			                           					<td>
			                           						
			                           					</td>
	                                    		</c:if>
	                                    		<td align="center">
		                                    		<c:choose>
			                                    		<c:when test="${sredniaOcen==null || sredniaOcen==0}">
			                                    			<strong>brak ocen</strong>
			                                    		</c:when>
			                                    		<c:otherwise>
			                                    			<c:set var="sredniaOcen" value="${sredniaOcen/wagaOcen}" />
			                                    			<strong>${sredniaOcen}</strong>
			                                    			
			                                    			<c:if test="${wybor2=='wystawienie_oceny_sem_lub_rocznej'}" >
				                                    			<button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal2">
																 	Wystaw Ocene
																</button>
															</c:if>
			                                    		</c:otherwise>
			                                    		
		                                    		</c:choose>
		                                    	</td>
		                                    	<c:if test="${wybor2=='wystawienie_oceny_sem_lub_rocznej'}" >
			                                    	<td align="center">
			                                    		<c:forEach items="${uczen.oceny}" var="pojedynczaOcena">
		                           							<c:if test="${pojedynczaOcena.typ=='koncowa'}">
		                           								<strong>${pojedynczaOcena.ocena}</strong>
		                           							</c:if>
				                           				</c:forEach>
			                                    	</td>
		                                    	</c:if>
	                                    	</tr>
	                                </tbody>
                    			</table>
                    		</div> 
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
								        <button type="button" class="btn btn-default" data-dismiss="modal">Anuluj</button>
								        <input type="submit"  class="btn btn-primary" value="zapisz" />
								      </div>
								    </div>
								  </div>
								</div>
								
								</form:form>
								
								<form:form commandName="ocena" action="/PracaInz/wystawienieOcenyKoncowej.html">
	        					
								<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-header">
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								        <h4 class="modal-title" id="exampleModalLabel">Panel zmiany oceny</h4>
								      </div>
								      <div class="modal-body">
								        	
								          <div class="form-group">
									        		<label for="labelWyborKlasy">Średnia ucznia</label>
													<input class="form-control" value="${sredniaOcen}" disabled="disabled" />
												</div>
												<c:set var="ocenaKoncowa" value="0" />
												
												<c:set var="sredniaPoZawyzeniu" value="${sredniaOcen+0.5}" />
												<c:set var="sredniaPoZanizeniu" value="${sredniaOcen-0.5}" />
												<c:set var="ocenaKoncowaPoZawyzeniu" value="0" />
												<c:set var="ocenaKoncowaPoZanizeniu" value="0" />
												
												
												<c:choose>
													<c:when test="${sredniaOcen<1.75}">
														<c:set var="ocenaKoncowa" value="1" />
													</c:when>
													<c:when test="${sredniaOcen>=1.75 && sredniaOcen<2.75}">
														<c:set var="ocenaKoncowa" value="2" />
													</c:when>
													<c:when test="${sredniaOcen>=2.75 && sredniaOcen<3.75}">
														<c:set var="ocenaKoncowa" value="3" />
													</c:when>
													<c:when test="${sredniaOcen>=3.75 && sredniaOcen<4.75}">
														<c:set var="ocenaKoncowa" value="4" />
													</c:when>
													<c:when test="${sredniaOcen>=4.75 && sredniaOcen<5.4}">
														<c:set var="ocenaKoncowa" value="5" />
													</c:when>
													<c:when test="${sredniaOcen>=5.4 && sredniaOcen<6}">
														<c:set var="ocenaKoncowa" value="6" />
													</c:when>
												</c:choose>
												
												<c:choose>
													<c:when test="${sredniaPoZanizeniu<1.75}">
														<c:set var="ocenaKoncowaPoZanizeniu" value="1" />
													</c:when>
													<c:when test="${sredniaPoZanizeniu>=1.75 && sredniaPoZanizeniu<2.75}">
														<c:set var="ocenaKoncowaPoZanizeniu" value="2" />
													</c:when>
													<c:when test="${sredniaPoZanizeniu>=2.75 && sredniaPoZanizeniu<3.75}">
														<c:set var="ocenaKoncowaPoZanizeniu" value="3" />
													</c:when>
													<c:when test="${sredniaPoZanizeniu>=3.75 && sredniaPoZanizeniu<4.75}">
														<c:set var="ocenaKoncowaPoZanizeniu" value="4" />
													</c:when>
													<c:when test="${sredniaPoZanizeniu>=4.75 && sredniaPoZanizeniu<5.4}">
														<c:set var="ocenaKoncowaPoZanizeniu" value="5" />
													</c:when>
													<c:when test="${sredniaPoZanizeniu>=5.4 && sredniaPoZanizeniu<6}">
														<c:set var="ocenaKoncowaPoZanizeniu" value="6" />
													</c:when>
												</c:choose>
												
												<c:choose>
													<c:when test="${sredniaPoZawyzeniu<1.75}">
														<c:set var="ocenaKoncowaPoZawyzeniu" value="1" />
													</c:when>
													<c:when test="${sredniaPoZawyzeniu>=1.75 && sredniaPoZawyzeniu<2.75}">
														<c:set var="ocenaKoncowaPoZawyzeniu" value="2" />
													</c:when>
													<c:when test="${sredniaPoZawyzeniu>=2.75 && sredniaPoZawyzeniu<3.75}">
														<c:set var="ocenaKoncowaPoZawyzeniu" value="3" />
													</c:when>
													<c:when test="${sredniaPoZawyzeniu>=3.75 && sredniaPoZawyzeniu<4.75}">
														<c:set var="ocenaKoncowaPoZawyzeniu" value="4" />
													</c:when>
													<c:when test="${sredniaPoZawyzeniu>=4.75 && sredniaPoZawyzeniu<5.4}">
														<c:set var="ocenaKoncowaPoZawyzeniu" value="5" />
													</c:when>
													<c:when test="${sredniaPoZawyzeniu>=5.4 && sredniaPoZawyzeniu<6}">
														<c:set var="ocenaKoncowaPoZawyzeniu" value="6" />
													</c:when>
												</c:choose>
												<div class="form-group">
									        		<label for="labelWyborKlasy">Średnia ucznia po zawyżeniu o 0.5</label>
													<input class="form-control" value="${sredniaPoZawyzeniu}" disabled="disabled" />
												</div>
												<div class="form-group">
									        		<label for="labelWyborKlasy">Średnia ucznia po zaniżeniu o 0.5</label>
													<input class="form-control" value="${sredniaPoZanizeniu}" disabled="disabled" />
												</div>
												<div class="form-group">
									        		<label for="labelWyborKlasy">Proponowana ocena</label>
													<input class="form-control" value="${ocenaKoncowa}" disabled="disabled" />
												</div>
												<div class="form-group">
						                            <label for="labelWyborKlasy">Wybór oceny końcowej uwzgledniając zmiane średniej</label>
						                            <form:select path="ocena" class="form-control" >
							            				<c:if test="${ocenaKoncowa!=ocenaKoncowaPoZanizeniu}">
							                            	<form:option value="${ocenaKoncowaPoZanizeniu}" />
							                            </c:if>
							                            <form:option value="${ocenaKoncowa}" />
							                            <c:if test="${ocenaKoncowa!=ocenaKoncowaPoZawyzeniu}">
							                            	<form:option value="${ocenaKoncowaPoZawyzeniu}" />
							                            </c:if>
						                            </form:select>
					                       		</div>
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-default" data-dismiss="modal">Anuluj</button>
								        <input type="submit"  class="btn btn-primary" value="Zapisz" />
								      </div>
								    </div>
								  </div>
								</div>
								
								</form:form>
								
								
								
	        				<a href="/PracaInz/przedmiot-${nazwaPrzedmiotu}.html">powrot</a>
	        			</c:when>
	        			
        					</c:choose>
                    	</c:otherwise>
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
