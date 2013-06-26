package com.xtotalloss.atdweb.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestBase;
import com.thoughtworks.selenium.Selenium;

public class Selenium_Test_klantInloggen extends SeleneseTestBase {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://xtotalloss.com:8080/");
		selenium.start();
		selenium.open("/");
		selenium.waitForPageToLoad("30000");

	}

	@Test
	public void testInloggenBestaandeGebruiker() throws Exception {
		selenium.open("/");
		selenium.type("id=gebruikersnaam", "admin");
		selenium.type("id=wachtwoord", "admin123");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Ingelogd als admin"));
	}

	@Test
	public void testInloggenVerkeerdeGegevens() throws Exception {
		selenium.open("/");
		selenium.type("id=gebruikersnaam", "admin");
		selenium.type("id=wachtwoord", "admin");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Gebruikersnaam en wachtwoord combinatie incorrect."));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
