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
 
        <h1>Nazwa przedmiotu: ${nazwaPrzedmiotu} </h1> 
        
                    <hr>
                  
                    		<c:choose>
			                    <c:when test="${wybor=='czynnosci_zwiazane_z_edycja_ocen'}">
			                    
			                    	  <c:choose>
                    					<c:when test="${ocenaKoncowa==null}">
					        				<form:form commandName="wspolne" class="form-horizontal" action="/PracaInz/formularzUczenIczynnnosc.html">
						                        <div class="form-group">
						                            <label for="adres" class="control-label">Wybrana klasa</label>
					                            	<input class="form-control" value="${klasa.rok} ${klasa.symbol}" disabled="disabled" />
						                        </div>
						                        <div class="form-group">
						                            <label for="labelWyborKlasy">Wybor ucznia</label>
						                            <form:select path="uczen.imie" class="form-control" >
							                            <c:forEach items="${klasa.uczniowie}" var="uczen" varStatus="loop">
							                            	<form:option value="${uczen.imie} ${uczen.nazwisko}"/>
							                            </c:forEach>
							                        </form:select>
							                    </div>
							                    <div class="form-group">
						                            <label for="labelWyborCzynnosci">Wybór czynności</label>
						                            <form:select path="wyborCZynnosci" class="form-control">
						                                <form:option value="wpisywanie oceny" />
						                                <form:option value="edycja oceny" />
						                                <form:option value="usuniecie oceny" />
						                                <form:option value="wystawienie oceny sem lub rocznej" />
						                            </form:select>
						                       </div>
						                        
						                        <button class="btn btn-primary btn-lg" type="submit" >Akceptuj</button>
					                    	</form:form>		
			        				</c:when>
			        				<c:when test="${ocenaKoncowa!=null}">
				        				<h2>Wystawiono już końcowe ocene dla wszystkich uczniów. Opcja czynności związane z edycją ocen jest niedostępna.</h2>
				        			</c:when>
		        					</c:choose>
	        			</c:when>
	        			
	        			<c:when test="${wybor=='czynnosci_zwiazane_z_edycja_frekfencji'}">
	        			
	        			</c:when>
	                    <c:when test="${wybor=='czynnosci_zwiazane_z_podgladaniem_ocen'}">
	                    	<form:form commandName="ocena" class="form-horizontal" action="/PracaInz/formularzWyswietlenieOcen.html" >
		                        <div class="form-group">
		                        </div>
		                        <div class="form-group">
		                            <label for="labelWyborKlasy">Wybór roku nauki</label>
		                            <form:select path="rokNauki" class="form-control" >
		                            	<c:forEach var="i" begin="1" end="${klasa.rok}">
		                           			<form:option value="${i}" />
		                           		</c:forEach>
		                            </form:select>
		                       </div>
		                        <button class="btn btn-primary btn-lg" type="submit" >Akceptuj</button>
	                    	</form:form>	
	                    	<c:if test="${ocenySemestr1 != null}">
	                    	
	                    	<h3>semestr pierwszy</h3>
	                    		<c:set var="waga1" value="${0}" />
                            	<c:set var="waga2" value="0" />
                            	<c:set var="waga3" value="0" />
                            	<c:set var="liczbaOcenWag1" value="${0}" />
                            	<c:set var="liczbaOcenWag2" value="${0}" />
                            	<c:set var="liczbaOcenWag3" value="${0}" />
		    					
		    					<c:forEach items="${ocenySemestr1.uczniowie}" var="uczen2" varStatus="loop">
                            		<c:set var="TliczbaOcenWag1" value="${0}" />
                            		<c:set var="TliczbaOcenWag2" value="${0}" />
                            		<c:set var="TliczbaOcenWag3" value="${0}" />
                            		<c:forEach items="${uczen2.oceny}" var="pojedynczaWaga" >
                            			<c:choose>
                            				<c:when test="${(pojedynczaWaga.wagaOceny==1) && pojedynczaWaga.typ=='czastkowa'}">
                            					<c:set var="TliczbaOcenWag1" value="${TliczbaOcenWag1+1}"></c:set>
                            				</c:when>
                            				<c:when test="${(pojedynczaWaga.wagaOceny==2) && pojedynczaWaga.typ=='czastkowa'}">
                            					<c:set var="TliczbaOcenWag2" value="${TliczbaOcenWag2+1}"></c:set>
                            				</c:when>
                            				<c:when test="${(pojedynczaWaga.wagaOceny==3) && pojedynczaWaga.typ=='czastkowa'}">
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
                           		<c:set var="maxLiczbaOcen" value="${liczbaOcenWag1+liczbaOcenWag2+liczbaOcenWag3}" />
                            <div class="table-responsive">
		                    	<table  class="table table-bordered" >
		                    	<thead>
		        				 	<tr>
		                              <td rowspan="3" align="center" ><strong>lp.</strong></td>
		                              
		                              	<td rowspan="3" align="center"><strong>Imie i Nazwisko</strong></td>
									  
		                              <td colspan="${maxLiczbaOcen}" align="center"><strong>Oceny i wagi</strong></td>
		                              
		                          	  <td rowspan="3" align="center"><strong>Średnia</strong></td>
		                          	  
		                          	  <td rowspan="3" align="center"><strong>Ocena semestralna</strong></td>
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
										<c:forEach items="${ocenySemestr1.uczniowie}" var="uczen2" varStatus="loop">
									 		<tr>
									 			<c:set var="sredniaOcen" value="${0}" />
									 			<c:set var="wagaOcen" value="${0}" />
									 			<c:set var="iloscKolumn" value="${1}" />
									 			<td align="center">${loop.index+1}</td>
	                                    		<td align="center">${uczen2.imie} ${uczen2.nazwisko}</td>
	                                    		
	                                    		<c:forEach items="${uczen2.oceny }" var="pojedynczaOcena">
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==1 && pojedynczaOcena.typ=='czastkowa'}">
	                                    				<td align="center">${pojedynczaOcena.ocena}</td>
	                                    				<c:set var="sredniaOcen" value="${sredniaOcen+pojedynczaOcena.ocena}" />
	                                    				<c:set var="wagaOcen" value="${wagaOcen+1}" />
	                                    				<c:set var="iloscKolumn" value="${iloscKolumn+1}" />
	                                    			</c:if>
	                                    		</c:forEach>
	                                    		
	                                    		<c:forEach begin="${iloscKolumn}" end="${liczbaOcenWag1}">
				                           			<td> </td>
				                           		</c:forEach>
				                           		<c:set var="iloscKolumn" value="${1}" />
	                                    		<c:forEach items="${uczen2.oceny}" var="pojedynczaOcena">
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==2 && pojedynczaOcena.typ=='czastkowa'}">
	                                    				<td align="center">${pojedynczaOcena.ocena}</td>
	                                    				<c:set var="sredniaOcen" value="${sredniaOcen+2*pojedynczaOcena.ocena}" />
	                                    				<c:set var="wagaOcen" value="${wagaOcen+2}" />
	                                    				<c:set var="iloscKolumn" value="${iloscKolumn+1}" />
	                                    			</c:if>
	                                    		</c:forEach>
	                                    		<c:forEach begin="${iloscKolumn}" end="${liczbaOcenWag2}">
				                           			<td> </td>
				                           		</c:forEach>
	                                    		<c:set var="iloscKolumn" value="${1}" />
	                                    		<c:forEach items="${uczen2.oceny}" var="pojedynczaOcena">
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==3 && pojedynczaOcena.typ=='czastkowa'}">
	                                    				<td align="center"> ${pojedynczaOcena.ocena}</td>
	                                    				<c:set var="sredniaOcen" value="${sredniaOcen+3*pojedynczaOcena.ocena}" />
	                                    				<c:set var="wagaOcen" value="${wagaOcen+3}" />
	                                    				<c:set var="iloscKolumn" value="${iloscKolumn+1}" />
	                                    			</c:if>
	                                    		</c:forEach>
	                                    		<c:forEach begin="${iloscKolumn}" end="${liczbaOcenWag3}">
				                           			<td> </td>
				                           		</c:forEach>
	                                    		<td align="center">
		                                    		<c:choose>
			                                    		<c:when test="${sredniaOcen==0}">
			                                    			brak ocen
			                                    		</c:when>
			                                    		<c:otherwise>
			                                    			${sredniaOcen/wagaOcen}
			                                    		</c:otherwise>
		                                    		</c:choose>
	                                    		</td>
	                                    		<td align="center">
		                                    		<c:forEach items="${uczen2.oceny}" var="pojedynczaOcena">
	                           							<c:if test="${pojedynczaOcena.typ=='semestralna'}">
	                           								<strong>${pojedynczaOcena.ocena}</strong>
	                           							</c:if>
			                           				</c:forEach>
		                                    	</td>
	                                    	</tr>
	                                    </c:forEach>
										
	        						</tbody>
                    			</table> 
                    		</div>
	                    	</c:if>
	                    	<c:if test="${ocenySemestr2 != null}">
	                    	<h3>semestr drugi</h3>
	                    		<c:set var="waga1" value="${0}" />
                            	<c:set var="waga2" value="0" />
                            	<c:set var="waga3" value="0" />
                            	<c:set var="liczbaOcenWag1" value="${0}" />
                            	<c:set var="liczbaOcenWag2" value="${0}" />
                            	<c:set var="liczbaOcenWag3" value="${0}" />
		    					<c:set var="maxLiczbaOcen" value="0" />
		    					<c:forEach items="${ocenySemestr2.uczniowie}" var="uczen2" varStatus="loop">
                            		<c:set var="TliczbaOcenWag1" value="${0}" />
                            		<c:set var="TliczbaOcenWag2" value="${0}" />
                            		<c:set var="TliczbaOcenWag3" value="${0}" />
                            		<c:forEach items="${uczen2.oceny}" var="pojedynczaWaga" >
                            			<c:choose>
                            				<c:when test="${(pojedynczaWaga.wagaOceny==1) && (pojedynczaWaga.typ=='czastkowa')}">
                            					<c:set var="TliczbaOcenWag1" value="${TliczbaOcenWag1+1}" />
                            				</c:when>
                            				<c:when test="${pojedynczaWaga.wagaOceny==2 && pojedynczaWaga.typ=='czastkowa'}">
                            					<c:set var="TliczbaOcenWag2" value="${TliczbaOcenWag2+1}" />
                            				</c:when>
                            				<c:when test="${pojedynczaWaga.wagaOceny==3 && pojedynczaWaga.typ=='czastkowa'}">
                            					<c:set var="TliczbaOcenWag3" value="${TliczbaOcenWag3+1}" />
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
                           		<c:set var="maxLiczbaOcen" value="${liczbaOcenWag1+liczbaOcenWag2+liczbaOcenWag3}"/>
                            <div class="table-responsive">
		                    	<table  class="table table-bordered" >
		                    	<thead>
	        				 	<tr>
	                              <td  rowspan="3"  ><strong>lp.</strong></td>
	                              
	                              	<td align="center" rowspan="3"><strong>Imie i Nazwisko</strong></td>
								  
	                              <td align="center" colspan="${maxLiczbaOcen}"><strong>Oceny i wagi</strong></td>
	                              
	                          	  <td align="center" rowspan="3"><strong>Średnia</strong></td>
	                          	  
	                          	 <td rowspan="3" align="center"><strong>Ocena końcowa</strong></td>
	                            </tr>
	                            	<tr>
                           				<c:if test="${liczbaOcenWag1!=0 }">
                           					<td align="center" colspan="${liczbaOcenWag1}"><strong>waga1</strong></td>
                           				</c:if>
                           				<c:if test="${liczbaOcenWag2!=0}">
                           					<td align="center" colspan="${liczbaOcenWag2}"><strong>waga2</strong></td>
                           				</c:if>
                           				<c:if test="${liczbaOcenWag3!=0}">
                           					<td align="center" colspan="${liczbaOcenWag3}"><strong>waga3</strong></td>
                           				</c:if>
	                            	</tr>
	                            	
	                           		<tr>
		                           		<c:forEach var="i" begin="1" end="${liczbaOcenWag1}">
		                           			<td align="center" ><strong>oc${i}</strong></td>
		                           		</c:forEach>
		                           		<c:forEach var="i" begin="1" end="${liczbaOcenWag2}">
		                           			<td align="center" ><strong>oc${i}</strong></td>
		                           		</c:forEach>
		                           		<c:forEach var="i" begin="1" end="${liczbaOcenWag3}">
		                           			<td align="center"><strong>oc${i}</strong></td>
		                           		</c:forEach>
	                           		</tr>
	                           		</thead>
	                           		<tbody>
										<c:forEach items="${ocenySemestr2.uczniowie}" var="uczen2" varStatus="loop">
									 		<tr>
									 			<c:set var="sredniaOcen" value="${0}" />
									 			<c:set var="wagaOcen" value="${0}" />
									 			<c:set var="iloscKolumn" value="${1}" />
									 			<td align="center">${loop.index+1}</td>
	                                    		<td align="center">${uczen2.imie} ${uczen2.nazwisko}</td>
	                                    		
	                                    		<c:forEach items="${uczen2.oceny}" var="pojedynczaOcena">
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==1 && pojedynczaOcena.typ=='czastkowa'}">
	                                    				<td align="center">${pojedynczaOcena.ocena}</td>
	                                    				<c:set var="sredniaOcen" value="${sredniaOcen+pojedynczaOcena.ocena}" />
	                                    				<c:set var="wagaOcen" value="${wagaOcen+1}" />
	                                    				<c:set var="iloscKolumn" value="${iloscKolumn+1}" />
	                                    			</c:if>
	                                    		</c:forEach>
	                                    		
	                                    		<c:forEach begin="${iloscKolumn}" end="${liczbaOcenWag1}">
				                           			<td> </td>
				                           		</c:forEach>
				                           		<c:set var="iloscKolumn" value="${1}" />
	                                    		<c:forEach items="${uczen2.oceny}" var="pojedynczaOcena">
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==2 && pojedynczaOcena.typ=='czastkowa'}">
	                                    				<td align="center">${pojedynczaOcena.ocena}</td>
	                                    				<c:set var="sredniaOcen" value="${sredniaOcen+2*pojedynczaOcena.ocena}" />
	                                    				<c:set var="wagaOcen" value="${wagaOcen+2}" />
	                                    				<c:set var="iloscKolumn" value="${iloscKolumn+1}" />
	                                    			</c:if>
	                                    		</c:forEach>
	                                    		<c:forEach begin="${iloscKolumn}" end="${liczbaOcenWag2}">
				                           			<td> </td>
				                           		</c:forEach>
	                                    		<c:set var="iloscKolumn" value="${1}" />
	                                    		<c:forEach items="${uczen2.oceny}" var="pojedynczaOcena">
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==3 && pojedynczaOcena.typ=='czastkowa'}">
	                                    				<td align="center">${pojedynczaOcena.ocena}</td>
	                                    				<c:set var="sredniaOcen" value="${sredniaOcen+3*pojedynczaOcena.ocena}" />
	                                    				<c:set var="wagaOcen" value="${wagaOcen+3}" />
	                                    				<c:set var="iloscKolumn" value="${iloscKolumn+1}" />
	                                    			</c:if>
	                                    		</c:forEach>
	                                    		<c:forEach begin="${iloscKolumn}" end="${liczbaOcenWag3}">
				                           			<td> </td>
				                           		</c:forEach>
	                                    		<td align="center">
		                                    		<c:choose>
			                                    		<c:when test="${sredniaOcen==0}">
			                                    			brak ocen
			                                    		</c:when>
			                                    		<c:otherwise>
			                                    			${sredniaOcen/wagaOcen}
			                                    		</c:otherwise>
		                                    		</c:choose>
	                                    		</td>
	                                    		<td align="center">
		                                    		<c:forEach items="${uczen2.oceny}" var="pojedynczaOcena">
	                           							<c:if test="${pojedynczaOcena.typ=='koncowa'}">
	                           								<strong>${pojedynczaOcena.ocena}</strong>
	                           							</c:if>
			                           				</c:forEach>
		                                    	</td>
	                                    	</tr>
	                                    </c:forEach>
										
	        						</tbody>
                    			</table>
                    			</div>>
	                    	</c:if>
	                    		
	                    </c:when>
	                    <c:when test="${wybor=='czynnosci zwiazane z podgladaniem frekfencji'}">
	                    </c:when>
                   	</c:choose>                              
                 
                        
    </div>
 <!--End Main Content-->
