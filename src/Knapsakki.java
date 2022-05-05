
public class Knapsakki {

	
	static int max(int a, int b)
	{
		return (a > b) ? a : b;
	}

	
	static int sakki(int kapasiteetti, int paino[], int arvo[], int n){
		int i, w;
		int K[][] = new int[n + 1][kapasiteetti + 1];

		for (i = 0; i <= n; i++) {
			for (w = 0; w <= kapasiteetti; w++) {
				if (i == 0 || w == 0) K[i][w] = 0;
				else if (paino[i - 1] <= w) K[i][w] = Math.max(arvo[i - 1] + K[i - 1][w - paino[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		return K[n][kapasiteetti];
	}

	public static void main(String args[])
	{
		int arvo[] = new int[] { 17, 10, 110 };
		int paino[] = new int[] { 13, 55, 41 };
		
		int kapasiteetti = 50;
		int n = arvo.length;
		System.out.println("Suurin hyötyarvo on: " + sakki(kapasiteetti, paino, arvo, n));
	}
}
