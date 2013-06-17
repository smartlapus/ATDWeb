package com.xtotalloss.atdweb.model;

public class Auto {
	private String merk;
	private String type;
	private String bouwjaar;
	
	public Auto(String mk, String typ, String bjaar){
		merk = mk;
		type = typ;
		bouwjaar = bjaar;
	}

	//Getters
	public String getMerk() {
		return merk;
	}

	public String getType() {
		return type;
	}

	public String getBouwjaar() {
		return bouwjaar;
	}
	
	//Setters
	public void setMerk(String merk) {
		this.merk = merk;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setBouwjaar(String bouwjaar) {
		this.bouwjaar = bouwjaar;
	}

	//ToString
	public String toString(){
		return merk + " " + type + ", bouwjaar: " + bouwjaar;
	}	
}
