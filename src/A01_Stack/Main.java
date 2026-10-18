package A01_Stack;

public class Main {

        public static void main(String[] args) throws Exception {
            for (int n : new int[]{10_000, 100_000}) {
                Stack<Integer> stack = new Stack<>();

                long t0 = System.nanoTime();
                for (int i = 0; i < n; i++) stack.push(i);
                long push = System.nanoTime() - t0;

                t0 = System.nanoTime();
                int anzahl = stack.getCount();                     // Anzahl vorher merken
                for (int k = 0; k < anzahl; k++) {
                    Integer wert = stack.pop();
                    if (wert == -1) break;                         // -1 gibt es nicht = Worst Case
                }
                long suche = System.nanoTime() - t0;

                System.out.println("n=" + n
                        + " | push gesamt=" + push + " ns"
                        + " (" + push / n + " ns pro push -> O(1))"
                        + " | suche=" + suche + " ns -> O(n)");
            }


        }

}
