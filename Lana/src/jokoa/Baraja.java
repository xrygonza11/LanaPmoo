
package jokoa;

import java.util.ArrayList;
import java.util.List;

public class Baraja {
	//atributuak
	private ListaKartak lista;
	private static Baraja nireBaraja=null;

	//gainontzeko metodoak
	
	public static Baraja getNireBaraja() {
		if (nireBaraja==null) {
			nireBaraja=new Baraja();
		}
		return nireBaraja;
	}
	
	public void multzoaSortu() {
		for(int i=1; i<=10;i++) {
			lista.gehituKarta(new Karta(i,"URREA"));
			lista.gehituKarta(new Karta(i,"KOPAK"));
			lista.gehituKarta(new Karta(i,"EZPATAK"));
			lista.gehituKarta(new Karta(i,"BASTOIAK"));
		}
		lista.setKartaKop(40);
	}
	
	public void reset() {
		lista.erreseteatu();
		multzoaSortu();
	}
	
	public void banaketa(Jokalaria[] mano) {
		
		mano.setk1(getKarta());
		mano.setk2(getKarta());
		mano.setk3(getKarta());
	}
	
	
	
	
	
	
}

