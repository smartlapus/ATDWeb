<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	if (null == session.getAttribute("gebruikerObject")) {
		RequestDispatcher rd = request
				.getRequestDispatcher("index.jsp");
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
<% Object msgReg = request.getAttribute("msgKlusSuccess"); if (msgReg != null) { out.println("<div class=\"succes\">" + msgReg+ "</div>"); } %>
		<div id="table">
			<div class="table-row">
				<div class="table-column">
					<b>Naam</b>
				</div>
				<div class="table-column">
					<b>Werkzaamheden</b>
				</div>
				<div class="table-column">
					<b>Kenteken</b>
				</div>
				<div class="table-column">
					<b>Datum</b>
				</div>
				<div class="table-column"></div>
			</div>





			<c:forEach var="klus"
				items="${ applicationScope.ATDWeb_Object.alleKlussen }">
				<div class="table-row">
					<div class="table-column">
						<c:out value="${ klus.naam }" />
					</div>
					<div class="table-column">
						<c:out value="${ klus.werkzaamheden }" />
					</div>
					<div class="table-column">
						<c:out value="${ klus.kenteken }" />
					</div>
					<div class="table-column">
						<c:out value="${ klus.datum }" />
					</div>
					<div class="table-column"><a href="KlusZoeken.do?buttonID=${ klus.uniqueID }">Klus aanpassen</a></div>
				</div>
			</c:forEach>

		</div>

	</div>
</body>
</html>
