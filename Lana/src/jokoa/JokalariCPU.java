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
		Konbinazioak k=this.getKonbinazioak();
		boolean a=k.konbinazioOnena();
		 if(!a) {
		 	turnoaBukatu();
		 }else {
			 //ListaKartak jk=this.getJokaldikoKartak();
			 //(jk.imprimatuKartak();
			 ListaKartak jk=this.getJokaldikoKartak();
			 //ListaJokalariak.getNireListaJokalariak().getZerrenda()[1].getJokaldikoKartak().imprimatuKartak();
			 //ListaJokalariak.getNireListaJokalariak().getZerrenda()[1].getLortutakoKartak().imprimatuKartak();
			for(int j=0;j<MahaikoKartak.getNireMahaikoKartak().getMahaikoKartak().getKartaKop();j++) {
				if(jk.getKarta(0).getPalo()==MahaikoKartak.getNireMahaikoKartak().getMahaikoKartak().getKarta(j).getPalo() && jk.getKarta(0).getZenb()==MahaikoKartak.getNireMahaikoKartak().getMahaikoKartak().getKarta(j).getZenb()) {
					MahaikoKartak.getNireMahaikoKartak().getMahaikoKartak().kenduKarta(j);
					jk.kenduKarta(0);
				}
				  
			}
			for(int h=0;h<this.getEskukoKartak().getKartaKop();h++) {
				if(jk.getKarta(0).getPalo()==this.getEskukoKartak().getKarta(h).getPalo() && jk.getKarta(0).getZenb()==this.getEskukoKartak().getKarta(h).getZenb()) {
					this.getEskukoKartak().kenduKarta(h);
					jk.kenduKarta(0);
				}
			}
			System.out.println(izena+"-k konbinazio bat egin du");
		 }
	}
	public void turnoaBukatu(){
		MahaikoKartak.getNireMahaikoKartak().getMahaikoKartak().gehituKarta(this.baloreGutxiengoKarta());
		System.out.println(izena+"-k ez du konbinaziorik lortu");
		System.out.println("Zure txanda da...");
	}
	private Karta baloreGutxiengoKarta(){
		int i=0;
		int aux=0;
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
							aux=i;
						}
					}
					else 
						if(ktp=="Urrea"){
							if(ktz>z){
								kt=k;
								aux=i;
							}
						}
						else if(ktz>z){
							kt=k;
							aux=i;
						}
				}			
			}
			i++;
		}
		this.getEskukoKartak().kenduKarta(aux);
		return kt;
	}
}
