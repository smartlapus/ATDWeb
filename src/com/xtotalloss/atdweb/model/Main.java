package com.xtotalloss.atdweb.model;
public class Main {
	
	public static void main(String[] args) {
		
		Bedrijf hetBedrijf = new Bedrijf("AutoTotaalDiensten", "Rozewolf 3");
		
		//Klanten en Auto's toevoegen
		Klant k1 = new Klant("Dion", "Iseger", "1234FD", "12", "De Bilt", "dion@d.nl", "0623645712");
		Klant k2 = new Klant("Martin", "Bakker", "5634AD", "112", "Utrecht", "Martin@d.nl", "0612345678");
		Klant k3 = new Klant("Jason", "Koolman", "4561MN", "65", "Utrecht", "Jason@bricks.com", "0694769372");
		Auto a1 = new Auto("Audi", "A1", "2011");
		Auto a2 = new Auto("Volvo", "V70", "2009");
		Auto a3 = new Auto("Volkswagen", "Touran 'Politie'", "2013");
		k1.setAuto(a3);
		k2.setAuto(a2);
		k3.setAuto(a1);
		hetBedrijf.voegKlantToe(k1);
		hetBedrijf.voegKlantToe(k2);
		hetBedrijf.voegKlantToe(k3);
		
		//Monteurs toevoegen
		Monteur m1 = new Monteur("Joyce", "Gadellaa", "1234FD", "12", "De Bilt", "dion@d.nl", "0623645712", "1234567890", "1234567");
		Monteur m2 = new Monteur("Robin", "Altena", "5634AD", "112", "Utrecht", "Martin@d.nl", "0612345678", "1234567890", "1234567");
		Monteur m3 = new Monteur("Victor", "Verstappen", "4561MN", "65", "Utrecht", "Jason@bricks.com", "0694769372", "1234567890", "1234567");
		hetBedrijf.voegMonteurToe(m1);
		hetBedrijf.voegMonteurToe(m3);
		hetBedrijf.voegMonteurToe(m2);
		
		//Financien toevoegen
		Financien f1 = new Financien(1, "Af", 275, "14-01-2013");
		Financien f2 = new Financien(1, "Bij", 530, "19-02-2013");
		Financien f3 = new Financien(1, "Af", 120, "26-03-2013");
		Financien f4 = new Financien(1, "Bij", 230, "28-03-2013");
		Financien f5 = new Financien(2, "Af", 720, "29-04-2013");
		Financien f6 = new Financien(2, "Af", 200, "05-05-2013");
		Financien f7 = new Financien(3, "Bij", 420, "10-08-2013");
		Financien f8 = new Financien(3, "Af", 230, "16-07-2013");
		hetBedrijf.voegFinancienToe(f1);
		hetBedrijf.voegFinancienToe(f2);
		hetBedrijf.voegFinancienToe(f3);
		hetBedrijf.voegFinancienToe(f4);
		hetBedrijf.voegFinancienToe(f5);
		hetBedrijf.voegFinancienToe(f6);
		hetBedrijf.voegFinancienToe(f7);
		hetBedrijf.voegFinancienToe(f8);
		
		//Klus toevoegen
		Klus kl1 = new Klus("APK", "Bandenspanning opnemen", "07-OP-13", "01-01-2011");
		Klus kl2 = new Klus("APK", "Deuren maken", "07-OP-13", "01-01-2011");
		Klus kl3 = new Klus("Cruisecontrol", "Installeren", "TI-02-MN", "11-04-2013");
		kl1.setMonteur(m1);
		kl2.setMonteur(m1);
		kl3.setMonteur(m2);
		hetBedrijf.voegKlusToe(kl1);
		hetBedrijf.voegKlusToe(kl2);
		hetBedrijf.voegKlusToe(kl3);
	}
}
