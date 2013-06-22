package com.xtotalloss.atdweb.tests;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.xtotalloss.atdweb.exceptions.OngeldigeKlusException;
import com.xtotalloss.atdweb.model.Klus;


public class tests {
		
	private UUID uniqueID;
	
		@Before 
		public void setup() throws Exception
		{
			 UUID uniuqeID = UUID.randomUUID();
			
		}
		
		// Klus toevoegen
		
		@Test(expected=OngeldigeKlusException.class)
		public void testGeenNaam() throws OngeldigeKlusException
		{
			Klus geenNaam = new Klus(uniqueID, "", "Bandenspanning opmeten", "93-IA-OI", "01-12-13");
		}
		
		@Test(expected=OngeldigeKlusException.class)
		public void testGeenWerkzaamheden() throws OngeldigeKlusException
		{
			Klus geenWerkzaamheden = new Klus(uniqueID, "APK Keuring", "", "93-IA-OI", "01-12-13");
		}
		
		@Test(expected=OngeldigeKlusException.class)
		public void testGeenKenteken() throws OngeldigeKlusException
		{
			Klus geenKenteken = new Klus(uniqueID, "APK Keuring", "Bandenspanning opmeten", "", "01-12-13");
		}
		
		@Test(expected=OngeldigeKlusException.class)
		public void testGeenDatum() throws OngeldigeKlusException
		{
			Klus geenDatum = new Klus(uniqueID, "APK Keuring", "Bandenspanning opmeten", "93-IA-OI", "");
		}
		
		@Test(expected=OngeldigeKlusException.class)
		public void testNaamMetCijfer() throws OngeldigeKlusException
		{
			Klus cijferInNaam = new Klus(uniqueID, "APK Keuring2", "Bandenspanning opmeten", "93-IA-OI", "01-12-13");
		}
		
		@Test
		public void testGeenException() throws OngeldigeKlusException
		{
			Klus allesGoed = new Klus (uniqueID, "APK Keuring", "Bandenspanning opmeten", "93-IA-OI", "01-12-13");
		}
}
