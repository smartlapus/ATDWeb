
<%
	if (null == session.getAttribute("loggedIn")) {
		RequestDispatcher rd = request
				.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
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
		<h1>Klus aanpassen</h1>
		<h1>Klusnaam	Werkzaamheden	Kenteken	Datum</h1>
		<%@ page import="java.util.ArrayList"%>
		<%@ page import="com.xtotalloss.atdweb.model.Klus"%>
		<form method="post" action="KlusAanpassen.do">
			<%
				ArrayList<Klus> alleKlussen = (ArrayList<Klus>) request.getServletContext().getAttribute("kluslijst");
				System.out.println(alleKlussen);
				for (Klus kl : alleKlussen) {
					out.println(kl.getNaam() + " " + kl.getWerkzaamheden() + " " + kl.getKenteken() + " " + kl.getDatum()); %> <input class="" type="submit" name="submit" id="submit" value="Klus aanpassen" /><br> 
					<% }%>
		</form>
	</div>
</body>
</html>
