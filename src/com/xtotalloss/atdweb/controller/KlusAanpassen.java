package com.xtotalloss.atdweb.controller;

import com.xtotalloss.atdweb.listeners.MyServletContextListener;
import com.xtotalloss.atdweb.model.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Klus;
import com.xtotalloss.atdweb.model.Monteur;

public class KlusAanpassen extends HttpServlet {
	private static final long serialVersionUID = 6787392421160231316L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Bedrijf atd = (Bedrijf) req.getServletContext().getAttribute("ATDWeb_Object");
		RequestDispatcher rd;
		String naam = req.getParameter("naam");
		String werkzaamheden = req.getParameter("werkzaamheden");
		String kenteken = req.getParameter("kenteken");
		String datum = req.getParameter("datum");
		
//		ArrayList<Klus> klussen = (ArrayList<Klus>) atd.alleKlussen;
//		getServletContext().setAttribute("gezochtemonteur", klussen);
		
		for (Klus klussen : atd.alleKlussen) {
				getServletContext().setAttribute("klusaanpassen", klussen);
		}
		

		rd = req.getRequestDispatcher("klusaanpassen.jsp");
		
		rd.forward(req, resp);
	}
	
}
