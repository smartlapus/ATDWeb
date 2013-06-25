<%@ page import="com.xtotalloss.atdweb.model.ParkeerGarage"%>
<%
	if (null == session.getAttribute("gebruikerObject")) {
		RequestDispatcher rd = request
				.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		return;
	}

	ParkeerGarage pg = (ParkeerGarage) getServletContext().getAttribute("ParkeerGarage_Object");
	
	if(request.getParameter("autoErbij")!=null) {
	    pg.autoErbij();
	} else if(request.getParameter("autoEraf")!=null) {
	    pg.autoEraf();
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
			<%@include file="includes/menu.jsp"%>
		</div>
	</div>

	<div id="header">
		<%@include file="includes/header.jsp"%>
	</div>

	<div id="content" class="shadow rounded">
		<h1>Parkeergarage</h1>
		<% Object msgPg = request.getAttribute("msgPg"); if (msgPg != null) { out.println(msgPg); } %>
		Welkom bij de parkeergarage van ATD.
		
	    <br /><br />
	    <div class="row">
	        <div class="column-first" style="width: 30%;">Plaatsen beschikbaar</div><div class="column-second"><%=pg.getAantalPlaatsenBeschikbaar()%></div>
	    </div>
	    <div class="row">
	        <div class="column-first" style="width: 30%;">Reservering deze maand</div><div class="column-second"><%=pg.getReserveringenDezeMaand()%></div>
	    </div>
	    <div class="row">
	        <div class="column-first" style="width: 30%;">Totaal aantal reserveringen</div><div class="column-second"><%=pg.getAlleReserveringen()%></div>
	    </div>
	    <br />
	    <form method="post" action="parkeergarageAdmin.jsp">
	    	<div style="float: right;">
		    	<input type="submit" style="margin-right: 0px;" class="form_submit" id="autoErbij" name="autoErbij" value="Auto erbij" />
		    </div>
		    <div style="float: left;">
		    	<input type="submit" class="form_submit" id="autoEraf" name="autoEraf" value="Auto eraf" />
	    	</div>
	    </form>
	</div>
</body>
</html>
