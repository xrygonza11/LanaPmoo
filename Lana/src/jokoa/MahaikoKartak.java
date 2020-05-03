package jokoa;

import java.util.ArrayList;
import java.util.Iterator;

public class MahaikoKartak {
	//atributuak
		private ListaKartak lista;
		private static MahaikoKartak nireMahaikoKartak=null;
		private Konbinazioak konbi;
		private int kartaKop;
		
	//gainontzeko metodoak
		public static MahaikoKartak getNireMahaikoKartak() {
			if (nireMahaikoKartak==null) {
				nireMahaikoKartak=new MahaikoKartak();
			}
			return nireMahaikoKartak;
		}
		public void banatuLau(Baraja b){
			int kont=4;
			while (kont>0){
				this.lista.gehituKarta(b.banaketa());
				kont=kont-1;
				this.kartaKop=this.kartaKop+1;
			}
		}
		public void erreseteatu(){
			this.lista.erreseteatu();
			this.konbi.erreseteatu();
			this.kartaKop=0;
		}
		
		public Karta lortuPosiziokoKarta(int pPos){
			return this.lista.getKarta(pPos);
		}
		
		public void gehituKarta(Karta k){
			this.lista.gehituKarta(k);
			this.kartaKop=this.kartaKop+1;
		}
		public void imprimatuKartak(){
			System.out.println("Mahaiko Kartak:");
			this.lista.imprimatuKartak();
		}
}
