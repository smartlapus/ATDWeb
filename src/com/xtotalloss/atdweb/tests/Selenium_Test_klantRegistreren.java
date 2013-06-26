package com.xtotalloss.atdweb.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestBase;
import com.thoughtworks.selenium.Selenium;

public class Selenium_Test_klantRegistreren extends SeleneseTestBase
{
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://xtotalloss.com:8080/");
		selenium.start();
		selenium.open("/");
		selenium.waitForPageToLoad("30000");
		
	}

			@Test
			public void testRegistrerenGeenNaam() throws Exception {
				selenium.type("id=naam", "");
				selenium.type("id=adres", "adminweg 92");
				selenium.type("xpath=(//input[@id='gebruikersnaam'])[2]", "admin");
				selenium.type("xpath=(//input[@id='wachtwoord'])[2]", "admin123");
				selenium.type("id=email", "ATDWeb@gmail.com");
				selenium.type("id=tel", "01043025");
				selenium.click("css=#content-right > div.content-container > form > #submit");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Naam mag niet leeg zijn."));
			}
			@Test
			public void testGeenAdres() throws Exception {
				selenium.open("/");
				selenium.type("id=naam", "admin");
				selenium.type("id=tel", "010430298");
				selenium.type("xpath=(//input[@id='gebruikersnaam'])[2]", "admin");
				selenium.type("xpath=(//input[@id='wachtwoord'])[2]", "admin123");
				selenium.type("id=email", "ATDWeb@gmail.com");
				selenium.click("css=#content-right > div.content-container > form > #submit");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Adres mag niet leeg zijn."));
			}
			@Test
			public void testGeenGebruikersNaam() throws Exception {
				selenium.type("id=naam", "admin");
				selenium.type("id=adres", "adminweg 92");
				selenium.type("xpath=(//input[@id='gebruikersnaam'])[2]", "");
				selenium.type("xpath=(//input[@id='wachtwoord'])[2]", "admin123");
				selenium.type("id=email", "ATDWeb@gmail.com");
				selenium.type("id=tel", "01043025");
				selenium.click("css=#content-right > div.content-container > form > #submit");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Gebruikersnaam mag niet leeg zijn."));
			}
			@Test
			public void testGeenWachtwoord() throws Exception {
				selenium.type("id=naam", "admin");
				selenium.type("id=adres", "adminweg 92");
				selenium.type("xpath=(//input[@id='gebruikersnaam'])[2]", "admin");
				selenium.type("xpath=(//input[@id='wachtwoord'])[2]", "");
				selenium.type("id=email", "ATDWeb@gmail.com");
				selenium.type("id=tel", "01043025");
				selenium.click("css=#content-right > div.content-container > form > #submit");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Wachtwoord mag niet leeg zijn."));
			}
			@Test
			public void testGeenEmail() throws Exception {
				selenium.type("id=naam", "admin");
				selenium.type("id=adres", "adminweg 92");
				selenium.type("xpath=(//input[@id='gebruikersnaam'])[2]", "admin");
				selenium.type("xpath=(//input[@id='wachtwoord'])[2]", "admin123");
				selenium.type("id=email", "");
				selenium.type("id=tel", "01043025");
				selenium.click("css=#content-right > div.content-container > form > #submit");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Email mag niet leeg zijn."));
			}
			@Test
			public void testGeenTelefoonNummer() throws Exception {
				selenium.type("id=naam", "admin");
				selenium.type("id=adres", "adminweg 92");
				selenium.type("xpath=(//input[@id='gebruikersnaam'])[2]", "admin");
				selenium.type("xpath=(//input[@id='wachtwoord'])[2]", "admin123");
				selenium.type("id=email", "ATDWeb@gmail.com");
				selenium.type("id=tel", "");
				selenium.click("css=#content-right > div.content-container > form > #submit");;
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Telefoonnummer mag niet leeg zijn."));
			}
			
			@Test
			public void testWachtwoordNietLangGenoeg() throws Exception {
				selenium.type("id=naam", "admin");
				selenium.type("id=adres", "adminweg 92");
				selenium.type("xpath=(//input[@id='gebruikersnaam'])[2]", "admin");
				selenium.type("xpath=(//input[@id='wachtwoord'])[2]", "admin");
				selenium.type("id=email", "ATDWeb@gmail.com");
				selenium.type("id=tel", "01043025");
				selenium.click("css=#content-right > div.content-container > form > #submit");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Wachtwoord moet minimaal 6 tekens lang zijn."));
			}
			
			@Test
			public void testBestaandeGebruikerRegistreren() throws Exception {
				selenium.type("id=naam", "admin");
				selenium.type("id=adres", "adminweg 92");
				selenium.type("xpath=(//input[@id='gebruikersnaam'])[2]", "admin");
				selenium.type("xpath=(//input[@id='wachtwoord'])[2]", "admin123");
				selenium.type("id=email", "ATDWeb@gmail.com");
				selenium.type("id=tel", "01043025");
				selenium.click("css=#content-right > div.content-container > form > #submit");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Gebruikersnaam bestaat al."));
			}

		
	

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
