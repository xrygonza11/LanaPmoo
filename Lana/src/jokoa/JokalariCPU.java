package jokoa;

public class JokalariCPU extends Jokalaria {
	//atributuak
	private String izena;
	//eraikitzaileak
	public JokalariCPU(){
		super();
		this.izena="CPU";
	}
	//gainontzeko metodoak
	
	public void jokaldiaEgin(){
		if(MahaikoKartak.getNireMahaikoKartak().getKartaKop()==0){
			turnoaBukatu();
		}
		else{
			Konbinazioak k=this.getKonbinazioak();
			boolean a=k.konbinazioOnena();
			 if(!a) {
			 	turnoaBukatu();
			 }else {
				 //ListaKartak jk=this.getJokaldikoKartak();
				 //(jk.imprimatuKartak();
				 ListaKartak lk=this.getLortutakoKartak();
				 //ListaJokalariak.getNireListaJokalariak().getZerrenda()[1].getJokaldikoKartak().imprimatuKartak();
				 //ListaJokalariak.getNireListaJokalariak().getZerrenda()[1].getLortutakoKartak().imprimatuKartak();
				 for(int i=0;i<lk.getKartaKop();i++) {
					 for(int j=0;j<MahaikoKartak.getNireMahaikoKartak().getKartaKop();j++) {
						 if(lk.getKarta(i).getPalo()==MahaikoKartak.getNireMahaikoKartak().lortuPosiziokoKarta(j).getPalo() && lk.getKarta(i).getZenb()==MahaikoKartak.getNireMahaikoKartak().lortuPosiziokoKarta(j).getZenb()) {
							 MahaikoKartak.getNireMahaikoKartak().kenduKartaPos(j);
						 }
					 }
					  
				 }
				 System.out.println("CPU-k konbinazio bat egin du");
			 }
	}
    }
	public void turnoaBukatu(){
		MahaikoKartak.getNireMahaikoKartak().gehituKarta(this.baloreGutxiengoKarta());
		System.out.println("CPU-k ez du konbinaziorik lortu");
		System.out.println("Zure txanda da...");
	}
	public Karta baloreGutxiengoKarta(){
		int i=0;
		Karta k=null;
		Karta kt=this.getEskukoKartak().getKarta(i);
		String ktp=kt.getPalo();
		int ktz=kt.getZenb();
		while (i<this.getEskukoKartak().getKartaKop()){
			k=this.getEskukoKartak().getKarta(i);
			String p=k.getPalo();
			int z=k.getZenb();
			if (p!="Urrea" && z!=7){
				if (z!=7){
					if(p!="Urrea"){
						if(ktz>z){
							kt=k;
						}
					}
					else 
						if(ktp=="Urrea"){
							if(ktz>z){
								kt=k;
							}
						}
						else if(ktz>z){
							kt=k;
						}
				}			
			}
			i++;
		}
		return kt;
	}
}
