package com.xtotalloss.atdweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Klant;

public class gegevensWijzigen extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Object object = req.getSession().getAttribute("gebruikerObject");
		if(object instanceof Klant){
			Klant k = (Klant)object;
		
		Bedrijf ATD = (Bedrijf) req.getServletContext().getAttribute("ATDWeb_Object");
		String naam = req.getParameter("naam");
		String adres = req.getParameter("adres");
		String telnr = req.getParameter("telefoonnummer");
		String email = req.getParameter("email");
		
		k.setNaam(naam);
		k.setAdres(adres);
		k.setTelefoonnummer(telnr);
		k.setEmail(email);
		
		RequestDispatcher rd = req.getRequestDispatcher("account.jsp");
		rd.forward(req, resp);
		}
	}
}