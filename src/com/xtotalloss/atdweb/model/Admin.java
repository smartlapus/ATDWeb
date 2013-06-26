package com.xtotalloss.atdweb.model;

import java.io.Serializable;

public class Admin implements Serializable{
	private String gebruikersnaam, password, naam;
	
	public Admin(String geb, String pass, String nm){
		gebruikersnaam = geb;
		password = pass;
		naam = nm;
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public String toString(){
		return gebruikersnaam;
	}
	
	// Equals overriden
	public boolean equals(Object andere) {
		boolean b;
		if (andere instanceof Admin) {
			b = true;
		} else {
			b = false;
		}
		b = b && (this.naam == ((Admin) andere).naam);
		b = b && (this.gebruikersnaam == ((Admin) andere).gebruikersnaam);
		return b;
	}
}
