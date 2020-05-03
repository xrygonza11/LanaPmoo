package jokoa;
import java.util.Iterator;
import java.util.ArrayList;

public class ListaJokalariak {
	//atributuak
	private Jokalaria[]lista;
	private static ListaJokalariak nireListaJokalariak=null;
	private int Gehienezko_puntuazioa=21;
	//eraikitzailea
	private ListaJokalariak() {
		this.lista= new Jokalaria[2];
	}
	//gainontzeko metodoak
	
	public static ListaJokalariak getNireListaJokalariak() {
		if (nireListaJokalariak==null) {
			nireListaJokalariak=new ListaJokalariak();
		}
		return nireListaJokalariak;
	}
	public Jokalaria[] getZerrenda() {
		return lista;
	}
	
	public void partidaJolastu(){
	while(!bukaera()){
		rondaJolastu();
		rondaBukatu();
	}
	}
	
	
	
	
	public boolean bukaera() {
		return  this.getZerrenda()[0].getPuntuak()>= Gehienezko_puntuazioa || this.getZerrenda()[1].getPuntuak()>= Gehienezko_puntuazioa;
	}
	public void rondaJolastu(){
		this.kartakBanatu();
		MahaikoKartak.getNireMahaikoKartak().banatuLau();
		int i=MahaikoKartak.getNireMahaikoKartak().banatzeanEskobaKop();
		this.lista[0].puntuakGehitu(i);
		
	}
	public void rondaBukatu(){
		this.getZerrenda()[0].puntuakGehitu(this.getZerrenda()[0].puntuenBanaketa());
		this.getZerrenda()[1].puntuakGehitu(this.getZerrenda()[1].puntuenBanaketa());
	}
	public void kartakBanatu(){
		int kont=3;
		while(kont>0) {
			Karta k=null;
			k=Baraja.getNireBaraja().banaketa();
			this.getZerrenda()[0].getEskukoKartak().gehituKarta(k);
			k=Baraja.getNireBaraja().banaketa();
			this.getZerrenda()[1].getEskukoKartak().gehituKarta(k);
		}
	}
	public boolean eskobaDa() {
		boolean eskoba=false;
		if(MahaikoKartak.getNireMahaikoKartak()==null) {
			eskoba=true;
		}
		return eskoba;
	}





}




