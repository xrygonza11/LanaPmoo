package jokoa;
public class proba {
	//att
	private ListaKartak lista;
	private ListaKartak lista2;
	private static boolean aurkitua;
	//metodos
	public proba() {
		lista=new ListaKartak();
		lista2=new ListaKartak();
		aurkitua=false;
	}
	public void meteKartas() {
		lista.gehituKarta(new Karta(1,"URREA"));
		lista.gehituKarta(new Karta(10,"KOPAK"));
		lista.gehituKarta(new Karta(11,"EZPATAK"));
		lista.gehituKarta(new Karta(8,"BASTOIAK"));
		lista.gehituKarta(new Karta(3,"BASTOIAK"));
	}
	static void unique_combination(int l, int sum, int K, ListaKartak local,ListaKartak A){ 
		// If a unique combination is found 

		if (sum == K)  { 
			local.imprimatuKartak();
			aurkitua=true;
			//hacer que local sea el array del jokaldi
			//aurkitua true
			return; 
		} 

		// For all other combinations 
		for (int i = l; i < A.getKartaKop(); i++){ 

			// Check if the sum exceeds K 
			//if (sum + A.getKarta(i).getZenb() > K) 
				//continue; 

			// Check if it is repeated or not 
			//if (i == 1 && A.getKarta(i).getZenb() == A.getKarta(i - 1).getZenb() &&  i > l) 
				//continue; 

			// Take the element into the combination 
			local.gehituKarta(A.getKarta(i)); 

			// Recursive call 
			if(!aurkitua)
			unique_combination(i + 1, sum + A.getKarta(i).getZenb(), K, local, A); 

			// Remove element from the combination 
			local.kenduKarta(local.getKartaKop() - 1); 
		} 
	} 
	public void runealo()throws ClassNotFoundException{
		meteKartas();
		unique_combination(0,0,11,lista2,lista);
	}
	
	
	
	
	
	
	
	
	
}
