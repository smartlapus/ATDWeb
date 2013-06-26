package com.xtotalloss.atdweb.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		Calendar datum = Calendar.getInstance();
		int dag = Integer.parseInt(req.getParameter("dag"));
		int maand = Integer.parseInt(req.getParameter("maand"));
		int jaar = Integer.parseInt(req.getParameter("jaar"));
		
		datum.set(jaar, maand - 1, dag);

		Klus kl = (Klus) getServletContext().getAttribute("klusaanpassen");
		RequestDispatcher rd = req.getRequestDispatcher("klusoverzicht.jsp");
		try {
			kl.setNaam(naam);
		} catch (OngeldigeKlusException e) {
			req.setAttribute("msgKlus", e.getMessage());
			rd = req.getRequestDispatcher("klusaanpassen.jsp");
		}
		try {
			kl.setWerkzaamheden(werkzaamheden);
		} catch (OngeldigeKlusException e) {
			req.setAttribute("msgKlus", e.getMessage());
			rd = req.getRequestDispatcher("klusaanpassen.jsp");
		}
		try {
			kl.setKenteken(kenteken);
		} catch (OngeldigeKlusException e) {
			req.setAttribute("msgKlus", e.getMessage());
			rd = req.getRequestDispatcher("klusaanpassen.jsp");
		}
		try{
			kl.pasDatumAan(dag, maand, jaar);
		}catch(OngeldigeKlusException  e){
			req.setAttribute("msgKlus", e.getMessage());
			rd = req.getRequestDispatcher("klusaanpassen.jsp");
		}
		System.out.println("### KlusAanpassenServlet -- " + kl);

		req.setAttribute("msgKlusSuccess", "Klus succesvol aangepast");
		rd.forward(req, resp);
	}
}
