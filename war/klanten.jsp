<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	if (null == session.getAttribute("gebruikerObject")) {
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
		<h1>Klanten</h1>
		<div class="table">
			
			<div class="table-row">
					<div class="table-column">
						<b>Naam</b>
					</div>
					<div class="table-column">
						<b>Adres</b>
					</div>
					<div class="table-column">
						<b>Telefoonnummer</b>
					</div>
					<div class="table-column">
						<b>Email</b>
					</div>
					<div class="table-column"></div>
				</div>
			
			<div class="table-row">
				<c:forEach var="klant" items="${ applicationScope.ATDWeb_Object.alleKlanten }">
				<div class="table-column">${ klant.naam }</div>
				<div class="table-column">${ klant.adres }</div>
				<div class="table-column">${ klant.telefoonnummer }</div>
				<div class="table-column">${ klant.email }</div>
					</c:forEach>

			</div>
		</div>



			
	</div>
	
</body>
</html>
