package com.xtotalloss.atdweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginController extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		RequestDispatcher rd;
		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String wachtwoord = req.getParameter("wachtwoord");
				
		if (("".equals(gebruikersnaam) || "".equals(wachtwoord))) {
			rd = req.getRequestDispatcher("index.jsp");
			req.setAttribute("msgLog", "<div class='nosucces'>U heeft niet alle velden ingevuld.</div>");
		} else {
			rd = req.getRequestDispatcher("account.jsp");
			//SESSION OF COOKIE SETTEN
		}
		
		rd.forward(req, resp);
	}
}