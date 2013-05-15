package com.xtotalloss.atdweb.controller;

import com.xtotalloss.atdweb.model.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class klusInplannen extends HttpServlet {
	private Bedrijf hetBedrijf = new Bedrijf("ATDWeb", "Utrecht");
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd;
		boolean klustoegevoegd = false;
		
		Klus testklus = new Klus("APK", "Bandenspanning controleren", "94-KE-02", "03-02-2013");
		hetBedrijf.voegKlusToe(testklus);
		
		String naam = req.getParameter("naam");
		String werkzaamheden = req.getParameter("werkzaamheden");
		String kenteken = req.getParameter("kent");
		String datum = req.getParameter("dat");
		String monteur = req.getParameter("monteur");
		

			for(Klus kl : hetBedrijf.alleKlussen){
				if(kl.getNaam().equals(naam)){
					System.out.println("DEBUG: IN ELSE");
					rd = req.getRequestDispatcher("klusinplannen.jsp");
					req.setAttribute("msgToe", "<div class='succes'>De klus bestaat al.</div>");
					rd.forward(req, resp);
					klustoegevoegd = false;
					break;
				}
				}
				
				if(klustoegevoegd == true){
					Klus kl1 = null;
					kl1 = new Klus(naam, werkzaamheden, kenteken, datum);
					hetBedrijf.voegKlusToe(kl1);
					System.out.println("DEBUG: IN IF");
					System.out.println(hetBedrijf.alleKlussen);
					rd = req.getRequestDispatcher("klusinplannen.jsp");
					req.setAttribute("msgToe", "<div class='succes'>Klus is toegevoegd:" + kl1 + "</div>");
					rd.forward(req, resp);
					
				}
				
			}
		}
	
		
