package jokoa;

import java.util.ArrayList;
import java.util.Iterator;

public class Konbinazioak{
		//atributuak
		private ArrayList<ListaKartak> lista;
		private int konbiKop;
		private static Konbinazioak nireKonbinazioak=null;
		//gainontzeko metodoak
		
		public static Konbinazioak getNireKonbinazioak() {
			if (nireKonbinazioak==null){	
				nireKonbinazioak=new Konbinazioak();
			}
			return nireKonbinazioak;
		}

		private Iterator<ListaKartak> getIteradorea(){
			return this.lista.iterator();
		}
		public void gehituKonbinazio(ListaKartak pKonbi){
			this.lista.add(pKonbi);
		}
		public void konbinazioEraketa(){
			//??
		}
		public ListaKartak konbinazioOnena(){
			//??
		}
		public void erreseteatu(){
			this.lista.clear();
		}
}
