package com.xtotalloss.atdweb.tests;
import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.xtotalloss.atdweb.controller.*;
import com.xtotalloss.atdweb.model.*;
import com.xtotalloss.atdweb.exceptions.*;


public class tests {
		
		@Before 
		public void setup() throws Exception
		{
			
		}
		@Test(expected=OngeldigeKlusException.class)
		public void testGeenNaam() throws OngeldigeKlusException
		{
			Klus geenNaam = new Klus("", "Bandenspanning opmeten", "93-IA-OI", "01-12-13");
		}
		@Test(expected=OngeldigeKlusException.class)
		public void testGeenWerkzaamheden() throws OngeldigeKlusException
		{
			Klus geenWerkzaamheden = new Klus("APK Keuring", "", "93-IA-OI", "01-12-13");
		}
		@Test(expected=OngeldigeKlusException.class)
		public void testGeenKenteken() throws OngeldigeKlusException
		{
			Klus geenKenteken = new Klus("APK Keuring", "Bandenspanning opmeten", "", "01-12-13");
		}
		@Test(expected=OngeldigeKlusException.class)
		public void testGeenDatum() throws OngeldigeKlusException
		{
			Klus geenDatum = new Klus("APK Keuring", "Bandenspanning opmeten", "93-IA-OI", "");
		}
		@Test(expected=OngeldigeKlusException.class)
		public void testNaamMetCijfer() throws OngeldigeKlusException
		{
			Klus cijferInNaam = new Klus("APK Keuring2", "Bandenspanning opmeten", "93-IA-OI", "01-12-13");
		}
		@Test
		public void testGeenException() throws OngeldigeKlusException
		{
			Klus allesGoed = new Klus ("APK Keuring", "Bandenspanning opmeten", "93-IA-OI", "01-12-13");
		}
}
