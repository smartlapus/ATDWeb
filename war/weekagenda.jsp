
<%
	if (null == session.getAttribute("loggedIn")) {
		RequestDispatcher rd = request
				.getRequestDispatcher("index.jsp");
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
<%@page import="java.util.*,java.text.*"%>
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
		<h1>Weekagenda</h1>
		<%
			// First get the month and year from the form.
			boolean yyok = false; // -1 is a valid year, use boolean
			int yy = 0, mm = 0;
			String yyString = request.getParameter("year");
			if (yyString != null && yyString.length() > 0) {
				try {
					yy = Integer.parseInt(yyString);
					yyok = true;
				} catch (NumberFormatException e) {
					out.println("Year " + yyString + " invalid");
				}
			}
			Calendar c = Calendar.getInstance();
			if (!yyok)
				yy = c.get(Calendar.YEAR);

			String mmString = request.getParameter("month");
			if (mmString == null) {
				mm = c.get(Calendar.MONTH);
			} else {
				for (int i = 0; i < maand.length; i++)
					if (maand[i].equals(mmString)) {
						mm = i;
						break;
					}
			}
		%>

		<form method=post action="weekagenda.jsp">
			Month: <select name=month>
				<%
					for (int i = 0; i < maand.length; i++) {
						if (i == mm)
							out.print("<option selected>");
						else
							out.print("<option>");
						out.print(maand[i]);
						out.println("</option>");
					}
				%>
			</select> Jaar (4 cijfers): <input type="text" size="5" name="year"
				value="<%=yy%>"></input> <input type=submit value="Weergeef">
		</form>
		<%!/** The names of the months */
	String[] maand = { "Januari", "Februari", "Maart", "April", "Mei", "Juni",
			"Juli", "Augustus", "September", "Oktober", "November", "December" };

	/** The days in each month. */
	int dom[] = { 31, 28, 31, 30, /* jan feb mar apr */
	31, 30, 31, 31, /* may jun jul aug */
	30, 31, 30, 31 /* sep oct nov dec */
	};%>

		<%
			/** The number of days to leave blank at the start of this month */
			int leadGap = 0;
		%>
		<table border=1>
			<tr>
				<th colspan=7><%=maand[mm]%> <%=yy%>
			</tr>

			<%
				GregorianCalendar calendar = new GregorianCalendar(yy, mm, 1);
			%>

			<tr>
				<td>Su
					<td>Mo
						<td>Tu
							<td>We
								<td>Th
									<td>Fr
										<td>Sa
			</tr>

			<%
				// Compute how much to leave before the first.
				// getDay(  ) returns 0 for Sunday, which is just right.
				leadGap = calendar.get(Calendar.DAY_OF_WEEK) - 1;

				int daysInMonth = dom[mm];
				if (calendar.isLeapYear(calendar.get(Calendar.YEAR)) && mm == 1)
					++daysInMonth;

				out.print("<tr>");

				// Blank out the labels before 1st day of month
				for (int i = 0; i < leadGap; i++) {
					out.print("<td>&nbsp;");
				}

				// Fill in numbers for the day of month.
				for (int i = 1; i <= daysInMonth; i++) {

					out.print("<td>");
					out.print(i);
					out.print("</td>");

					if ((leadGap + i) % 7 == 0) { // wrap if end of line.
						out.println("</tr>");
						out.print("<tr>");
					}
				}
			%>
			</tr>
		</table>
	</div>
	</div>
</body>
</html>
