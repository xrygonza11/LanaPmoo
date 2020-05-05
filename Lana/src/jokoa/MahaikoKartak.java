package jokoa;

public class MahaikoKartak {
	//atributuak
		private ListaKartak lista;
		private static MahaikoKartak nireMahaikoKartak=null;
		private int kartaKop;
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
				this.kartaKop=this.kartaKop+1;
			}
		}
		public void erreseteatu(){
			this.lista.erreseteatu();
			this.kartaKop=0;
		}
		public ListaKartak getMahaikoKartak() {
			return this.lista;
		}
		public Karta lortuPosiziokoKarta(int pPos){
			return this.lista.getKarta(pPos);
		}
		public int getKartaKop() {
			return this.kartaKop;
		}
		public void gehituKarta(Karta k){
			this.lista.gehituKarta(k);
			this.kartaKop=this.kartaKop+1;
		}
		public void imprimatuKartak(){
			System.out.println("Mahaiko Kartak:");
			System.out.println(" ");
			this.lista.imprimatuKartak();
		}
		public void kenduKartaPos(int pPos) {
			this.lista.kenduKarta(pPos);
			this.kartaKop=this.kartaKop-1;
		}
		public int banatzeanEskobaKop() {
			int eskobakop=0;
			Karta k=null;
			int  kartenBalioa=0;
			int i=0;
			while(i<this.lista.getKartaKop()) {
				k=this.lista.getKarta(i);
				kartenBalioa=kartenBalioa+k.getZenb();
				i++;
			}
			if(kartenBalioa==15) {
				eskobakop=1;
			}else{
				if(kartenBalioa==30){
					eskobakop=2;
			}	
			}
			return eskobakop;
		}
}
