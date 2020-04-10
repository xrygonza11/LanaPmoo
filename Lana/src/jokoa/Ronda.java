package jokoa;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
	private Jokaldia m1 = new Jokaldia();
	private Jokaldia m2 = new Jokaldia();

	private ArrayList<Karta> aukeratutakoak = new ArrayList<Karta>();
	private ArrayList<Karta> medio = new ArrayList<Karta>();

	private Baraja baraja = new Baraja();

	private ListaJokalariak jokoa = new ListaJokalariak();

	private Jokalaria j1 = new Jokalaria("Jugador1");
	private Jokalaria j2 = new Jokalaria("Jugador2");

	public Ronda() {

		banatu();
		kartakErdira();
		j1.setZenbat(true);
	}

	public void turnoAldaketa() {
		boolean t = j1.getZenbat();
		j1.setZenbat(!t);
		j2.setZenbat(t);
	}

	public Jokalaria getjokalari() {
		
		boolean t = j1.getZenbat();
		if (t) {
			return j1;
		}
		return j2;
	}
	

	public void kartakErdira() {
		medio.add(baraja.getKarta());
		medio.add(baraja.getKarta());
		medio.add(baraja.getKarta());
		medio.add(baraja.getKarta());
	}

	public void banatu() {
		baraja.banaketa(m1);
		baraja.banaketa(m2);
	}

	public List<Karta> geterdikoK() {
		return medio;
	}

	public List<Karta> getaurkeratutakoK() {
		return aukeratutakoak;
	}

	public Jokaldia getM1() {
		return m1;
	}

	public Jokaldia getM2() {
		return m2;

	}

	public boolean kartaGehituDezake(Jokaldia mano) {
		if (!mano.aukeraDaiteke()) {
			int num = mano.getAukeratua().getZenb();
			for (Karta k : aukeratutakoak) {
				num = num + k.getZenb();
			}
			return num == 15;
		}
		return false;
	}

	private int orosJ1() {
		int oros = 0;
		for (int i = 0; i < j1.getKartak().size(); i++) {
			if (j1.getKartak().get(i).getPalo().equals("ORO")) {
				oros++;
			}
		}
		return oros;
	}

	private int orosJ2() {
		int oros = 0;
		for (int i = 0; i < j2.getKartak().size(); i++) {
			if (j2.getKartak().get(i).getPalo().equals("ORO")) {
				oros++;
			}
		}
		return oros;
	}

	private int sietesJ1() {
		int sietes = 0;
		for (int i = 0; i < j1.getKartak().size(); i++) {
			if (j1.getKartak().get(i).getZenb() == 7) {
				sietes++;
			}
		}
		return sietes;
	}

	private int sietesJ2() {
		int sietes = 0;
		for (int i = 0; i < j2.getKartak().size(); i++) {
			if (j2.getKartak().get(i).getZenb() == 7) {
				sietes++;
			}
		}
		return sietes;
	}

	private boolean sieteOroJ1() {
		for (int i = 0; i < j1.getKartak().size(); i++) {
			if (j1.getKartak().get(i).getZenb() == 7 && j1.getKartak().get(i).getPalo().equals("ORO")) {
				return true;
			}
		}
		return false;
	}

	public void sumaPuntos() {
		int punt1 = 0;
		int punt2 = 0;
		if (j1.getKartak().size() > j2.getKartak().size()) {
			punt1++;

		} else if (j1.getKartak().size() < j2.getKartak().size()) {
			punt2++;
		}

		if (orosJ1() > orosJ2()) {
			punt1++;
		} else if (orosJ1() < orosJ2()) {
			punt2++;
		}

		if (sietesJ1() > sietesJ2()) {
			punt1++;

		} else if (sietesJ1() < sietesJ2()) {
			punt2++;
		}

		if (sieteOroJ1()) {
			punt1++;
		} else {
			punt2++;
		}
		
		j1.puntuakGehitu(punt1);
		j2.puntuakGehitu(punt2);

	}

	public boolean hayEscoba() {
	
		return medio.size() == 0;
		
	}

	public void Eskoba(Jokalaria j) {
		j.puntuakGehitu(1);
	}

	public Jokalaria getJ1() {
		return j1;
	}

	public void setJ1(Jokalaria j1) {
		this.j1 = j1;
	}

	public Jokalaria getJ2() {
		return j2;
	}

	public void setJ2(Jokalaria j2) {
		this.j2 = j2;
	}

	public void rondaHasieratu() {
		j1.getKartak().clear();
		j2.getKartak().clear();
		baraja = new Baraja();
	}

	public void kartakGehitu(Jokalaria j) {
		List<Karta> r = aukeratutakoak;
		j.geiKartak(r);
	}

	public Baraja getMultzoa() {
		return baraja;
	}

	public void setMultzoa(Baraja m) {
		this.baraja = m;
	}

	public ListaJokalariak getJokoa() {
		return jokoa;
	}

	public void setJokoa(ListaJokalariak jokoa) {
		this.jokoa = jokoa;
	}
}
