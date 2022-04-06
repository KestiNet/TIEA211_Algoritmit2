import java.util.Random;

public class HeapKeko {

    public void sort(int taulukko[])
    {
        int n = taulukko.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(taulukko, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = taulukko[0];
            taulukko[0] = taulukko[i];
            taulukko[i] = temp;

            // call max heapify on the reduced heap
            heapify(taulukko, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int taulukko[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && taulukko[l] > taulukko[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && taulukko[r] > taulukko[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = taulukko[i];
            taulukko[i] = taulukko[largest];
            taulukko[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(taulukko, n, largest);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int taulukko[])
    {
        int n = taulukko.length;
        for (int i = 0; i < n; ++i)
            System.out.print(taulukko[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[])
    {
        int min = 1;
        int max = 50;
        Random satunnainen = new Random();
        int taulukko[] = new int[8];
        //int n = taulukko.length;
        for(int i = 0; i < taulukko.length; ++i)
            taulukko[i] = satunnainen.nextInt(max + min) +min;
        System.out.println(taulukko);
        HeapKeko ob = new HeapKeko();
        ob.sort(taulukko);

        System.out.println("Sorted array is");
        printArray(taulukko);
    }
}
