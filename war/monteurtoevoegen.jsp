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
          <div style="float: left; width: 420px;">   
                <input class="form_input" type="text" name="voornaam" id="voornaam" value="Voornaam" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_input" type="text" name="achternaam" id="achternaam" value="Achternaam" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_input" type="text" name="postcode" id="pcode" value="Postcode" onblur="onBlur(this)" onfocus="onFocus(this)" />
				<input class="form_input" type="text" name="huisnr" id="huis" value="Huisnr" onblur="onBlur(this)" onfocus="onFocus(this)" />
				<input class="form_input" type="text" name="plaats" id="plaats" value="Plaats" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_input" type="text" name="email" id="mail" value="Email" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_input" type="text" name="telnr" id="telnr" value="Telefoonnummer" onblur="onBlur(this)" onfocus="onFocus(this)" />
				<input class="form_input" type="text" name="bsnnr" id="bsn" value="Burger Service Nummer" onblur="onBlur(this)" onfocus="onFocus(this)" />
				<input class="form_input" type="text" name="rekeningnr" id="reknr" value="Rekening Nummer" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_input" type="text" name="gebruikersnaam" id="gebnaam" value="Gebruikersnaam" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_input" type="password" name="password" id="password" value="Wachtwoord" onblur="onBlur(this)" onfocus="onFocus(this)" />	
    			<input class="form_submit" type="submit" name="submit" id="submit" value"Voeg Toe!" onblur="onBlur(this)" onfocus="onFocus(this)" />
    	</div>
    </form>
</div>   

</body>
</html>
