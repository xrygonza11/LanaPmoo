package jokoa;

public class HasieranAukeraOkerraSalbuespena extends Exception {
	public HasieranAukeraOkerraSalbuespena() {
		super();
	}
	public void inprimatuMezua() {
		System.out.println("Egindako kontsulta ez da zuzena, aukeratu beste bat.");
	}
}
