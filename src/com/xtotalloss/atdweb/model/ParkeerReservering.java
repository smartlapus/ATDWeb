package com.xtotalloss.atdweb.model;

import java.util.Calendar;

public class ParkeerReservering {
	private Klant deReserveerder;
	private Calendar datum = Calendar.getInstance();
	private String reserveerDatum;
	
	public ParkeerReservering(Klant k) {
		deReserveerder = k;
		reserveerDatum = getDatum();
	}

	//Getters
	public int getMaand() {
		int deMaand = datum.get(Calendar.MONTH) + 1;
		return deMaand;
	}
	
	public int getDag() {
		int deDag = datum.get(Calendar.DAY_OF_MONTH);
		return deDag;
	}
	
	public int getJaar() {
		int hetJaar = datum.get(Calendar.YEAR);
		return hetJaar;
	}
	
	public String getDatum() {
		String s = getDag() + " - " + getMaand() + " - " + getJaar();
		return s;
	}
	
	public Klant getDeReserveerder() {
		return deReserveerder;
	}
	
	//Setters
	public void setDatum(Calendar d) {
		datum = d;
	}
	
	public void setReserveerder(Klant k) {
		deReserveerder = k;
	}
	
	//Equals overriden
	public boolean equals(Object andere) { 
		boolean b; 
		if (andere instanceof ParkeerReservering) { b = true; } else { b = false; } 
		b = b && (this.deReserveerder.equals(((ParkeerReservering)andere).deReserveerder)); 
		b = b && (this.reserveerDatum.equals(((ParkeerReservering)andere).reserveerDatum)); 
		return b; 
	} 
	
	public String toString() {
		String s = "Parkeerplaats reservering op " + datum;
		return s;
	}
}
