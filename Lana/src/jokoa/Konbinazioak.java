package jokoa;

import java.util.Iterator;

public class Konbinazioak{
		//atributuak
		private static Konbinazioak nireKonbinazioak=null;
		private boolean aurkitua=false;
		private Matrizea konbiKartak;
		//gainontzeko metodoak
		
		public static Konbinazioak getNireKonbinazioak() {
			if (nireKonbinazioak==null){	
				nireKonbinazioak=new Konbinazioak();
			}
			return nireKonbinazioak;
		}
		private Konbinazioak() {
			konbiKartak=new Matrizea();
		}

		public boolean konbinazioOnena(){
			int i=0;
			konbiKartak.erreseteatu();
			ListaKartak lk=ListaJokalariak.getNireListaJokalariak().getZerrenda()[1].getEskukoKartak();
			ListaKartak jk=ListaJokalariak.getNireListaJokalariak().getZerrenda()[1].getJokaldikoKartak();
			while(i<lk.getKartaKop()) {
				Karta k=lk.getKarta(i);
				konbinazioakEgin(0,0,15-k.getZenb(),jk,MahaikoKartak.getNireMahaikoKartak().getMahaikoKartak(),konbiKartak,k);
				i++;
			}
			if(aurkitua) {
				konbinazioOnenaAukeratu();
			}
			return aurkitua;
			/*
			 coger primera carta y comprobar
			 "" segunda ""
			 "" tercera ""
			 lk=geteskukokartak
			 while i<lk.kartakop&&!aurkitua
			 	k= lk.get(i)
			 	unique_conbinations(0,0,15-k.getzenb(),this.getJokaldikoKartak,Mahaikokartak.getNiremahaikokartak)
			 if(aurkitua)
			 	getLortutakoKartak.gehitukarta(k)
			 return aurkitua
			 */
			
		}
		private void konbinazioakEgin(int l, int sum, int K, ListaKartak local,ListaKartak A, Matrizea matrize, Karta karta){ 
			// If a unique combination is found 

			if (sum == K)  { 
				local.gehituKarta(karta);
				local.imprimatuKartak();
				matrize.gehituLista(local);
				aurkitua=true;
				local.erreseteatu();
				sum=0;
				//hacer que local sea el array del jokaldi
				//aurkitua true
				//ListaJokalariak.getNireListaJokalariak().getZerrenda()[1].getLortutakoKartak().imprimatuKartak();
				//return; 
			}

			// For all other combinations 
			for (int i = l; i < A.getKartaKop(); i++){ 

				// Check if the sum exceeds K 
				if (sum + A.getKarta(i).getZenb() > K) 
					continue; 

				// Check if it is repeated or not 
				if (i == 1 && A.getKarta(i).getZenb() == A.getKarta(i - 1).getZenb() &&  i > l) 
					continue; 

				// Take the element into the combination 
				local.gehituKarta(A.getKarta(i)); 

				// Recursive call 
				//if(!aurkitua)
				konbinazioakEgin(i + 1, sum + A.getKarta(i).getZenb(), K, local, A, matrize,karta); 

				// Remove element from the combination
				if(local.getKartaKop()!=0) {
				local.kenduKarta(local.getKartaKop()-1); 
				}
			} 
		}
		private void konbinazioOnenaAukeratu() {
			konbiKartak.imprimatuMatrizea();
			konbiKartak.puntuazioakEman();
			ListaKartak l=konbiKartak.getLista(konbiKartak.puntuazioAltuenaAukeratu());
			l.imprimatuKartak();
			Iterator<Karta> itr=l.getIteradorea();
			Karta k=null;
			while(itr.hasNext()) {
				k=itr.next();
				k.imprimatuKarta();
				ListaJokalariak.getNireListaJokalariak().getZerrenda()[1].getLortutakoKartak().gehituKarta(k);
				ListaJokalariak.getNireListaJokalariak().getZerrenda()[1].getJokaldikoKartak().gehituKarta(k);
				ListaJokalariak.getNireListaJokalariak().getZerrenda()[1].getJokaldikoKartak().imprimatuKartak();
			}
			
		}
		public Matrizea getKonbiKartak() {
			return konbiKartak;
		}
}
