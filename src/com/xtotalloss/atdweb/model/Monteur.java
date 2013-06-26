package com.xtotalloss.atdweb.model;

import java.util.ArrayList;

import com.xtotalloss.atdweb.exceptions.InvalidUserException;
import com.xtotalloss.atdweb.exceptions.OngeldigeMonteurException;

public class Monteur implements java.io.Serializable {

	private static final long serialVersionUID = -6447637491564898644L;
	private String voornaam, achternaam, postcode, huisnr, plaats, email, telnummer, bsnnr, reknummer, gebruikersnaam, wachtwoord;
	private ArrayList<OngeldigeMonteurException> errorMessagesList;

	public Monteur(String vnm, String anm, String pcode, String hnr, String plts, String mail, String telnr, String bsn, String reknr, String gbnm, String ww) throws OngeldigeMonteurException {

		errorMessagesList = new ArrayList<OngeldigeMonteurException>();

		if (vnm == null || "".equals(vnm)) {
			OngeldigeMonteurException errorMessage = new OngeldigeMonteurException("Voornaam mag niet leeg zijn.");
			errorMessagesList.add(errorMessage);
		}
		if (anm == null || "".equals(anm)) {
			OngeldigeMonteurException errorMessage = new OngeldigeMonteurException("Achternaam mag niet leeg zijn.");
			errorMessagesList.add(errorMessage);
		}
		if (pcode == null || "".equals(pcode)) {
			OngeldigeMonteurException errorMessage = new OngeldigeMonteurException("Postcode mag niet leeg zijn.");
			errorMessagesList.add(errorMessage);
		}
		if (hnr == null || "".equals(hnr)) {
			OngeldigeMonteurException errorMessage = new OngeldigeMonteurException("Huisnummer mag niet leeg zijn.");
			errorMessagesList.add(errorMessage);
		}
		if (plts == null || "".equals(plts)) {
			OngeldigeMonteurException errorMessage = new OngeldigeMonteurException("Plaats mag niet leeg zijn.");
			errorMessagesList.add(errorMessage);
		}
		if (mail == null || "".equals(mail)) {
			OngeldigeMonteurException errorMessage = new OngeldigeMonteurException("Email mag niet leeg zijn.");
			errorMessagesList.add(errorMessage);
		}
		if (telnr == null || "".equals(telnr)) {
			OngeldigeMonteurException errorMessage = new OngeldigeMonteurException("Telefoonnummer mag niet leeg zijn.");
			errorMessagesList.add(errorMessage);
		}
		if (bsn == null || "".equals(bsn)) {
			OngeldigeMonteurException errorMessage = new OngeldigeMonteurException("BSN Nummer mag niet leeg zijn.");
			errorMessagesList.add(errorMessage);
		}
		if (reknr == null || "".equals(reknr)) {
			OngeldigeMonteurException errorMessage = new OngeldigeMonteurException("Rekening Nummer mag niet leeg zijn.");
			errorMessagesList.add(errorMessage);
		}
		if (gbnm == null || "".equals(gbnm)) {
			OngeldigeMonteurException errorMessage = new OngeldigeMonteurException("Gebruikersnaam mag niet leeg zijn.");
			errorMessagesList.add(errorMessage);
		}
		if (ww == null || "".equals(ww)) {
			OngeldigeMonteurException errorMessage = new OngeldigeMonteurException("Wachtwoord mag niet leeg zijn.");
			errorMessagesList.add(errorMessage);
		}
		
		if (!"".equals(telnr)) {
			if (!telnr.matches("[0-9]+")) {
				OngeldigeMonteurException errorMessage = new OngeldigeMonteurException("Telefoonnummer mag alleen uit cijfers bestaan.");
				errorMessagesList.add(errorMessage);
			}
		}
		if (!"".equals(bsn)) {
			if (!bsn.matches(".*[0-9].*")) {
				OngeldigeMonteurException errorMessage = new OngeldigeMonteurException("BSN mag alleen uit cijfers bestaan.");
				errorMessagesList.add(errorMessage);
			}
		}
		if (!"".equals(reknr)) {
			if (!reknr.matches(".*[0-9].*")) {
				OngeldigeMonteurException errorMessage = new OngeldigeMonteurException("Rekeningnummer mag alleen uit cijfers bestaan.");
				errorMessagesList.add(errorMessage);
			}
		}
		if (pcode.length() > 6 && !pcode.matches("a-zA-Z0-9")) {
			OngeldigeMonteurException errorMessage = new OngeldigeMonteurException("Postcode is incorrect.");
			errorMessagesList.add(errorMessage);
		}

		// Check if there are any errors to print
		if (errorMessagesList.size() > 0) {
			String errorMessage = "";
			for (OngeldigeMonteurException IUE : errorMessagesList) {
				errorMessage += IUE.getMessage() + "<br />";
			}

			throw new OngeldigeMonteurException(errorMessage);
		}

		voornaam = vnm;
		achternaam = anm;
		postcode = pcode;
		huisnr = hnr;
		plaats = plts;
		email = mail;
		telnummer = telnr;
		bsnnr = bsn;
		reknummer = reknr;
		gebruikersnaam = gbnm;
		wachtwoord = ww;

	}

	// Getters
	public String getVoornaam() {
		return voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getHuisnr() {
		return huisnr;
	}

	public String getPlaats() {
		return plaats;
	}

	public String getEmail() {
		return email;
	}

	public String getTelnummer() {
		return telnummer;
	}

	public String getBsnnr() {
		return bsnnr;
	}

	public String getReknummer() {
		return reknummer;
	}

	// Setters
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setHuisnr(String huisnr) {
		this.huisnr = huisnr;
	}

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelnummer(String telnummer) {
		this.telnummer = telnummer;
	}

	public void setBsnnr(String bsnnr) {
		this.bsnnr = bsnnr;
	}

	public void setReknummer(String reknummer) {
		this.reknummer = reknummer;
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	// Equals overriden
	public boolean equals(Object andere) {
		boolean b;
		if (andere instanceof Monteur) {
			b = true;
		} else {
			b = false;
		}
		b = b && (this.voornaam == ((Monteur) andere).voornaam);
		b = b && (this.achternaam == ((Monteur) andere).achternaam);
		b = b && (this.postcode == ((Monteur) andere).postcode);
		b = b && (this.huisnr == ((Monteur) andere).huisnr);
		b = b && (this.plaats == ((Monteur) andere).plaats);
		b = b && (this.email == ((Monteur) andere).email);
		b = b && (this.telnummer == ((Monteur) andere).telnummer);
		b = b && (this.bsnnr == ((Monteur) andere).bsnnr);
		b = b && (this.reknummer == ((Monteur) andere).reknummer);
		b = b && (this.gebruikersnaam == ((Monteur) andere).gebruikersnaam);
		return b;
	}

	// ToString
	public String toString() {
		String s = voornaam + " " + achternaam;
		return s;
	}
}