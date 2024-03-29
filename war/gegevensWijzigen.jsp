<%
if(null == session.getAttribute("gebruikerObject")){
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
      
<div id="content" class="shadow rounded">
	<h1>Account Wijzigen</h1>
	<form method="post" action="gegevensWijzigen.do">
	<%
	if(object instanceof Klant){
		Klant gebruiker = (Klant)object;
%>
    <div class="row">
        <div class="column-first">Naam</div><div class="column-second"> <input class="form_input" type="text" name="naam" id="naam" onblur="onBlur(this)" onfocus="onFocus(this)" value="<%out.print(gebruiker.getNaam());%>" /></div>
    </div>
    <div class="row">
        <div class="column-first">Adres</div><div class="column-second"><input class="form_input" type="text" name="adres" id="adres" onblur="onBlur(this)" onfocus="onFocus(this)" value="<%out.print(gebruiker.getAdres());%>" /></div>
    </div>
    <div class="row">
        <div class="column-first">Telefoonnummer</div><div class="column-second"><input class="form_input" type="text" name="telefoonnummer" id="telefoonnummer" onblur="onBlur(this)" onfocus="onFocus(this)" value="<%out.print(gebruiker.getTelefoonnummer());%>" /></div>
    </div>
    <div class="row">
        <div class="column-first">Gebruikersnaam</div><div class="column-second"><%out.print(gebruiker.getGebruikersnaam());%></div>
    </div>
    <div class="row">
        <div class="column-first">Email</div><div class="column-second"><input class="form_input" type="text" name="email" id="email" onblur="onBlur(this)" onfocus="onFocus(this)" value="<%out.print(gebruiker.getEmail());%>" /></div>
    </div>
    <input class="form_submit" type="submit" name="submit" id="submit" value="Gegevens Wijzigen" />
</div>   
<%} %>
</body>
</html>