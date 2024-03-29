package com.xtotalloss.atdweb.listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.xtotalloss.atdweb.exceptions.InvalidUserException;
import com.xtotalloss.atdweb.exceptions.OngeldigeKlusException;
import com.xtotalloss.atdweb.exceptions.OngeldigeMonteurException;
import com.xtotalloss.atdweb.exceptions.OngeldigeParkeergarageException;
import com.xtotalloss.atdweb.model.Admin;
import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Klant;
import com.xtotalloss.atdweb.model.Klus;
import com.xtotalloss.atdweb.model.Monteur;
import com.xtotalloss.atdweb.model.Onderdeel;
import com.xtotalloss.atdweb.model.ParkeerGarage;

public class MyServletContextListener implements ServletContextListener {

	private ServletContext context;
	private File savePath_Bedrijf;

	public ParkeerGarage parkeerGarage;
	private Bedrijf ATD;

	public void contextInitialized(ServletContextEvent sce) {

		// Get the location to read "ATD_Bedrijf.obj"
		context = sce.getServletContext();
		savePath_Bedrijf = new File(context.getRealPath("/../" + "ATD_Bedrijf.obj"));

		try {
			parkeerGarage = new ParkeerGarage(50);
		} catch (OngeldigeParkeergarageException e1) {
			
			e1.printStackTrace();
		}

		

		try {
			FileInputStream fis = new FileInputStream(savePath_Bedrijf);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ATD = (Bedrijf) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException ioe) {
			ioe.printStackTrace();
		}
		
		if (ATD == null) {
			try {
				ATD = createNewATD();
			} catch (OngeldigeMonteurException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("### MyServletContextListener -- New Bedrijf Added " + ATD);
		}
		
		context.setAttribute("ATDWeb_Object", ATD);
		context.setAttribute("ParkeerGarage_Object", parkeerGarage);
		context.setAttribute("monteurslijst", ATD.alleMonteurs);
		context.setAttribute("kluslijst", ATD.alleKlussen);

		System.out.println("Geregistreerde gebruikers op bedrijf: " + ATD.getNaam());
		for (Klant k : ATD.alleKlanten) {
			System.out.println("Klant: " + k.getGebruikersnaam() + " met wachtwoord: " + k.getWachtwoord());
		}
		
//		for (Admin k : ATD.alleAdmins) {
//			System.out.println("Admin: " + k.getGebruikersnaam() + " met wachtwoord: " + k.getPassword());
//		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
		context = sce.getServletContext();
		savePath_Bedrijf = new File(context.getRealPath("/../" + "ATD_Bedrijf.obj"));

		Object o = sce.getServletContext().getAttribute("ATDWeb_Object");
		Bedrijf ATD = (Bedrijf) o;

		try {
			FileOutputStream fos = new FileOutputStream(savePath_Bedrijf);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ATD);
			oos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public Bedrijf createNewATD() throws OngeldigeMonteurException {
		ATD = new Bedrijf("ATDWeb", "Utrecht");
		// Klanten toevoegen
		Klant k1 = null;
		try {
			k1 = new Klant("testklant", "adminweg 92", "klant", "admin123", "ATDWeb@gmail.com", "01043025");
			ATD.voegKlantToe(k1);
			Admin a1 = new Admin("admin", "admin123", "Henk Paladijn");
			Admin a2 = new Admin("Jopie", "j00p", "Jopie");
			ATD.voegAdminToe(a1);
			ATD.voegAdminToe(a2);
		} catch (InvalidUserException e) {
			String s = e.getMessage();
			System.out.println("### MyServletContextListener.java -- createNewATD() " + s);
		}		

		// Monteurs toevoegen
		Monteur m1 = new Monteur("Joyce", "Gadellaa", "1234FD", "12", "De Bilt", "dion@d.nl", "0623645712", "1234567890", "1234567", "Joyce01", "mypass");
		Monteur m2 = new Monteur("Robin", "Altena", "5634AD", "112", "Utrecht", "Martin@d.nl", "0612345678", "1234567890", "1234567", "Robin", "j3Qel45Ds");
		Monteur m3 = new Monteur("Victor", "Verstappen", "4561MN", "65", "Utrecht", "Jason@bricks.com", "0694769372", "1234567890", "1234567", "Stryder", "$se2!Er3se");
		ATD.voegMonteurToe(m1);
		ATD.voegMonteurToe(m3);
		ATD.voegMonteurToe(m2);

		// Klussen toevoegen
		Klus kl1;
		 UUID klusID = UUID.randomUUID();
		try {
			Calendar datum = Calendar.getInstance();
			kl1 = new Klus(klusID, "APK Keuring", "Alles controleren", "07-IA-21", datum);
			ATD.voegKlusToe(kl1);
		} catch (OngeldigeKlusException e) {
			e.printStackTrace();
		}

		// Klussen toevoegen
		Onderdeel o1 = new Onderdeel("Band", 30, 50);
		Onderdeel o2 = new Onderdeel("Wieldop", 15, 50);
		ATD.voegOnderdeelToe(o1);
		ATD.voegOnderdeelToe(o2);

		return ATD;
	}
}