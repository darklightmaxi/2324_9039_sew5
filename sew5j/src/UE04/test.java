package UE04;

import java.io.IOException;
import java.nio.file.Path;

public class test {

    public static void main(String[] args) throws IOException {
        //String s[] = "1;2;3;4;;;;;".split(";",-1);
        String Filename = "Graph_A-H.csv";
        String path = "src/UE04/resources/"+Filename;
        Graph g = new Graph();
        g.readGraphFromAdjacencyMatrixFile(Path.of(path));
    }
}
