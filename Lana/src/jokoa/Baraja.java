package jokoa;

import java.util.Random;

public class Baraja {
	//atributuak
	private ListaKartak lista;
	private static Baraja nireBaraja=null;
	//eraikitzailea
	private Baraja() {
		lista=new ListaKartak();
	}

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
	
	public Karta banaketa() {
		Karta k=null;
		Random r=new Random();
		if(lista.getKartaKop()>1){
			int random=r.nextInt(lista.getKartaKop());
			k=lista.getKarta(random);
			lista.kenduKarta(random);
		}
		return k;
	}
	public ListaKartak getBaraja() {
		return lista;
	}
	
	
	
	
	
}

