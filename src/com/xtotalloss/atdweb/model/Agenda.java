package com.xtotalloss.atdweb.model;
public class Agenda {

	private String dag, maand, jaar;
	
	public Agenda(String dg, String md, String jr) {
		dg = dag;
		md = maand;
		jr = jaar;
	}
	
	//Getters
	public String getDag() {
		return dag;
	}
	
	public String getMaand() {
		return maand;
	}
	
	public String getJaar()	{
		return jaar;
	}
	
	public String getDatum() {
		return dag + maand + jaar;
	}
	
	//ToString
	public String toString() {
		String s = "Datum:" + dag + maand + jaar;
		return s;
	}
}
