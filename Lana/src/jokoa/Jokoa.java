
package jokoa;

public class Jokoa {

	private int puntuak1=0;
	private int puntuak2=0;

	public static int Gehienezko_puntuazioa = 15;

	public boolean bukaera() {
		return puntuak1 >= Gehienezko_puntuazioa || puntuak2>= Gehienezko_puntuazioa;
	}

	public int getJokalari1Puntuak() {
		return puntuak1;
	}
	public void setJokalari1Puntuak(int puntu1) {
		this.puntuak1 = puntu1+this.puntuak1;
	}
	public int getJokalari2Puntuak() {
		return puntuak2;
	}
	public void setJokalari2Puntuak(int puntu2) {
		this.puntuak2 = puntu2+this.puntuak2;
	}
	public void partidaBatJolastu() {
		puntuak1=0;
		puntuak2=0;
	}
	
	








}




