package jokoa;

public class Konbinazioak{
		//atributuak
		private static Konbinazioak nireKonbinazioak=null;
		private boolean aurkitua=false;
		private ListaKartak konbiKartak;
		//eraikitzailea
		private Konbinazioak() {
			konbiKartak=new ListaKartak();
		}
		//gainontzeko metodoak
		
		public static Konbinazioak getNireKonbinazioak() {
			if (nireKonbinazioak==null){	
				nireKonbinazioak=new Konbinazioak();
			}
			return nireKonbinazioak;
		}

		public ListaKartak getKonbiKartak(){
			return konbiKartak;
		}
		public boolean konbinazioOnena(){
			int i=0;
			ListaKartak lk=ListaJokalariak.getNireListaJokalariak().getZerrenda()[1].getEskukoKartak();
			ListaKartak jk=ListaJokalariak.getNireListaJokalariak().getZerrenda()[1].getJokaldikoKartak();
			ListaKartak gk=ListaJokalariak.getNireListaJokalariak().getZerrenda()[1].getLortutakoKartak();
			while(i<lk.getKartaKop()&&!aurkitua) {
				Karta k=lk.getKarta(i);
				konbinazioakEgin(0,0,15-k.getZenb(),jk,MahaikoKartak.getNireMahaikoKartak().getMahaikoKartak());
				i++;
			}
			Karta k=lk.getKarta(i-1);
			if(aurkitua) {
				gk.gehituKarta(k);
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
		private void konbinazioakEgin(int l, int sum, int K, ListaKartak local,ListaKartak A){ 
			// If a unique combination is found 

			if (sum == K)  { 
				konbiKartak=local;
				aurkitua=true;
				for(int i=0;i<local.getKartaKop();i++) {
					Karta k=local.getKarta(i);
					ListaJokalariak.getNireListaJokalariak().getZerrenda()[1].getLortutakoKartak().gehituKarta(k);
				}
				//hacer que local sea el array del jokaldi
				//aurkitua true
				//ListaJokalariak.getNireListaJokalariak().getZerrenda()[1].getLortutakoKartak().imprimatuKartak();
				return; 
			} 

			// For all other combinations 
			for (int i = l; i < A.getKartaKop(); i++){ 

				// Check if the sum exceeds K 
				//if (sum + A.getKarta(i).getZenb() > K) 
					//continue; 

				// Check if it is repeated or not 
				//if (i == 1 && A.getKarta(i).getZenb() == A.getKarta(i - 1).getZenb() &&  i > l) 
					//continue; 

				// Take the element into the combination 
				local.gehituKarta(A.getKarta(i)); 

				// Recursive call 
				if(!aurkitua)
				konbinazioakEgin(i + 1, sum + A.getKarta(i).getZenb(), K, local, A); 

				// Remove element from the combination 
				local.kenduKarta(local.getKartaKop() - 1); 
			} 
		}
}
