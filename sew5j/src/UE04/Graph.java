package UE04;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Graph {
    record pair(int distance, String name){}
    private PriorityQueue<pair> pq;
    private ArrayList<pair> nodes;
    public void readGraphFromAdjacencyMatrixFile(Path file) throws IOException {
        //String s[] = "1;2;3;4;;;;;".split(";",-1);

        List<String> lines = Files.readAllLines(file);
        for (String s: lines){
            System.out.println(s);
        }
    }
    public String getAllPaths(){
        return "";
    }
    public void calcWithDijkstra(String startNodeId){
        pq.add(new pair(0, startNodeId));
        while (!pq.isEmpty()){
            pair node = pq.poll();
        }
    }
}
