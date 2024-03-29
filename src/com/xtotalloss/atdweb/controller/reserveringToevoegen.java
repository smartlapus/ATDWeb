package com.xtotalloss.atdweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.exceptions.OngeldigeParkeergarageException;
import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Klant;
import com.xtotalloss.atdweb.model.ParkeerGarage;
import com.xtotalloss.atdweb.model.ParkeerReservering;

public class reserveringToevoegen extends HttpServlet {
	private static final long serialVersionUID = 7076611831652512670L;	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("parkeergarageGebruiker.jsp");		
		ParkeerGarage parkeerGarage = (ParkeerGarage) req.getServletContext().getAttribute("ParkeerGarage_Object");
			
		Klant deReserveerder = (Klant) req.getSession().getAttribute("gebruikerObject");
		ParkeerReservering reservering = null;
		try {
			reservering = new ParkeerReservering(deReserveerder);
		} catch (OngeldigeParkeergarageException e) {
			
			e.printStackTrace();
		}
		
		try {
			if(parkeerGarage.voegReserveringToe(reservering)) {
				System.out.print("### reserveringToevoegen.java --Reservering toegevoegd: " + reservering);
				req.setAttribute("msgPg", "<div class='succes'>U heeft een plek gereserveerd op naam: + " + deReserveerder.getNaam() + "</div>");
			} 
		
		} catch (OngeldigeParkeergarageException e) {
			req.setAttribute("msgPgFail", e.getMessage());
			System.out.println("e caught");
		}

		rd.forward(req, resp);
	}

}
