package com.xtotalloss.atdweb.tests;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;

import com.xtotalloss.atdweb.exceptions.InvalidUserException;
import com.xtotalloss.atdweb.exceptions.OngeldigeKlusException;
import com.xtotalloss.atdweb.exceptions.OngeldigeMonteurException;
import com.xtotalloss.atdweb.exceptions.OngeldigeParkeergarageException;
import com.xtotalloss.atdweb.model.Bedrijf;
import com.xtotalloss.atdweb.model.Klant;
import com.xtotalloss.atdweb.model.Klus;
import com.xtotalloss.atdweb.model.Monteur;
import com.xtotalloss.atdweb.model.ParkeerGarage;
import com.xtotalloss.atdweb.model.ParkeerReservering;

public class tests {

	private UUID uniqueID;
	private Klus klus;
	private Bedrijf ATD;
	private ArrayList<Klant> alleKlanten;
	private Klant bestaandeKlant, testKlant;
	private ParkeerReservering testReservering;


	@BeforeClass
	public void setUpBeforeClass() throws Exception {

	}

	@Before
	public void setup() throws Exception {
		UUID uniuqeID = UUID.randomUUID();
		Calendar datum = Calendar.getInstance();
		klus = new Klus(uniqueID, "APK Keuring", "Bandenspanning opmeten", "93-IA-OI", datum);
		ATD = new Bedrijf("ATDWeb", "Utrecht");
		alleKlanten = new ArrayList<Klant>();
		bestaandeKlant = new Klant("admin", "adminweg 92", "admin", "admin123", "ATDWeb@gmail.com", "1234567");
		alleKlanten.add(bestaandeKlant);
		
		testKlant = new Klant("admin", "adminweg 92", "admin", "admin123", "ATDWeb@gmail.com", "01043025");
		testReservering = new ParkeerReservering(testKlant);


	}

	// Klus toevoegen
	@Test(expected = OngeldigeKlusException.class)
	public void testKlusToevoegenGeenNaam() throws OngeldigeKlusException {
		Calendar datum = Calendar.getInstance();
		Klus geenNaam = new Klus(uniqueID, "", "Bandenspanning opmeten", "93-IA-OI", datum);
	}

	@Test(expected = OngeldigeKlusException.class)
	public void testKlusToevoegenGeenWerkzaamheden() throws OngeldigeKlusException {
		Calendar datum = Calendar.getInstance();
		Klus geenWerkzaamheden = new Klus(uniqueID, "APK Keuring", "", "93-IA-OI", datum);
	}

	@Test(expected = OngeldigeKlusException.class)
	public void testKlusToevoegenGeenKenteken() throws OngeldigeKlusException {
		Calendar datum = Calendar.getInstance();
		Klus geenKenteken = new Klus(uniqueID, "APK Keuring", "Bandenspanning opmeten", "", datum);
	}

	@Test(expected = OngeldigeKlusException.class)
	public void testKlusToevoegenGeenDatum() throws OngeldigeKlusException {
		Calendar datum = Calendar.getInstance();
		Klus geenDatum = new Klus(uniqueID, "APK Keuring", "Bandenspanning opmeten", "93-IA-OI", null);
	}

	@Test(expected = OngeldigeKlusException.class)
	public void testKlusToevoegenNaamMetCijfer() throws OngeldigeKlusException {
		Calendar datum = Calendar.getInstance();
		Klus cijferInNaam = new Klus(uniqueID, "APK Keuring2", "Bandenspanning opmeten", "93-IA-OI", datum);
	}

	@Test
	public void testKlusToevoegenGeenException() throws OngeldigeKlusException {
		Calendar datum = Calendar.getInstance();
		Klus allesGoed = new Klus(uniqueID, "APK Keuring", "Bandenspanning opmeten", "93-IA-OI", datum);
	}

	// Klus aanpassen

	@Test(expected = OngeldigeKlusException.class)
	public void testKlusAanpassenGeenNaam() throws OngeldigeKlusException {
		klus.setNaam(null);
	}

	@Test(expected = OngeldigeKlusException.class)
	public void testKlusAanpassenGeenWerkzaamheid() throws OngeldigeKlusException {
		klus.setWerkzaamheden(null);
	}

	@Test(expected = OngeldigeKlusException.class)
	public void testKlusAanpassenGeenKenteken() throws OngeldigeKlusException {
		klus.setKenteken(null);
	}

	@Test(expected = OngeldigeKlusException.class)
	public void testKlusAanpassenGeenDatum() throws OngeldigeKlusException, ParseException {
		klus.setDatum(null);
	}

	@Test(expected = ParseException.class)
	public void testKlusAanpassenOngeldigeDatum() throws ParseException, OngeldigeKlusException {
//		klus.setDatum(datum);
	}

	@Test
	public void testKlusAanpassenCorrecteGegevens() throws OngeldigeKlusException, ParseException {
		klus.setNaam("Nieuwe APK Keuring");
		klus.setWerkzaamheden("Bandenspanning opmeten en ruitewisser vervangen");
		klus.setKenteken("93-IA-OI");
//		klus.setDatum("01/12/2013");
	}

	// Registreren

	@Test(expected = InvalidUserException.class)
	public void testRegistrerenGeenNaam() throws InvalidUserException {
		Klant nieuweKlant = new Klant("", "adminweg 92", "admin", "admin123", "ATDWeb@gmail.com", "01043025");
	}

	@Test(expected = InvalidUserException.class)
	public void testRegistrerenGeenAdres() throws InvalidUserException {
		Klant nieuweKlant = new Klant("admin", "", "admin", "admin123", "ATDWeb@gmail.com", "01043025");
	}

	@Test(expected = InvalidUserException.class)
	public void testRegistrerenGeenGebruikersNaam() throws InvalidUserException {
		Klant nieuweKlant = new Klant("admin", "adminweg 92", "", "admin123", "ATDWeb@gmail.com", "01043025");
	}

	@Test(expected = InvalidUserException.class)
	public void testRegistrerenGeenWachtwoord() throws InvalidUserException {
		Klant nieuweKlant = new Klant("admin", "adminweg 92", "admin", "", "ATDWeb@gmail.com", "01043025");
	}

	@Test(expected = InvalidUserException.class)
	public void testRegistrerenGeenEmail() throws InvalidUserException {
		Klant nieuweKlant = new Klant("admin", "adminweg 92", "admin", "admin", "", "01043025");
	}

	@Test(expected = InvalidUserException.class)
	public void testRegistrerenGeenTelefoonNummer() throws InvalidUserException {
		Klant nieuweKlant = new Klant("admin", "adminweg 92", "admin", "admin123", "ATDWeb@gmail.com", "");
	}

	@Test(expected = InvalidUserException.class)
	public void testRegistrerenWachtwoordMinderDanZesTekens() throws InvalidUserException {
		Klant nieuweKlant = new Klant("admin", "adminweg 92", "admin", "admin", "ATDWeb@gmail.com", "1234567");

	}

	@Test(expected = InvalidUserException.class)
	public void testRegistrerenTelefoonNummerMetLetters() throws InvalidUserException {
		Klant nieuweKlant = new Klant("admin", "adminweg 92", "admin", "admin", "ATDWeb@gmail.com", "123456as7");

	}

	@Test(expected = InvalidUserException.class)
	public void testRegistrerenNaamMetCijfers() throws InvalidUserException {
		Klant nieuweKlant = new Klant("admin123", "adminweg 92", "admin", "admin", "ATDWeb@gmail.com", "1234567");

	}

	@Test(expected = InvalidUserException.class)
	public void testRegistrerenBestaandeKlant() throws InvalidUserException {
		Klant nieuweKlant = new Klant("admin", "adminweg 92", "admin", "admin", "ATDWeb@gmail.com", "1234567");
		ATD.voegKlantToe(nieuweKlant);
	}

	// Inloggen

	@Test
	public void testInloggenBestaandeGebruiker() throws Exception {
		for (Klant k : ATD.alleKlanten) {
			if (k.getGebruikersnaam().equals("admin123") && k.getWachtwoord().equals("admin123")) {
			} else {
				throw new Exception("User not found");
			}
		}
	}

	// Monteur Toevoegen

	@Test(expected = OngeldigeMonteurException.class)
	public void testMonteurToevoegenGeenNaam() throws OngeldigeMonteurException {
		Monteur geenNaam = new Monteur("", "achternaam", "3500AA", "21", "Utrecht", "test@test.nl", "030-5590320", "34534534", "3253675", "Gebruiker", "wachtwoord");
	}
	@Test(expected = OngeldigeMonteurException.class)
	public void testMonteurToevoegenGeenPostcode() throws OngeldigeMonteurException {
		Monteur geenPostcode = new Monteur("voornaam", "achternaam", "", "21", "Utrecht", "test@test.nl", "030-5590320", "34534534", "3253675", "Gebruiker", "wachtwoord");
	}
	@Test(expected = OngeldigeMonteurException.class)
	public void testMonteurToevoegenOngeldigePostcode() throws OngeldigeMonteurException {
		Monteur ongeldigePostcode = new Monteur("voornaam", "achternaam", "AAAA2222", "21", "Utrecht", "test@test.nl", "030-5590320", "34534534", "3253675", "Gebruiker", "wachtwoord");
	}
	@Test(expected = OngeldigeMonteurException.class)
	public void testMonteurToevoegenGeenHuisnr() throws OngeldigeMonteurException {
		Monteur geenMonteurToevoegenHuisnr = new Monteur("voornaam", "achternaam", "3500AA", "", "Utrecht", "test@test.nl", "030-5590320", "34534534", "3253675", "Gebruiker", "wachtwoord");
	}
	@Test(expected = OngeldigeMonteurException.class)
	public void testMonteurToevoegenGeenEmail() throws OngeldigeMonteurException {
		Monteur geenMonteurToevoegenEmail = new Monteur("voornaam", "achternaam", "3500AA", "21", "Utrecht", "", "030-5590320", "34534534", "3253675", "Gebruiker", "wachtwoord");
	}
	@Test(expected = OngeldigeMonteurException.class)
	public void testMonteurToevoegenGeenTelnr() throws OngeldigeMonteurException {
		Monteur geenMonteurToevoegenTelnr = new Monteur("voornaam", "achternaam", "3500AA", "21", "Utrecht", "test@test.nl", "", "34534534", "3253675", "Gebruiker", "wachtwoord");
	}
	@Test(expected = OngeldigeMonteurException.class)
	public void testMonteurToevoegenGeenCijfersBSN() throws OngeldigeMonteurException {
		Monteur geenMonteurToevoegenCijfersBSN = new Monteur("voornaam", "achternaam", "3500AA", "21", "Utrecht", "test@test.nl", "030-5590320", "bsn nr", "3253675", "Gebruiker", "wachtwoord");
	}
	@Test(expected = OngeldigeMonteurException.class)
	public void testMonteurToevoegenOngeldigTelnr() throws OngeldigeMonteurException {
		Monteur testMonteurToevoegenOngeldigTelnr = new Monteur("voornaam", "achternaam", "3500AA", "21", "Utrecht", "test@test.nl", "030-AABBCCDD", "34534534", "3253675", "Gebruiker", "wachtwoord");
	}
	@Test
	public void testMonteurToevoegenGeenException() throws OngeldigeMonteurException {
		Monteur testMonteurToevoegenGeenException = new Monteur("voornaam", "achternaam", "3500AA", "21", "Utrecht", "test@test.nl", "030-556456", "34534534", "3253675", "Gebruiker", "wachtwoord");
	}
	
	// Parkeer Garage
	
	@Test(expected = OngeldigeParkeergarageException.class)
	public void testOngeldigeParkeergarage() throws OngeldigeParkeergarageException {
		ParkeerGarage ongeldigeParkeergarage = new ParkeerGarage(-10);
	}
	
	@Test(expected = OngeldigeParkeergarageException.class)
	public void testTweeReserveringen() throws OngeldigeParkeergarageException {
		ParkeerGarage tweeReserveringen = new ParkeerGarage(50);
		tweeReserveringen.voegReserveringToe(testReservering);
		tweeReserveringen.voegReserveringToe(testReservering);
	}
	
	@Test(expected = OngeldigeParkeergarageException.class)
	public void testGeenReserveerder() throws OngeldigeParkeergarageException {
		ParkeerReservering geenReserveerder = new ParkeerReservering(null);
	}

	@Test
	public void testGeenException() throws OngeldigeParkeergarageException {
		ParkeerGarage geenException = new ParkeerGarage(50);
	}


}
