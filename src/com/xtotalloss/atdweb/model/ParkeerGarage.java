package com.xtotalloss.atdweb.model;

import java.util.ArrayList;
import java.util.Calendar;

import com.xtotalloss.atdweb.exceptions.OngeldigeParkeergarageException;

public class ParkeerGarage {
	private int aantalPlaatsen, aantalPlaatsenBeschikbaar;
	
	public ArrayList<ParkeerReservering> alleReserveringen;
	
	public ParkeerGarage(int ap) throws OngeldigeParkeergarageException {
		if(ap < 0){
			throw new OngeldigeParkeergarageException("Parkeergarage moet minstens 0 zijn.");
		}
		
		aantalPlaatsen = ap;
		alleReserveringen = new ArrayList<ParkeerReservering>();
		aantalPlaatsenBeschikbaar = aantalPlaatsen;
	}
	
	public void autoErbij(){
		if(aantalPlaatsenBeschikbaar > 0){
			aantalPlaatsenBeschikbaar--;
		}
	}
	
	public void autoEraf(){
		if(aantalPlaatsenBeschikbaar < aantalPlaatsen){
			aantalPlaatsenBeschikbaar++;
		}
	}
	
	public boolean voegReserveringToe(ParkeerReservering pr) throws OngeldigeParkeergarageException {
		if(!alleReserveringen.contains(pr)) {
			alleReserveringen.add(pr);
			autoErbij();
			return true;
		} else if(alleReserveringen.contains(pr)){
			throw new OngeldigeParkeergarageException("Reservering mag 1x per klant per dag");
			
		}
		
		return false;
		
	}
	
	public boolean verwijderReservering(ParkeerReservering pr) {
		if(alleReserveringen.contains(pr)) {
			alleReserveringen.remove(pr);
			autoEraf();
			return true;
		}
		return false;
	}
	
	public int getAlleReserveringen() {
		return alleReserveringen.size();
	}
	
	public int getReserveringenDezeMaand() {
		Calendar datum = Calendar.getInstance();
		int aantalReserveringen = 0;
		int dezeMaand = datum.get(Calendar.MONTH) + 1;
		
		for(ParkeerReservering pr : alleReserveringen) {
			if(pr.getMaand() == dezeMaand) {
				aantalReserveringen ++;
			}
		}
		
		return aantalReserveringen;
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
