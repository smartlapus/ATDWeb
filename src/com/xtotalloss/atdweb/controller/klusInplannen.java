package com.xtotalloss.atdweb.controller;

import java.io.IOException;
import java.util.UUID;
import java.util.Calendar;

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

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd;

		Bedrijf ATD = (Bedrijf) req.getServletContext().getAttribute("ATDWeb_Object");

		

		String naam = req.getParameter("naam");
		String werkzaamheden = req.getParameter("werkzaamheden");
		String kenteken = req.getParameter("kent");

		Calendar datum = Calendar.getInstance();
		int dag = 0, maand = 0, jaar = 0;
		UUID uniqueID = UUID.randomUUID();
		Klus kl = null;

		try {
			
			dag = Integer.parseInt(req.getParameter("dag"));
			maand = Integer.parseInt(req.getParameter("maand"));
			jaar = Integer.parseInt(req.getParameter("jaar"));

			datum.set(jaar, maand - 1, dag);
			kl = new Klus(uniqueID, naam, werkzaamheden, kenteken, datum);
			ATD.voegKlusToe(kl);
			req.setAttribute("msgKlusSucces", "<div class='succes'>Klus " + kl.getNaam() + " met werkzaamheden " + kl.getWerkzaamheden() + " is toegevoegd.</div>");
			System.out.println("### klusInplannen.java -- Klus succesfully added");
		} catch (NumberFormatException | OngeldigeKlusException Exception) {
			req.setAttribute("msgKlus", "Ongeldige datum");
			rd = req.getRequestDispatcher("klusinplannen.jsp");
	
		}

		System.out.println("### klusInplannen.java -- DEBUG: IN IF");
		System.out.println("### klusInplannen.java -- " + ATD.alleKlussen);
		rd = req.getRequestDispatcher("klusinplannen.jsp");
		rd.forward(req, resp);

	}
}
