package com.xtotalloss.atdweb.controller;

import com.xtotalloss.atdweb.listeners.MyServletContextListener;
import com.xtotalloss.atdweb.model.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class klusInplannen extends HttpServlet {
	private static final long serialVersionUID = 6787392421160231316L;
	private Bedrijf ATD = MyServletContextListener.ATD;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd;
		boolean klustoegevoegd = true;

		Klus testklus = new Klus("APK", "Bandenspanning controleren", "94-KE-02", "03-02-2013");
		ATD.voegKlusToe(testklus);

		String naam = req.getParameter("naam");
		String werkzaamheden = req.getParameter("werkzaamheden");
		String kenteken = req.getParameter("kent");
		String datum = req.getParameter("dat");
		// String monteur = req.getParameter("monteur");

		for (Klus kl : ATD.alleKlussen) {
			if (kl.getNaam().equals(naam)) {
				System.out.println("DEBUG: IN ELSE");
				klustoegevoegd = false;
				req.setAttribute("msgKlus", "<div class='nosucces'>De klus bestaat al.</div>");
				rd = req.getRequestDispatcher("klusinplannen.jsp");
				rd.forward(req, resp);
				break;
			}
			
		}
		if (klustoegevoegd == true) {
			Klus kl1 = new Klus(naam, werkzaamheden, kenteken, datum);
			ATD.voegKlusToe(kl1);
			System.out.println("DEBUG: IN IF");
			System.out.println(ATD.alleKlussen);
			rd = req.getRequestDispatcher("klusinplannen.jsp");
			req.setAttribute("msgKlus", "<div class='succes'>Klus is toegevoegd:" + kl1 + "</div>");
			rd.forward(req, resp);
		}
	}
}
