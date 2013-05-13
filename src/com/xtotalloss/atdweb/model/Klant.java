package com.xtotalloss.atdweb.model;

public class Klant {
	
	private String voornaam, achternaam, postcode, huisnr, plaats, email, telnummer;
	protected Auto auto;

	public Klant(String vnm, String anm, String pcode, String hnr, String plts, String mail, String telnr){
		voornaam = vnm;
		achternaam = anm;
		postcode = pcode;
		huisnr = hnr;
		plaats = plts;
		email = mail;
		telnummer = telnr;	
	}
	
	public Klant(String vnm, String anm) {
		voornaam = vnm;
		achternaam = anm;
	}

	//Getters
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
	
	public Auto getAuto() {
		return auto;
	}	
	
	//Setters
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

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	//ToString
	public String toString() {
		String s = voornaam + " " + achternaam;
		return s;
		
	}
	
	public String toStringAlleGegevens() {
		String aG = voornaam + " " + achternaam + ". \n " + postcode + " " + huisnr + " " + plaats + ". \n " + email + ", " + telnummer; 
		return aG;
	}
}
