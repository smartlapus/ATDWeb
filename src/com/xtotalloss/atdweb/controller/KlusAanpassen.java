package com.xtotalloss.atdweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

import com.xtotalloss.atdweb.exceptions.OngeldigeKlusException;
import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Klus;

public class KlusAanpassen extends HttpServlet {
	private static final long serialVersionUID = -6497873098880191026L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Bedrijf atd = (Bedrijf) req.getServletContext().getAttribute("ATDWeb_Object");
		String naam = req.getParameter("naam");
		String werkzaamheden = req.getParameter("werkzaamheden");
		String kenteken = req.getParameter("kenteken");
		String datum = req.getParameter("datum");

		Klus kl = (Klus) getServletContext().getAttribute("klusaanpassen");
		try {
			kl.setNaam(naam);
		} catch (OngeldigeKlusException e) {
			e.printStackTrace();
		}
		try {
			kl.setWerkzaamheden(werkzaamheden);
		} catch (OngeldigeKlusException e) {
			e.printStackTrace();
		}
		try {
			kl.setKenteken(kenteken);
		} catch (OngeldigeKlusException e) {
			e.printStackTrace();
		}
		try {
			
				kl.setDatum(datum);
			
		} catch (OngeldigeKlusException e) {
			e.printStackTrace();

		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		System.out.println("### KlusAanpassenServlet -- " + kl);

		RequestDispatcher rd = req.getRequestDispatcher("klusoverzicht.jsp");
		rd.forward(req, resp);
	}
}
