package UE04;

/**
 * @author Maximilian Kniely
 */
public class Edge implements Comparable<Edge>{
    /**
     * distance of that edge
     */
    private final int distance;

    /**
     * neighbor of that edge
     */
    private final Node neighbor;
    
    public Edge(int distance, Node neighbor) {
        this.distance = distance;
        this.neighbor = neighbor;
    }
    
    public Node getNeighbor() {
        return neighbor;
    }
    
    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Edge [distance=" + distance + ", neighbor=" + neighbor.getId() + "]";
    }

    @Override
    public int compareTo(Edge o) {
        return neighbor.getId().compareTo(o.neighbor.getId());
    }

}
