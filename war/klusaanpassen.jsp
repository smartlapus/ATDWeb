
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
		<h1>Klus aanpassen</h1>
		<%@ page import="java.util.ArrayList" %>
		<%@ page import="com.xtotalloss.atdweb.model.*" %>
		<% Object msgReg = request.getAttribute("msgKlus"); if (msgReg != null) { out.println("<div class=\"nosucces\">" + msgReg+ "</div>"); } %>
		<form action="KlusAanpassen.do" method="post" >
		<%Klus kl = (Klus)getServletContext().getAttribute("klusaanpassen"); %>
				<div style="float: left; width: 220px;">
				<input class="form_input" type="text" name="naam" id="naam" value="<%out.println(kl.getNaam());%>" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_input" type="text" name="werkzaamheden" id="werkzaamheden" value="<%out.println(kl.getWerkzaamheden());%>" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_input" type="text" name="kenteken" id="kenteken" value="<%out.println(kl.getKenteken());%>" onblur="onBlur(this)" onfocus="onFocus(this)" />
				<input class="form_datum" type="text" name="dag" id="dag" value="<%out.println(kl.getDag());%>" />
               <input class="form_datum" type="text" name="maand" id="maand" value="<%out.println(kl.getMaand());%>" />
               <input class="form_datum" type="text" name="jaar" id="jaar" value="<%out.println(kl.getJaar());%>" />
			 <input class="form_submit" type="submit" name="submit" id="submit" value="Pas aan" onblur="onBlur(this)" onfocus="onFocus(this)" />
				</div>
        </form>
        <form action="KlusVerwijderen.do" method="post" >
				 <input class="form_submit" type="submit" name="submit" id="submit" value="Verwijder klus" onblur="onBlur(this)" onfocus="onFocus(this)" />
				
        </form>
        </div>
  
</body>
</html>
