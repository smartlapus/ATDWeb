package com.xtotalloss.atdweb.model;
import java.util.ArrayList;



public class Bedrijf implements java.io.Serializable{
	private static final long serialVersionUID = -6462233708802885889L;
	private String naam;
	private String adres;
	public ArrayList<Klant> alleKlanten;
	public ArrayList<Klus> alleKlussen;
	public ArrayList<Monteur> alleMonteurs;
	protected ArrayList<Financien> alleFinancien;
	
	public Bedrijf(String naam, String adres){
		
		naam = "ATDWeb";
		adres = "U";
		alleKlanten = new ArrayList<Klant>();
		alleMonteurs = new ArrayList<Monteur>();
		alleFinancien = new ArrayList<Financien>();
		alleKlussen = new ArrayList<Klus>();
	}
	
	//Getters
	public ArrayList<Klant> getAlleKlanten() {
		return alleKlanten;
	}

	public ArrayList<Klus> getAlleKlussen() {
		return alleKlussen;
	}

	public ArrayList<Monteur> getAlleMonteurs() {
		return alleMonteurs;
	}
	
	public ArrayList<Financien> getAlleFinancien() {
		return alleFinancien;
	}
	
	public String getNaam() {
		return naam;
	}

	public String getAdres() {
		return adres;
	}
	
	//Setters
	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	
	//Functions
	public void voegKlantToe(Klant klant) {
		if(!alleKlanten.contains(klant)) {
			alleKlanten.add(klant);
			System.out.println("Klant is toegevoegd");
			System.out.println(alleKlanten);
		}
	}
	
	public void verwijderKlant(Klant klant){
		if(alleKlanten.contains(klant)){
			alleKlanten.remove(klant);
			System.out.println("Klant is verwijderd");
			System.out.println(alleKlanten);
		}
	}
	
	public void voegMonteurToe(Monteur medewerker) {
		if(!alleMonteurs.contains(medewerker)) {
			alleMonteurs.add(medewerker);
			System.out.println("Monteur is toegevoegd");
			System.out.println(alleMonteurs);
		}
	}
	public void voegKlusToe(Klus klus) {
		if(!alleKlussen.contains(klus)) {
			alleKlussen.add(klus);
			System.out.println("Klus is toegevoegd");
			System.out.println(alleKlussen);
		}
	}
	
	public void verwijderMonteur(Monteur monteur) {
		if(alleMonteurs.contains(monteur)) {
			alleMonteurs.remove(monteur);
			System.out.println("Monteur is verwijderd");
			System.out.println(alleMonteurs);
		}
	}
	
	public void verwijderKlus(Klus klus){
		if(alleKlussen.contains(klus)) {
			alleKlussen.remove(klus);
			System.out.println("Klus is verwijderd");
			System.out.println(alleKlussen);
		}
	}
	
	public void voegFinancienToe(Financien fin){
		if(!alleFinancien.contains(fin)) {
			alleFinancien.add(fin);
		}
	}


}
