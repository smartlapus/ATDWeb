<%@ page import="com.xtotalloss.atdweb.model.ParkeerGarage"%>
<%
	if (null == session.getAttribute("gebruikerObject")) {
		RequestDispatcher rd = request
				.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		return;
	}

	ParkeerGarage pg = (ParkeerGarage) getServletContext().getAttribute("ParkeerGarage_Object");
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
			<%@include file="includes/menu.jsp"%>
		</div>
	</div>

	<div id="header">
		<%@include file="includes/header.jsp"%>
	</div>

	<div id="content" class="shadow rounded">
		<h1>Parkeergarage</h1>
		<% Object msgPg = request.getAttribute("msgPg"); if (msgPg != null) { out.println(msgPg); } %>
		Welkom bij de parkeergarage van ATD. De garage is 24/7 open en heeft ruimte voor <%= pg.getAantalPlaatsen()%> auto's. Hier kunt u een parkeerplaats gemakkelijk en snel reserveren. De reservering wordt opgeslagen op uw account.
		
	    <br /><br />
	    <div class="row">
	        <div class="column-first">Plaatsen beschikbaar</div><div class="column-second"><%=pg.getAantalPlaatsenBeschikbaar()%></div>
	    </div><br />
	    
	    <a href="reserveringToevoegen.do" class="button-black">Parkeerplaats reserveren</a>
	</div>
</body>
</html>
