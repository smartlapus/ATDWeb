package com.xtotalloss.atdweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.model.Admin;
import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Klant;
import com.xtotalloss.atdweb.model.Monteur;

public class loginController extends HttpServlet {
	private static final long serialVersionUID = 5979843064772262161L;

	private Bedrijf ATD;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;

		ATD = (Bedrijf) req.getServletContext().getAttribute("ATDWeb_Object");
		Klant klant; // rename
		Monteur monteur; // rename
		Admin admin;

		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String wachtwoord = req.getParameter("wachtwoord");
		String naam = req.getParameter("naam");
		String tel = req.getParameter("tel");
		String adres = req.getParameter("adres");
		String email = req.getParameter("email");

		klant = doLoginKlant(gebruikersnaam, wachtwoord);
		monteur = doLoginMonteur(gebruikersnaam, wachtwoord);
		admin = doLoginAdmin(gebruikersnaam, wachtwoord);

		if (klant != null) {
			req.getSession().setAttribute("gebruikerObject", klant);
			System.out.println("### loginController.java -- " + klant);
			req.getSession().setAttribute("loggedIn", gebruikersnaam);
			rd = req.getRequestDispatcher("account.jsp");
			resp.addCookie(new Cookie("gebruikersCookie", gebruikersnaam));
		}// else {
//			rd = req.getRequestDispatcher("index.jsp");
//			req.setAttribute("msgLog","<div class='nosucces'>Gebruikersnaam en wachtwoord combinatie incorrect.</div>");
//		}
		
		if (admin != null) {
			req.getSession().setAttribute("gebruikerObject", admin);
			System.out.println("### loginController.java -- " + admin);
			req.getSession().setAttribute("loggedIn", gebruikersnaam);
			rd = req.getRequestDispatcher("account.jsp");
			resp.addCookie(new Cookie("gebruikersCookie", gebruikersnaam));
		}// else {
//			rd = req.getRequestDispatcher("index.jsp");
//			req.setAttribute("msgLog","<div class='nosucces'>Gebruikersnaam en wachtwoord combinatie incorrect.</div>");
//		}
		
		if (monteur != null) {
			req.getSession().setAttribute("gebruikerObject", monteur);
			System.out.println("### loginController.java -- " + monteur);
			req.getSession().setAttribute("loggedIn", gebruikersnaam);
			rd = req.getRequestDispatcher("account.jsp");
			resp.addCookie(new Cookie("gebruikersCookie", gebruikersnaam));
		} else {
			rd = req.getRequestDispatcher("index.jsp");
			req.setAttribute("msgLog","<div class='nosucces'>Gebruikersnaam en wachtwoord combinatie incorrect.</div>");
		}

		rd.forward(req, resp);
	}

	private Klant doLoginKlant(String gebr, String ww) {

		for (Klant k : ATD.alleKlanten) {
			if (k.getGebruikersnaam().equals(gebr)
					&& k.getWachtwoord().equals(ww)) {
				return k;
			}
		}
		return null;
	}

	private Monteur doLoginMonteur(String gebr, String ww) {

		for (Monteur m : ATD.alleMonteurs) {
			if (m.getGebruikersnaam().equals(gebr)&& m.getWachtwoord().equals(ww)) {
				return m;
			}
		}
		return null;
	}
	
	private Admin doLoginAdmin(String gebr, String ww) {

		for (Admin m : ATD.alleAdmins) {
			if (m.getGebruikersnaam().equals(gebr)&& m.getPassword().equals(ww)) {
				return m;
			}
		}
		return null;
	}
}