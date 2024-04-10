package UE04;

/**
 * Die Klasse Edge repräsentiert eine Edge im Graphen.
 * Sie speichert die Distanz zum Nachbarknoten und den Nachbarknoten selbst.
 *
 * @author Maximilian Kniely
 */
public class Edge {

    private int distance;
    private Node neighbour;

    public Node getNeighbour(){
        return this.neighbour;
    }

    public int getDistance(){
        return this.distance;
    }

    /**
     * Konstruktor für die Edge Klasse.
     * Initialisiert die Kante mit einer Distanz und einem Nachbarknoten.
     *
     * @param distance die Distanz zur Nachbarknoten
     * @param neighbour der Nachbarknoten
     */
    public Edge(int distance, Node neighbour) {
        this.distance = distance;
        this.neighbour = neighbour;
    }

    /**
     * Gibt einen String mit den Attributen der Edge zurück.
     * @return ein String mit den Attributen der Kante
     */
    @Override
    public String toString() {
        return "Edge{" +
                "distance=" + distance +
                ", neighbour=" + neighbour +
                '}';
    }
}