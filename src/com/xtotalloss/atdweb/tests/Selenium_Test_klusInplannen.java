package com.xtotalloss.atdweb.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestBase;
import com.thoughtworks.selenium.Selenium;

public class Selenium_Test_klusInplannen extends SeleneseTestBase
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
	@Test
	public void testKlusAanpassenGeenNaam() throws Exception {
		selenium.type("id=naam", "");
		selenium.type("id=werkzaamheden", "Werkzaamheden");
		selenium.type("id=kent", "03-02-UK");
		selenium.type("id=dag", "01");
		selenium.type("id=maand", "09");
		selenium.type("id=jaar", "2013");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Naam mag niet leeg zijn."));
	}

	@Test
	public void testKlusAanpassenGeenWerkzaamheden() throws Exception {
		selenium.type("id=naam", "Naam");
		selenium.type("id=werkzaamheden", "");
		selenium.type("id=kent", "03-02-UK");
		selenium.type("id=dag", "01");
		selenium.type("id=maand", "09");
		selenium.type("id=jaar", "2013");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Werkzaamheden mag niet leeg zijn."));
	}
	@Test
	public void testKlusAanpassenGeenKenteken() throws Exception {
		selenium.type("id=naam", "Naam");
		selenium.type("id=werkzaamheden", "Werkzaamheden");
		selenium.type("id=kent", "");
		selenium.type("id=dag", "01");
		selenium.type("id=maand", "09");
		selenium.type("id=jaar", "2013");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Kenteken mag niet leeg zijn."));
	}
	@Test
	public void testKlusAanpassenGeenDatum() throws Exception {
		selenium.type("id=naam", "Naam");
		selenium.type("id=werkzaamheden", "Werkzaamheden");
		selenium.type("id=kent", "03-02-UK");
		selenium.type("id=dag", "");
		selenium.type("id=maand", "");
		selenium.type("id=jaar", "");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Fout in de invoer"));
	}
	@Test
	public void testKlusAanpassenAllesLeeg() throws Exception {
		selenium.type("id=naam", "");
		selenium.type("id=werkzaamheden", "");
		selenium.type("id=kent", "");
		selenium.type("id=dag", "");
		selenium.type("id=maand", "");
		selenium.type("id=jaar", "");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Fout in de invoer"));
	}
	@Test
	public void testKlusAanpassenNaamMetCijfers() throws Exception {
		selenium.type("id=naam", "APK1");
		selenium.type("id=werkzaamheden", "Bandenspanning opnemen");
		selenium.type("id=kent", "03-02-UK");
		selenium.type("id=dag", "01");
		selenium.type("id=maand", "09");
		selenium.type("id=jaar", "2013");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Naam mag niet uit cijfers bestaan."));
	}
	
	
	// Extra voor Klus Aanpassen
	
			@Test
			public void testOngeldigeDatum() throws Exception {
				selenium.type("id=naam", "APK1");
				selenium.type("id=werkzaamheden", "Bandenspanning opnemen");
				selenium.type("id=kent", "03-02-UK");
				selenium.type("id=dat", "02-03-13");
				selenium.click("id=submit");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Ongeldige datum."));
			}
			
			@Test
			public void testCorrecteGegevensKlusAanpassen() throws Exception {
				selenium.type("id=naam", "APK1");
				selenium.type("id=werkzaamheden", "Bandenspanning opnemen");
				selenium.type("id=kent", "03-02-UK");
				selenium.type("id=dat", "02/03/13");
				selenium.click("id=submit");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Klus is succesvol aangepast."));
			}

		// Monteur Toevoegen

		@Test
			public void testMonteurToevoegen() throws Exception {
				selenium.click("link=Toevoegen");
				selenium.waitForPageToLoad("30000");
				selenium.type("id=voornaam", "voornaam");
				selenium.type("id=achternaam", "achternaam");
				selenium.type("id=pcode", "3580AA");
				selenium.type("id=huis", "24");
				selenium.type("id=plaats", "Utrecht");
				selenium.type("id=mail", "test@test.nl");
				selenium.type("id=telnr", "06-18999540");
				selenium.type("id=bsn", "4564564");
				selenium.type("id=reknr", "3865352");
				selenium.type("id=gebnaam", "gebruikersnaam");
				selenium.type("id=password", "wachtwoord");
				selenium.click("id=submit");
				verifyTrue(selenium.isTextPresent("Monteur toegevoegd"));
			}
			
			@Test
			public void testAlleVeldenGevuld() throws Exception {
				selenium.click("link=Toevoegen");
				selenium.waitForPageToLoad("30000");
				selenium.type("id=voornaam", "");
				selenium.type("id=achternaam", "achternaam");
				selenium.type("id=pcode", "3580AA");
				selenium.type("id=huis", "24");
				selenium.type("id=plaats", "");
				selenium.type("id=mail", "test@test.nl");
				selenium.type("id=telnr", "06-18999540");
				selenium.type("id=bsn", "4564564");
				selenium.type("id=reknr", "3865352");
				selenium.type("id=gebnaam", "");
				selenium.type("id=password", "wachtwoord");
				selenium.click("id=submit");
				verifyTrue(selenium.isTextPresent("Monteur toegevoegd"));
			}
			
			@Test
			public void testFoutePostcode() throws Exception {
				selenium.click("link=Toevoegen");
				selenium.waitForPageToLoad("30000");
				selenium.type("id=voornaam", "voornaam");
				selenium.type("id=achternaam", "");
				selenium.type("id=pcode", "AABBCCDD22");
				selenium.type("id=huis", "24");
				selenium.type("id=plaats", "Utrecht");
				selenium.type("id=mail", "test@test.nl");
				selenium.type("id=telnr", "06-18999540");
				selenium.type("id=bsn", "4564564");
				selenium.type("id=reknr", "3865352");
				selenium.type("id=gebnaam", "gebruikersnaam");
				selenium.type("id=password", "wachtwoord");
				selenium.click("id=submit");
				verifyTrue(selenium.isTextPresent("Monteur toegevoegd"));
			}
			
			@Test
			public void testFouteEmail() throws Exception {
				selenium.click("link=Toevoegen");
				selenium.waitForPageToLoad("30000");
				selenium.type("id=voornaam", "voornaam");
				selenium.type("id=achternaam", "");
				selenium.type("id=pcode", "AABBCCDD22");
				selenium.type("id=huis", "24");
				selenium.type("id=plaats", "Utrecht");
				selenium.type("id=mail", "www.mijnemail.nl");
				selenium.type("id=telnr", "06-18999540");
				selenium.type("id=bsn", "4564564");
				selenium.type("id=reknr", "3865352");
				selenium.type("id=gebnaam", "gebruikersnaam");
				selenium.type("id=password", "wachtwoord");
				selenium.click("id=submit");
				verifyTrue(selenium.isTextPresent("Monteur toegevoegd"));
			}
			
			@Test
			public void testDezelfdeNaam() throws Exception {
				selenium.click("link=Toevoegen");
				selenium.waitForPageToLoad("30000");
				selenium.type("id=voornaam", "admin");
				selenium.type("id=achternaam", "achternaam");
				selenium.type("id=pcode", "AABBCCDD22");
				selenium.type("id=huis", "24");
				selenium.type("id=plaats", "Utrecht");
				selenium.type("id=mail", "test@test.nl");
				selenium.type("id=telnr", "06-18999540");
				selenium.type("id=bsn", "4564564");
				selenium.type("id=reknr", "3865352");
				selenium.type("id=gebnaam", "admin");
				selenium.type("id=password", "admin");
				selenium.click("id=submit");
				verifyTrue(selenium.isTextPresent("De gebruikersnaam bestaat al"));
			}

		// Parkeer Garage

		@Test
			public void testReserveringPlaatsen() throws Exception {
				selenium.click("link=Parkeergarage");
				selenium.waitForPageToLoad("30000");
				selenium.click("link=Parkeerplaats reserveren");
				selenium.waitForPageToLoad("30000");
				verifyTrue(selenium.isTextPresent("U heeft gereserveerd"));
			}

			@Test
			public void testAlGereserveerd() throws Exception {
				selenium.click("link=Parkeergarage");
				selenium.waitForPageToLoad("30000");
				selenium.click("link=Parkeerplaats reserveren");
				selenium.waitForPageToLoad("30000");
				verifyTrue(selenium.isTextPresent("U heeft al een reservering geplaatst!"));
			}

		// Registreren
			
			@Test
			public void testRegistrerenGeenNaam() throws Exception {
				selenium.type("id=naam", "");
				selenium.type("id=adres", "adminweg 92");
				selenium.type("xpath=(//input[@id='gebruikersnaam'])[2]", "admin");
				selenium.type("xpath=(//input[@id='wachtwoord'])[2]", "admin123");
				selenium.type("id=email", "ATDWeb@gmail.com");
				selenium.type("id=tel", "01043025");
				selenium.click("id=submit");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Naam mag niet leeg zijn."));
			}
			@Test
			public void testGeenAdres() throws Exception {
				selenium.type("id=naam", "admin");
				selenium.type("id=adres", "");
				selenium.type("xpath=(//input[@id='gebruikersnaam'])[2]", "admin");
				selenium.type("xpath=(//input[@id='wachtwoord'])[2]", "admin123");
				selenium.type("id=email", "ATDWeb@gmail.com");
				selenium.type("id=tel", "01043025");
				selenium.click("id=submit");
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
				selenium.click("id=submit");
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
				selenium.click("id=submit");
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
				selenium.click("id=submit");
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
				selenium.click("id=submit");
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
				selenium.click("id=submit");
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
				selenium.click("id=submit");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Gebruikersnaam bestaat al."));
			}

			// Inloggen
			
		public void testInloggenBestaandeGebruiker() throws Exception {
			selenium.open("/ATDWeb/");
			selenium.type("id=gebruikersnaam", "admin");
			selenium.type("id=wachtwoord", "admin123");
			selenium.click("id=submit");
			selenium.waitForPageToLoad("30000");
			assertTrue(selenium.isTextPresent("Ingelogd als admin"));
		}

		public void testInloggenVerkeerdeGegevens() throws Exception {
			selenium.open("/ATDWeb/");
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
