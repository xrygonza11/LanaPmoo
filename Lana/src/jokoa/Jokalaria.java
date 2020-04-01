package jokoa;

import java.util.ArrayList;
import java.util.List;

public class Jokalaria {
	private String izena;
	private boolean zenbat;
	private Jokaldia m;
	private int puntuak=0;
	private List<Karta> kartak = new ArrayList<Karta>();
	
	public int getPuntuak() {
		return puntuak;
	}
	public void puntuakGehitu(int p) {
		puntuak=puntuak+p;
	}
	public Jokalaria(String pIzena) {
		this.izena = pIzena;
	}
	public String getIzena() {
		return izena;
	}
	
	public boolean getZenbat() {
		return zenbat;
	}
	public void setZenbat(boolean z) {
		zenbat=z;
	}
	public void geiKartak(List<Karta> r) {
		kartak.addAll(r);
	}
	public List<Karta> getKartak(){
		return kartak;
	}
	public void berriabiarazi() {
		puntuak=0;
		kartak = new ArrayList<Karta>();
	}
	public Jokaldia getM() {
		return m;
	}
	public void setM(Jokaldia m) {
		this.m = m;
	}
	
}
