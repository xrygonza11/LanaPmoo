package jokoa;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaKartak {
	//atributuak
	private ArrayList<Karta> lista;
	private int kartaKop=0;
	private int puntuazioa=0;
	//eraikitzaile
	public ListaKartak() {
		lista=new ArrayList<Karta>();
	}
	//gainontzeko metodoak
	public Karta getKarta(int pPos) {
		Karta k = lista.get(pPos);
		return k;		
	}
	public void kenduKarta(int pPos){
		lista.remove(pPos);
		kartaKop=kartaKop-1;
		
	}
	public void setKartaKop(int pKartaKop){
		this.kartaKop=pKartaKop;
	}
	public void gehituKarta(Karta pKarta){
		this.lista.add(pKarta);
		this.kartaKop=kartaKop+1;
	}
	public void erreseteatu(){
		this.lista.clear();
	}
	public Iterator<Karta> getIteradorea(){
		return this.lista.iterator();
	}
	public void imprimatuKartak(){
		Iterator<Karta>itr=this.getIteradorea();
		Karta k= null;
		while (itr.hasNext()){
			k=itr.next();
			k.imprimatuKarta();
		}
	}
	public int getKartaKop(){
		return this.kartaKop;
	}
	public void gehituPuntuazioa(int pPunt) {
		puntuazioa=puntuazioa+pPunt;
	}
	public int getPuntuazioa() {
		return puntuazioa;
	}
	
}
