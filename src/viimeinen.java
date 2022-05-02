
public class viimeinen {
	
	static class yJoukko{
		 public int arvo;
		 public String elaimet;
		 yJoukko(int arvo, String elaimet){
			 this.arvo = arvo;
			 this.elaimet = elaimet;
		 }
	 }
	
	public static void union(int[]yJoukko,int a, int b) {
		
		int k;
		k = yJoukko[a] + yJoukko[b];
		if (yJoukko[a] <= yJoukko[b]) {
			yJoukko[a] = k;
			yJoukko[b] = a;
		}
		else {
			yJoukko[b] = k;
			yJoukko[a] = b;
		System.out.println(k);
		}
	}
  
	public static int find(int[] yJoukko, int x) {
		
		int j, k;
		j = x;
		try {
			while  (yJoukko[j] > 0) {
				j = yJoukko[j];
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			while (yJoukko[x] > 0) {
				k = x;
				x = yJoukko[x]; 
				yJoukko[k] = j;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return j;
		
	}
	
	public static void main(String[] args) {

		yJoukko [] taulukko;
		 
		 taulukko = new yJoukko[5];
		 
		 taulukko[0] = new yJoukko(1,"kiuru");
		 taulukko[1] = new yJoukko(2, "lokki");
		 taulukko[2] = new yJoukko(3, "rastas");
		 taulukko[3] = new yJoukko(4, "sorsa");
		 taulukko[4] = new yJoukko(5, "varis");
	
		 union(taulukko, taulukko);
		 
	}

	private static void union(viimeinen.yJoukko[] taulukko, viimeinen.yJoukko[] taulukko2) {
		// TODO Auto-generated method stub
		
	}

		
	}

