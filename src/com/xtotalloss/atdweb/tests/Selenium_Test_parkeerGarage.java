package com.xtotalloss.atdweb.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestBase;
import com.thoughtworks.selenium.Selenium;

public class Selenium_Test_parkeerGarage extends SeleneseTestBase {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://xtotalloss.com:8080/");
		selenium.start();
		selenium.open("/");
		selenium.type("id=gebruikersnaam", "klant");
		selenium.type("id=wachtwoord", "admin123");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Klus inplannen");
		selenium.waitForPageToLoad("30000");
	}

	// Parkeer Garage

	@Test
	public void testReserveringPlaatsen() throws Exception {
		selenium.open("parkeergarageGebruiker.jsp");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Parkeerplaats reserveren");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("U heeft een plek gereserveerd op naam:"));
	}

	@Test
	public void testSAlGereserveerd() throws Exception {
		selenium.open("parkeergarageGebruiker.jsp");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Parkeerplaats reserveren");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Reservering mag 1x per klant per dag"));
	}


	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
