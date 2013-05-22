package com.xtotalloss.atdweb.listeners;

import java.io.*; 
import javax.servlet.*;
import com.xtotalloss.atdweb.model.*;



public class MyServletContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		Bedrijf ATD = new Bedrijf("ATDWeb", "Utrecht");
		Klant k1 = new Klant("Yassir Driuch", "C. Dirkszstraat 92", "Yassir", "w8woord", "yassir.driuch@gmail.com", "0612345678");
		ATD.voegKlantToe(k1);
		System.out.println(k1);
		System.out.println("Success!");
	sce.getServletContext().setAttribute("ATD_Object", ATD);
	
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