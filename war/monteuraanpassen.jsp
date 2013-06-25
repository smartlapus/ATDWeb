
<%
	if (null == session.getAttribute("gebruikerObject")) {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
		<%@ page import="java.util.ArrayList"%>
		<%@ page import="com.xtotalloss.atdweb.model.*"%>
		<form action="MonteurOverzichtServlet.do" method="get">
			<%
				Monteur m = (Monteur) getServletContext().getAttribute("gezochtemonteur");
			%>
			<div style="float: left; width: 220px;">
				<input class="form_input" type="text" name="voornaam" id="voornaam"
					value="<%out.println(m.getVoornaam());%>" onblur="onBlur(this)"
					onfocus="onFocus(this)" /> <input class="form_input" type="text"
					name="achternaam" id="achternaam"
					value="<%out.println(m.getAchternaam());%>" onblur="onBlur(this)"
					onfocus="onFocus(this)" /> <input class="form_input" type="text"
					name="postcode" id="pcode"
					value="<%out.println(m.getPostcode());%>" onblur="onBlur(this)"
					onfocus="onFocus(this)" /> <input class="form_input" type="text"
					name="huisnr" id="huis" value="<%out.println(m.getHuisnr());%>"
					onblur="onBlur(this)" onfocus="onFocus(this)" /> <input
					class="form_input" type="text" name="plaats" id="plaats"
					value="<%out.println(m.getPlaats());%>" onblur="onBlur(this)"
					onfocus="onFocus(this)" /> <input class="form_input" type="text"
					name="email" id="mail" value="<%out.println(m.getEmail());%>"
					onblur="onBlur(this)" onfocus="onFocus(this)" />
			</div>
			<div style="float: left; width: 220px;">
				<input class="form_input" type="text" name="telnr" id="telnr"
					value="<%out.println(m.getTelnummer());%>" onblur="onBlur(this)"
					onfocus="onFocus(this)" /> <input class="form_input" type="text"
					name="bsnnr" id="bsn" value="<%out.println(m.getBsnnr());%>"
					onblur="onBlur(this)" onfocus="onFocus(this)" /> <input
					class="form_input" type="text" name="rekeningnr" id="reknr"
					value="<%out.println(m.getReknummer());%>" onblur="onBlur(this)"
					onfocus="onFocus(this)" /> <input class="form_input" type="text"
					name="gebruikersnaam" id="gebnaam"
					value="<%out.println(m.getGebruikersnaam());%>"
					onblur="onBlur(this)" onfocus="onFocus(this)" /> <input
					class="form_submit" type="submit" name="submit" id="submit"
					value="Pas aan" onblur="onBlur(this)" onfocus="onFocus(this)" />

			</div>
		</form>
	</div>
</body>
</html>
