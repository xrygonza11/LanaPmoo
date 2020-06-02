package probak;

import static org.junit.Assert.*;
import jokoa.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class jokalariArruntaTest {
	private JokalariArrunta j;
	private MahaikoKartak m;
	private ListaKartak ek;
	private ListaKartak jk;
	private ListaKartak lk;
	private ListaKartak mk;
	private Karta k1;
	private Karta k2;
	private Karta k3;
	private Karta k4;
	private Karta k5;
	private Karta k6;
	private Karta k7;
	
	@Before
	public void setUp() throws Exception {
		j=new JokalariArrunta("Aitor");
		m=MahaikoKartak.getNireMahaikoKartak();
		ek=j.getEskukoKartak();
		jk=j.getJokaldikoKartak();
		lk=j.getLortutakoKartak();
		mk=m.getMahaikoKartak();
		k1=new Karta(4,"URREA");
		k2=new Karta(3,"KOPAK");
		k3=new Karta(10,"EZPATAK");
		k4=new Karta(5,"URREA");
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
		k1=null;
		k2=null;
		k3=null;
		k4=null;
		k5=null;
		k6=null;
		k7=null;
	}
	//Metodo bakoitza bere aldetik probatu
	@Test
	public void test1JokaldiaEgin() {
		System.out.println("Eskuko karta bota nahi dugun eskatuko digu, baietz (b) esango diogu eta konbinazio bat egingo dugu eskuko karta batekin(10) eta mahaiko karta batekin(5)");
		j.jokaldiaEgin();
		assertEquals(2,ek.getKartaKop());
		assertEquals(3,mk.getKartaKop());
		assertEquals(2,lk.getKartaKop());
	}
	@Test
	public void test2JokaldiaEgin() {
		System.out.println("Eskuko karta bota nahi dugun eskatuko digu, baietz (b) esango diogu eta konbinazio bat egingo dugu eskuko karta batekin(4) eta mahaiko karta birekin(5)(6)");
		j.jokaldiaEgin();
		lk.imprimatuKartak();
		assertEquals(2,ek.getKartaKop());
		assertEquals(2,mk.getKartaKop());
		assertEquals(3,lk.getKartaKop());
		
	}

	@Test
	public void testTurnoaBukatu() {
		System.out.println("Edozein karta botako da mahaira");
		j.turnoaBukatu();
		assertEquals(2,ek.getKartaKop());
		assertEquals(5,mk.getKartaKop());
	}

	@Test
	public void testJokalariArrunta() {
		assertNotNull(j);
		assertNotNull(m);
		assertNotNull(ek);
		assertNotNull(jk);
		assertNotNull(lk);
		assertNotNull(mk);
		assertNotNull(k1);
		assertNotNull(k2);
		assertNotNull(k3);
		assertNotNull(k4);
		assertNotNull(k5);
		assertNotNull(k6);
		assertNotNull(k7);
	}

	@Test
	public void testImprimatuEskua() {
		//konsolaren bitartez konprobatua
		j.imprimatuEskua();
	}

	@Test
	public void testGetSaiakerak() {
		System.out.println("Test honetan 15 gehitzen ez duten 3 jokaldi egin eta ikusi nola saiakerak gutxitzen diren; gainera saiakerarik gabe geratzean zer gertatzen den ikusi daiteke");
		j.jokaldiaEgin();
		
	}

}
