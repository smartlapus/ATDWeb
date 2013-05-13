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
		<h1>Klus toevoegen</h1>
    <form method="post" action="klusinplannen.do">
          <div style="float: left; width: 210px;">   
               <input class="form_input" type="text" name="naam" id="naam" value="Naam klus..." onblur="onBlur(this)" onfocus="onFocus(this)" />
               <input class="form_input" type="text" name="werkzaamheden" id="werkzaamheden" value="Werkzaamheden..." onblur="onBlur(this)" onfocus="onFocus(this)" />
               <input class="form_input" type="text" name="kent" id="kent" value="Kenteken van auto..." onblur="onBlur(this)" onfocus="onFocus(this)" />                 <input class="form_input" type="text" name="dat" id="dat" value="Datum..." onblur="onBlur(this)" onfocus="onFocus(this)" />
               <select>
					 <option value="monteur1">monteurA</option>
				     <option value="saab">monteurB</option>
				     <option value="mercedes">monteurC</option>
		   			 <option value="audi">monteurD</option>
		 	  </select>
              </div> 
                	<input class="form_submit" type="submit" name="submit" id="submit" value="Klus toevoegen" />
	  </form>

</div>   
</body>
</html>
