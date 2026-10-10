package A07_Sorting;


public class BubbleSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Person[] personen) {

		int numPersonen = personen.length;

		// Äussere Schleife: wie oft durchlaufen
		for (int i = 0; i < numPersonen; i++) {

			// Innere Schleife: Nachbarn vergleichen
			// -1-i weil hinten schon sortiert ist
			for (int j = 0; j < numPersonen - 1; j++) {

				// Linker groesser als rechter? Dann falsch herum
				if (personen[j].compareTo(personen[j+1]) > 0) {

					// Plätze tauschen
					Person temp = personen[j];
					personen[j] = personen[j+1];
					personen[j+1] = temp;
				}
			}
		}

	}
	
}
