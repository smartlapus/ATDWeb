package com.xtotalloss.atdweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.exceptions.OngeldigeMonteurException;
import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Monteur;

public class MonteurToevoegen extends HttpServlet {
	private static final long serialVersionUID = -162531052446206437L;

	private Bedrijf ATD;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;

		ATD = (Bedrijf) req.getServletContext().getAttribute("ATDWeb_Object");
		rd = req.getRequestDispatcher("monteurzoeken.jsp");

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
		System.out.println("### MonteurToevoegen.java -- DEBUG: VOOR IF");

		try {
			Monteur m2 = new Monteur(first, last, pcode, huisnr, plaats, mail, telnr, bsn, reknr, gebruikersnaam, pass);
			Boolean bestaatAl = false;

			for (Monteur monteur : ATD.alleMonteurs) {
				if (m2.getGebruikersnaam().equals(monteur.getGebruikersnaam())) {
					req.setAttribute("msgToe", "Gebruikersnaam bestaat al");
					bestaatAl = true;
				}
			}

			if (!bestaatAl) {
				ATD.voegMonteurToe(m2);
				req.setAttribute("msgToe", "Monteur toegevoegd");
			}
			else{
				req.setAttribute("msgToe", "Gebruikersnaam bestaat al");
				rd = req.getRequestDispatcher("monteurtoevoegen.jsp");
			}

		} catch (OngeldigeMonteurException e) {
			rd = req.getRequestDispatcher("monteurtoevoegen.jsp");
			req.setAttribute("msgToe", e.getMessage());
		}

		rd.forward(req, resp);

	}

}
