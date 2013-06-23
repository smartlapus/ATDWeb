package com.xtotalloss.atdweb.model;

import java.util.ArrayList;

import com.xtotalloss.atdweb.exceptions.InvalidUserException;

public class Bedrijf implements java.io.Serializable {
	private static final long serialVersionUID = -6462233708802885889L;
	private String naam;
	private String adres;
	public ArrayList<Klant> alleKlanten;
	public ArrayList<Onderdeel> alleOnderdelen;
	public ArrayList<Onderdeel> alleGebruikteOnderdelen;
	public ArrayList<Klus> alleKlussen;
	public ArrayList<Monteur> alleMonteurs;
	public ArrayList<Financien> alleFinancien;

	public Bedrijf(String naam, String adres) {
		this.naam = naam;
		this.adres = adres;
		alleKlanten = new ArrayList<Klant>();
		alleOnderdelen = new ArrayList<Onderdeel>();
		alleGebruikteOnderdelen = new ArrayList<Onderdeel>();
		alleMonteurs = new ArrayList<Monteur>();
		alleFinancien = new ArrayList<Financien>();
		alleKlussen = new ArrayList<Klus>();
	}

	// Getters
	public ArrayList<Klant> getAlleKlanten() {
		return alleKlanten;
	}

	public ArrayList<Klus> getAlleKlussen() {
		return alleKlussen;
	}

	public ArrayList<Monteur> getAlleMonteurs() {
		return alleMonteurs;
	}

	public ArrayList<Financien> getAlleFinancien() {
		return alleFinancien;
	}

	public String getNaam() {
		return naam;
	}

	public String getAdres() {
		return adres;
	}

	public String toString() {
		return "Bedrijf: " + naam + " op adres: " + adres;
	}

	// Setters
	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	// Functions
	public void voegKlantToe(Klant klant) throws InvalidUserException {

		for (Klant k : alleKlanten) {
			for (Monteur m : alleMonteurs) {
				if (klant.getGebruikersnaam().equals(k.getGebruikersnaam()) || klant.getGebruikersnaam().equals(m.getGebruikersnaam())) {
					throw new InvalidUserException("Gebruikersnaam bestaat al.");
				}
			}
		}

		if (!alleKlanten.contains(klant)) {
			alleKlanten.add(klant);
			System.out.println("### Bedrijf.java -- Klant is toegevoegd " + klant.getGebruikersnaam() + " Pass: " + klant.getWachtwoord());

		}
	}

	public void verwijderKlant(Klant klant) {
		if (alleKlanten.contains(klant)) {
			alleKlanten.remove(klant);
			System.out.println("### Bedrijf.java -- Klant is verwijderd " + klant.getGebruikersnaam());

		}
	}

	public void voegMonteurToe(Monteur medewerker) {
		if (!alleMonteurs.contains(medewerker)) {
			alleMonteurs.add(medewerker);
			System.out.println("### Bedrijf.java -- Monteur is toegevoegd " + medewerker.getGebruikersnaam());

		}
	}

	public void voegOnderdeelToe(Onderdeel onderdeel) {
		if (!alleOnderdelen.contains(onderdeel)) {
			alleOnderdelen.add(onderdeel);
			System.out.println("### Bedrijf.java -- Onderdeel is toegevoegd " + onderdeel.getNaam());

		}
	}

	public void voegGebruiktOnderdeelToe(Onderdeel onderdeel) {
		alleGebruikteOnderdelen.add(onderdeel);
		System.out.println("### Bedrijf.java -- gebruikt onderdeel is toegevoegd" + onderdeel.getNaam());

	}

	public void voegKlusToe(Klus klus) {
		if (!alleKlussen.contains(klus)) {
			alleKlussen.add(klus);
			System.out.println("### Bedrijf.java -- Klus is toegevoegd " + klus.getNaam());

		}
	}

	public void verwijderMonteur(Monteur monteur) {
		if (alleMonteurs.contains(monteur)) {
			alleMonteurs.remove(monteur);
			System.out.println("### Bedrijf.java -- Monteur is verwijderd " + monteur.getGebruikersnaam());

		}
	}

	public void verwijderKlus(Klus klus) {
		if (alleKlussen.contains(klus)) {
			alleKlussen.remove(klus);
			System.out.println("### Bedrijf.java -- Klus is verwijderd " + klus.getNaam());

		}
	}

	public void voegFinancienToe(Financien fin) {
		if (!alleFinancien.contains(fin)) {
			alleFinancien.add(fin);
		}
	}

}
