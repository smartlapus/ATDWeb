<%
if(null == session.getAttribute("loggedIn")){
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
    	<%@include file="includes/menu.jsp" %>
    </div>
</div>

<div id="header">
	<%@include file="includes/header.jsp" %>
</div>
      
<div id="content" class="shadow rounded">
	<h1>Monteur Toevoegen</h1>
	<% Object msgToe = request.getAttribute("msgToe"); if (msgToe != null) { out.println(msgToe); } %>
    <form method="post" action="MonteurToevoegen.do">
          <div style="float: left; width: 220px;">   
                <input class="form_input" type="text" name="voornaam" id="voornaam" placeholder="Voornaam" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_input" type="text" name="achternaam" id="achternaam" placeholder="Achternaam" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_input" type="text" name="postcode" id="pcode" placeholder="Postcode" onblur="onBlur(this)" onfocus="onFocus(this)" />
				<input class="form_input" type="text" name="huisnr" id="huis" placeholder="Huisnr" onblur="onBlur(this)" onfocus="onFocus(this)" />
				<input class="form_input" type="text" name="plaats" id="plaats" placeholder="Plaats" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_input" type="text" name="email" id="mail" placeholder="Email" onblur="onBlur(this)" onfocus="onFocus(this)" />
          </div>
          <div style="float: left; width: 220px;">
                <input class="form_input" type="text" name="telnr" id="telnr" placeholder="Telefoonnummer" onblur="onBlur(this)" onfocus="onFocus(this)" />
				<input class="form_input" type="text" name="bsnnr" id="bsn" placeholder="Burger Service Nummer" onblur="onBlur(this)" onfocus="onFocus(this)" />
				<input class="form_input" type="text" name="rekeningnr" id="reknr" placeholder="Rekening Nummer" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_input" type="text" name="gebruikersnaam" id="gebnaam" placeholder="Gebruikersnaam" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_input" type="password" name="password" id="password" placeholder="Wachtwoord" onblur="onBlur(this)" onfocus="onFocus(this)" />	
    			<input class="form_submit" type="submit" name="submit" id="submit" value="Aanpassen" onblur="onBlur(this)" onfocus="onFocus(this)" />
    	</div>
    	<div style="float: left; width: 220px;">
    	<h3>Wachtwoord resetten</h3>
    	  <input class="form_input" type="password" name="password" id="password" placeholder="Wachtwoord" onblur="onBlur(this)" onfocus="onFocus(this)" />
    	    <input class="form_input" type="password" name="password" id="password" placeholder="Wachtwoord" onblur="onBlur(this)" onfocus="onFocus(this)" />
   		</div>
    </form>
</div>   

</body>
</html>
