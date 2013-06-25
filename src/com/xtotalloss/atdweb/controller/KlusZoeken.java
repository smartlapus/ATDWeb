package com.xtotalloss.atdweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Klus;

public class KlusZoeken extends HttpServlet {
	private static final long serialVersionUID = 6787392421160231316L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Bedrijf atd = (Bedrijf) req.getServletContext().getAttribute("ATDWeb_Object");
		RequestDispatcher rd;

		String gezochteKlus = req.getParameter("buttonID");

		for (Klus klus : atd.alleKlussen) {
			
			if (klus.getUniqueID().equals(gezochteKlus)) {
				getServletContext().setAttribute("klusaanpassen", klus);
			}
		}

		rd = req.getRequestDispatcher("klusaanpassen.jsp");

		rd.forward(req, resp);
	}

}
