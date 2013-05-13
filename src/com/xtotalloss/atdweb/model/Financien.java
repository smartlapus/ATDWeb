package com.xtotalloss.atdweb.model;

public class Financien {
	
	private String soort, datum;
	private int kwartaal, bedrag;

	public Financien(int kw, String srt, int bd, String dt){
		kwartaal = kw;
		soort = srt;
		bedrag = bd;
		datum = dt;
	}

	//Getters
	public int getKwartaal() {
		return kwartaal;
	}

	public String getSoort() {
		return soort;
	}
	
	public int getBedrag() {
		return bedrag;
	}

	public String getDatum() {
		return datum;
	}
	
	//Setters
	public void setKwartaal(int kw) {
		this.kwartaal = kw;
	}
	
	public void setSoort(String srt) {
		this.soort = srt;
	}
	
	public void setBedrag(int bd) {
		this.bedrag = bd;
	}

	public void setDatum(String dt) {
		this.datum = dt;
	}

	//ToString
	public String toString(){
		String s = soort + " " + bedrag;
		return s;	
	}
}
