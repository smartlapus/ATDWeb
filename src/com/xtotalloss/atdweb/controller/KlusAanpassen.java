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

public class KlusAanpassen extends HttpServlet {
	private static final long serialVersionUID = 6787392421160231316L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Bedrijf atd = (Bedrijf) req.getServletContext().getAttribute("ATD_Object");
		RequestDispatcher rd;
		ArrayList<Klus> klussen = (ArrayList<Klus>) atd.alleKlussen;
		System.out.println("Klusatt: "+ klussen);
		req.setAttribute("kluslijst", klussen);
		
		rd = req.getRequestDispatcher("klusaanpassen.jsp");
		
		rd.forward(req, resp);
	}
	
}
