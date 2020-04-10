package jokoa;

import java.util.Scanner;

public class JokalariArrunta extends Jokalaria{
	//eraikitzaileak
	public JokalariArrunta(String pIzena){
		super(pIzena);
	}
	
public void imprimatuEskua(){
	this.getEskukoKartak().imprimatuKartak();
}


}
