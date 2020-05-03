package jokoa;
import java.util.Iterator;
import java.util.ArrayList;

public class ListaJokalariak {
	//atributuak
	private ArrayList<Jokalaria> lista;
	private static ListaJokalariak nireListaJokalariak=null;
	private int Gehienezko_puntuazioa=21;
	private Baraja b;
	//gainontzeko metodoak
	
	public static ListaJokalariak getNireListaJokalariak() {
		if (nireListaJokalariak==null) {
			nireListaJokalariak=new ListaJokalariak();
		}
		return nireListaJokalariak;
	}
	private Iterator<Jokalaria> getIteradorea(){
		return this.lista.iterator();
	}
	
	public void partidaJolastu(){
	while(!bukaera()){
		rondaJolastu();
	}
	}
	
	
	
	
	public boolean bukaera() {
		return  getJokalari1Puntuak()>= Gehienezko_puntuazioa || getJokalari2Puntuak()>= Gehienezko_puntuazioa;
	}
	public void rondaJolastu(){
		
	}
	public void rondaBukatu(){
		Jokalaria j=null;
		Iterator itr=this.getIteradorea();
		while(itr.hasNext()){
			j=itr.next();
			j.puntuakGehitu(j.puntuenBanaketa());
		}
	}
	public void kartakBanatu(){
		int kont=3;
		
	}






}




