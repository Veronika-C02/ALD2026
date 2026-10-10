package A07_Sorting;


public class QuickSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Person[] personen) {
		 // REKURSION --> Abbruchbedingung

		sort(personen, 0, personen.length - 1);
	}

	private void sort(Person[] personen, int left, int right) {
		// Nur sortieren, wenn mindestens 2 Elemente vorhanden sind
		if (left < right) {
			// Array am Pivot aufteilen und dessen Endposition bestimmen
			int pi = partition(personen, left, right);
			// Linken Teilbereich (Elemente kleiner als Pivot) sortieren
			sort(personen, left, pi - 1);
			// Rechten Teilbereich (Elemente größer als Pivot) sortieren
			sort(personen, pi + 1, right);
		}
	}

	private int partition(Person[] personen, int left, int right) {
		// Letztes Element als Pivot festlegen
		Person pivot = personen[right];
		// Zeiger für die Trennung zwischen kleinen und großen Elementen
		int i = left - 1;

		// Bereich von left bis right - 1 durchlaufen
		for (int j = left; j < right; j++) {
			// Aktuelles Element gehört links vom Pivot
			if (personen[j].compareTo(pivot) <= 0) {
				// Trennzeiger nach rechts verschieben
				i++;
				// Kleineres Element in den linken Bereich tauschen
				Person tmp = personen[i];
				personen[i] = personen[j];
				personen[j] = tmp;
			}
		}
		// Pivot an seine endgültige, sortierte Position verschieben
		Person tmp = personen[i + 1];
		personen[i + 1] = personen[right];
		personen[right] = tmp;

		// Endposition des Pivots zurückgeben
		return i + 1;
	}

}