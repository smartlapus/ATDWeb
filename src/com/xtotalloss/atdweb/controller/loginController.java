package com.xtotalloss.atdweb.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.listeners.MyServletContextListener;
import com.xtotalloss.atdweb.model.*;

public class loginController extends HttpServlet {
	private Bedrijf ATD = MyServletContextListener.ATD;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		RequestDispatcher rd;
		boolean loginSucces = false;
		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String wachtwoord = req.getParameter("wachtwoord");
		
		if ("".equals(gebruikersnaam) || "".equals(wachtwoord)) {
			loginSucces = false;
			req.setAttribute("msgLog", "<div class='nosucces'>U heeft niet alle velden ingevuld.</div>");
		} else {	
			for(Klant k : ATD.alleKlanten) {
				if (k.getGebruikersnaam().equals(gebruikersnaam) && k.getWachtwoord().equals(wachtwoord)) {
					loginSucces = true;
				}
			}
		}
		
		if(loginSucces)
			rd = req.getRequestDispatcher("account.jsp");
		else 
			rd = req.getRequestDispatcher("index.jsp");
		
		rd.forward(req, resp);
	}
}