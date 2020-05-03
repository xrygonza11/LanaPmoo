package jokoa;


public class JokalariArrunta extends Jokalaria{
	//eraikitzaileak
	private String izena;
	private int saiakerak=3;
	public JokalariArrunta(Teklatua tk){
		String s=tk.irakurriString();
		this.izena=s;
	}
	//gainontzeko metodoak
	public void imprimatuEskua(){
		System.out.println("Zure Eskuko Kartak:");
		this.getEskukoKartak().imprimatuKartak();
	}
	public int getSaiakerak() {
		return this.saiakerak;
	}
	public void jokaldiaegin(Teklatua tk,int pSaiakerak)throws SaiakeraMaximoakGainditutaSalbuespena{
		Karta k=null;
		int jokaldiPuntuak=0;
		try {
			if(saiakerak<=0) {
				throw new SaiakeraMaximoakGainditutaSalbuespena();
			}
		}catch(SaiakeraMaximoakGainditutaSalbuespena e) {
			e.inprimatuMezua();
			turnoaBukatu(tk);
		}
		while(pSaiakerak>0) {
		System.out.println(izena+" "+pSaiakerak+" geratzen zaizkizu.");
		MahaikoKartak.getNireMahaikoKartak().imprimatuKartak();
		System.out.println(" ");
		this.imprimatuEskua();
		System.out.println( izena+ "Egin Zure Jokaldia");
		System.out.println("Aukeratu Eskuko Karta");
		k=this.aukeratuEskukoKarta(tk);
		jokaldiPuntuak=jokaldiPuntuak+k.getZenb();
		aukeratuMahaikoKartak(tk,pSaiakerak,jokaldiPuntuak);
		}
	}
	public Karta aukeratuEskukoKarta(Teklatua tk){
		Karta k=null;
		int aukera=0;
		Boolean denaOndo=false;
		tk.irakurriEnter();
		String sarrera=tk.irakurriString();
		try {
			aukera=Integer.parseInt(sarrera);
			denaOndo=true;
		}catch(NumberFormatException e) {
			System.out.println("Sarrera zenbaki bat izan behar da.");
			this.aukeratuEskukoKarta(tk);
		}
		if(denaOndo) {
			k=getEskukoKartak().getKarta(aukera);
			if(k==null) {
				System.out.println("Aukeratutako posizioan ez dago kartarik, aukeratu beste bat.");
				this.aukeratuEskukoKarta(tk);
			}
		}
		return k;
	}
	public void aukeratuMahaikoKartak(Teklatua tk, int pSaiakerak,int pJokaldiPuntuak) throws SaiakeraMaximoakGainditutaSalbuespena{
		Karta k2=null;
		int aukera=0;
		Boolean denaOndo=false;
		char baieztapena=0;
		tk.irakurriEnter();
		String sarrera=tk.irakurriString();
		do {
		try {
			aukera=Integer.parseInt(sarrera);
			denaOndo=true;
		}catch(NumberFormatException e) {
			System.out.println("Sarrera zenbaki bat izan behar da.");
			this.aukeratuMahaikoKartak(tk, pSaiakerak,pJokaldiPuntuak);
		}
		if(denaOndo) {
			k2= MahaikoKartak.getNireMahaikoKartak().lortuPosiziokoKarta(aukera);
			if(k2==null) {
				System.out.println("Aukeratutako posizioan ez dago kartarik, aukeratu beste bat.");
				this.aukeratuMahaikoKartak(tk,pSaiakerak,pJokaldiPuntuak);
			}
			this.getJokaldikoKartak().gehituKarta(k2);
			MahaikoKartak.getNireMahaikoKartak().kenduKartaPos(aukera);
			pJokaldiPuntuak=pJokaldiPuntuak+k2.getZenb();
			System.out.println("Karta gehiago aukeratu nahi dituzu? Bai(b)/Ez(e)");
			baieztapena=tk.irakurriChar();
			if(baieztapena=='b') {
				this.aukeratuMahaikoKartak(tk, pSaiakerak,pJokaldiPuntuak);
			}
		}
		}while(baieztapena!='e');
		if(pJokaldiPuntuak!=15) {
			System.out.println("Jokaldiak ez du balio");
			pSaiakerak--;
			while(this.getJokaldikoKartak().getKartaKop()>0){
				int i=this.getJokaldikoKartak().getKartaKop();
				k2=this.getJokaldikoKartak().getKarta(i);
				MahaikoKartak.getNireMahaikoKartak().gehituKarta(k2);
				this.getJokaldikoKartak().kenduKarta(i);
				i--;
			}
			this.jokaldiaegin(tk,pSaiakerak);
		}else {
			while(this.getJokaldikoKartak().getKartaKop()>0){
				int i=this.getJokaldikoKartak().getKartaKop();
				k2=this.getJokaldikoKartak().getKarta(i);
				this.getLortutakoKartak().gehituKarta(k2);
				this.getJokaldikoKartak().kenduKarta(i);
				i--;
			}
		}
		
	}
	public void turnoaBukatu(Teklatua tk){
		System.out.println("Txanda bukatuko da, aukeratu karta bat mahaira botatzeko");
		this.imprimatuEskua();
		Karta k=null;
		int aukera=0;
		Boolean denaOndo=false;
		tk.irakurriEnter();
		String sarrera=tk.irakurriString();
		try {
			aukera=Integer.parseInt(sarrera);
			denaOndo=true;
		}catch(NumberFormatException e) {
			System.out.println("Sarrera zenbaki bat izan behar da.");
			this.turnoaBukatu(tk);
		}
		if(denaOndo) {
			k=getEskukoKartak().getKarta(aukera);
			if(k==null) {
				System.out.println("Aukeratutako posizioan ez dago kartarik, aukeratu beste bat.");
				this.turnoaBukatu(tk);
			}
		}
		MahaikoKartak.getNireMahaikoKartak().gehituKarta(k);
		this.getEskukoKartak().kenduKarta(aukera);
	}

}
