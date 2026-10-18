package A02_Heap;
import java.util.ArrayList;
import A02_Heap.Task;

public class Main_Sorted {
        public static void main(String[] args) {
            for (int n : new int[]{1_000, 5_000, 20_000}) {
                ArrayList<Task> liste = new ArrayList<>();

                long t0 = System.nanoTime();
                for (int i = 0; i < n; i++) {
                    Task t = new Task(i, (int) (Math.random() * 1_000_000));
                    int pos = 0;
                    while (pos < liste.size() && liste.get(pos).getPriority() < t.getPriority()) pos++; // Stelle suchen
                    liste.add(pos, t);                                                                 // einschieben = alles rutscht nach
                }
                long insert = System.nanoTime() - t0;

                t0 = System.nanoTime();
                while (!liste.isEmpty()) liste.remove(0);
                long remove = System.nanoTime() - t0;

                System.out.println("n=" + n
                        + " | insert gesamt=" + insert + " ns"
                        + " (" + insert / n + " ns pro insert -> O(n))"
                        + " | remove gesamt=" + remove + " ns -> O(n^2)");
            }
        }
}


