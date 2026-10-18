package A01a_Queue;

public class Main {

    public static void main(String[] args) {

        // Einfügen bei einer Queue
        Queue<Integer> queue = new Queue<>();
        int n = 100000; // // größe des stacks

        long start = System.nanoTime(); // start der Zeitmessung
        for (int i = 0; i < n; i++) {
            int zufall = (int) (Math.random() * 100000);
            queue.enqueue(zufall);
        }
        long ende = System.nanoTime(); // Ende der Zeitmessung

        System.out.println("Gesamtzeit Queue: " + (ende - start) + " ns");



    }
}
