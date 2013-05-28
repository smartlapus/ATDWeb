package com.xtotalloss.atdweb.model;

public class Main {
	protected static Bedrijf hetBedrijf;
	
	public static void main(String[] args) {
		hetBedrijf = new Bedrijf("ATDWeb", "Utrecht");
		Klant k = new Klant("test", "test", "test", "test", "test", "test");
		hetBedrijf.voegKlantToe(k);
		System.out.println(hetBedrijf.alleKlanten);
	}
}
