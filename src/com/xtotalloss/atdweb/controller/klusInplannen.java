package com.xtotalloss.atdweb.controller;

import com.xtotalloss.atdweb.model.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class klusInplannen extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	
		RequestDispatcher rd;
		String naam = req.getParameter("naam");
		String werkzaamheden = req.getParameter("werkzaamheden");
		String kenteken = req.getParameter("kent");
		String dat = req.getParameter("dat");
		String monteur = req.getParameter("monteur");
		
		if (("".equals(naam) || "".equals(werkzaamheden) || "".equals(kenteken) || "".equals(dat) ||
				"".equals(monteur))) {
			rd = req.getRequestDispatcher("index.jsp");
			req.setAttribute("msgReg", "<div class='nosucces'>U heeft niet alle velden ingevuld.</div>");
		} else {
			//(String nm, String werk, String kent, String dat)
			//hetBedrijf.voegKlusToe(kl);
			rd = req.getRequestDispatcher("index.jsp");
			req.setAttribute("msgReg", "<div class='succes'>Klus toegevoegd: + kl + </div>");
		}
		rd.forward(req, resp);
	}	
}