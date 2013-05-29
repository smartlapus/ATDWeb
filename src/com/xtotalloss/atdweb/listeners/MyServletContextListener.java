package com.xtotalloss.atdweb.listeners;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Klant;

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