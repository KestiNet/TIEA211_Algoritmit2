import java.util.Random;

/**
 *Lajitellaan kokonaislukutaulukko suuruusjärjestykseen kekolajittelulla
 * @author Esa Kesti
 */

public class HeapKeko {

    public void sort(int taulukko[])
    {
        int n = taulukko.length;
        //Aletaan rakentamaan kekoa
        for (int i = n / 2 - 1; i >= 0; i--)
            kekoa(taulukko, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = taulukko[0];
            taulukko[0] = taulukko[i];
            taulukko[i] = temp;

            kekoa(taulukko, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void kekoa(int taulukko[], int n, int i)
    {
        int suurin = i; // Initialize largest as root
        int j = 2 * i + 1; // left = 2*i + 1
        int k = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (j < n && taulukko[j] > taulukko[suurin])
            suurin = j;

        // If right child is larger than largest so far
        if (k < n && taulukko[k] > taulukko[suurin])
            suurin = k;

        // If largest is not root
        if (suurin != i) {
            int swappi = taulukko[i];
            taulukko[i] = taulukko[suurin];
            taulukko[suurin] = swappi;

            // Recursively heapify the affected sub-tree
            kekoa(taulukko, n, suurin);
        }
    }

    //Tulostetaan taulukko
    static void tulostaTaulukko(int taulukko[])
    {
        int n = taulukko.length;
        for (int i = 0; i < n; ++i)
            System.out.print(taulukko[i] + " ");
        System.out.println();
    }

    /**
     * @param args ei käytössä
     * Luodaan taulukko ja lisätään kokonaislukuja random luokan avulla
     * Kutsutaan aliohjelmaa myös tulostamaan
     */
    public static void main(String args[])
    {
        int min = 1;
        int max = 317;
        Random satunnainen = new Random();
        int taulukko[] = new int[8];
        //int n = taulukko.length;
        for(int i = 0; i < taulukko.length; ++i)
            taulukko[i] = satunnainen.nextInt(max + min) +min;
        HeapKeko ob = new HeapKeko();
        ob.sort(taulukko);

        System.out.println("Järjestetty taulukko: ");
        tulostaTaulukko(taulukko);
    }
}
