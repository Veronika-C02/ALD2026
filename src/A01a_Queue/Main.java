package A01a_Queue;


public class Main {

        public static void main(String[] args) throws Exception {
            for (int n : new int[]{10_000, 100_000}) {
                Queue<Integer> queue = new Queue<>();

                long t0 = System.nanoTime();
                for (int i = 0; i < n; i++) queue.enqueue(i);
                long add = System.nanoTime() - t0;

                t0 = System.nanoTime();
                int anzahl = queue.getCount();                     // Anzahl vorher merken
                for (int k = 0; k < anzahl; k++) {
                    Integer wert = queue.dequeue();
                    if (wert == -1) break;                         // -1 gibt es nicht = Worst Case
                }
                long suche = System.nanoTime() - t0;

                System.out.println("n=" + n
                        + " | add gesamt=" + add + " ns"
                        + " (" + add / n + " ns pro add -> O(1))"
                        + " | suche=" + suche + " ns -> O(n)");


            }

    }
}
