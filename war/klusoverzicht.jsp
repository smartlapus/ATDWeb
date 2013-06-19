<%
if (null == session.getAttribute("loggedIn")) {
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
			<%@include file="includes/menu.jsp"%>
		</div>
	</div>

	<div id="header">
		<%@include file="includes/header.jsp"%>
	</div>

	<div id="content" class="shadow rounded">
		<h1>Klus overzicht</h1>
		
		<%@ page import="java.util.ArrayList"%>
		<%@ page import="com.xtotalloss.atdweb.model.Klus"%>
		<form method="post" action="KlusAanpassen.do">
			<div id="table">
			<div class="table-row">
				<div class="table-column" style="width: 25%;"><b>Naam</b></div>
				<div class="table-column" style="width: 25%;"><b>Werkzaamheden</b></div>
				<div class="table-column" style="width: 25%;"><b>Kenteken</b></div>
				<div class="table-column" style="width: 25%;"><b>Datum</b></div>
			</div>
				<div class="table-row">
				<%
				ArrayList<Klus> alleKlussen = (ArrayList<Klus>) request.getServletContext().getAttribute("kluslijst");
				System.out.println(alleKlussen);
				for (Klus kl : alleKlussen) {
				%>
					<div class="table-column" style="width: 20%;"><% out.println(kl.getNaam()); %></div>
					<div class="table-column" style="width: 20%;"><% out.println(kl.getWerkzaamheden()); %></div>
					<div class="table-column" style="width: 20%;"><% out.println(kl.getKenteken()); %></div>
					<div class="table-column" style="width: 20%;"><% out.println(kl.getDatum()); %></div>
					<input class="table-column" type="submit" style="width: 20%;" name="submit" id="submit" value="Klus aanpassen" />
				<%}%>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
