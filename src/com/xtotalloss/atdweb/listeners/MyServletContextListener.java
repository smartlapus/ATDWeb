package com.xtotalloss.atdweb.listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.xtotalloss.atdweb.exceptions.InvalidUserException;
import com.xtotalloss.atdweb.exceptions.OngeldigeKlusException;
import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Klant;
import com.xtotalloss.atdweb.model.Klus;
import com.xtotalloss.atdweb.model.Monteur;
import com.xtotalloss.atdweb.model.Onderdeel;
import com.xtotalloss.atdweb.model.ParkeerGarage;
import com.xtotalloss.atdweb.model.ParkeerReservering;

public class MyServletContextListener implements ServletContextListener {

	private ServletContext context;
	private File savePath_Bedrijf;

	public ParkeerGarage parkeerGarage;
	private Bedrijf ATD;

	public void contextInitialized(ServletContextEvent sce) {

		// Get the location to read "ATD_Bedrijf.obj"
		context = sce.getServletContext();
		savePath_Bedrijf = new File(context.getRealPath("/../" + "ATD_Bedrijf.obj"));

		parkeerGarage = new ParkeerGarage(50);

		

		try {
			FileInputStream fis = new FileInputStream(savePath_Bedrijf);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ATD = (Bedrijf) ois.readObject();

			if (ATD == null) {
				ATD = createNewATD();
				System.out.println("### MyServletContextListener -- New Bedrijf Added " + ATD);
			}

			ois.close();
		} catch (IOException | ClassNotFoundException ioe) {
			ioe.printStackTrace();
		}

		context.setAttribute("ATDWeb_Object", ATD);
		context.setAttribute("ParkeerGarage_Object", parkeerGarage);
		context.setAttribute("monteurslijst", ATD.alleMonteurs);
		context.setAttribute("kluslijst", ATD.alleKlussen);

		System.out.println("Geregistreerde gebruikers op bedrijf: " + ATD.getNaam());
		for (Klant k : ATD.alleKlanten) {
			System.out.println("Klant: " + k.getGebruikersnaam() + " met wachtwoord: " + k.getWachtwoord());
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {

		// Get the location to store "ATD_Bedrijf.obj"
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

	public Bedrijf createNewATD() {
		ATD = new Bedrijf("ATDWeb", "Utrecht");
		// Klanten toevoegen
		Klant k1 = null;
		try {
			k1 = new Klant("admin", "adminweg 92", "admin", "admin", "ATDWeb@gmail.com", "01043025");
			ATD.voegKlantToe(k1);
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
		try {
			kl1 = new Klus("APK Keuring", "Alles controleren", "07-IA-21", "02-04-12");
			ATD.voegKlusToe(kl1);
		} catch (OngeldigeKlusException e) {
			e.printStackTrace();
		}

		// Klussen toevoegen
		Onderdeel o1 = new Onderdeel("Band", 30, 50);
		Onderdeel o2 = new Onderdeel("Wieldop", 15, 50);
		ATD.voegOnderdeelToe(o1);
		ATD.voegOnderdeelToe(o2);

		// Reserveringen toevoegen
		ParkeerReservering pr1 = new ParkeerReservering(k1);
		parkeerGarage.alleReserveringen.add(pr1);

		// Printen
		

		return ATD;
	}
}