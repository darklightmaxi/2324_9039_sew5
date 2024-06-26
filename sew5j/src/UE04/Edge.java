package UE04;

/**
 * Die Klasse Edge repräsentiert eine Edge im Graphen.
 * Sie speichert die Distanz zum Nachbarknoten und den Nachbarknoten selbst.
 *
 * @author Maximilian Kniely
 */
public class Edge {
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

    private int distance;
    private Node neighbour;

    // Get Neighbour on other side of edge
    public Node getNeighbour(){
        return this.neighbour;
    }

    // Get distance to neighbour
    public int getDistance(){
        return this.distance;
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