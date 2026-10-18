package A06_Tiefensuche;

import java.util.ArrayList;
import java.util.List;

import A05_Breitensuche.BaseTree;
import A05_Breitensuche.Node;

public class Tiefensuche extends BaseTree<Film> {

	@Override
	/**
	 * Sortierkriterium im Baum: Länge des Films
	 */
	protected int compare(Film a, Film b) {
		return Double.compare(a.getLänge(), b.getLänge());
	}

	/**
	 * Retourniert die Titelliste der Film-Knoten des Teilbaums in symmetrischer Folge (engl. in-order, d.h. links-Knoten-rechts)
	 * @param node Wurzelknoten des Teilbaums
	 * @return Liste der Titel in symmetrischer Reihenfolge
	 */
	public List<String> getNodesInOrder(Node<Film> node) {
		List<String> result = new ArrayList<>();

		// Abbruchbedingung: leerer Teilbaum liefert eine leere Liste
		if (node == null) {
			return result;
		}
		// 1. zuerst der ganze linke Teilbaum (dort stehen die kürzeren Filme)
		result.addAll(getNodesInOrder(node.getLeft()));

		//2. dann der Knoten selbst
		result.add(node.getValue().getTitel());

		// 3. zum schluss der rechte Teilbaum (die längere Filme)
		result.addAll(getNodesInOrder(node.getRight()));

		// wegen der Baumordnung ist die Liste automatisch nach Länge sortiert
		return result;
	}
	
	/**
	 * Retourniert Titelliste jener Filme, deren Länge zwischen min und max liegt, in Hauptreihenfolge (engl. pre-order, d.h. Knoten-links-rechts)
	 * @param min Minimale Länge des Spielfilms
	 * @param max Maximale Länge des Spielfilms
	 * @return Liste der Filmtitel in Hauptreihenfolge
	 */
	public List<String> getMinMaxPreOrder( double min, double max) {
		// Fassade für außen: holt sich die Wurzel selbst und startet die Rekursion
		return getMinMaxPreOrderNode(getRoot(), min, max);

	}

	// rekursiver Helfer - braucht den Knoten, um in die Teilbäume zu kommen
	private List<String> getMinMaxPreOrderNode(Node<Film> node, double min, double max) {
		List<String> result = new ArrayList<>();

		//leerer Teilbaum -> nichts zu tun
		if (node == null) {
			return result;
		}

		double länge = node.getValue().getLänge();

		// 1. Knoten selbst prüfen: liegt die Länge im erlaubten Bereich?
		if (länge >= min && länge <= max) {
			result.add(node.getValue().getTitel());}

		// 2. links 3. rechts Teilbaum -> das macht die Hauptreinfolge aus
		result.addAll(getMinMaxPreOrderNode(node.getLeft(), min, max));
		result.addAll(getMinMaxPreOrderNode(node.getRight(), min, max));

		return result;
	}

}
