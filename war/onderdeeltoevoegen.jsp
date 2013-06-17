<%
if(null == session.getAttribute("loggedIn")){
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
	<h1>Monteur Toevoegen</h1>
	<% Object msgToe = request.getAttribute("msgToe"); if (msgToe != null) { out.println(msgToe); } %>
    <form method="post" action="OnderdeelToevoegenServlet.do">
          <div style="float: left; width: 220px;">   
                <input class="form_input" type="text" name="naam" id="voornaam" placeholder="Naam" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_input" type="text" name="prijsperstuk" id="achternaam" placeholder="Prijs per stuk" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_input" type="text" name="aantalopvoorraad" id="pcode" placeholder="Aantal op Voorraad" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_submit" type="submit" name="submit" id="submit" value="Toevoegen" onblur="onBlur(this)" onfocus="onFocus(this)" />
				
          </div>
        
    </form>
</div>   

</body>
</html>
