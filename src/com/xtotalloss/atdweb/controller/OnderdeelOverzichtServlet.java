package com.xtotalloss.atdweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Onderdeel;

public class OnderdeelOverzichtServlet extends HttpServlet {
	private static final long serialVersionUID = -6497873098880191026L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Bedrijf atd = (Bedrijf) req.getServletContext().getAttribute(
				"ATD_Object");
		String first = req.getParameter("voornaam");
		String last = req.getParameter("achternaam");
		String pcode = req.getParameter("postcode");
		int aantal = Integer.parseInt(last);
		double prijs = Double.parseDouble(pcode);
		

			Onderdeel o = (Onderdeel) getServletContext().getAttribute("gezochtemonteur");
			o.setNaam(first);
			o.setAantalOpVoorraad(aantal);
			o.setPrijsPerStuk(prijs);
			
			System.out.println("### MonteurOverzichtServlet -- " + o);
		
		RequestDispatcher rd = req.getRequestDispatcher("onderdeelzoeken.jsp");
		rd.forward(req, resp);
	}
}
