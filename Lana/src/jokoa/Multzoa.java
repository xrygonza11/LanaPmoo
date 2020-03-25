
package jokoa;

import java.util.ArrayList;
import java.util.List;

public class Multzoa {
	
	private List<Karta> listaKartak = new ArrayList<>();
	
	public Multzoa() {
		multzoaSortu();
		
	}
	
	public void multzoaSortu() {
		for(int i=1; i<=10;i++) {
			listaKartak.add(new Karta(i,"URREA"));
			listaKartak.add(new Karta(i,"KOPAK"));
			listaKartak.add(new Karta(i,"EZPATAK"));
			listaKartak.add(new Karta(i,"BASTOIAK"));
		}
	}
	
	public void reset() {
		listaKartak.clear();
		multzoaSortu();
	}
	
	public void banaketa(Jokaldia mano) {
		
		mano.setk1(getKarta());
		mano.setk2(getKarta());
		mano.setk3(getKarta());
	}
	
	public Karta getKarta() {
		Karta k = listaKartak.get(0);
		listaKartak.remove(0);
		return k;		
	}
	
	public boolean kartakGeratu() {
		return listaKartak.size()>0;
	}
	
	
}

