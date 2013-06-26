package com.xtotalloss.atdweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Klus;

public class KlusVerwijderen extends HttpServlet {
	private static final long serialVersionUID = -6497873098880191026L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Bedrijf atd = (Bedrijf) req.getServletContext().getAttribute("ATDWeb_Object");
		Klus kl = (Klus) getServletContext().getAttribute("klusaanpassen");
		RequestDispatcher rd = req.getRequestDispatcher("klusoverzicht.jsp");
		
		atd.alleKlussen.remove(kl);

		req.setAttribute("msgKlusSuccess", "Klus succesvol verwijderd");
		rd.forward(req, resp);
	}
}
