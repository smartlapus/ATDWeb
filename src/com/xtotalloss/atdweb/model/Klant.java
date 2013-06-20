package com.xtotalloss.atdweb.model;

import com.xtotalloss.atdweb.exceptions.InvalidUserException;

public class Klant implements java.io.Serializable {

	private static final long serialVersionUID = 3779322564661073749L;
	private String naam, tel, adres, gebruikersnaam, wachtwoord, email;
	private ParkeerGarage pg;
	protected Auto auto;

	public Klant(String nm, String adr, String user, String passwd, String mail, String telnr) throws InvalidUserException {
		if (nm == null || "".equals(nm)) {
			InvalidUserException errorMessage = new InvalidUserException("Gebruikersnaam mag niet leeg zijn.");
			// errorMessage add to arrayList
			// arrayList to string
			// jstl for:each --> ArrayList<InvalidUserException>
			
			
			
		}
		if (adr == null || "".equals(adr)) {
			throw new InvalidUserException("Adres mag niet leeg zijn.");
		}
		if (passwd == null || "".equals(passwd)) {
			throw new InvalidUserException("Wachtwoord mag niet leeg zijn.");
		}
		if (mail == null || "".equals(mail)) {
			throw new InvalidUserException("Email mag niet leeg zijn.");
		}
		if (telnr == null || "".equals(telnr)) {
			throw new InvalidUserException("Telefoonnummer mag niet leeg zijn.");
		}
		if (nm.matches(".*[0-9].*")) {
			throw new InvalidUserException("Een naam mag alleen uit letters bestaan.");
		}
		if (!telnr.matches(".*[0-9].*")) {
			throw new InvalidUserException("Telefoonnummer mag alleen uit cijfers bestaan.");
		}

		naam = nm;
		adres = adr;
		gebruikersnaam = user;
		wachtwoord = passwd;
		email = mail;
		tel = telnr;
	}

	public Klant(String user, String passwd) {
		gebruikersnaam = user;
		wachtwoord = passwd;
	}

	// Getters
	public String getNaam() {
		return naam;
	}

	public String getTelefoonnummer() {
		return tel;
	}

	public String getAdres() {
		return adres;
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public String getEmail() {
		return email;
	}

	public Auto getAuto() {
		return auto;
	}

	// Setters
	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setTelefoonnummer(String tel) {
		this.tel = tel;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	// Equals overriden
	public boolean equals(Object andere) {
		boolean b;
		if (andere instanceof Klant) {
			b = true;
		} else {
			b = false;
		}
		b = b && (this.naam == ((Klant) andere).naam);
		b = b && (this.adres == ((Klant) andere).adres);
		b = b && (this.gebruikersnaam == ((Klant) andere).gebruikersnaam);
		b = b && (this.email == ((Klant) andere).email);
		b = b && (this.tel == ((Klant) andere).tel);
		return b;
	}

	// ToString
	public String toString() {
		String s = naam;
		return s;
	}
}
