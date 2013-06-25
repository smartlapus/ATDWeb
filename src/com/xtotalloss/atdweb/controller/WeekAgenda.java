package com.xtotalloss.atdweb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.exceptions.OngeldigeKlusException;
import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Klus;

public class WeekAgenda extends HttpServlet {

	private ArrayList<Klus> WeekAgendaKlussen;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		System.out.println("### WeekAgenda.java -- WeekAgenda.do executed");
		
		Bedrijf atd = (Bedrijf) req.getServletContext().getAttribute("ATDWeb_Object");
		Calendar datum = Calendar.getInstance();
		WeekAgendaKlussen = new ArrayList<Klus>();
		
		
		int deWeek = datum.get(Calendar.WEEK_OF_YEAR);
		
		for(Klus klus : atd.alleKlussen){
			if(klus.getWeek() == deWeek){
				System.out.println("Klus: " +klus);
				WeekAgendaKlussen.add(klus);
				
			}
		}
		
		
			req.getServletContext().setAttribute("WeekAgenda", WeekAgendaKlussen);
		
	
//			 UUID klusID = UUID.randomUUID();
//			try {
//				Klus klus = new Klus(klusID, "Geen klussen", "", "", datum);
//			} catch (OngeldigeKlusException e) {
//				
//				e.printStackTrace();
//			}
		
		
	
		
		rd = req.getRequestDispatcher("weekagenda.jsp");
		rd.forward(req, resp);
		
		
	}
}
