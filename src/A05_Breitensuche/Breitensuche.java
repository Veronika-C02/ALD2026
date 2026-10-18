package A05_Breitensuche;

import java.util.*;


public class Breitensuche extends BaseTree<Integer> {

	@Override
	protected int compare(Integer a, Integer b) {
		return a.compareTo(b);
	}

	/**
	 * Liefert Knoten des Baums ausgehend von Start in Reihenfolge der Breitensuche zurück
	 * @param start Startknoten für Teilbaum
	 * @return Liste der Knoten in Breitenfolge
	 */
	public List<Integer> getBreadthFirstOrder(Node<Integer> start) {
		List<Integer> result = new ArrayList<>();
		if (start == null) return result; // nichts zu tun wenn leer

		// Schlange für alles was noch dran ist
		Queue<Node<Integer>> queue = new LinkedList<>();
		queue.add(start); // mit start anfangen

		while (!queue.isEmpty()) { // solange noch was da ist
			Node<Integer> current = queue.poll(); // vordersten holen
			result.add(current.getValue()); // Wert merken

			// Kinder hinten anstellen, links zuerst
			if (current.getLeft() != null) queue.add(current.getLeft());
			if (current.getRight() != null) queue.add(current.getRight());
		}
		return result;
	}

	/**
	 * Liefert Knoten des Baums ausgehend von Start in Reihenfolge der Breitensuche zurück,
	 * allerdings nur jene Knoten, die in der angegebenen Ebene liegen (Start hat Ebene=1)
	 * @param start Startknoten für Teilbaum
	 * @param level Nur Knoten dieser Ebene ausgeben
	 * @return Liste aller Knoten
	 */
	public List<Integer> getBreadthFirstOrderForLevel(Node<Integer> start, int level) {

		if (start == null || level < 1)
			return Collections.emptyList();
		if (level == 1)
			return List.of(start.getValue());
		List<Integer> nodesAtLevel = new ArrayList<>();
		nodesAtLevel.addAll(getBreadthFirstOrderForLevel(start.getLeft(), level - 1));
		nodesAtLevel.addAll(getBreadthFirstOrderForLevel(start.getRight(), level - 1));
		return nodesAtLevel;

	}

}
