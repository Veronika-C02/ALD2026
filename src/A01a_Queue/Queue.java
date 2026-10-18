package A01a_Queue;

public class Queue<T>
{
    public Node<T> getFirst() {
        return first;
    }

    private Node<T> first;
    
    private Node<T> last;

    private int count;

    /**
     * Das vorderste (=erste) Element aus der Queue entfernen und zurückliefern.
     * Existiert kein Element, wird eine Exception ausgelöst.
     * @throws QueueEmptyException 
     */
    public T dequeue() throws QueueEmptyException {

        if(first == null){
            last = null;
            QueueEmptyException QueueEmptyException = new QueueEmptyException();
            throw QueueEmptyException;

        }else {
            Node<T> current = first;
            first = first.getNext();
            count--;
            return current.getData();
        }
    }
    
    /**
     * Übergebenen Integer am Ende der Queue anhängen.
     * @param i Zahl
     */
    public void enqueue(T i) {
        Node<T> current = new Node<>(i);

        if(first == null){
            first = current;
        }else {

            last.setNext(current);

        }
        last = current;
        count++;
    }
    
    /**
     * Liefert die Anzahl der Elemente im Stack
     * @return
     */
    public int getCount() {
    	return count;
    }
}
