package com.xtotalloss.atdweb.model;

public class ParkeerGarage {
	private int aantalPlaatsen, aantalPlaatsenBeschikbaar;
	
	public ParkeerGarage(int ap){
		aantalPlaatsen = ap;
	}
	
	public void autoErbij() {
		aantalPlaatsenBeschikbaar --;
	}
	
	public void autoEraf() {
		aantalPlaatsenBeschikbaar ++;
	}

	//Getters
	public int getAantalPlaatsen() {
		return aantalPlaatsen;
	}
	
	public int getAantalPlaatsenBeschikbaar() {
		return aantalPlaatsenBeschikbaar;
	}

	//Setters
	public void setAantalPlaatsen(int ap) {
		aantalPlaatsen = ap;
	}

	public void setAantalPlaatsenBeschikbaar(int apb) {
		aantalPlaatsenBeschikbaar = apb;
	}	
	
	public String toString() {
		String s = "Parkeergarage met " + getAantalPlaatsen() + " plaatsen waarvan " + getAantalPlaatsenBeschikbaar() + " plaatsen beschikbaar.";
		return s;
	}
}
