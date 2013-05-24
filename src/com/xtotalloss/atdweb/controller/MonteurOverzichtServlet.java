package com.xtotalloss.atdweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.listeners.MyServletContextListener;
import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Monteur;

public class MonteurOverzichtServlet extends HttpServlet {
	private Bedrijf ATD = MyServletContextListener.ATD;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Monteur m1 = new Monteur("Joyce", "Gadellaa", "1234FD", "12", "De Bilt", "dion@d.nl", "0623645712", "1234567890", "1234567", "Joyce01", "mypass");
		Monteur m2 = new Monteur("Robin", "Altena", "5634AD", "112", "Utrecht", "Martin@d.nl", "0612345678", "1234567890", "1234567", "Robin", "j3Qel45Ds");
		Monteur m3 = new Monteur("Victor", "Verstappen", "4561MN", "65", "Utrecht", "Jason@bricks.com", "0694769372", "1234567890", "1234567", "Stryder", "$se2!Er3se");
		ATD.voegMonteurToe(m1);
		ATD.voegMonteurToe(m3);
		ATD.voegMonteurToe(m2); 
		
		String first = req.getParameter("firstname");
		String last = req.getParameter("lastname");
		boolean searchsuccess = false;
		for(Monteur m : ATD.alleMonteurs){
			if(m.getVoornaam() == first && m.getAchternaam() == last){
				String firstname = m.getVoornaam();
				String lastname = m.getAchternaam();
				String email = m.getEmail();
				String telnummer = m.getTelnummer();
				String bsn = m.getBsnnr();
				String huisnr = m.getHuisnr();
				String plaats = m.getPlaats();
				String postcode = m.getPostcode();
				String reknr = m.getReknummer();
				searchsuccess = true;
				break;
			}
		}
			RequestDispatcher rd = null;
			if (searchsuccess)
			rd = req.getRequestDispatcher("welcomepage.jsp");
			else rd = req.getRequestDispatcher("monteuroverzicht.jsp");
			rd.forward(req, resp);
		}
		
		
		
	}

