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

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Bedrijf atd = (Bedrijf) req.getServletContext().getAttribute(
				"ATD_Object");
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
		String pass2 = req.getParameter("password2");
		String action = req.getParameter("submit");

		if (action.equals("Pas aan")) {
			Monteur m = (Monteur) getServletContext().getAttribute(
					"gezochtemonteur");
			m.setVoornaam(first);
			m.setAchternaam(last);
			m.setPostcode(pcode);
			m.setHuisnr(huisnr);
			m.setPlaats(plaats);
			m.setEmail(mail);
			m.setTelnummer(telnr);
			m.setBsnnr(bsn);
			m.setReknummer(reknr);
			m.setGebruikersnaam(gebruikersnaam);
			System.out.println(m);
		}

		if (action.equals("Reset")) {
			Monteur m = (Monteur) getServletContext().getAttribute("gezochtemonteur");
			if (pass.equals(pass2)) {
				m.setWachtwoord(pass);
			}
		}

		RequestDispatcher rd = req.getRequestDispatcher("monteurzoeken.jsp");
		rd.forward(req, resp);
	}
}
