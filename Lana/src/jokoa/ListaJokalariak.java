package jokoa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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
	public static void irakurri(File txt){
		FileReader fr=null;
		BufferedReader br=null;
		
		try{
			fr= new FileReader(txt);
			br= new BufferedReader(fr);
			String lerroa;
			while((lerroa=br.readLine())!=null)
				System.out.println(lerroa);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	public void partidaHasieratu(){
		do {
			clear();
			File txt= new File ("res/Hasiera.txt");
			irakurri(txt);
			int sarrera=Teklatua.getNireTeklatua().irakurriAukera(1,4);
			switch(sarrera) {
			case 1:
				clear();
				System.out.println("Sartu zure izena");
				String izena=Teklatua.getNireTeklatua().irakurriString();
				ListaJokalariak.getNireListaJokalariak().getZerrenda()[0]=new JokalariArrunta(izena);
				ListaJokalariak.getNireListaJokalariak().getZerrenda()[1]=new JokalariCPU();
				partidaJolastu();
				break;
			case 2:
				clear();
				System.out.println("Sartu zure izena");
				String izena2=Teklatua.getNireTeklatua().irakurriString();
				ListaJokalariak.getNireListaJokalariak().getZerrenda()[0]=new JokalariArrunta(izena2);
				System.out.println("Sartu bigarren jokalariaren izena");
				String izena3=Teklatua.getNireTeklatua().irakurriString();
				ListaJokalariak.getNireListaJokalariak().getZerrenda()[1]=new JokalariArrunta(izena3);
				partidaJolastu();
				break;
			case 3:
				File txt1= new File ("res/ARAUAK.txt");
				irakurri(txt1);
				System.out.println("Sakatu enter menura itzultzeko");
				Teklatua.getNireTeklatua().irakurriEnter();
				break;
			case 4:
				System.exit(0);
				break;
			}
		}while(true);
	}
	public void partidaJolastu(){
		clear();
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
				if(eskobaDa()) {
					this.getZerrenda()[0].puntuakGehitu(1);
				}
				this.getZerrenda()[1].jokaldiaEgin();
				if(eskobaDa()) {
					this.getZerrenda()[1].puntuakGehitu(1);
				}
			}
			this.kartakBanatu();
		}
		
	}
	public boolean rondarenBukaeraKonprobatu() {
		boolean b=false;
		if(this.getZerrenda()[0].getEskukoKartak().getKartaKop()==0 || this.getZerrenda()[1].getEskukoKartak().getKartaKop()==0 && Baraja.getNireBaraja().getBaraja().getKartaKop()==0) {
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
		if(MahaikoKartak.getNireMahaikoKartak().getMahaikoKartak().getKartaKop()==0) {
			eskoba=true;
		}
		//System.out.println("Eskoba egon da!");
		return eskoba;
	}
	public void jokoaBerrabiarazi() {
		this.getZerrenda()[0].denaErreseteatu();
		this.getZerrenda()[1].denaErreseteatu();
		MahaikoKartak.getNireMahaikoKartak().getMahaikoKartak().erreseteatu();
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




