package UE04;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class GraphTest {

    private Graph graph;

    @Before
    public void setUp() {
        graph = new Graph();
    }

    @Test
    public void testReadGraphFromAdjacencyMatrixFile() throws Exception {
        graph.readGraphFromAdjacencyMatrixFile("src/UE04/resources/Graph_A-H.csv"); // Provide path to test file

        // Assert that nodes are correctly initialized
        assertEquals(8, graph.getNodes().size());
        assertEquals("A", graph.getNodes().get(0).getId());
        assertEquals("B", graph.getNodes().get(1).getId());
        assertEquals("C", graph.getNodes().get(2).getId());
        assertEquals("D", graph.getNodes().get(3).getId());
        assertEquals("E", graph.getNodes().get(4).getId());
        assertEquals("F", graph.getNodes().get(5).getId());
        assertEquals("G", graph.getNodes().get(6).getId());
        assertEquals("H", graph.getNodes().get(7).getId());
    }

    @Test
    public void testCalcWithDijkstra() throws Exception {
        graph.readGraphFromAdjacencyMatrixFile("src/UE04/resources/Graph_A-H.csv"); // Provide path to test file
        graph.calcWithDijkstra("A");

        // Assert that Dijkstra's algorithm sets correct distances
        assertEquals(0, graph.getNodeMap().get("A").getDistance());
        assertEquals(1, graph.getNodeMap().get("B").getDistance());
        assertEquals(3, graph.getNodeMap().get("C").getDistance());
    }
}