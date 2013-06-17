package com.xtotalloss.atdweb.model;

public class Klus implements java.io.Serializable{
	private static final long serialVersionUID = -4362534758612225109L;
	private String naam;
	private String werkzaamheden;
	private String kenteken;
	private String datum;
	protected Monteur monteur;
	
	public Klus (String nm, String werk, String kent, String dat) {
		naam = nm;
		werkzaamheden = werk;
		kenteken = kent;
		datum = dat;
	}
	
	//Getters
	public String getNaam()	{
		return naam;
	}
	
	public String getWerkzaamheden() {
		return werkzaamheden;
	}

	public String getKenteken()	{
		return kenteken;
	}

	public String getDatum() {
		return datum;
	}
	
	public Monteur getMonteur() {
		return monteur;
	}
	
	//Setters
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public void setWerkzaamheden(String werkzaamheden) {
		this.werkzaamheden = werkzaamheden;
	}
	
	public void setKenteken(String kenteken) {
		this.kenteken = kenteken;
	}
	
	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	public void setMonteur(Monteur monteur) {
		this.monteur = monteur;
	}
	
	//ToString
	public String toString(){
		String s = naam + ": " + werkzaamheden + " (" + datum + ")";
		return s;
		
	}
	
	public String toStringAlleGegevens(){
		String aG = naam + ". \n " + werkzaamheden + ". \n " + kenteken + ". \n " + datum; 
		return aG;
	}
}
