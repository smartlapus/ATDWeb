package com.xtotalloss.atdweb.controller;
import com.xtotalloss.atdweb.model.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MonteurToevoegen extends HttpServlet {
	private Bedrijf hetBedrijf = new Bedrijf("ATDWeb", "Utrecht");

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd;
		boolean monsucces = true;
		Monteur dummy = new Monteur("dummy","dummy","1","1","1","1","1","1","1","1","1");
		hetBedrijf.voegMonteurToe(dummy);
		String first = req.getParameter("voornaam");
		String last = req.getParameter("achternaam");
		String pcode = req.getParameter("postcode");
		String huisnr = req.getParameter("huisnr");
		String plaats = req.getParameter("plaats");
		String mail = req.getParameter("email");
		String telnr = req.getParameter("telnr");
		String bsn = req.getParameter("bsnnr");
		String reknr = req.getParameter("rekeningnr");
		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String pass = req.getParameter("password");
		System.out.println("DEBUG: VOOR IF");
		
		for(Monteur m : hetBedrijf.alleMonteurs){
			if(m.getGebruikersnaam().equals(gebruikersnaam)){
				System.out.println("DEBUG: IN ELSE");
				rd = req.getRequestDispatcher("monteurtoevoegen.jsp");
				req.setAttribute("msgToe", "<div class='succes'>De gebruikersnaam bestaat al.</div>");
				rd.forward(req, resp);
				monsucces = false;
				break;
			}
			}
			
			if(monsucces == true){
				Monteur m2 = null;
				m2 = new Monteur(first,last,pcode,huisnr,plaats,mail,telnr,bsn,reknr,gebruikersnaam,pass);
				hetBedrijf.voegMonteurToe(m2);
				System.out.println("DEBUG: IN IF");
				System.out.println(hetBedrijf.alleMonteurs);
				rd = req.getRequestDispatcher("monteurtoevoegen.jsp");
				req.setAttribute("msgToe", "<div class='succes'>Account geregisteerd:" + m2 + "</div>");
				rd.forward(req, resp);
				
			}
			
		}
	}
	

