package com.xtotalloss.atdweb.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registerController extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		RequestDispatcher rd;
		String naam = req.getParameter("naam");
		String tel = req.getParameter("tel");
		String adres = req.getParameter("adres");
		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String wachtwoord	= req.getParameter("wachtwoord");
		String email = req.getParameter("email");
				
		if (("".equals(naam) || "".equals(tel) || "".equals(adres) || "".equals(gebruikersnaam) || "".equals(wachtwoord) || "".equals(email))) {
			rd = req.getRequestDispatcher("index.jsp");
			req.setAttribute("msgReg", "<div class='nosucces'>U heeft niet alle velden ingevuld.</div>");
		} else {
			//Klant k = new Klant(naam, tel, adres, gebruikersnaam, wachtwoord, email);
			//hetBedrijf.voegKlantToe(k);
			rd = req.getRequestDispatcher("index.jsp");
			req.setAttribute("msgReg", "<div class='succes'>Account geregisteerd: + k + </div>");
		}

		rd.forward(req, resp);
	}
}