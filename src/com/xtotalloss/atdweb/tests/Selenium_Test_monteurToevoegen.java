package com.xtotalloss.atdweb.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestBase;
import com.thoughtworks.selenium.Selenium;

public class Selenium_Test_monteurToevoegen extends SeleneseTestBase
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
		selenium.click("link=Klus inplannen");
		selenium.waitForPageToLoad("30000");
	}
	

		// Monteur Toevoegen

		@Test
			public void testMonteurToevoegen() throws Exception {
			selenium.open("monteurtoevoegen.jsp");
				selenium.waitForPageToLoad("30000");
				selenium.type("id=voornaam", "voornaam");
				selenium.type("id=achternaam", "achternaam");
				selenium.type("id=pcode", "3580AA");
				selenium.type("id=huis", "24");
				selenium.type("id=plaats", "Utrecht");
				selenium.type("id=mail", "test@test.nl");
				selenium.type("id=telnr", "0618999540");
				selenium.type("id=bsn", "4564564");
				selenium.type("id=reknr", "3865352");
				selenium.type("id=gebnaam", "nieuweUser");
				selenium.type("id=password", "wachtwoord");
				selenium.click("id=submit");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Monteur toegevoegd"));
			}
			
			@Test
			public void testAlleVeldenGevuld() throws Exception {
				selenium.open("monteurtoevoegen.jsp");
				selenium.waitForPageToLoad("30000");
				selenium.type("id=voornaam", "");
				selenium.type("id=achternaam", "achternaam");
				selenium.type("id=pcode", "3580AA");
				selenium.type("id=huis", "24");
				selenium.type("id=plaats", "");
				selenium.type("id=mail", "test@test.nl");
				selenium.type("id=telnr", "0618999540");
				selenium.type("id=bsn", "4564564");
				selenium.type("id=reknr", "3865352");
				selenium.type("id=gebnaam", "");
				selenium.type("id=password", "wachtwoord");
				selenium.click("id=submit");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Voornaam mag niet leeg zijn."));
				assertTrue(selenium.isTextPresent("Plaats mag niet leeg zijn."));
				assertTrue(selenium.isTextPresent("Gebruikersnaam mag niet leeg zijn."));
			}
			
			@Test
			public void testFoutePostcode() throws Exception {
				selenium.open("monteurtoevoegen.jsp");
				selenium.waitForPageToLoad("30000");
				selenium.type("id=voornaam", "voornaam");
				selenium.type("id=achternaam", "achternaam");
				selenium.type("id=pcode", "AABBCCDD22");
				selenium.type("id=huis", "24");
				selenium.type("id=plaats", "Utrecht");
				selenium.type("id=mail", "test@test.nl");
				selenium.type("id=telnr", "0618999540");
				selenium.type("id=bsn", "4564564");
				selenium.type("id=reknr", "3865352");
				selenium.type("id=gebnaam", "gebruikersnaam");
				selenium.type("id=password", "wachtwoord");
				selenium.click("id=submit");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Postcode is incorrect."));
			}
			
			@Test
			public void testDezelfdeNaam() throws Exception {
				selenium.open("monteurtoevoegen.jsp");
				selenium.waitForPageToLoad("30000");
				selenium.type("id=voornaam", "voornaam");
				selenium.type("id=achternaam", "achternaam");
				selenium.type("id=pcode", "3580AA");
				selenium.type("id=huis", "24");
				selenium.type("id=plaats", "Utrecht");
				selenium.type("id=mail", "test@test.nl");
				selenium.type("id=telnr", "0618999540");
				selenium.type("id=bsn", "4564564");
				selenium.type("id=reknr", "3865352");
				selenium.type("id=gebnaam", "gesbruikersnaam");
				selenium.type("id=password", "wachtwoord");
				selenium.click("id=submit");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Gebruikersnaam bestaat al"));
			}

		
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
