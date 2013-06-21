package com.xtotalloss.atdweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Klus;

public class klusInplannen extends HttpServlet {
	private static final long serialVersionUID = 6787392421160231316L;
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd;
		
		Bedrijf ATD = (Bedrijf) req.getServletContext().getAttribute("ATDWeb_Object");

		String naam = req.getParameter("naam");
		String werkzaamheden = req.getParameter("werkzaamheden");
		String kenteken = req.getParameter("kent");
		String datum = req.getParameter("dat");
		// String monteur = req.getParameter("monteur");

		Klus kl1 = new Klus(naam, werkzaamheden, kenteken, datum);
		ATD.voegKlusToe(kl1);
		System.out.println("### klusInplannen.java -- DEBUG: IN IF");
		System.out.println("### klusInplannen.java -- " + ATD.alleKlussen);
		rd = req.getRequestDispatcher("klusinplannen.jsp");
		req.setAttribute("msgKlus", "<div class='succes'>Klus is toegevoegd:"
				+ kl1 + "</div>");
		rd.forward(req, resp);

	}
}
