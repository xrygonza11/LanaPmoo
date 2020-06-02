package jokoa;

import java.util.ArrayList;
import java.util.Iterator;

public class Matrizea {
	//atributuak
	private ArrayList<ListaKartak> matrize;
	//eraikitzailea
	public Matrizea(){
		matrize=new ArrayList<ListaKartak>();
	}
	//gainontzeko metodoak
	public ListaKartak getLista(int pPos) {
		ListaKartak l = matrize.get(pPos);
		return l;		
	}
	public void kenduLista(int pPos){
		matrize.remove(pPos);
	}
	public void gehituLista(ListaKartak lista) {
		matrize.add(lista);
	}
	private Iterator<ListaKartak> getIteradorea() {
		return this.matrize.iterator();
	}
	public void erreseteatu() {
		matrize.clear();
	}
	public void puntuazioakEman() {
		Iterator<ListaKartak> litr= this.getIteradorea();
		ListaKartak l=null;
		Karta k=null;
		while(litr.hasNext()) {
			l=litr.next();
			l.gehituPuntuazioa(l.getKartaKop());
			Iterator<Karta> itr=l.getIteradorea();
			while(itr.hasNext()) {
				k=itr.next();
				if(k.getPalo()=="URREA") {
					l.gehituPuntuazioa(1);
				}
				if(k.getZenb()==7) {
					l.gehituPuntuazioa(1);
				}
			}
		}
	}
	public int puntuazioAltuenaAukeratu() {
		Iterator<ListaKartak> itr=this.getIteradorea();
		ListaKartak l=null;
		int aux=0;
		int i=0;
		int puntuazioa=0;
		while(itr.hasNext()) {
			l=itr.next();
			if(l.getPuntuazioa()>puntuazioa) {
				i=aux;
				puntuazioa=l.getPuntuazioa();
			}
			aux++;
		}
		return i;
	}
	public void imprimatuMatrizea() {
		Iterator<ListaKartak> itr=this.getIteradorea();
		ListaKartak l=new ListaKartak();
		while(itr.hasNext()) {
			l=itr.next();
			l.imprimatuKartak();
		}
	}

}
