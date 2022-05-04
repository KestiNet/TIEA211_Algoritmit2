
public class O3 {

	
// M‰‰ritell‰‰n n‰in:

	static class Solmu{
		
		int linkki;
		String alkio;
	}

        static String[] perusjoukko = {"kiuru", "lokki", "rastas", "sorsa", "varis"};

	static int pvKoko = 5;
	
	static Solmu[] pvJoukko = new Solmu[pvKoko];

	public static void union(int a, int b) {
		int k;
		k = pvJoukko[a].linkki + pvJoukko[b].linkki;
		if (pvJoukko[a].linkki <= pvJoukko[b].linkki) {
			pvJoukko[a].linkki = k;
			pvJoukko[b].linkki = a;
		}else {
			pvJoukko[b].linkki = k;
			pvJoukko[a].linkki = b;
		}
		// System.out.println(k);
	}
	
	public static int find (int x) {
		
		int j, k;
		
		j = x;
		while (pvJoukko[j].linkki >= 0) {
			j = pvJoukko[j].linkki;
		}
		while (pvJoukko[x].linkki >= 0) {
			k = x;
			x = pvJoukko[x].linkki;
			pvJoukko[k].linkki = j;
		}
		
		return j;
		
		// System.out.println(j);
		
		
	}
	public static void main(String[] args) {
		

		// Sijoitetaan arvot t‰‰ll‰:
		for (int i = 0; i < pvJoukko.length; i++) {
			pvJoukko[i] = new Solmu();
	                pvJoukko[i].linkki = -1;
        	        pvJoukko[i].alkio = perusjoukko[i];

		}
	
		// Tulostetaan:
		for (int i = 0; i < pvKoko; i++) {
		   System.out.print(pvJoukko[i].linkki + ":");
	           System.out.print(pvJoukko[i].alkio + " | ");
		}
	        System.out.println();

		// Testi:
		union(1, 2);

		// Tulostetaan:
		for (int i = 0; i < pvKoko; i++) {
		   System.out.print(pvJoukko[i].linkki + ":");
	           System.out.print(pvJoukko[i].alkio + " | ");
		}
	        System.out.println();

		//Testi:
                int j = find(2);

		// Tulostetaan:
	        System.out.println("Find palauttaa : " + j);
		for (int i = 0; i < pvKoko; i++) {
		   System.out.print(pvJoukko[i].linkki + ":");
	           System.out.print(pvJoukko[i].alkio + " | ");
		}
	        System.out.println();
	}

}