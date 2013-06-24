<%
if(null == session.getAttribute("loggedIn")){
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	return;
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.logged.css" type="text/css" />
<link rel="stylesheet" href="css/form.css" type="text/css" />
<title>ATD Portal</title>
<script type="text/javascript" src="javascript/jquery.min.js"></script>
<script type="text/javascript" src="javascript/functions.js"></script>
</head>

<body>
<div id="top-header">
	<div id="top-header-container">
    	<%@include file="includes/menu.jsp" %>
    </div>
</div>

<div id="header">
	<%@include file="includes/header.jsp" %>
</div>
     <%
	if(object instanceof Klant){
		Klant gebruiker = (Klant)object;
%>
<div id="content" class="shadow rounded">
	<h1>Mijn Account</h1>
    <div class="row">
        <div class="column-first">Naam</div><div class="column-second"><%= gebruiker.getNaam()%></div>
    </div>
    <div class="row">
        <div class="column-first">Adres</div><div class="column-second"><%= gebruiker.getAdres()%></div>
    </div>
    <div class="row">
        <div class="column-first">Telefoonnummer</div><div class="column-second"><%= gebruiker.getTelefoonnummer()%></div>
    </div>
    <div class="row">
        <div class="column-first">Gebruikersnaam</div><div class="column-second"><%= gebruiker.getGebruikersnaam()%></div>
    </div>
    <div class="row">
        <div class="column-first">Email</div><div class="column-second"><%= gebruiker.getEmail()%></div>
    </div>
    <a href="gegevensWijzigen.jsp" class="button-black">Gegevens wijzigen</a>
</div>   
<%} 
	if(object instanceof Monteur){
		Monteur gebruiker = (Monteur)object;
%>
<div id="content" class="shadow rounded">
	<h1>Mijn Account</h1>
    <div class="row">
        <div class="column-first">Voornaam</div><div class="column-second"><%= gebruiker.getVoornaam()%></div>
    </div>
     <div class="row">
        <div class="column-first">Achternaam</div><div class="column-second"><%= gebruiker.getAchternaam()%></div>
    </div>
    <div class="row">
        <div class="column-first">Gebruikersnaam</div><div class="column-second"><%= gebruiker.getGebruikersnaam()%></div>
    </div>
    <div class="row">
        <div class="column-first">Email</div><div class="column-second"><%= gebruiker.getEmail()%></div>
    </div>
</div>   
<%} 
	if(object instanceof Admin){
		Admin gebruiker = (Admin)object;
%>
<div id="content" class="shadow rounded">
	<h1>Mijn Account</h1>
    <div class="row">
        <div class="column-first">Naam</div><div class="column-second"><%= gebruiker.getNaam()%></div>
    </div>
    <div class="row">
        <div class="column-first">Gebruikersnaam</div><div class="column-second"><%= gebruiker.getGebruikersnaam()%></div>
    </div>
</div>   
<%} %>

</body>
</html>
