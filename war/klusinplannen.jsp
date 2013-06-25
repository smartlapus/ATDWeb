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
		<h1>Klus toevoegen</h1>
		<% Object msgReg = request.getAttribute("msgKlus"); if (msgReg != null) { out.println("<div class=\"nosucces\">" + msgReg+ "</div>"); } %>
        	<% Object msgRegSuccess = request.getAttribute("msgKlusSucces"); if (msgRegSuccess != null) { out.println(msgRegSuccess); } %>
    	<form method="post" action="klusInplannen.do">
          <div style="float: left; width: 210px;">   
               <input class="form_input" type="text" name="naam" id="naam" placeholder="Naam klus..."/>
               <input class="form_input" type="text" name="werkzaamheden" id="werkzaamheden" placeholder="Werkzaamheden..."/>
               <input class="form_input" type="text" name="kent" id="kent" placeholder="Kenteken van auto..."/>                 
               <input class="form_datum" type="text" name="dag" id="dag" placeholder="Dag..."/> 
               <input class="form_datum" type="text" name="maand" id="maand" placeholder="Maand..."/> 
               <input class="form_datum" type="text" name="jaar" id="dag" placeholder="Jaar..." /> 
		 	  <input class="form_submit" type="submit" name="submit" id="submit" value="Klus toevoegen" />
              </div>  	
	 	 </form>
	</div>   
</body>
</html>
