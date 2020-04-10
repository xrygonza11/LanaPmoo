package jokoa;

import java.util.ArrayList;

public class JokalariArrunta extends Jokalaria{
	//eraikitzaileak
	public JokalariArrunta(String pIzena){
		super(pIzena);
	}
	
	public Karta () {
		return k1;
	}
	public void setk1(Karta K1) {
		this.k1 = K1;
	}

	public Karta getk2() {
		return k2;
	}
	public void setk2(Karta K2) {
		this.k2 = K2;
	}

	public Karta getk3() {
		return k3;
	}
	public void setk3(Karta K3) {
		this.k3 = K3;
	}
	
	public Jokalaria getJokalaria() {
		return joka;
	}
	
	public void setJokalaria(Jokalaria j) {
		this.joka=j;
	}
	
	public boolean badago(Karta k) {
		return k1==k || k2==k || k3== k;
	}
	
	
	public Karta badagoJokaldian(ArrayList <Karta> kartak) {
		for(Karta k: kartak) {
			if(badago(k)) {
				return k;
			}
		}
		return null;
	}


	public static boolean gehituDezake(ArrayList <Karta> auker) {
		int num = 0;
		for(Karta c: auker) {
			num=num+c.getZenb();
		}
		return num==15;

	}
	public void ezabatu(Karta k) {
		if(k == k1)setk1(null);
		if(k == k2)setk2(null);
		if(k == k3)setk3(null);
	}
	
	public boolean aukeraDaiteke() {
		boolean seleccionada= true;
		if(k1!= null&&k1.aukeratua()==true)seleccionada=false;
		if(k2!= null&&k2.aukeratua()==true)seleccionada=false;
		if(k3!= null&&k3.aukeratua()==true)seleccionada=false;
		return seleccionada;
	}
	
	public Karta getAukeratua() {
		if(k1!= null&&k1.aukeratua()==true)return k1;
		if(k2!= null&&k2.aukeratua()==true)return k2;
		if(k3!= null&&k3.aukeratua()==true)return k3;
		return null;
	}
	
	public boolean hutsaDa() {
		if(k1==null&&k2==null&&k3==null) {
			return true;
		}
		return false;
	}
	
	


}

}
