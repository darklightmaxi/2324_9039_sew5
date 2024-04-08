package UE04;

import java.util.*;

public class Node implements Comparable<Node> {
    /**
     * Unique Identifier
     */
    private final String id;

    /**
     * all edges the node has
     */
    private HashSet<Edge> edges; // Schneller als Treeset, Reihenfolge ist mir egal

    /**
     * current distance to this node
     */
    private int distance;

    /**
     * previous node for the shortest route
     */
    private Node previous;

    /**
     * has this node been visited?
     */
    private boolean isVisited;

    public Node(String id) {
        this.id = id;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    @Override
    public int compareTo(Node o) {
        return this.distance == o.distance ? this.id.compareTo(o.id) : this.distance - o.distance;
    }

    public Node getPrevious() {
        return previous;
    }

    @Override
    public String toString() {
        return "Node [id=" + id + ", distance=" + distance + ", edges=" + edges + "]";
    }

    public void init() {
        isVisited = false;
        previous = null;
        distance = Integer.MAX_VALUE;
    }

    public void setStartNode() {
        distance = 0;
    }

    public String getId() {
        return id;
    }

    public int getDistance() {
        return distance;
    }

    public String getPath() {
        return "";
    }

    public boolean isFirst() {
        return previous == null && distance == 0;
    }

    public void visit(PriorityQueue<Node> queue){
        isVisited = true;
        for (Edge edge : edges) {
            Node neighbor = edge.getNeighbor();
            queue.add(neighbor)
        }
    }

}
