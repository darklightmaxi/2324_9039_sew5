package UE04;

import java.util.ArrayList;
import java.util.List;
/**
 * Die Klasse Node repräsentiert einen Knoten im Graphen.
 * Sie implementiert das Comparable-Interface zur Vergleichbarkeit von Knoten anhand ihrer Distanz.
 *
 * @author Maximilian Kniely
 */
public class Node implements Comparable<Node> {

    private String id;
    private List<Edge> edges;
    private int distance;
    private Node previous;
    private boolean isVisited;

    public void setPrevious(Node previous){
        this.previous = previous;
    }

    public int getDistance(){
        return this.distance;
    }

    public Node getPrevious(){
        return this.previous;
    }

    public String getId(){
        return this.id;
    }

    public void setDistance(int distance){
        this.distance = distance;
    }

    public boolean getVisited(){
        return this.isVisited;
    }

    public void setVisited(boolean isVisited){
        this.isVisited = isVisited;
    }

    /**
     * Konstruktor für die Node Klasse.
     * Initialisiert den Knoten mit einer ID, einer leeren Liste von Kanten,
     * einer maximalen Distanz und dem Zustand "nicht besucht".
     *
     * @param id die ID des Knotens
     */
    public Node(String id) {
        this.id = id;
        edges = new ArrayList<>();
        distance = Integer.MAX_VALUE; // Infinite distance initially
        previous = null;
        isVisited = false;
    }

    /**
     * Ändert die Distanz und den vorherigen Knoten des aktuellen Knotens.
     *
     * @param newDistance die neue Distanz
     * @param newPrevious der neue vorherige Knoten
     */
    public void change(int newDistance, Node newPrevious) {
        distance = newDistance;
        previous = newPrevious;
    }

    /**
     * Vergleicht den aktuellen Knoten mit einem anderen Knoten anhand ihrer Distanzen.
     *
     * @param other der andere Knoten
     * @return -1, 0 oder 1, abhängig davon, ob die Distanz des aktuellen Knotens kleiner, gleich oder größer als die des anderen Knotens ist
     */
    @Override
    public int compareTo(Node other) {
        return this.distance == other.distance ? this.getId().compareTo(other.getId()) : Integer.compare(this.distance, other.distance);
    }

    /**
     * Gibt eine Zeichenkette mit der ID des Knotens zurück.
     *
     * @return eine Zeichenkette mit der ID des Knotens
     */
    @Override
    public String toString() {
        return "Node ID: " + id;
    }

    /**
     * Gibt den Pfad vom Startknoten bis zu diesem Knoten zurück.
     *
     * @return eine Zeichenkette mit dem Pfad vom Startknoten bis zu diesem Knoten
     */
    public String getPath() {
        // Implementation des Pfads von Startknoten bis zu diesem Knoten
        return null;
    }

    /**
     * Fügt dem aktuellen Knoten eine neue Kante hinzu.
     *
     * @param edge die neue Kante
     */
    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    /**
     * Initialisiert den Knoten für eine neue Berechnung des kürzesten Pfades.
     * Setzt die Distanz auf maximalen Wert, den vorherigen Knoten auf null und den Zustand auf "nicht besucht".
     */
    public void init() {
        distance = Integer.MAX_VALUE;
        previous = null;
        isVisited = false;
    }

    /**
     * Besucht alle Nachbarn des aktuellen Knotens und bietet ihre Distanzen für die Verwendung im Dijkstra-Algorithmus an.
     *
     * @param g der Graph, zu dem der Knoten gehört
     */
    public void visit(Graph g) {
        for(var e:this.edges){
            Node next = e.getNeighbour();
            int distance = e.getDistance();
            g.offerDistance(next, this, this.distance + distance);
        }
    }
}