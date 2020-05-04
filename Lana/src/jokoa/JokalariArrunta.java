package jokoa;


public class JokalariArrunta extends Jokalaria{
	//eraikitzaileak
	private String izena;
	private int saiakerak=3;
	public JokalariArrunta(String pS){
		super();
		this.izena=pS;	
	}
	//gainontzeko metodoak
	public void imprimatuEskua(){
		System.out.println("Zure Eskuko Kartak:");
		this.getEskukoKartak().imprimatuKartak();
	}
	public int getSaiakerak() {
		return this.saiakerak;
	}
	private void saiakerakBerrabiarazi() {
		this.saiakerak=3;
	}
	public void jokaldiaEgin(){
		Karta k=null;
		int jokaldiPuntuak=0;
		try {
			if(this.saiakerak<=0) {
				throw new SaiakeraMaximoakGainditutaSalbuespena();
			}
		}catch(SaiakeraMaximoakGainditutaSalbuespena e) {
			e.inprimatuMezua();
			turnoaBukatu();
		}
		while(this.saiakerak>0) {
		System.out.println(izena+" "+this.saiakerak+" geratzen zaizkizu.");
		MahaikoKartak.getNireMahaikoKartak().imprimatuKartak();
		System.out.println(" ");
		this.imprimatuEskua();
		System.out.println( izena+ "Egin Zure Jokaldia");
		System.out.println("Aukeratu Eskuko Karta");
		k=this.aukeratuEskukoKarta();
		jokaldiPuntuak=jokaldiPuntuak+k.getZenb();
		aukeratuMahaikoKartak(jokaldiPuntuak);
		}
		this.saiakerakBerrabiarazi();
	}
	public Karta aukeratuEskukoKarta(){
		Karta k=null;
		int aukera=0;
		Boolean denaOndo=false;
		Teklatua.getNireTeklatua().irakurriEnter();
		String sarrera=Teklatua.getNireTeklatua().irakurriString();
		try {
			aukera=Integer.parseInt(sarrera);
			denaOndo=true;
		}catch(NumberFormatException e) {
			System.out.println("Sarrera zenbaki bat izan behar da.");
			this.aukeratuEskukoKarta();
		}
		if(denaOndo) {
			k=getEskukoKartak().getKarta(aukera);
			try {
			if(k==null) {
				throw new AukeratutakoKartaOkerraSalbuespena();
			}
			}catch(AukeratutakoKartaOkerraSalbuespena e){
				e.inprimatuMezua();
				this.aukeratuEskukoKarta();
			}
			}
		return k;
		}
		
	public void aukeratuMahaikoKartak(int pJokaldiPuntuak){
		Karta k2=null;
		int aukera=0;
		Boolean denaOndo=false;
		char baieztapena=0;
		Teklatua.getNireTeklatua().irakurriEnter();
		String sarrera=Teklatua.getNireTeklatua().irakurriString();
		do {
		try {
			aukera=Integer.parseInt(sarrera);
			denaOndo=true;
		}catch(NumberFormatException e) {
			System.out.println("Sarrera zenbaki bat izan behar da.");
			this.aukeratuMahaikoKartak(pJokaldiPuntuak);
		}
		if(denaOndo) {
			k2= MahaikoKartak.getNireMahaikoKartak().lortuPosiziokoKarta(aukera);
			if(k2==null) {
				System.out.println("Aukeratutako posizioan ez dago kartarik, aukeratu beste bat.");
				this.aukeratuMahaikoKartak(pJokaldiPuntuak);
			}
			this.getJokaldikoKartak().gehituKarta(k2);
			MahaikoKartak.getNireMahaikoKartak().kenduKartaPos(aukera);
			pJokaldiPuntuak=pJokaldiPuntuak+k2.getZenb();
			System.out.println("Karta gehiago aukeratu nahi dituzu? Bai(b)/Ez(e)");
			baieztapena=Teklatua.getNireTeklatua().irakurriChar();
			if(baieztapena=='b') {
				this.aukeratuMahaikoKartak(pJokaldiPuntuak);
			}
		}
		}while(baieztapena!='e');
		if(pJokaldiPuntuak!=15) {
			System.out.println("Jokaldiak ez du balio");
			this.saiakerak--;
			while(this.getJokaldikoKartak().getKartaKop()>0){
				int i=this.getJokaldikoKartak().getKartaKop();
				k2=this.getJokaldikoKartak().getKarta(i);
				MahaikoKartak.getNireMahaikoKartak().gehituKarta(k2);
				this.getJokaldikoKartak().kenduKarta(i);
				i--;
			}
			this.jokaldiaEgin();
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
	public void turnoaBukatu(){
		System.out.println("Txanda bukatuko da, aukeratu karta bat mahaira botatzeko");
		this.imprimatuEskua();
		Karta k=null;
		int aukera=0;
		Boolean denaOndo=false;
		Teklatua.getNireTeklatua().irakurriEnter();
		String sarrera=Teklatua.getNireTeklatua().irakurriString();
		try {
			aukera=Integer.parseInt(sarrera);
			denaOndo=true;
		}catch(NumberFormatException e) {
			System.out.println("Sarrera zenbaki bat izan behar da.");
			this.turnoaBukatu();
		}
		if(denaOndo) {
			k=getEskukoKartak().getKarta(aukera);
			if(k==null) {
				System.out.println("Aukeratutako posizioan ez dago kartarik, aukeratu beste bat.");
				this.turnoaBukatu();
			}
		}
		MahaikoKartak.getNireMahaikoKartak().gehituKarta(k);
		this.getEskukoKartak().kenduKarta(aukera);
	}

}
