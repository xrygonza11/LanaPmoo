package jokoa;

public class ListaJokalariak {
	//atributuak
	private Jokalaria[]lista;
	private static ListaJokalariak nireListaJokalariak=null;
	private int Gehienezko_puntuazioa=21;
	
	//eraikitzailea
	private ListaJokalariak() {
		this.lista= new Jokalaria[2];
	}
	//gainontzeko metodoak
	
	public static synchronized ListaJokalariak getNireListaJokalariak() {
		if (ListaJokalariak.nireListaJokalariak==null) {
			ListaJokalariak.nireListaJokalariak=new ListaJokalariak();
		}
		return ListaJokalariak.nireListaJokalariak;
	}
	public Jokalaria[] getZerrenda() {
		return lista;
	}
	
	public void partidaJolastu(){
		clear();
		System.out.println("Sartu zure izena");
		String izena=Teklatua.getNireTeklatua().irakurriString();
		ListaJokalariak.getNireListaJokalariak().getZerrenda()[0]=new JokalariArrunta(izena);
		ListaJokalariak.getNireListaJokalariak().getZerrenda()[1]=new JokalariCPU();
		this.getZerrenda()[0].puntuakErreseteatu();
		this.getZerrenda()[1].puntuakErreseteatu();
		while(!bukaeraKonprobatu()){
			rondaJolastu();
			rondaBukatu();
		}
		if(this.getZerrenda()[0].getPuntuak()>= Gehienezko_puntuazioa && this.getZerrenda()[1].getPuntuak()>= Gehienezko_puntuazioa) {
			rondaExtraJolastu();
		}
		if(this.getZerrenda()[0].getPuntuak()>this.getZerrenda()[1].getPuntuak()) {
			System.out.println("ZORIONAK IRABAZI DUZU!!");
		}else {
			if(this.getZerrenda()[1].getPuntuak()>this.getZerrenda()[0].getPuntuak()) {
				System.out.println("ZORTE TXARRA, GALDU DUZU");
			}
		}
	}
	
	public void rondaExtraJolastu() {
		rondaJolastu();
		rondaBukatu();
		if(this.getZerrenda()[0].getPuntuak()>this.getZerrenda()[1].getPuntuak()) {
			System.out.println("ZORIONAK IRABAZI DUZU!!");
		}else {
			if(this.getZerrenda()[1].getPuntuak()>this.getZerrenda()[0].getPuntuak()) {
				System.out.println("ZORTE TXARRA, GALDU DUZU");
			}else {
				rondaExtraJolastu();
			}
		}
	}
	
	
	public boolean bukaeraKonprobatu() {
		boolean b=false;
		if(this.getZerrenda()[0].getPuntuak()>= Gehienezko_puntuazioa || this.getZerrenda()[1].getPuntuak()>= Gehienezko_puntuazioa) {
			b=true;
		}
		return b;
	}
	public void rondaJolastu(){
		this.jokoaBerrabiarazi();
		this.kartakBanatu();
		MahaikoKartak.getNireMahaikoKartak().banatuLau();
		int i=MahaikoKartak.getNireMahaikoKartak().banatzeanEskobaKop();
		this.lista[0].puntuakGehitu(i);
		while(!rondarenBukaeraKonprobatu()) {
			while(!banaketaBeharrezkoaDa()) {
				clear();
				this.getZerrenda()[0].jokaldiaEgin();
				this.getZerrenda()[1].jokaldiaEgin();
			}
			this.kartakBanatu();
		}
		
	}
	public boolean rondarenBukaeraKonprobatu() {
		boolean b=false;
		if(this.getZerrenda()[0].getEskukoKartak().getKartaKop()==0 && this.getZerrenda()[1].getEskukoKartak().getKartaKop()==0 && Baraja.getNireBaraja().getBaraja().getKartaKop()==0) {
			b=true;
		}
		return b;
	}
	public boolean banaketaBeharrezkoaDa() {
		boolean b=false;
		if(this.getZerrenda()[0].getEskukoKartak().getKartaKop()==0 && this.getZerrenda()[1].getEskukoKartak().getKartaKop()==0) {
			b=true;
		}
		return b;
	}
	public void rondaBukatu(){
		this.getZerrenda()[0].puntuakGehitu(this.getZerrenda()[0].puntuenBanaketa());
		this.getZerrenda()[1].puntuakGehitu(this.getZerrenda()[1].puntuenBanaketa());
	}
	public void kartakBanatu(){
		int kont=3;
		while(kont>0) {
			Karta k=null;
			k=Baraja.getNireBaraja().banaketa();
			this.getZerrenda()[0].getEskukoKartak().gehituKarta(k);
			k=Baraja.getNireBaraja().banaketa();
			this.getZerrenda()[1].getEskukoKartak().gehituKarta(k);
			kont--;
		}
	}
	public boolean eskobaDa() {
		boolean eskoba=false;
		if(MahaikoKartak.getNireMahaikoKartak().getKartaKop()==0) {
			eskoba=true;
		}
		return eskoba;
	}
	public void jokoaBerrabiarazi() {
		this.getZerrenda()[0].denaErreseteatu();
		this.getZerrenda()[1].denaErreseteatu();
		MahaikoKartak.getNireMahaikoKartak().erreseteatu();
		Baraja.getNireBaraja().reset();
		
	}
	public static void clear() {
		try {
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}catch(Exception E) {
			System.out.println(E);
		}
	}





}




