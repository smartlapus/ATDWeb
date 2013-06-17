package com.xtotalloss.atdweb.model;

public class Onderdeel {
	private String naam;
	private int aantalOpVoorraad;
	private double prijsPerStuk;
	
	public Onderdeel(String nm, int aov, double pps){
		naam = nm;
		aantalOpVoorraad = aov;
		prijsPerStuk = pps;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public int getAantalOpVoorraad() {
		return aantalOpVoorraad;
	}

	public void setAantalOpVoorraad(int aantalOpVoorraad) {
		this.aantalOpVoorraad = aantalOpVoorraad;
	}

	public double getPrijsPerStuk() {
		return prijsPerStuk;
	}

	public void setPrijsPerStuk(double prijsPerStuk) {
		this.prijsPerStuk = prijsPerStuk;
	}
	
	public String toString(){
		return naam;
	}
}
