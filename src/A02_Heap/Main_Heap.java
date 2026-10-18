package A02_Heap;

import A02_Heap.TaskHeapArrayList;

public class Main_Heap{
    public static void main(String[] args) {
        // Warmlauf: einmal klein durchlaufen, damit Java den Code optimiert
        TaskHeapArrayList warm = new TaskHeapArrayList();
        for (int i = 0; i < 10_000; i++) warm.insert(new Task(i, i));
        while (warm.remove() != null) { }

        for (int n : new int[]{1_000, 5_000, 20_000}) {
            TaskHeapArrayList heap = new TaskHeapArrayList();

            long t0 = System.nanoTime();
            for (int i = 0; i < n; i++) heap.insert(new Task(i, (int) (Math.random() * 1_000_000)));
            long insert = System.nanoTime() - t0;

            t0 = System.nanoTime();
            while (heap.remove() != null) { }
            long remove = System.nanoTime() - t0;

            System.out.println("n=" + n
                    + " | insert gesamt=" + insert + " ns"
                    + " (" + insert / n + " ns pro insert -> O(log n))"
                    + " | remove gesamt=" + remove + " ns -> O(n log n)");
        }
    }
}
