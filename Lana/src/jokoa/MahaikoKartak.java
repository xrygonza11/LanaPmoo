package jokoa;

import java.util.Iterator;

public class MahaikoKartak {
	//atributuak
		private ListaKartak lista;
		private static MahaikoKartak nireMahaikoKartak=null;
	//eraikitzaile
		public MahaikoKartak() {
			this.lista=new ListaKartak();
		}
	//gainontzeko metodoak
		public static MahaikoKartak getNireMahaikoKartak() {
			if (nireMahaikoKartak==null) {
				nireMahaikoKartak=new MahaikoKartak();
			}
			return nireMahaikoKartak;
		}
		public void banatuLau(){
			int kont=4;
			while (kont>0){
				this.lista.gehituKarta(Baraja.getNireBaraja().banaketa());
				kont=kont-1;
			}
		}
		public ListaKartak getMahaikoKartak() {
			return this.lista;
		}
		public void imprimatuKartak(){
			System.out.println("Mahaiko Kartak:");
			System.out.println(" ");
			this.lista.imprimatuKartak();
		}
		public int banatzeanEskobaKop() {
			int eskobakop=0;
			Karta k=null;
			int  kartenBalioa=0;
			Iterator<Karta>itr=lista.getIteradorea();
			while(itr.hasNext()) {
				k=itr.next();
				kartenBalioa=kartenBalioa+k.getZenb();
			}
			if(kartenBalioa==15) {
				eskobakop=1;
			}
			if(kartenBalioa==30){
				eskobakop=2;
			}	
			return eskobakop;
		}
}
