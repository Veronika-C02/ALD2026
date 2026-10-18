package A04_TraverseTree;

import java.util.HashSet;
import java.util.Set;


public class Dictionary {

	/**
	 * Wurzel des Baums (Startknoten)
	 */
	private Word root;
	
	public Word getRoot() {
		return root;
	}

	/**
	 * Zählt alle Wörter des Teilbaums ab einem bestimmten Wort
	 * @param w Wort
	 * @return Zahl der Wörter (=Anzahl der Elemente)
	 */
	public int countWordsInSubTree(Word w) {
		// Abbruchbedingung --->  ein leerer teilbaum enthält keine Wörter
		if (w == null) {
			return 0;
		}
		//übergebenes Wort
		int anzahl = 1;

		anzahl = anzahl + countWordsInSubTree(w.getLeft()); // alle Wörter im linken Teilbaum
		anzahl = anzahl + countWordsInSubTree(w.getRight()); //alle Wörter im rechten Teilbaum

		return anzahl;
	}

	/**
	 * Liefert die Menge aller Wörter retour, die ein spezifisches Präfix haben.
	 * @param prefix Wörter müssen diesen Präfix haben
	 * @return Menge aller zutreffenden Wörter
	 */
	public Set<String> getWordsWithPrefix(String prefix) {
		//Treffer sammeln
		Set<String> ergebnis = new HashSet<>();

		sammleMitPraefix(root, prefix, ergebnis);
		return ergebnis;
	}

	//Hilfsmethode: durchläuft den Baum und füllt das Set
	private void sammleMitPraefix(Word current, String prefix, Set<String> ergebnis) {
		// Abbruchbedingung: nichts mehr da zum Durchsuchen
		if (current == null) {
			return;}

		String wort = current.getWort(); // wort des aktuellen Knotens holen

		// Prüfen, ob dieses Wort mit dem Präfix beginnt
		if (wort.startsWith(prefix)) {
			ergebnis.add(wort);   // treffer
		}

		//linken Teilbaum suchen
		sammleMitPraefix(current.getLeft(), prefix, ergebnis);

			// rechten Teilbaum suchen
		sammleMitPraefix(current.getRight(), prefix, ergebnis);
	}


	/**
	 * Neues Wort hinzufügen
	 * @param wort Hinzuzufügendes Wort
	 */
	public void add(String wort) {
		Word neu = new Word(wort);
		if (root == null) {			// Fall 1: Baum ist leer
			root = neu;
			return;
		}
		Word w = root;				// Fall 2: Baum ist nicht leer
		while (true) {
			int vgl = wort.compareTo(w.getWort());
			if (vgl < 0) {			// Neues Wort ist lexikographisch kleiner
				if (w.getLeft() == null) {
					w.setLeft(neu);
					neu.setParent(w);
					return;
				}
				w = w.getLeft();
			}
			else if (vgl > 0) {		// Neues Wort ist lexikographisch größer
				if (w.getRight() == null) {
					w.setRight(neu);
					neu.setParent(w);
					return;
				}
				w = w.getRight();
			}
			else {					// Neues Wort ist lexikographisch gleich
				return;
			}
		}
	}

	public Word find(String s) {
		return find(root, s);
	}
	
	private Word find(Word current, String s) {
		if (current == null) {
			return null;
		}
		int vgl = s.compareTo(current.getWort());
		if (vgl == 0) {		// Gefunden
			return current;
		}
		else if (vgl < 0) {	// Links
			return find(current.getLeft(), s);
		}
		else {				// Rechts
			return find(current.getRight(), s);
		}
	}
	
}
