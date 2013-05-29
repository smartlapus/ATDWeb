package com.xtotalloss.atdweb.listeners;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Klant;
import com.xtotalloss.atdweb.model.Monteur;

public class MyServletContextListener implements ServletContextListener {
	public static Bedrijf ATD;
	
	public void contextInitialized(ServletContextEvent sce) {
		ATD = new Bedrijf("ATDWeb", "Utrecht");
		/*try{ 
		FileInputStream fis = new FileInputStream("ATDWeb.obj");    
		ObjectInputStream ois = new ObjectInputStream(fis);   
		Bedrijf ATD = (Bedrijf) ois.readObject();
		ois.close(); }
		catch(IOException | ClassNotFoundException ioe){
			ioe.printStackTrace();
		}*/
		System.out.println(ATD);
		Klant k1 = new Klant("Yassir Driuch", "C. Dirkszstraat 92", "admin", "admin", "yassir.driuch@gmail.com", "0612345678");
		ATD.voegKlantToe(k1);
		Monteur m1 = new Monteur("Joyce", "Gadellaa", "1234FD", "12", "De Bilt", "dion@d.nl", "0623645712", "1234567890", "1234567", "Joyce01", "mypass");
		Monteur m2 = new Monteur("Robin", "Altena", "5634AD", "112", "Utrecht", "Martin@d.nl", "0612345678", "1234567890", "1234567", "Robin", "j3Qel45Ds");
		Monteur m3 = new Monteur("Victor", "Verstappen", "4561MN", "65", "Utrecht", "Jason@bricks.com", "0694769372", "1234567890", "1234567", "Stryder", "$se2!Er3se");
		ATD.voegMonteurToe(m1);
		ATD.voegMonteurToe(m3);
		ATD.voegMonteurToe(m2);
		System.out.println(k1);
		System.out.println("Success!");
		System.out.println(ATD.alleMonteurs);
		System.out.println(ATD.getAlleMonteurs());
		sce.getServletContext().setAttribute("ATD_Object", ATD);
		sce.getServletContext().setAttribute("monteurslijst", ATD.alleMonteurs);
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