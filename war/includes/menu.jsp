<%@ page import="com.xtotalloss.atdweb.model.*"%>
<%
	Object object = session.getAttribute("gebruikerObject");
	if(object instanceof Klant){
		Klant gebruiker = (Klant)object;
%>
<ul id="nav">
	<li><a href="#" class="button" style="background-image: url(images/icons/cog.fw.png);">Algemeen</a>
		<ul>
			<li><a href="account.jsp">Mijn account</a></li>
			<li><a href="logoutController.do">Uitloggen</a></li>
		</ul></li>
		<li><a href="#" class="button" style="background-image: url(images/icons/tool.fw.png);">Klussen</a>
		<ul>
			<li><a href="weekagenda.jsp">Weekagenda</a></li>
			<li><a href="klusinplannen.jsp">Klus inplannen</a></li>
		</ul></li>
		<li><a href="parkeergarage.jsp" class="button" style="background-image: url(images/icons/parking.fw.png);">Parkeergarage</a></li>
</ul>
<div id="top-header-info">
	Ingelogd als <a href="account.jsp"><%=gebruiker.getGebruikersnaam()%></a>
</div>
<%	}
	if(object instanceof Monteur){
		Monteur gebruiker = (Monteur)object;
		%>
		<ul id="nav">
	<li><a href="#" class="button" style="background-image: url(images/icons/cog.fw.png);">Algemeen</a>
		<ul>
			<li><a href="account.jsp">Mijn account</a></li>
			<li><a href="logoutController.do">Uitloggen</a></li>
		</ul></li>
		<li><a href="#" class="button" style="background-image: url(images/icons/tool.fw.png);">Klussen</a>
		<ul>
			<li><a href="klusoverzicht.jsp">Klus overzicht</a></li>
		</ul></li>
		<li><a href="#" class="button" style="background-image: url(images/icons/truck.fw.png);">Voorraad</a>
		<ul>
			<li><a href="onderdeeltoevoegen.jsp">Toevoegen</a></li>
		</ul></li>
		<li><a href="#" class="button" style="background-image: url(images/icons/balance.fw.png);">Financieel</a>
		<ul>
			<li><a href="factuuropmaken.jsp">Factuuropmaken</a></li>
		</ul></li>
		<li><a href="parkeergarage.jsp" class="button" style="background-image: url(images/icons/parking.fw.png);">Parkeergarage</a></li>
</ul>
<div id="top-header-info">
	Ingelogd als <a href="account.jsp"><%=gebruiker.getGebruikersnaam()%></a>
</div>
<%	}
%>
<!-- <ul id="nav">
	<li><a href="#" class="button" style="background-image: url(images/icons/cog.fw.png);">Algemeen</a>
		<ul>
			<li><a href="account.jsp">Mijn account</a></li>
			<li><a href="logoutController.do">Uitloggen</a></li>
		</ul></li>
	<li><a href="klanten.jsp" class="button" style="background-image: url(images/icons/user.fw.png);">Klanten</a></li>
	<li><a href="#" class="button" style="background-image: url(images/icons/truck.fw.png);">Voorraad</a>
		<ul>
			<li><a href="voorraad.jsp">Overzicht</a></li>
			<li><a href="onderdeeltoevoegen.jsp">Toevoegen</a></li>
		</ul></li>
	<li><a href="#" class="button" style="background-image: url(images/icons/tool.fw.png);">Klussen</a>
		<ul>
			<li><a href="weekagenda.jsp">Weekagenda</a></li>
			<li><a href="klusinplannen.jsp">Klus inplannen</a></li>
			<li><a href="klusoverzicht.jsp">Klus overzicht</a></li>
		</ul></li>
	<li><a href="#" class="button" style="background-image: url(images/icons/tool.fw.png);">Monteur</a>
		<ul>
			<li><a href="monteurtoevoegen.jsp">Toevoegen</a></li>
			<li><a href="monteurzoeken.jsp">Aanpassen</a></li>
		</ul></li>
	<li><a href="#" class="button" style="background-image: url(images/icons/balance.fw.png);">Financieel</a>
		<ul>
			<li><a href="financieel.jsp">Financieeloverzicht</a></li>
			<li><a href="factuuropmaken.jsp">Factuuropmaken</a></li>
		</ul></li>
	<li><a href="parkeergarage.jsp" class="button" style="background-image: url(images/icons/parking.fw.png);">Parkeergarage</a></li>
</ul>

<div id="top-header-info">
	Ingelogd als <a href="account.jsp">%=gebruiker.getGebruikersnaam()%></a>
</div> -->
