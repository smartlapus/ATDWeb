package com.xtotalloss.atdweb.controller;
import com.xtotalloss.atdweb.listeners.MyServletContextListener;
import com.xtotalloss.atdweb.model.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OnderdeelToevoegenServlet extends HttpServlet {
	private static final long serialVersionUID = -162531052446206437L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		Bedrijf ATD = (Bedrijf) req.getServletContext().getAttribute("ATDWeb_Object");
		
		boolean monsucces = true;
		String first = req.getParameter("naam");
		String last = req.getParameter("prijsperstuk");
		String pcode = req.getParameter("aantalopvoorraad");
		
		double prijs = Double.parseDouble(last);
		int voorraad = Integer.parseInt(pcode);
		
		System.out.println("### OnderdeelToevoegenServlet -- DEBUG: VOOR IF");
		
		for(Onderdeel o : ATD.alleOnderdelen) {
			if(o.getNaam().equals(first)){
				rd = req.getRequestDispatcher("onderdeeltoevoegen.jsp");
				req.setAttribute("msgToe", "<div class='nosucces'>het onderdeel bestaat al.</div>");
				rd.forward(req, resp);
				monsucces = false;
				break;
			}
		}
			
		if(monsucces == true) {
			Onderdeel o2 = new Onderdeel(first, voorraad, prijs);
			ATD.voegOnderdeelToe(o2);
			System.out.println("### OnderdeelToevoegenServlet -- DEBUG: IN IF");
			System.out.println("### OnderdeelToevoegenServlet -- " + ATD.alleMonteurs);
			rd = req.getRequestDispatcher("onderdeeltoevoegen.jsp");
			req.setAttribute("msgToe", "<div class='succes'>Onderdeel Toegevoegd: " + first + "</div>");
			rd.forward(req, resp);
		}	
	}
}
	

