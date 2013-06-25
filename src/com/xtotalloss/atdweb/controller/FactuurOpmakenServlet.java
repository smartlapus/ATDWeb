package com.xtotalloss.atdweb.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Klant;
import com.xtotalloss.atdweb.model.Onderdeel;

public class FactuurOpmakenServlet extends HttpServlet {
	private static final long serialVersionUID = -162531052446206437L;
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		Bedrijf ATD = (Bedrijf) req.getServletContext().getAttribute("ATDWeb_Object");
		
		String name = req.getParameter("dropdown");
		String nameklant = req.getParameter("dropdownklanten");
		//int voorraad;
		double prijsperstuk;
		String action = req.getParameter("submit");
		String factuurbon = req.getParameter("Factuur");

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.ssl.enable", true);
		Session mailSession = Session.getInstance(props);

		if (action.equals("Toevoegen")) {
			String aantal = req.getParameter("aantal");
			int	voorraad = Integer.parseInt(aantal);
			for (Onderdeel o : ATD.alleOnderdelen) {
				if (o.getNaam().equals(name) && o.getAantalOpVoorraad() >= voorraad) {					
					prijsperstuk = o.getPrijsPerStuk();
					int nieuwevoorraad = o.getAantalOpVoorraad() - voorraad;
					o.setAantalOpVoorraad(nieuwevoorraad);
					Onderdeel o2 = new Onderdeel(name, voorraad, prijsperstuk);
					ATD.voegGebruiktOnderdeelToe(o2);
					
					System.out.println("### FactuurOpmakenServlet.java -- " + ATD.alleGebruikteOnderdelen);
					req.setAttribute("msgToe","<div class='succes'>Onderdeel Toegevoegd: " + name+ "</div>");
					rd = req.getRequestDispatcher("factuuropmaken.jsp");
					System.out.println("### FactuurOpmakenServlet.java -- Onderdeel Toegevoegd");
					break;
					
				} else {
					rd = req.getRequestDispatcher("factuuropmaken.jsp");
					req.setAttribute("msgToe","<div class='nosucces'>Toevoegen is mislukt</div>");	
				}
			}
		}
			if (action.equals("Verstuur Factuur")) {
				for (Klant k : ATD.alleKlanten) {
					if (k.getNaam().equals(nameklant)) {
						try {
							MimeMessage msg = new MimeMessage(mailSession);
							msg.setFrom(new InternetAddress("student.hu.test@gmail.com", "ATDWeb.nl"));
							msg.setRecipients(Message.RecipientType.TO,"dion139@hotmail.com");
							msg.setSubject("Uw Factuur");
							msg.setSentDate(Calendar.getInstance().getTime());
							msg.setText("Beste "+k.getNaam()+ ", Hierbij uw factuur \n \n" + factuurbon);
							Transport.send(msg, "student.hu.test@gmail.com","1234VIJF");
							ATD.alleGebruikteOnderdelen.clear();
							
							rd = req.getRequestDispatcher("factuuropmaken.jsp");
							req.setAttribute("msgToe","<div class='succes'>Factuur is verstuurd</div>");
						} catch (Exception e) {
							rd = req.getRequestDispatcher("factuuropmaken.jsp");
							req.setAttribute("msgToe","<div class='nosucces'>Fout bijversturen factuur</div>");
						}
						
					}
				}
			}
			rd.forward(req, resp);
		}
	}