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
 viyviv
        <h1>Nazwa przedmiotu: ${nazwaPrzedmiotu} </h1> 
        
                    <hr>
                    <c:choose>
	                    <c:when test="${wybor=='czynnosci_zwiazane_z_edycja_ocen'}">
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
		                                <form:option value="wystawienie oceny sem/rocznej" />
		                            </form:select>
		                       </div>
		                        
		                        <button class="btn btn-primary btn-lg" type="submit" >Akceptuj</button>
	                    	</form:form>		
	        			</c:when>
	        			<c:when test="${wybor=='czynnosci_zwiazane_z_edycja_frekfencji'}">
	        			
	        			</c:when>
	                    <c:when test="${wybor=='czynnosci_zwiazane_z_podgladaniem_ocen'}">
	                    	<form:form commandName="ocena" class="form-horizontal" action="/PracaInz/formularzWyswietlenieOcen.html" >
		                        <div class="form-group">
		                        </div>
		                        <div class="form-group">
		                            <label for="labelWyborKlasy">Wybór roku nauki</label>
		                            <form:select path="ocena" class="form-control" >
		                            	<c:forEach var="i" begin="1" end="${klasa.rok}">
		                           			<form:option value="${i}" />
		                           		</c:forEach>
		                            </form:select>
		                       </div>
		                        <button class="btn btn-primary btn-lg" type="submit" >Akceptuj</button>
	                    	</form:form>	
	                    
	                    	bjjk
	                    	<c:if test="${ocenySemestr1 != null}">
	                    		dupa
	                    		<c:set var="waga1" value="${0}" />
                            	<c:set var="waga2" value="0" />
                            	<c:set var="waga3" value="0" />
                            	<c:set var="liczbaOcenWag1" value="${0}" />
                            	<c:set var="liczbaOcenWag2" value="${0}" />
                            	<c:set var="liczbaOcenWag3" value="${0}" />
		    					<c:set var="maxLiczbaOcen" value="0" />
		    					<c:forEach items="${ocenySemestr1.uczniowie}" var="uczen2" varStatus="loop">
		    					LOLOLO
                            		<c:set var="TliczbaOcenWag1" value="${0}" />
                            		<c:set var="TliczbaOcenWag2" value="${0}" />
                            		<c:set var="TliczbaOcenWag3" value="${0}" />
                            		${uczen2.oceny[0].ocena}
                            		<c:forEach items="${uczen2.oceny}" var="pojedynczaWaga" >
                            			<c:choose>
                            				<c:when test="${(pojedynczaWaga.wagaOceny==1)}">
                            					${TliczbaOcenWag1=TliczbaOcenWag1+1}
                            				</c:when>
                            				<c:when test="${(pojedynczaWaga.wagaOceny==2)}">
                            					${TliczbaOcenWag2=TliczbaOcenWag2+1}
                            				</c:when>
                            				<c:when test="${(pojedynczaWaga.wagaOceny==3)}">
                            					${TliczbaOcenWag3=TliczbaOcenWag3+1}
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
                           		wypisuje liczbe ocenWAg ${liczbaOcenWag1} po
                           		wypisuje liczbe ocenWAg2 ${liczbaOcenWag2} po
                           		wypisuje liczbe ocenWAg3 ${liczbaOcenWag3} po
                           		${maxLiczbaOcen=liczbaOcenWag1+liczbaOcenWag2+liczbaOcenWag3}
                           		wypisuje max liczbe ocen ${maxLiczbaOcen} 
           						wypisuje max liczbe ocen ${maxLiczbaOcen}  koniec              		
                            
		                    	<table  border="1" >
	        				 	<tr>
	                              <td width="18" rowspan="3"  ><strong>lp.</strong></td>
	                              
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
										<c:forEach items="${ocenySemestr1.uczniowie}" var="uczen2" varStatus="loop">
									 		<tr>
									 			<c:set var="sredniaOcen" value="${0}" />
									 			<c:set var="wagaOcen" value="${0}" />
									 			<c:set var="iloscKolumn" value="${1}" />
									 			<td width="18">${loop.index+1}</td>
	                                    		<td width="122">${uczen2.imie} ${uczen2.nazwisko}</td>
	                                    		
	                                    		<c:forEach items="${uczen2.oceny}" var="pojedynczaOcena">
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==1}">
	                                    				<td width="122">${pojedynczaOcena.ocena}</td>
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
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==2}">
	                                    				<td width="122">${pojedynczaOcena.ocena}</td>
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
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==3}">
	                                    				<td width="122">${pojedynczaOcena.ocena}</td>
	                                    				<c:set var="sredniaOcen" value="${sredniaOcen+3*pojedynczaOcena.ocena}" />
	                                    				<c:set var="wagaOcen" value="${wagaOcen+3}" />
	                                    				<c:set var="iloscKolumn" value="${iloscKolumn+1}" />
	                                    			</c:if>
	                                    		</c:forEach>
	                                    		<c:forEach begin="${iloscKolumn}" end="${liczbaOcenWag3}">
				                           			<td> </td>
				                           		</c:forEach>
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
	                                    </c:forEach>
										
	        
                    			</table> 
	                    	</c:if>
	                    	<c:if test="${ocenySemestr2 != null}">
	                    		dipa blada
	                    		<c:set var="waga1" value="${0}" />
                            	<c:set var="waga2" value="0" />
                            	<c:set var="waga3" value="0" />
                            	<c:set var="liczbaOcenWag1" value="${0}" />
                            	<c:set var="liczbaOcenWag2" value="${0}" />
                            	<c:set var="liczbaOcenWag3" value="${0}" />
		    					<c:set var="maxLiczbaOcen" value="0" />
		    					<c:forEach items="${ocenySemestr2.uczniowie}" var="uczen2" varStatus="loop">
		    					LOLOLO
                            		<c:set var="TliczbaOcenWag1" value="${0}" />
                            		<c:set var="TliczbaOcenWag2" value="${0}" />
                            		<c:set var="TliczbaOcenWag3" value="${0}" />
                            		${uczen2.oceny[0].ocena}
                            		<c:forEach items="${uczen2.oceny}" var="pojedynczaWaga" >
                            		KURWEKA
                            			<c:choose>
                            				<c:when test="${(pojedynczaWaga.wagaOceny==1)}">
                            					${TliczbaOcenWag1=TliczbaOcenWag1+1}
                            				</c:when>
                            				<c:when test="${(pojedynczaWaga.wagaOceny==2)}">
                            					${TliczbaOcenWag2=TliczbaOcenWag2+1}
                            				</c:when>
                            				<c:when test="${(pojedynczaWaga.wagaOceny==3)}">
                            					${TliczbaOcenWag3=TliczbaOcenWag3+1}
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
                           		wypisuje liczbe ocenWAg ${liczbaOcenWag1} po
                           		wypisuje liczbe ocenWAg2 ${liczbaOcenWag2} po
                           		wypisuje liczbe ocenWAg3 ${liczbaOcenWag3} po
                           		${maxLiczbaOcen=liczbaOcenWag1+liczbaOcenWag2+liczbaOcenWag3}
                           		wypisuje max liczbe ocen ${maxLiczbaOcen} 
           						wypisuje max liczbe ocen ${maxLiczbaOcen}  koniec              		
                            
		                    	<table  border="1" >
	        				 	<tr>
	                              <td width="18" rowspan="3"  ><strong>lp.</strong></td>
	                              
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
										<c:forEach items="${ocenySemestr2.uczniowie}" var="uczen2" varStatus="loop">
									 		<tr>
									 			<c:set var="sredniaOcen" value="${0}" />
									 			<c:set var="wagaOcen" value="${0}" />
									 			<c:set var="iloscKolumn" value="${1}" />
									 			<td width="18">${loop.index+1}</td>
	                                    		<td width="122">${uczen2.imie} ${uczen2.nazwisko}</td>
	                                    		
	                                    		<c:forEach items="${uczen2.oceny}" var="pojedynczaOcena">
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==1}">
	                                    				<td width="122">${pojedynczaOcena.ocena}</td>
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
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==2}">
	                                    				<td width="122">${pojedynczaOcena.ocena}</td>
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
	                                    			<c:if test="${pojedynczaOcena.wagaOceny==3}">
	                                    				<td width="122">${pojedynczaOcena.ocena}</td>
	                                    				<c:set var="sredniaOcen" value="${sredniaOcen+3*pojedynczaOcena.ocena}" />
	                                    				<c:set var="wagaOcen" value="${wagaOcen+3}" />
	                                    				<c:set var="iloscKolumn" value="${iloscKolumn+1}" />
	                                    			</c:if>
	                                    		</c:forEach>
	                                    		<c:forEach begin="${iloscKolumn}" end="${liczbaOcenWag3}">
				                           			<td> </td>
				                           		</c:forEach>
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
	                                    </c:forEach>
										
	        
                    			</table>
	                    	</c:if>
	                    		
	                    </c:when>
	                    <c:when test="${wybor=='czynnosci zwiazane z podgladaniem frekfencji'}">
	                    	dupa2
	                    </c:when>
                   	</c:choose>                              
                 
                        
    </div>
 <!--End Main Content-->
