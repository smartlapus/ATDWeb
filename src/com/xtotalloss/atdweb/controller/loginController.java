package com.xtotalloss.atdweb.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.listeners.MyServletContextListener;
import com.xtotalloss.atdweb.model.*;

public class loginController extends HttpServlet {
	private static final long serialVersionUID = 5979843064772262161L;
	private Bedrijf ATD = MyServletContextListener.ATD;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		RequestDispatcher rd;
		boolean loginSucces;
		
		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String wachtwoord = req.getParameter("wachtwoord");
		loginSucces = doLogin(gebruikersnaam, wachtwoord); 
		
		if(loginSucces) {
			req.getSession().setAttribute("loggedIn", gebruikersnaam);
			rd = req.getRequestDispatcher("account.jsp");
			resp.addCookie(new Cookie("gebruikersCookie", gebruikersnaam));
		} else {
			rd = req.getRequestDispatcher("index.jsp");
			req.setAttribute("msgLog", "<div class='nosucces'>Gebruikersnaam en wachtwoord combinatie incorrect.</div>");
		}
		
		rd.forward(req, resp);
	}
	
	private boolean doLogin(String gebr, String ww) {
		boolean loginSucces = false;
		for(Klant k : ATD.alleKlanten) {
			if (k.getGebruikersnaam().equals(gebr) && k.getWachtwoord().equals(ww)) {
				loginSucces = true;
			}
		}
		return loginSucces;
	}
}