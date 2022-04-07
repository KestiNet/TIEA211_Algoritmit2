import java.util.Random;

/**
 *Lajitellaan kokonaislukutaulukko suuruusjärjestykseen kekolajittelulla
 * @author Esa Kesti
 */

public class HeapKeko {
    //Aletaan rakentamaan kekoa ja käydään taulukkoa läpi
    public void sort(int taulukko[])
    {
        int n = taulukko.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            kekoa(taulukko, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = taulukko[0];
            taulukko[0] = taulukko[i];
            taulukko[i] = temp;

            kekoa(taulukko, i, 0);
        }
    }


    //Aletaan rakentamaan kekoa
    //Kkäydään läpi vasen ja oikea lapsisolmu
    void kekoa(int taulukko[], int n, int i)
    {
        int suurin = i;
        int j = 2 * i + 1;
        int k = 2 * i + 2;

        if (j < n && taulukko[j] > taulukko[suurin])
            suurin = j;

        if (k < n && taulukko[k] > taulukko[suurin])
            suurin = k;


        if (suurin != i) {
            int swappi = taulukko[i];
            taulukko[i] = taulukko[suurin];
            taulukko[suurin] = swappi;

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
        for(int i = 0; i < taulukko.length; ++i)
            taulukko[i] = satunnainen.nextInt(max + min) +min;
        HeapKeko keko = new HeapKeko();
        keko.sort(taulukko);

        System.out.println("Järjestetty taulukko: ");
        tulostaTaulukko(taulukko);
    }
}
