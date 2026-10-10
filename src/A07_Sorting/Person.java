package A07_Sorting;

public class Person {
	
	private final String nachname;
	
	private final String vorname;

	public Person(String vorname, String nachname) {
		this.nachname = nachname;
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	/**
	 * Vergleicht zwei Personen miteinander
	 * @return <0, wenn a<b || =0, wenn a=b || >0, wenn a>b
	 */
	public int compareTo(Person p) {
		// 1. erst Nachnamen vergleichen
		int ergebnis = nachname.compareTo(p.getNachname());

		// 2. wenn gleich (== 0), dann Vornamen vergleichen
		if (ergebnis == 0) {
			ergebnis = vorname.compareTo(p.getVorname());
		}

		return ergebnis;
	}
}
