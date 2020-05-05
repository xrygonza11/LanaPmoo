package jokoa;

public class AukeratutakoKartaOkerraSalbuespena extends Exception {
	public AukeratutakoKartaOkerraSalbuespena() {
		super();
	}
	public void inprimatuMezua() {
		System.out.println("Aukeratutako posizioan ez dago kartarik, aukeratu beste bat.");
	}
}
