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
        	<form method="post" action="loginController.do">
                <input class="form_input" type="text" name="gebruikersnaam" id="gebruikersnaam" value="Gebruikersnaam..." onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_input" type="password" name="wachtwoord" id="wachtwoord" value="Wachtwoord..." onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_submit" type="submit" name="submit" id="submit" value="Inloggen" />
            </form>
        </div>
    </div>  
	<div id="content-right" class="shadow rounded">
    	<div class="content-title" style="background-color: #FF8000">Nog geen account?<img src="images/arrow-tip.fw.png" /></div>
        <div class="content-container" style="width: 440px;">
        	<form method="post" action="registerController.do">
                <div style="float: left; width: 210px;">   
                    <input class="form_input" type="text" name="naam" id="naam" value="Voor- en achternaam..." onblur="onBlur(this)" onfocus="onFocus(this)" />
                    <input class="form_input" type="text" name="tel" id="tel" value="Telefoonnummer..." onblur="onBlur(this)" onfocus="onFocus(this)" />
                    <input class="form_input" type="text" name="adres" id="adres" value="Adres + huisnummer..." onblur="onBlur(this)" onfocus="onFocus(this)" />
                </div> 
                <div style="float: right; width: 210px;">   
                    <input class="form_input" type="text" name="gebruikersnaam" id="gebruikersnaam" value="Gebruikersnaam..." onblur="onBlur(this)" onfocus="onFocus(this)" />
                    <input class="form_input" type="password" name="wachtwoord" id="wachtwoord" value="Wachtwoord..." onblur="onBlur(this)" onfocus="onFocus(this)" />
                    <input class="form_input" type="text" name="email" id="email" value="Email adres..." onblur="onBlur(this)" onfocus="onFocus(this)" />
                </div> 
                <input class="form_submit" type="submit" name="submit" id="submit" value="Registreren" />
            </form>
        </div>
    </div>   
</div>
</body>
</html>
