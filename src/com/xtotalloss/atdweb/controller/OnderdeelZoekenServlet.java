package com.xtotalloss.atdweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Monteur;
import com.xtotalloss.atdweb.model.Onderdeel;

public class OnderdeelZoekenServlet extends HttpServlet {
	private static final long serialVersionUID = -6497873098880195026L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Bedrijf atd = (Bedrijf) req.getServletContext().getAttribute("ATDWeb_Object");
		String onderdeel = req.getParameter("dropdown");
		
		for (Onderdeel ond : atd.alleOnderdelen) {
			if (ond.toString().equals(onderdeel)) {
				Onderdeel o = ond;
				getServletContext().setAttribute("gezochtemonteur", o);
			}
		}

		RequestDispatcher rd = req.getRequestDispatcher("onderdeelaanpassen.jsp");
		rd.forward(req, resp);
	}
}
