package UE04;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Maximilian Kniely
 */
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

    public boolean getVisited(){
        return isVisited;
    }

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

    public void visit(PriorityQueue<Node> queue) {
        isVisited = true;
        for (Edge edge : edges) {
            Node neighbour = edge.getNeighbor();
            int newDist = distance + edge.getDistance();
            if (newDist < neighbour.distance) {
                if (edge.getDistance() == Integer.MAX_VALUE) queue.remove(edge.getNeighbor());
                neighbour.distance = newDist;
                neighbour.previous = this;
                queue.add(edge.getNeighbor());
            }
        }
    }

    public String edgesToStr() {
        return edges.stream().map(it -> it.getNeighbor().id + ":" + it.getDistance()).collect(Collectors.joining(" ", "", ""));
    }
}
