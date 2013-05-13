package com.xtotalloss.atdweb.model;

public class Monteur {
	
	private String voornaam, achternaam, postcode, huisnr, plaats, email, telnummer, bsnnr, reknummer;

	public Monteur(String vnm, String anm, String pcode, String hnr, String plts, String mail, String telnr, String bsn, String reknr) {
		voornaam = vnm;
		achternaam = anm;
		postcode = pcode;
		huisnr = hnr;
		plaats = plts;
		email = mail;
		telnummer = telnr;
		bsnnr = bsn;
		reknummer = reknr;
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

	public String getBsnnr() {
		return bsnnr;
	}

	public String getReknummer() {
		return reknummer;
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
	
	public void setBsnnr(String bsnnr) {
		this.bsnnr = bsnnr;
	}
	
	public void setReknummer(String reknummer) {
		this.reknummer = reknummer;
	}
	
	//ToString	
	public String toString(){
		String s = voornaam + " " + achternaam;
		return s;
	}
}