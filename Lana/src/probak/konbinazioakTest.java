package probak;

import static org.junit.Assert.*;
import jokoa.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class konbinazioakTest {
	private ListaJokalariak lj;
	private JokalariCPU j;
	private MahaikoKartak m;
	private ListaKartak ek;
	private ListaKartak jk;
	private ListaKartak lk;
	private ListaKartak mk;
	private Konbinazioak k;
	private Matrizea mat;
	private Karta k1;
	private Karta k2;
	private Karta k3;
	private Karta k4;
	private Karta k5;
	private Karta k6;
	private Karta k7;

	@Before
	public void setUp() throws Exception {
		lj=ListaJokalariak.getNireListaJokalariak();
		//j=new JokalariCPU();
		lj.getZerrenda()[1]=new JokalariCPU();
		m=MahaikoKartak.getNireMahaikoKartak();
		ek=lj.getZerrenda()[1].getEskukoKartak();
		jk=lj.getZerrenda()[1].getJokaldikoKartak();
		lk=lj.getZerrenda()[1].getLortutakoKartak();
		mk=m.getMahaikoKartak();
		k=Konbinazioak.getNireKonbinazioak();
		mat=k.getKonbiKartak();
		k1=new Karta(2,"URREA");
		k2=new Karta(3,"KOPAK");
		k3=new Karta(5,"EZPATAK");
		k4=new Karta(10,"URREA");
		k5=new Karta(6,"BASTOAK");
		k6=new Karta(2,"KOPAK");
		k7=new Karta(4,"KOPAK");
		ek.gehituKarta(k1);
		ek.gehituKarta(k2);
		ek.gehituKarta(k3);
		mk.gehituKarta(k4);
		mk.gehituKarta(k5);
		mk.gehituKarta(k6);
		mk.gehituKarta(k7);
	}

	@After
	public void tearDown() throws Exception {
		j=null;
		m=null;
		ek.erreseteatu();
		jk.erreseteatu();
		lk.erreseteatu();
		mk.erreseteatu();
		k=null;
		mat.erreseteatu();
		k1=null;
		k2=null;
		k3=null;
		k4=null;
		k5=null;
		k6=null;
		k7=null;
	}

	@Test
	public void testKonbinazioOnena() {
		//konsolaren bitartez ikusiko dira konbinazio guztiak
		lj.getZerrenda()[1].getKonbinazioak().konbinazioOnena();
	}

}
