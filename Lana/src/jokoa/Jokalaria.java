package jokoa;

import java.util.ArrayList;
import java.util.List;

public abstract class Jokalaria {
	//atributuak
	private String izena;
	private int puntuak;
	private ListaKartak eskukoKartak;
	private ListaKartak lortutakoKartak;
	
	//eraikitzaileak
	public Jokalaria (String pIzena){
		this.izena=pIzena;
		this.puntuak=0;
		this.eskukoKartak=new ListaKartak();
		this.lortutakoKartak=new ListaKartak();
	}
	
	//gainontzeko metodoak
	protected ListaKartak getEskukoKartak(){
		return this.eskukoKartak;
	}
	protected ListaKartak getLortutakoKartak(){
		return this.lortutakoKartak;
	}
	protected int getPuntuak(){
		return this.puntuak;
	}
	public void puntuakGehitu(int p) {
		puntuak=puntuak+p;
	}


	public void berriabiarazi() {
		puntuak=0;
		lortutakoKartak.erreseteatu();
	}
	
}
