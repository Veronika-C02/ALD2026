package A03_DoubleLinkedList;

public class DoubleLinkedList<T>
{
    private Node<T> first;
    private Node<T> last;
    private Node<T> current;

    /**
     * Einfügen einer neuen <T>
     * @param a <T>
     */
    public void add(T a) {
        Node<T> newNode = new Node<>(a);

        if (first == null) {          // leere Liste: neues Element ist anfang und Ende
            first = newNode;
            last = newNode;
        } else {                      //hinten anhängen
            last.setNext(newNode);
            newNode.setPrevious(last);
            last = newNode;           // last wandert mit
        }
    }

    /**
     * Internen Zeiger für next() zurücksetzen
     */
    public void reset() {
        current = first;
    }

    /**
     * analog zur Funktion reset()
     */
    public void resetToLast() {
        current = last;
    }

    /**
     * Liefert erste Node der Liste retour oder null, wenn Liste leer
     * @return Node|null
     */
    public Node<T> getFirst() {
        return first;
    }
    
    /**
     * Liefert letzte Node der Liste retour oder null, wenn Liste leer
     * @return Node|null
     */
    public Node<T> getLast() {

        return last;
    }
    
    /**
     * Gibt aktuelle <T> zurück und setzt internen Zeiger weiter.
     * Falls current nicht gesetzt, wird null retourniert.
     * @return <T>|null
     */
    public T next() {
        if(current == null) {        //vor dem ersten oder hinter dem letzten Element
            return null;
        }
        T data = current.getData();   // lesen
        current = current.getNext();//weiterrücken
        return data;
    }

    /**
     * analog zur Funktion next()
     * @return <T>|null
     */
    public T previous() {
        if (current == null) {
            return null;
        }
        T data = current.getData();
        current = current.getPrevious();
        return data;
    }
    
    /**
     * Current-Pointer auf nächste <T> setzen (aber nicht auslesen).
     * Ignoriert still, dass current nicht gesetzt ist.
     */
    public void moveNext() {
        if (current != null) {
            current = current.getNext();
        }
    }

    
    /**
     * Analog zur Funktion moveNext()
     */
    public void movePrevious() {
        if (current != null) {
            current = current.getPrevious();
        }
    }
   
    /**
     * Retourniert aktuelle (current) <T>, ohne Zeiger zu ändern
     * @return <T>
     * @throws CurrentNotSetException
     */
    public T getCurrent() throws CurrentNotSetException {
        if (current == null) {
            throw new CurrentNotSetException();
        }
        return current.getData();
    }

    /**
     * Gibt <T> an bestimmter Position zurück
     * @param pos Position, Nummerierung startet mit 1
     * @return <T>|null
     */
    public T get(int pos) {
        if (pos < 1) {
            return null;
        }

        Node<T> temp = first;   // Hilfszeiger ---> vorne starten
        int index = 1;          // Position vom Hilfszeiger mitzählen

        // durch die Liste laufen, bis temp null ist
        while (temp != null) {
            if (index == pos) {
                return temp.getData();   //Position gefunden
            }
            temp = temp.getNext();
            index++;
        }

        //Pos existiert nicht
        return null;
    }

    /**
     * Entfernen des Elements an der angegebenen Position.
     * Falls das entfernte Element das aktuelle Element ist, wird current auf null gesetzt.
     * @param pos
     */

    public void remove(int pos) {
        if (pos < 1) {
            return;   // ungültige Position, nichts tun
        }

        //Node an der Position suchen
        Node<T> temp = first;
        int index = 1;

        while (temp != null && index < pos) {
            temp = temp.getNext();
            index++;
        }

        // Position existiert nicht
        if (temp == null) {
            return;
        }

        // Nachbarn merken
        Node<T> previousNode = temp.getPrevious();
        Node<T> nextNode = temp.getNext();

        // first
        if (previousNode == null) {
            first = nextNode;             // war das erste Element
        } else {
            previousNode.setNext(nextNode);
        }

        // Last
        if (nextNode == null) {
            last = previousNode;
        } else {
            nextNode.setPrevious(previousNode);
        }

            // wenn entfernte Element das aktuelle --> current leeren
        if (temp == current) {
            current = null;
        }

        //Verbindungen der ausgebauten Node kappen
        temp.setNext(null);
        temp.setPrevious(null);
    }
    
    /**
     * Entfernt das aktuelle Element.
     * Als neues aktuelles Element wird der Nachfolger gesetzt oder
     * (falls kein Nachfolger) das vorhergehende Element 
     * @throws CurrentNotSetException
     */
    public void removeCurrent() throws CurrentNotSetException {
        if (current == null) {throw new CurrentNotSetException();
        }

        Node<T> previousNode = current.getPrevious();
        Node<T> nextNode = current.getNext();

        // current aus der Kette hängen
        if (previousNode == null) {
            first = nextNode;
        } else {
            previousNode.setNext(nextNode);}

        if (nextNode == null) {
            last = previousNode;}
        else {
            nextNode.setPrevious(previousNode);
        }

        // neues current: Nachfolge --> wenn es keinen gibt den Vorgänger
        if (nextNode != null) {
            current = nextNode;
        } else {
            current = previousNode;
        }



    }
    
    /**
     * Die Methode fügt die übergebene <T> nach der aktuellen (current) ein
     * und setzt dann die neu eingefügte <T> als aktuelle (current) <T>.
     * @throws CurrentNotSetException 
     */
    public void insertAfterCurrentAndMove(T a) throws CurrentNotSetException {

        if (current == null) {
            throw new CurrentNotSetException();
        }

        Node<T> newNode = new Node<>(a);
        Node<T> nextNode = current.getNext();

        // neuen Knoten hinter current
        current.setNext(newNode);
        newNode.setPrevious(current);

        newNode.setNext(nextNode); //Nachfolger verbinden

        if (nextNode != null) {
            nextNode.setPrevious(newNode);
        } else {
            // current war das letzte Element --> newNode ist jetzt last
            last = newNode;
        }

        current = newNode;

    }
}
