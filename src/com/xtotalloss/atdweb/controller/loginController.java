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
		Klant klant; // rename
		
		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String wachtwoord = req.getParameter("wachtwoord");
		String naam = req.getParameter("naam");
		String tel = req.getParameter("tel");
		String adres = req.getParameter("adres");
		String email = req.getParameter("email");
		
		
		
		klant = doLogin(gebruikersnaam, wachtwoord); 
		
		if(klant != null) {
			
			req.getSession().setAttribute("klantObject", klant);
			System.out.println(klant);
			
			req.getSession().setAttribute("loggedIn", gebruikersnaam);
			rd = req.getRequestDispatcher("account.jsp");
			resp.addCookie(new Cookie("gebruikersCookie", gebruikersnaam));
		} else {
			rd = req.getRequestDispatcher("index.jsp");
			req.setAttribute("msgLog", "<div class='nosucces'>Gebruikersnaam en wachtwoord combinatie incorrect.</div>");
		}
		
		rd.forward(req, resp);
	}
	
	private Klant doLogin(String gebr, String ww) {
	
		for(Klant k : ATD.alleKlanten) {
			if (k.getGebruikersnaam().equals(gebr) && k.getWachtwoord().equals(ww)) {
				return k;
			}
		}
		return null;
	}
}