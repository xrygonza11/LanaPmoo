package jokoa;

import java.util.Scanner;

public class JokalariArrunta extends Jokalaria{
	//eraikitzaileak
	private String izena;
	public JokalariArrunta(Teklatua tk){
		String s=tk.irakurriString();
		this.izena=s;
	}
	//gainontzeko metodoak
	public void imprimatuEskua(){
		System.out.println("Zure Eskuko Kartak:");
		this.getEskukoKartak().imprimatuKartak();
	}
	public void jokaldia(Teklatua tk){
		Karta k=null;
		MahaikoKartak.getNireMahaikoKartak().imprimatuKartak();
		System.out.println(" ");
		this.imprimatuEskua();
		System.out.println( izena+ "Egin Zure Jokaldia");
		System.out.println("Aukeratu Eskuko Karta");
		k=this.getEskukoKartak().getKarta(tk.irakurriOsoa());
		
	}
	public void turnoaBukatu(){
		
	}

}
