package com.xtotalloss.atdweb.listeners;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.xtotalloss.atdweb.model.*;

public class MyServletContextListener implements ServletContextListener {
	public static Bedrijf ATD;
	public static ParkeerGarage pg;
	
	public void contextInitialized(ServletContextEvent sce) {
		ATD = new Bedrijf("ATDWeb", "Utrecht");
		pg = new ParkeerGarage(50);
		
		/*try{ 
		FileInputStream fis = new FileInputStream("ATDWeb.obj");    
		ObjectInputStream ois = new ObjectInputStream(fis);   
		Bedrijf ATD = (Bedrijf) ois.readObject();
		ois.close(); }
		catch(IOException | ClassNotFoundException ioe){
			ioe.printStackTrace();
		}*/
		
		//Klanten toevoegen
		Klant k1 = new Klant("admin", "adminweg 92", "admin", "admin", "ATDWeb@gmail.com", "0612345678");
		Klant k2 = new Klant("testklant", "adminweg 92", "test", "test", "test@gmail.com", "0612345678");
		ATD.voegKlantToe(k1);
		ATD.voegKlantToe(k2);
		
		//Monteurs toevoegen
		Monteur m1 = new Monteur("Joyce", "Gadellaa", "1234FD", "12", "De Bilt", "dion@d.nl", "0623645712", "1234567890", "1234567", "Joyce01", "mypass");
		Monteur m2 = new Monteur("Robin", "Altena", "5634AD", "112", "Utrecht", "Martin@d.nl", "0612345678", "1234567890", "1234567", "Robin", "j3Qel45Ds");
		Monteur m3 = new Monteur("Victor", "Verstappen", "4561MN", "65", "Utrecht", "Jason@bricks.com", "0694769372", "1234567890", "1234567", "Stryder", "$se2!Er3se");
		ATD.voegMonteurToe(m1);
		ATD.voegMonteurToe(m3);
		ATD.voegMonteurToe(m2);
		
		//Klussen toevoegen
		Klus kl1 = new Klus("APK Keuring", "Alles controleren", "07-IA-21", "02-04-12");
		ATD.voegKlusToe(kl1);
		
		//Reserveringen toevoegen
		ParkeerReservering pr1 = new ParkeerReservering(k2);
		pg.alleReserveringen.add(pr1);
		
		//Printen
		System.out.println(ATD);
		System.out.println(k1);
		System.out.println("Success!");
		System.out.println(ATD.alleMonteurs);
		System.out.println(ATD.getAlleMonteurs());
		System.out.println(ATD.alleKlussen);
		System.out.println(ATD.getAlleKlussen());
		
		sce.getServletContext().setAttribute("ATD_Object", ATD);
		sce.getServletContext().setAttribute("parkeergarage_object", pg);
		sce.getServletContext().setAttribute("monteurslijst", ATD.alleMonteurs);
		sce.getServletContext().setAttribute("kluslijst", ATD.alleKlussen);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		Object o = sce.getServletContext().getAttribute("ATD_Object");
		Bedrijf ATD = (Bedrijf)o;
		
		try {
			FileOutputStream fos = new FileOutputStream("ATDWeb.obj");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ATD);
			oos.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace(); 
		}
	}
}