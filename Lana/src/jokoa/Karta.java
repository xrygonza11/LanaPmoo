package jokoa;



public class Karta {
	private String palo;
	private int zenb;
	private boolean aukeratua;

	public Karta(int z,String p) {
		this.zenb= z;
		this.palo= p;

	}

	public int getZenb() {
		return zenb;
	}

	public String getPalo() {
		return palo;
	}

	public boolean aukeratua() {
		return aukeratua;
	}

	public void setAukeratua(boolean a) {
		this.aukeratua = a;
	}
	public void imprimatuKarta(){
		System.out.println("Paloa: "+this.palo);
		System.out.println("Zenbakia: "+this.zenb);
		System.out.println("         ");
	}
}

