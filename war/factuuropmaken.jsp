
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
    <%@ page import="java.util.ArrayList" %>
	<%@ page import="com.xtotalloss.atdweb.model.*" %>
<div id="content" class="shadow rounded">
	<h1>Factuur Opmaken</h1>
	<% Object msgToe = request.getAttribute("msgToe"); if (msgToe != null) { out.println(msgToe); } %>
    <form method="post" action="FactuurOpmakenServlet.do">
          <div style="float: left; width: 220px;">   
               <select name="dropdown">
					<%
						Bedrijf atd = (Bedrijf)request.getServletContext().getAttribute("ATD_Object");
						System.out.println(atd.alleOnderdelen);
						for (Onderdeel o : atd.alleOnderdelen) {
							out.println("<option value=\"" + o.toString() + "\">" +o.toString()+ "</option>");
						}
					%>
				</select>	<br />
                <input class="form_input" type="text" name="aantal" id="achternaam" placeholder="Aantal" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <input class="form_submit" type="submit" name="submit" id="submit" value="Toevoegen" onblur="onBlur(this)" onfocus="onFocus(this)" />
                <br />
				
          </div>
        	<div style="float: left; width: 220px;">  
        		<div style="width: 200px; height: 200px;">
                 <select name="dropdownklanten">
					<%
						System.out.println(atd.alleOnderdelen);
						for (Klant k : atd.alleKlanten) {
							out.println("<option value=\"" + k.toString() + "\">" +k.toString()+ "</option>");
						}
					%>
				</select>
      				<textarea name="Factuur" readonly style="width: 250px; height: 170px;"><% 
      				if(atd.alleGebruikteOnderdelen != null){
      				for (Onderdeel o2 : atd.alleGebruikteOnderdelen){
      					double prijs = o2.getAantalOpVoorraad() * o2.getPrijsPerStuk();
      					out.println(o2.getAantalOpVoorraad()+" x "+o2.getNaam() +"		"+prijs);
      					}
      					} else{
      					out.println("Voeg onderdelen toe");}%></textarea>
      				
        		</div>
        		<input class="form_submit" type="submit" name="submit" id="submit" value="Verstuur Factuur" onblur="onBlur(this)" onfocus="onFocus(this)" />
        	</div>
    </form>
</div>   

</body>
</html>
