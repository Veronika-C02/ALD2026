package A01_Stack;


import com.sun.source.tree.ClassTree;

public class Stack<T>
{

    private Node<T> first;
     private int count;

    /**
     * Oberstes Element entfernen und zurückliefern.
     * Existiert kein Element, wird eine Exception ausgelöst.
     * @throws StackEmptyException 
     */
    public T pop() throws StackEmptyException {
        if (first == null) {
            StackEmptyException StackEmptyException = new StackEmptyException();
            throw StackEmptyException;
        }

        Node<T> current = first;
        first = first.getNext();
        count--;
        return current.getData();
    }
    
    /**
     * Übergebenen T auf Stack (als oberstes Element) speichern.
     * @param i data
     */
    public void push(T i) {
        Node<T> current = new Node<>(i);
        current.setNext(first);
        first = current;
        count++;
    }
    
    /**
     * Liefert die Anzahl der Elemente im Stack
     * @return
     */
    public int getCount() {
    	return count;
    }

    public Node<T> getFirst() {
        return first;
    }

}
