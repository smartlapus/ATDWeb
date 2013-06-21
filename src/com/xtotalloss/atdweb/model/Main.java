package com.xtotalloss.atdweb.model;

import com.xtotalloss.atdweb.exceptions.InvalidUserException;

public class Main {
	protected static Bedrijf hetBedrijf;
	
	public static void main(String[] args) throws InvalidUserException {
		hetBedrijf = new Bedrijf("ATDWeb", "Utrecht");
		Klant k = new Klant("test", "test", "test", "test", "test", "test");
		hetBedrijf.voegKlantToe(k);
		System.out.println(hetBedrijf.alleKlanten);
	}
}
