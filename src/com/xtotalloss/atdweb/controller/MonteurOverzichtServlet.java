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

public class MonteurOverzichtServlet extends HttpServlet {
	private static final long serialVersionUID = -6497873098880191026L;
	//private Bedrijf atd = MyServletContextListener.ATD;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Bedrijf atd = (Bedrijf) req.getServletContext().getAttribute("ATD_Object");
		System.out.println(atd);
		ArrayList<Monteur> monteurs =(ArrayList<Monteur>) atd.alleMonteurs;
		System.out.println("Monteurattr: "+monteurs);
		req.setAttribute("monteurslijst", monteurs);
		
		
		RequestDispatcher rd = null;
		
		//rd = req.getRequestDispatcher("welcomepage.jsp");
		
		rd = req.getRequestDispatcher("monteuroverzicht.jsp");
		
		rd.forward(req, resp);
	}
}

