package A05_Breitensuche;

import java.util.*;

public class Main {
    static class Node {
        int value; Node left, right;
        Node(int value) { this.value = value; }
    }

    static Node buildTree(int[] values) {
        Node root = new Node(values[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            Node p = q.peek();
            if (p.left == null) { p.left = new Node(values[i]); q.add(p.left); }
            else { p.right = new Node(values[i]); q.add(p.right); q.poll(); }
        }
        return root;
    }

    // BFS: Queue, Ebene für Ebene
    static int bfs(Node root, int[] result) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            result[i++] = current.value;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return i;
    }

    // DFS: Rekursion, erst links, dann rechts
    static int dfs(Node node, int[] result, int i) {
        if (node == null) return i;
        result[i++] = node.value;
        i = dfs(node.left, result, i);
        return dfs(node.right, result, i);
    }

    public static void main(String[] args) {
        int[] values = {50, 30, 70, 20, 40, 60};
        int[] bfsOrder = new int[values.length];
        int[] dfsOrder = new int[values.length];

        int bfsSteps = bfs(buildTree(values), bfsOrder);
        int dfsSteps = dfs(buildTree(values), dfsOrder, 0);

        System.out.println("BFS: " + Arrays.toString(bfsOrder) + " (" + bfsSteps + " Schritte)");
        System.out.println("DFS: " + Arrays.toString(dfsOrder) + " (" + dfsSteps + " Schritte)");

        for (int size : new int[]{6, 12, 100}) {
            int[] vals = new int[size];
            for (int i = 0; i < size; i++) vals[i] = i + 1;
            int s1 = bfs(buildTree(vals), new int[size]);
            int s2 = dfs(buildTree(vals), new int[size], 0);
            System.out.println("n=" + size + " | BFS: " + s1 + " | DFS: " + s2 + " -> O(n)");
        }
    }
}
