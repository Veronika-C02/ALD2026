package A07_Sorting;


public class BubbleSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 *
	 */


	// 2 Varianten
	// // 1. For mit (gesamtanzahl) und For mit (gesamtanzahl -1)
	// // 2. For mit (gesamtanzahl-1) und For mit (gesamtanzahl -1-i)

	public void sort(Person[] personen) {

		int numPersonen = personen.length;
		// Äussere Schleife: wie oft durchlaufen
		for (int i = 0; i < numPersonen; i++) {

			boolean swapped = false; // Verbesserung

			// Innere Schleife: Nachbarn vergleichen
			for (int j = 0; j < numPersonen - 1; j++) {

				// Linker groesser als rechter? Dann falsch herum
				if (personen[j].compareTo(personen[j+1]) > 0) {

					// Plätze tauschen
					Person temp = personen[j];
					personen[j] = personen[j+1];
					personen[j+1] = temp;
					swapped = true; // Verbesserung
				}
			}

			if(!swapped) // Verbesserung
				break;
		}

	}
	
}
