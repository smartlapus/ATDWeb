package com.xtotalloss.atdweb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.listeners.MyServletContextListener;
import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Monteur;

public class MonteurZoekenServlet extends HttpServlet {
	private static final long serialVersionUID = -6497873098880195026L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Bedrijf atd = (Bedrijf) req.getServletContext().getAttribute("ATDWeb_Object");
		String monteur = req.getParameter("dropdown");
		
		for (Monteur mon : atd.alleMonteurs) {
			if (mon.toString().equals(monteur)) {
				Monteur m = mon;
				getServletContext().setAttribute("gezochtemonteur", m);
			}
		}

		RequestDispatcher rd = req.getRequestDispatcher("monteuraanpassen.jsp");
		rd.forward(req, resp);
	}
}
