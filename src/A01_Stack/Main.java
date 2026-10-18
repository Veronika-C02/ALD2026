package A01_Stack;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Einfügen bei einem Stack
        Stack<Integer> stack = new Stack<>();
        int n = 100000; // größe des stacks

        long start = System.nanoTime(); // start der zeitmessung
        for (int i = 0; i < n; i++) {
            int zufall = (int) (Math.random() * 100000);
            stack.push(zufall);
        }
        long ende = System.nanoTime(); // ende der zeitmessung

        System.out.println("Gesamtzeit Stack: " + ((ende - start) / n) + " ns");


        // "suchen" in einem stack
        int gesucht = 5;

        Node<Integer> current = stack.getFirst();
        while (current != null) {
            if (current.getData() == gesucht) {
                System.out.println("gefunden!");
                break;
            }
            current = current.getNext();
        }

    }
}
