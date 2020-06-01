package jokoa;


public class JokalariArrunta extends Jokalaria{
	//eraikitzaileak
	private String izena;
	private int saiakerak=3;
	private int aukera=0;
	private int jokaldiPuntuak=0;
	public JokalariArrunta(String pS){
		super();
		this.izena=pS;	
	}
	//gainontzeko metodoak
	public void imprimatuEskua(){
		System.out.println("Zure Eskuko Kartak:");
		System.out.println(" ");
		this.getEskukoKartak().imprimatuKartak();
	}
	public int getSaiakerak() {
		return this.saiakerak;
	}
	private void saiakerakBerrabiarazi() {
		this.saiakerak=3;
	}
	public void jokaldiaEgin(){
		char kartakBota=0;
		Karta k=null;
		jokaldiPuntuak=0;
		try {
			if(this.saiakerak<=0) {
				throw new SaiakeraMaximoakGainditutaSalbuespena();
			}
		}catch(SaiakeraMaximoakGainditutaSalbuespena e) {
			e.inprimatuMezua();
			turnoaBukatu();
		}
		System.out.println(izena+" "+this.saiakerak+" saiakerak geratzen zaizkizu.");
		MahaikoKartak.getNireMahaikoKartak().imprimatuKartak();
		System.out.println(" ");
		this.imprimatuEskua();
		System.out.println("Karten aukeraketa egin nahi duzu? Bai(b)/Ez(e)");
		kartakBota=Teklatua.getNireTeklatua().irakurriChar();
		while(kartakBota!='b'&&kartakBota!='e') {
			System.out.println("Karaktereak ez du balio, beste bat sartu");
			kartakBota=Teklatua.getNireTeklatua().irakurriChar();
		}
		if(kartakBota=='b') {
		System.out.println( izena+", egin zure jokaldia");
		System.out.println("Aukeratu eskuko karta");
		k=this.aukeratuEskukoKarta();
		jokaldiPuntuak=jokaldiPuntuak+k.getZenb();
		aukeratuMahaikoKartak();
		this.getEskukoKartak().kenduKarta(aukera-1);
		this.saiakerakBerrabiarazi();
		}
		else {
			turnoaBukatu();
		}
	}
	private Karta aukeratuEskukoKarta(){
		Karta k=null;
		Boolean denaOndo=false;
		String sarrera=Teklatua.getNireTeklatua().irakurriString();
		try {
			aukera=Integer.parseInt(sarrera);
			denaOndo=true;
		}catch(NumberFormatException e) {
			System.out.println("Sarrera zenbaki bat izan behar da.");
			this.aukeratuEskukoKarta();
		}
		if(denaOndo) {	
			try {
				k=getEskukoKartak().getKarta(aukera-1);
			}catch(IndexOutOfBoundsException e){
				System.out.println("Aukeratutako posizioan ez dago kartarik");
				this.aukeratuEskukoKarta();
			}
			}
		return k;
		}
		
	private void aukeratuMahaikoKartak(){
		//System.out.println("Orain mahaiko kartak aukeratu");
		//MahaikoKartak.getNireMahaikoKartak().imprimatuKartak();
		Karta k2=null;
		int aukera=0;
		Boolean denaOndo=false;
		char baieztapena=0;
		//String sarrera=Teklatua.getNireTeklatua().irakurriString();
		while(baieztapena!='e') {
			try {
				System.out.println("Orain mahaiko kartak aukeratu");
				MahaikoKartak.getNireMahaikoKartak().imprimatuKartak();
				String sarrera=Teklatua.getNireTeklatua().irakurriString();
				aukera=Integer.parseInt(sarrera);
				denaOndo=true;
			}catch(NumberFormatException e) {
				System.out.println("Sarrera zenbaki bat izan behar da.");
			}
			if(denaOndo) {
				denaOndo=false;
				mahaikoAukeraketaEgin(k2,aukera);
				System.out.println("Karta gehiago aukeratu nahi dituzu? Bai(b)/Ez(e)");
				baieztapena=Teklatua.getNireTeklatua().irakurriChar();
				while(baieztapena!='b'&&baieztapena!='e') {
					System.out.println("Karaktereak ez du balio, beste bat sartu");
					baieztapena=Teklatua.getNireTeklatua().irakurriChar();
				}
			}
		}
		if(jokaldiPuntuak!=15) {
			System.out.println("Jokaldiak ez du balio");
			this.saiakerak--;
			int i=0;
			for(i=1;i<this.getJokaldikoKartak().getKartaKop();i++) {//this.getJokaldikoKartak().getKartaKop()>0){
				//int i=this.getJokaldikoKartak().getKartaKop();
				k2=this.getJokaldikoKartak().getKarta(i-1);
				MahaikoKartak.getNireMahaikoKartak().getMahaikoKartak().gehituKarta(k2);
			}
			this.getJokaldikoKartak().erreseteatu();
			this.jokaldiaEgin();
		}else {
			//int i=0;
			for(int i=1;i<this.getJokaldikoKartak().getKartaKop();i++) {//(this.getJokaldikoKartak().getKartaKop()>0){
				//int i=this.getJokaldikoKartak().getKartaKop();
				k2=this.getJokaldikoKartak().getKarta(i-1);
				this.getLortutakoKartak().gehituKarta(k2);
			}
			this.getJokaldikoKartak().erreseteatu();
		}
		
	}
	private void mahaikoAukeraketaEgin(Karta k2,int pAukera) {
		try {
			k2= MahaikoKartak.getNireMahaikoKartak().getMahaikoKartak().getKarta(pAukera-1);
			}catch(IndexOutOfBoundsException e){
				System.out.println("Aukeratutako posizioan ez dago kartarik");
				this.aukeratuMahaikoKartak();
			}	
		jokaldiPuntuak=jokaldiPuntuak+k2.getZenb();
		System.out.println("Jokaldiaren balorea: "+jokaldiPuntuak);
		this.getJokaldikoKartak().gehituKarta(k2);
		MahaikoKartak.getNireMahaikoKartak().getMahaikoKartak().kenduKarta(pAukera-1);
	}
	public void turnoaBukatu(){
		System.out.println("Txanda bukatuko da, aukeratu karta bat mahaira botatzeko");
		this.imprimatuEskua();
		Karta k=null;
		int aukera=0;
		Boolean denaOndo=false;
		String sarrera=Teklatua.getNireTeklatua().irakurriString();
		try {
			aukera=Integer.parseInt(sarrera);
			denaOndo=true;
		}catch(NumberFormatException e) {
			System.out.println("Sarrera zenbaki bat izan behar da.");
			this.turnoaBukatu();
		}
		if(denaOndo) {
			try {
				k=getEskukoKartak().getKarta(aukera-1);
				}catch(IndexOutOfBoundsException e){
					System.out.println("Aukeratutako posizioan ez dago kartarik");
					this.turnoaBukatu();
				}
		MahaikoKartak.getNireMahaikoKartak().getMahaikoKartak().gehituKarta(k);
		this.getEskukoKartak().kenduKarta(aukera-1);
	}
	}

}
