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
		this.getKonbinazioak().konbinazioOnena();
	}
	public void turnoaBukatu(){
		MahaikoKartak.getNireMahaikoKartak().gehituKarta(this.baloreGutxiengoKarta());
		System.out.println("Zure txanda da...");
	}
	public Karta baloreGutxiengoKarta(){
		int i=this.getEskukoKartak().getKartaKop();
		Karta k=null;
		Karta kt=this.getEskukoKartak().getKarta(i);
		String ktp=kt.getPalo();
		int ktz=kt.getZenb();
		while (i>0){
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
			i--;
		}
		return kt;
	}
}
