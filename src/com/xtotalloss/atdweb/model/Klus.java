package com.xtotalloss.atdweb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import com.xtotalloss.atdweb.exceptions.OngeldigeKlusException;

public class Klus implements Serializable{
	private static final long serialVersionUID = -4362534758612225109L;
	private UUID uniqueID;
	private String naam;
	private String werkzaamheden;
	private String kenteken;
	private String datum;
	protected Monteur monteur;
	
	private ArrayList<OngeldigeKlusException> errorMessagesList;
	
	public Klus (UUID id, String nm, String werk, String kent, String dat) throws OngeldigeKlusException{
	
		errorMessagesList = new ArrayList<OngeldigeKlusException>();

		if (nm == null || "".equals(nm)) {

			OngeldigeKlusException errorMessage = new OngeldigeKlusException(
					"Naam mag niet leeg zijn.");

			errorMessagesList.add(errorMessage);
		}
		if (werk == null || "".equals(werk)) {

			OngeldigeKlusException errorMessage = new OngeldigeKlusException(
					"Werkzaamheden mag niet leeg zijn.");

			errorMessagesList.add(errorMessage);
		}
		if (kent == null || "".equals(kent)) {

			OngeldigeKlusException errorMessage = new OngeldigeKlusException(
					"Kenteken mag niet leeg zijn.");

			errorMessagesList.add(errorMessage);
		}
		if (dat == null || "".equals(dat)) {

			OngeldigeKlusException errorMessage = new OngeldigeKlusException(
					"Datum mag niet leeg zijn.");

			errorMessagesList.add(errorMessage);
		}
		if (nm.matches(".*[0-9].*")) {
			OngeldigeKlusException errorMessage = new OngeldigeKlusException(
					"Naam mag niet uit cijfers bestaan.");
			errorMessagesList.add(errorMessage);
		}
		if (errorMessagesList.size() > 0) {
			String errorMessage = "";
			for (OngeldigeKlusException IUE : errorMessagesList) {
				errorMessage += IUE.getMessage() + "<br />";
			}

			throw new OngeldigeKlusException(errorMessage);
		}
			uniqueID = id;
			naam = nm;
			werkzaamheden = werk;
			kenteken = kent;
			datum = dat;
	}
	
	//Getters
	public String getUniqueID(){
		String s = uniqueID.toString();
		return s;
	}
	
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
