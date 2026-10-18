package A07_Sorting;

import java.util.Random;

public class Main{

    static long vergleiche = 0;   // zählt Vergleiche für die O-Notation

    public static void main(String[] args) {
        int[] groessen = {1000, 2000, 4000, 8000, 16000};

        System.out.println("n;Bubble ms;Bubble Vergl.;Bubble/n^2;Quick ms;Quick Vergl.;Quick/(n*log2 n)");

        for (int n : groessen) {
            int[] daten = zufall(n);
            int[] a = daten.clone();
            int[] b = daten.clone();

            vergleiche = 0;
            long start = System.nanoTime();
            bubbleSort(a);
            long msBubble = (System.nanoTime() - start) / 1_000_000;
            long vb = vergleiche;

            vergleiche = 0;
            start = System.nanoTime();
            quickSort(b, 0, b.length - 1);
            long msQuick = (System.nanoTime() - start) / 1_000_000;
            long vq = vergleiche;

            double log2n = Math.log(n) / Math.log(2);

            System.out.println(n + ";" + msBubble + ";" + vb + ";" + (vb / (double) (n * n))
                    + ";" + msQuick + ";" + vq + ";" + (vq / (n * log2n)));
        }
    }

    // gleiche Zufallsdaten für beide Sorten (fester Seed)
    static int[] zufall(int n) {
        Random r = new Random(42);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = r.nextInt(10000);
        return a;
    }

    static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                vergleiche++;
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    static void quickSort(int[] a, int links, int rechts) {
        if (links >= rechts) return;
        int pivot = a[(links + rechts) / 2];
        int i = links, j = rechts;
        while (i <= j) {
            while (a[i] < pivot) { vergleiche++; i++; }
            vergleiche++;
            while (a[j] > pivot) { vergleiche++; j--; }
            vergleiche++;
            if (i <= j) {
                int temp = a[i]; a[i] = a[j]; a[j] = temp;
                i++; j--;
            }
        }
        quickSort(a, links, j);
        quickSort(a, i, rechts);
    }
}
