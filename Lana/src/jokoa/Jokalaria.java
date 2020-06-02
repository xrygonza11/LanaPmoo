package jokoa;

public abstract class Jokalaria {
	//atributuak
	private int puntuak;
	private ListaKartak eskukoKartak;
	private ListaKartak lortutakoKartak;
	private ListaKartak jokaldikoKartak;
	private Konbinazioak konbi;
	//eraikitzaileak
	public Jokalaria (){
		this.puntuak=0;
		this.eskukoKartak=new ListaKartak();
		this.lortutakoKartak=new ListaKartak();
		this.jokaldikoKartak=new ListaKartak();
		this.konbi=Konbinazioak.getNireKonbinazioak();
	}
	
	//gainontzeko metodoak
	public ListaKartak getEskukoKartak(){
		return this.eskukoKartak;
	}
	public ListaKartak getLortutakoKartak(){
		return this.lortutakoKartak;
	}
	public ListaKartak getJokaldikoKartak() {
		return this.jokaldikoKartak;
	}
	public Konbinazioak getKonbinazioak() {
		return this.konbi;
	}
	public int getPuntuak(){
		return this.puntuak;
	}
	public void puntuakGehitu(int e) {
		puntuak=puntuak+e;
	}
	public int puntuenBanaketa(){
		Karta k=null;
		int zKop=0;
		int uKop=0;
		int i=this.lortutakoKartak.getKartaKop();
		int puntuak=0;
		while(i>0){
			k=this.lortutakoKartak.getKarta(i);
			String kp=k.getPalo();
			int kz=k.getZenb();
			if(kp=="Urrea" && kz==7){
				puntuak=puntuak+1;
				zKop=zKop+1;
				uKop=uKop+1;
			}
			else if(kp=="Urrea"){
				uKop=uKop+1;
			}
			else if(kz==7){
				zKop=zKop+1;
			}
			i--;
		}
		if(zKop>2){
			if(zKop==4){
				puntuak=puntuak+1;
			}
			puntuak=puntuak+1;
		}
		if (uKop>5){
			if(uKop==10){
				puntuak=puntuak+1;
			}
			puntuak=puntuak+1;
		}
		i=this.lortutakoKartak.getKartaKop();
		if(i>20){
			if(i>30){
				puntuak=puntuak+1;
			}
			puntuak=puntuak+1;
		}
		return puntuak;
	}

	public void puntuakErreseteatu() {
		puntuak=0;
	}
	public void denaErreseteatu() {
		this.getEskukoKartak().erreseteatu();
		this.getJokaldikoKartak().erreseteatu();
		//this.getKonbinazioak().getKonbiKartak().erreseteatu();
		this.getLortutakoKartak().erreseteatu();
	}
	public abstract void jokaldiaEgin();
	public abstract void turnoaBukatu();
	

}
