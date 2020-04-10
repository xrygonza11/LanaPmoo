package jokoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ListaKartak {
	//atributuak
	private ArrayList<Karta> lista;
	private int kartaKop;
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
	}
	public void erreseteatu(){
		this.lista.clear();
	}
	private Iterator<Karta> getIteradorea(){
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
}
