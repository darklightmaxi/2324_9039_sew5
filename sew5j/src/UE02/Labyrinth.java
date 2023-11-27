package UE02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author 9039
 * Klasse für Labyrinthe
 */
public class Labyrinth {
    public static String[][] maps = {{
            "############",
            "#  #     # #",
            "## # ### # #",
            "#  # # # # #",
            "## ### # # #",
            "#        # #",
            "## ####### #",
            "#          #",
            "# ######## #",
            "# #   #    #",
            "#   #   # ##",
            "######A#####"
    }, {
            "################################",
            "#                              #",
            "# ############################ #",
            "# # ###       ##  #          # #",
            "# #     ##### ### # ########## #",
            "# #   ##### #     # #      ### #",
            "# # ##### #   ###   # # ## # # #",
            "# # ### # ## ######## # ##   # #",
            "# ##### #  # #   #    #    ### #",
            "# # ### ## # # # # ####### # # #",
            "# #        # #   #     #     # #",
            "# ######## # ######### # ### # #",
            "# ####     #  # #   #  # ##### #",
            "# # #### #### # # # # ## # ### #",
            "#                      # #     #",
            "###########################A####"
    }, {
            "###########################A####",
            "#   #      ## # # ###  #     # #",
            "# ###### #### # # #### ##### # #",
            "# # ###  ## # # # #          # #",
            "# # ### ### # # # # # #### # # #",
            "# #     ### # # # # # ## # # # #",
            "# # # # ### # # # # ######## # #",
            "# # # #     #          #     # #",
            "# ### ################ # # # # #",
            "# #   #             ## # #   # #",
            "# # #### ############# # #   # #",
            "# #                    #     # #",
            "# # #################### # # # #",
            "# # #### #           ###     # #",
            "# # ## # ### ### ### ### # ### #",
            "# #    #     ##  ##  # ###   # #",
            "# ####   ###### #### # ###  ## #",
            "###########################A####"
    }, {
            "#############",
            "#           #",
            "#           #",
            "#           #",
            "###########A#"
    }};

    /**
     * Wandelt (unveränderliche) Strings in Char-Arrays um
     * @param map der Plan, ein String je Zeile
     * @return char[][] des Plans
     */
    public static char[][] fromStrings(String[] map) {
        char[][] lab = new char[map.length][map[0].length()];

        for (int i = 0; i < map.length; i++) {

            lab[i] = map[i].toCharArray();

        }

        return lab;
    }


    /**
     * Ausgabe des Layrinths
     * @param lab
     */
    public static void printLabyrinth(char[][] lab) {
        for (char[] c : lab) {

            System.out.println(c);

        }
    }

    /**
     * Eine Methode, die nach einem Weg sucht, und true/false returnt je nach Antwort, die BFS wird mit einer Queue und einer Schleife realisiert
     * @param zeile  aktuelle Position (X)
     * @param spalte aktuelle Position (Y)
     * @param lab labyrinth
     * @throws InterruptedException für die verlangsamte Ausgabe mit sleep()
     */

    public static boolean suchen(int zeile, int spalte, char[][] lab) throws InterruptedException {
        record pair(int x, int y) { }

        Queue<pair> queue = new ArrayDeque();
        queue.add(new pair(zeile, spalte));

        boolean[][] visited = new boolean[lab.length][lab[0].length];

        while (!queue.isEmpty()) {
            pair object = queue.poll();

            if (lab[object.x][object.y] == '#') {
                continue;
            }

            if (visited[object.x][object.y]) {
                continue;
            }

            if (lab[object.x][object.y] == 'A') return true;

            visited[object.x][object.y] = true;

            queue.add(new pair(object.x + 1, object.y));
            queue.add(new pair(object.x, object.y + 1));
            queue.add(new pair(object.x, object.y - 1));
            queue.add(new pair(object.x - 1, object.y));

            char[][] copyLab = new char[lab.length][lab[0].length];

            for (int i = 0; i < lab.length; i++){
                for (int j = 0; j < lab[0].length-1; j++){          // Hier length-1 weil es mir eine ganz komische ArrayOutOfBounce Exception gegeben hat
                    copyLab[i][j] = lab[i][j];
                }
            }

            copyLab[object.x][object.y] = '0';
            lab[object.x][object.y] = 'X';

            printLabyrinth(copyLab);
            Thread.sleep(1);

            System.out.println();
        }

        return false;
    }

    /**
     * Pseudomethode für dfs
     * @param zeile  aktuelle Position (X)
     * @param spalte aktuelle Position (Y)
     * @param lab Labyrinth
     * @return Anzahl aller einzigartigen Wege
     */
    public static int suchenAlle(int zeile, int spalte, char[][] lab) {
        return dfs(zeile, spalte, lab, new boolean[lab.length][lab[0].length]);
    }

    /**
     * Sucht die Anzahl aller Wege durch ein Labyrinth. Hierfür wird DFS (Depth-First-Search, Tiefensuche) verwendet.
     * @param zeile  aktuelle Position (X)
     * @param spalte aktuelle Position (Y)
     * @param lab    Labyrinth
     * @param visited ein 2dim Array, welches Zeigt wo man bereits war
     * @return Anzahl der einzigartigen Wege
     */
    public static int dfs(int zeile, int spalte, char[][] lab, boolean[][] visited) {

        int count = 0;

        if (visited[zeile][spalte] || lab[zeile][spalte] == '#') return 0;

        if (lab[zeile][spalte] == 'A') return 1;

        visited[zeile][spalte] = true;

        count = dfs(zeile + 1, spalte, lab, visited) + dfs(zeile - 1, spalte, lab, visited) + dfs(zeile, spalte + 1, lab, visited) + dfs(zeile, spalte - 1, lab, visited);

        visited[zeile][spalte] = false;

        return count;
    }


    /**
     * Ja die braucht man halt
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        char[][] labyrinth = fromStrings(maps[2]);

        String file = "src/UE02/l2.txt";
        ArrayList<String> in = (ArrayList<String>) Files.readAllLines(Path.of(file));
        char[][] labyrinth2 = new char[in.size()][in.get(0).length()];

        for (int i = 0; i < in.size(); i++) {
            String s = in.get(i);
            labyrinth2[i] = (s.toCharArray());
        }


        //printLabyrinth(labyrinth);
        //System.out.println("Test Labyrinth");
        //System.out.println("Ausgang gefunden: " + (suchen(5, 5, labyrinth) ? "ja" : "nein"));
        //System.out.println("Anzahl Wege: " + suchenAlle(5, 5, labyrinth));
        //System.out.println();


        //printLabyrinth(labyrinth2);
        System.out.println("Labyrinth aus File");
        System.out.println("Ausgang gefunden: " + (suchen(5, 5, labyrinth2) ? "ja" : "nein"));


        System.out.println("Anzahl Wege: " + suchenAlle(5, 5, labyrinth2));
    }

}
