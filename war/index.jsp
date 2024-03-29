<%
if(null != session.getAttribute("gebruikerObject")){
	RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
	rd.forward(request, response);
	return;
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/form.css" type="text/css" />
<title>ATD Portal</title>
<script type="text/javascript" src="javascript/jquery.min.js"></script>
<script type="text/javascript" src="javascript/functions.js"></script>
</head>

<body>
<div id="header">
	<%@include file="includes/header.jsp" %>
</div>

<div id="image-slider" class="shadow rounded">
	<div id="image-slider-container">
		<img src="images/imageslider/img1.jpg" class="active rounded" />
        <img src="images/imageslider/img2.jpg" class="rounded" />
    </div>
</div>
      
<div id="content"> 
    <div id="content-left" class="shadow rounded">
    	<div class="content-title" style="background-color: #0085B2;">Bestaande klant?<img src="images/arrow-tip.fw.png" /></div>
       	<div class="content-container" style="width: 210px;">
       		<% Object msgLog = request.getAttribute("msgLog"); if (msgLog != null) { out.println(msgLog); } %>
        	<form method="post" action="loginController.do">
                <input class="form_input" type="text" name="gebruikersnaam" id="gebruikersnaam" placeholder="Gebruikersnaam..." value="${cookie.gebruikersCookie.value}" />
                <input class="form_input" type="password" name="wachtwoord" id="wachtwoord" placeholder="Wachtwoord..." />
                <input class="form_submit" type="submit" name="submit" id="submit" value="Inloggen" />
            </form>
        </div>
    </div>  
	<div id="content-right" class="shadow rounded">
    	<div class="content-title" style="background-color: #FF8000">Nog geen account?<img src="images/arrow-tip.fw.png" /></div>
        <div class="content-container" style="width: 440px;">
        	<% Object msgReg = request.getAttribute("msgReg"); if (msgReg != null) { out.println("<div class=\"nosucces\">" + msgReg+ "</div>"); } %>
        	<% Object msgRegSuccess = request.getAttribute("msgRegSuccess"); if (msgRegSuccess != null) { out.println(msgRegSuccess); } %>
        	<form method="post" action="registerController.do">
                <div style="float: left; width: 210px;">   
                    <input class="form_input" type="text" name="naam" id="naam" placeholder="Voor- en achternaam..." onblur="onBlur(this)" onfocus="onFocus(this)" value="${param.naam}" />
                    <input class="form_input" type="text" name="tel" id="tel" placeholder="Telefoonnummer..." onblur="onBlur(this)" onfocus="onFocus(this)" value="${param.tel}" />
                    <input class="form_input" type="text" name="adres" id="adres" placeholder="Adres + huisnummer..." onblur="onBlur(this)" onfocus="onFocus(this)" value="${param.adres}" />
                </div> 
                <div style="float: right; width: 210px;">   
                    <input class="form_input" type="text" name="gebruikersnaam" id="gebruikersnaam" placeholder="Gebruikersnaam..." onblur="onBlur(this)" onfocus="onFocus(this)" value="${param.gebruikersnaam}" />
                    <input class="form_input" type="password" name="wachtwoord" id="wachtwoord" placeholder="Wachtwoord..." onblur="onBlur(this)" onfocus="onFocus(this)" />
                    <input class="form_input" type="text" name="email" id="email" placeholder="Email adres..." onblur="onBlur(this)" onfocus="onFocus(this)" value="${param.email}" />
                </div> 
                <input class="form_submit" type="submit" name="submit" id="submit" value="Registreren" />
            </form>
        </div>
    </div>   
</div>
</body>
</html>
