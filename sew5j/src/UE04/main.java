package UE04;

import java.io.File;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws Exception {
        //File[] files = new File("src/UE04/resources/").listFiles();

        int invalid_graphs = 0;

        String prefix = "src/UE04/resources/";
        String[] files = {"big.csv", "Graph_12_with_names.csv", "Graph_A-H.csv", "Graph_A-M.csv", "kaputt_Graph_A-H_a.csv", "kaputt_Graph_A-H_b.csv", "kaputt_Graph_A-H_c.csv", "kaputt_Graph_A-H_d.csv", "kaputt_Graph_A-H_e.csv", "kaputt_Graph_A-H_f.csv", "unzusammenhaengend_Graph_A-M.csv"};

        for (String file : files) {
            Graph graph = new Graph();
            try {
                graph.readGraphFromAdjacencyMatrixFile(prefix + file);
            } catch (Exception e) {
                System.out.println("Invalid file: " + file + "\n");
                invalid_graphs++;
                continue;
            }
            Node startnode = graph.getNodes().get(0);
            graph.calcWithDijkstra(startnode.getId());
            System.out.println("File: " + file);
            System.out.println(graph.getAllPaths());
        }

        System.out.println("Count of invalid Graphs: " + invalid_graphs);
    }
}
