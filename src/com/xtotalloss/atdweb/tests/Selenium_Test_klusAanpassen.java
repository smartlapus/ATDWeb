package com.xtotalloss.atdweb.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestBase;
import com.thoughtworks.selenium.Selenium;

public class Selenium_Test_klusAanpassen extends SeleneseTestBase
{
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://xtotalloss.com:8080/");
		selenium.start();
		selenium.open("/");
		selenium.type("id=gebruikersnaam", "admin");
		selenium.type("id=wachtwoord", "admin123");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Klus overzicht");
		selenium.waitForPageToLoad("30000");
	}
	
	
			@Test
			public void testOngeldigeNaam() throws Exception {
				selenium.click("link=Klus aanpassen");
				selenium.waitForPageToLoad("30000");
				selenium.type("id=naam", "APK1");
				selenium.type("id=werkzaamheden", "Bandenspanning opnemen");
				selenium.type("id=kenteken", "03-02-UK");
				selenium.click("id=submit");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Naam mag geen cijfers bevatten."));
			}
			
			@Test
			public void testCorrecteGegevensKlusAanpassen() throws Exception {
				selenium.click("link=Klus aanpassen");
				selenium.waitForPageToLoad("30000");selenium.type("id=naam", "APK");
				selenium.type("id=werkzaamheden", "Bandenspanning opnemen");
				selenium.type("id=kenteken", "03-02-UK");
				selenium.click("id=submit");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Klus succesvol aangepast"));
			}

		

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
