package com.xtotalloss.atdweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.listeners.MyServletContextListener;
import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Klant;

public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1911902193740282162L;
	private Bedrijf ATD = MyServletContextListener.ATD;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		RequestDispatcher rd;
		boolean registerSucces;
		
		String naam = req.getParameter("naam");
		String tel = req.getParameter("tel");
		String adres = req.getParameter("adres");
		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String wachtwoord	= req.getParameter("wachtwoord");
		String email = req.getParameter("email");
		registerSucces = doRegister(naam, adres, gebruikersnaam, wachtwoord, email, tel); 
			
		if(registerSucces) {
			Klant k = new Klant(naam, adres, gebruikersnaam, wachtwoord, email, tel);
			ATD.voegKlantToe(k);
			req.setAttribute("msgReg", "<div class='succes'>Account geregisteerd:" + k.getGebruikersnaam() + "</div>");
			rd = req.getRequestDispatcher("index.jsp");
		} else {
			req.setAttribute("msgReg", "<div class='nosucces'>U heeft niet alle velden ingevuld.</div>");
			rd = req.getRequestDispatcher("index.jsp");
		}
		
		rd.forward(req, resp);
	}
	
	private boolean doRegister(String nm, String ad, String gebr, String ww, String em, String tel) {
		boolean registerSucces = false;
		if(!nm.equals("") && !ad.equals("") && !gebr.equals("") && !ww.equals("") && !em.equals("") && !tel.equals("")) {
			registerSucces = true;
		}
		return registerSucces;
	}
}