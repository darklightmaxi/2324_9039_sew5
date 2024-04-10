package UE04;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Die Klasse Graph repräsentiert einen Graphen und implementiert das Interface IOfferDistance.
 * Sie ermöglicht das Einlesen eines Graphen aus einer Adjazenzmatrix-Datei,
 * die Berechnung aller kürzesten Pfade mittels Dijkstras Algorithmus
 * sowie das Anbieten von Distanzen für die Verwendung im Algorithmus.
 *
 * @author Maximilian Kniely
 */
public class Graph implements IOfferDistance {

    private TreeSet<Node> pq;
    private List<Node> nodes;
    private Map<String, Node> nodeMap = new TreeMap<>();

    public List<Node> getNodes(){
        return this.nodes;
    }

    public Map<String, Node> getNodeMap(){
        return this.nodeMap;
    }

    /**
     * Konstruktor für die Graph Klasse.
     * Initialisiert die PriorityQueue, die Liste von Knoten und die Map zur Speicherung von Knoten.
     */
    public Graph() {
        pq = new TreeSet<>();
        nodes = new ArrayList<>();
    }

    /**
     * Liest den Graphen aus einer Adjazenzmatrix-Datei ein.
     *
     * @param filePath der Pfad zur Adjazenzmatrix-Datei
     * @throws IOException wenn ein Fehler beim Lesen der Datei auftritt
     */
    public void readGraphFromAdjacencyMatrixFile(String filePath) throws Exception {

        try {

            List<String> lines = Files.readAllLines(Path.of(filePath));
            String[] names = lines.get(0).split(";", -1);
            for (int i = 1; i < names.length; i++) {
                Node node = new Node(names[i]);
                nodeMap.put(names[i], node);
                this.nodes.add(node);
            }
            for (int i = 1; i < lines.size(); i++) {
                var cur = lines.get(i).split(";", -1);

                if (cur.length != names.length || !cur[0].equals(names[i]) || lines.size() != names.length) {
                    throw new Exception("Graph is invalid!");
                }

                for (int j = 1; j < names.length; j++) {
                    if (cur[j].isEmpty()) {
                        continue;
                    }
                    nodeMap.get(cur[0]).addEdge(new Edge(Integer.parseInt(cur[j]), nodeMap.get(names[j])));
                }
            }
        }
        catch (Exception invalidGraph){
            throw new Exception("Graph is invalid!");
        }
    }

    /**
     * Gibt eine Zeichenkette mit den kürzesten Pfaden für alle Knoten zurück.
     *
     * @return eine Zeichenkette mit den kürzesten Pfaden für alle Knoten
     */
    public String getAllPaths() {
        String out = "";
        for (var node : nodes) {
            Node cur = node;
            if (cur.getPrevious() == null){
                out += cur.getId() + "----> is start node\n";
                continue;
            }
            out += "Distance: " + cur.getDistance() + " ";
            while (cur.getPrevious() != null) {
                out += cur.getId() + " -> ";
                cur = cur.getPrevious();
            }
            out += cur.getId() + "\n";
        }
        return out;
    }

    /**
     * Berechnet den kürzesten Pfad von einem Startknoten zu allen anderen Knoten im Graphen.
     *
     * @param startNodeId die ID des Startknotens
     */
    public void calcWithDijkstra(String startNodeId) {
        for (var node : nodes) node.init();
        pq = new TreeSet<>();
        Node start = nodeMap.get(startNodeId);
        start.setDistance(0);

        pq.add(start);
        while (!pq.isEmpty()) {
            Node cur = pq.first();
            pq.remove(cur);

            if (cur.getVisited())
                continue;

            cur.setVisited(true);
            cur.visit(this);
        }
    }

    /**
     * Fügt eine neue Distanz für den nächsten zu betrachtenden Knoten hinzu.
     * @param node2change Node die gechanged werden soll
     * @param newPrevious Neue Previous Node
     * @param newDistance Neue Distance
     */
    @Override
    public void offerDistance(Node node2change, Node newPrevious, int newDistance) {
        if (node2change.getDistance() > newDistance) {
            pq.remove(node2change);
            node2change.setDistance(newDistance);
            node2change.setPrevious(newPrevious);
            pq.add(node2change);
        }
    }
}