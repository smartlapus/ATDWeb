<%@ page import="java.util.ArrayList" %>
		<%@ page import="com.xtotalloss.atdweb.model.*" %>
<%
	if (null == session.getAttribute("gebruikerObject")) {
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
		<h1>Monteur Overzicht</h1>
		<% Object msgToe = request.getAttribute("msgToe"); if (msgToe != null) { out.println("<div class=\"succes\">" + msgToe + "</div>"); } %>
		<form action="MonteurZoekenServlet.do" method="get" >
			 <div style="float: center; width: 220px;">  
				<select name="dropdown">
					<%
						Bedrijf atd = (Bedrijf)request.getServletContext().getAttribute("ATDWeb_Object");
						System.out.println(atd.alleMonteurs);
						for (Monteur m : atd.alleMonteurs) {
							out.println("<option value=\"" + m.toString() + "\">" +m.toString()+ "</option>");
						}
					%>
				</select>	<br />
    			<input class="form_submit" type="submit" name="submit" id="submit" value="Zoeken" onblur="onBlur(this)" onfocus="onFocus(this)" />		
			</div>
		</form>
	</div>
</body>
</html>