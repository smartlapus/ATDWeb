package com.xtotalloss.atdweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.exceptions.InvalidUserException;
import com.xtotalloss.atdweb.listeners.MyServletContextListener;
import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Klant;
import com.xtotalloss.atdweb.model.Monteur;

public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1911902193740282162L;


	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		Bedrijf ATD = (Bedrijf) req.getServletContext().getAttribute("ATDWeb_Object");

		String naam = req.getParameter("naam");
		String tel = req.getParameter("tel");
		String adres = req.getParameter("adres");
		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String wachtwoord = req.getParameter("wachtwoord");
		String email = req.getParameter("email");
		Klant k = null;
			
			try {
				k = new Klant(naam, adres, gebruikersnaam, wachtwoord, email,tel);
				ATD.voegKlantToe(k);
				req.setAttribute("msgRegSuccess","<div class='succes'>Account geregisteerd: " + k.getGebruikersnaam() + "</div>");
				System.out.println("### registerController.java -- User succesfully added");
			} catch (InvalidUserException e) {
			req.setAttribute("msgReg", e.getMessage());
			}
			
			rd = req.getRequestDispatcher("index.jsp");
		
		rd.forward(req, resp);
	}

}