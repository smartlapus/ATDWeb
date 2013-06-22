package com.xtotalloss.atdweb.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.exceptions.OngeldigeKlusException;
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
		
		UUID uniqueID = UUID.randomUUID();
		// String monteur = req.getParameter("monteur");

		Klus kl = null;
		try {
			kl = new Klus(uniqueID, naam, werkzaamheden, kenteken, datum);
			ATD.voegKlusToe(kl);
			req.setAttribute("msgKlusSucces", "<div class='succes'>Klus is toegevoegd:" + kl + "</div>");
			System.out.println("### klusInplannen.java -- Klus succesfully added");
		} catch (OngeldigeKlusException OKE) {
			req.setAttribute("msgKlus", OKE.getMessage());
		}
		System.out.println("### klusInplannen.java -- DEBUG: IN IF");
		System.out.println("### klusInplannen.java -- " + ATD.alleKlussen);
		rd = req.getRequestDispatcher("klusinplannen.jsp");
		rd.forward(req, resp);

	}
}
