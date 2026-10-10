package A10_DijkstraPQShortestPath;


public class DijkstraPQShortestPath extends FindWay {
	private int[] dist;

	public DijkstraPQShortestPath(Graph graph) {
		super(graph);
	}

	/**
	 * Startentfernung initialisieren
	 * 
	 * //@param from Startknoten
	 *
	 */
	protected void initPathSearch() {
		int numv = graph.numVertices();
		dist = new int[numv];
		for (int i = 0; i < numv; i++) {
			dist[i] = 9999; // Summen im Graph dürfen nie mehr ergeben
		}
	}

	/**
	 * Berechnet *alle* kürzesten Wege ausgehend vom Startknoten Setzt dist[]-
	 * und pred[]-Arrays, kein Rückgabewert
	 * 
	 * @param from
	 *            Startknoten
	 */
	protected boolean calculatePath(int from, int to) {

		// TODO: IHRE IMPLEMENTIERUNG

		// Array Befüllen
		int numVertices = graph.numVertices();
		while (numVertices > 0) {
			int currentWeight = graph.getEdgeWeight(from,to);
			numVertices -= 1;
			dist[numVertices] = currentWeight; // distanzen eingetragen

		}

		// Heap Erzeugung und befüllen
		VertexHeap heap = null;
		int arrayLength = dist.length;
		while (arrayLength > 0) {

			Vertex vertex = new Vertex(arrayLength,dist[arrayLength]);
			heap.insert(vertex);
			arrayLength -= 1;

		}

		// Kosten auf 0 setzen

		// While


		// neue Distanzen anpassen --> Prüfungsrelevant


		return true;
	}
}
