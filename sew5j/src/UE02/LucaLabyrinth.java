package UE02;
//TODO: Mein Name in der Javadoc

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class LucaLabyrinth {
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
     * Wandelt (unveränderliche) Strings in Char-Arrays
     * @param map  der Plan, ein String je Zeile
     * @return char[][] des Plans
     */
    public static char[][] fromStrings(String[] map) {
        char[][] res = new char[map.length][map[0].length()];
        for (int i = 0; i < map.length; i++) {
            res[i] = map[i].toCharArray();
        }
        return res;
    }


    /**
     * Ausgabe des Layrinths
     * @param lab
     */
    public static void printLabyrinth(char[][] lab) {
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[0].length; j++) {
                System.out.print(lab[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Suche den Weg
     * @param zeile     aktuelle Position
     * @param spalte     aktuelle Position
     * @param lab
     * @throws InterruptedException    für die verlangsamte Ausgabe mit sleep()
     */
    public static boolean suchen(int zeile, int spalte, char[][] lab) throws InterruptedException {
        // Diese Methode hab ich überarbeitet, die hat mir gar nicht gefallen
        if (lab[zeile][spalte] == 'A'){
            return true;
        } else if (lab[zeile][spalte]=='#') {
            return false;
        } else if (lab[zeile][spalte]=='O') {
            return false;
        }else {
            lab[zeile][spalte] = 'O';
        }
//		printLabyrinth(lab);
        return suchen(zeile, spalte + 1, lab) || suchen(zeile, spalte - 1, lab) || suchen(zeile + 1, spalte, lab) || suchen(zeile - 1, spalte, lab);
    }

    public static int suchenAlle(int zeile, int spalte, char[][] lab, Set visited, int count) throws InterruptedException {
        if (lab[zeile][spalte] == 'A'){
            return 1;
        } else if (lab[zeile][spalte]=='#') {
            return 0;
        }
        int len = visited.size();
        visited.add(Integer.toString(zeile)+ "_"+Integer.toString(spalte));
        if (len == visited.size()) {
            return 0;
        }

        count += suchenAlle(zeile, spalte+1, lab, visited, count);
        count += suchenAlle(zeile, spalte-1, lab, visited, count);
        count += suchenAlle(zeile+1, spalte, lab, visited, count);
        count += suchenAlle(zeile-1, spalte, lab, visited, count);


        return count;
    }

    public static char[][] readLabyrinthFromFile(String path) throws IOException {
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Path.of(path));
        return fromStrings(lines.toArray(String[]::new));
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        /*char[][] labyrinth = fromStrings(maps[3]);
        printLabyrinth(labyrinth);
        System.out.println("Ausgang gefunden: " + (suchen(5, 5, labyrinth) ? "ja" : "nein"));
        Set visited = new HashSet();
        System.out.println("Anzahl Wege: " + suchenAlle(5, 5, labyrinth, visited, 0));
*/
        char [][] l1 = readLabyrinthFromFile("src/UE02/l1.txt");
        printLabyrinth(l1);
        
        Set v1 = new HashSet();
        System.out.println("Ausgang gefunden: " + (suchen(5, 5, l1.clone()) ? "ja" : "nein"));
        System.out.println("Anzahl Wege: " + suchenAlle(5, 5, l1.clone(), v1, 0));
/*
        char [][] l2= readLabyrinthFromFile("src/UE02_Labyrinth/l2.txt");
        printLabyrinth(l2);
        Set v2 = new HashSet();
        System.out.println("Ausgang gefunden: " + (suchen(5, 5, l2.clone()) ? "ja" : "nein"));
        System.out.println("Anzahl Wege: " + suchenAlle(5, 5, l2.clone(), v2, 0));

        char [][] l3= readLabyrinthFromFile("src/UE02_Labyrinth/l3.txt");
        char [][] l31= readLabyrinthFromFile("src/UE02_Labyrinth/l3.txt");
        printLabyrinth(l3);
        Set v3 = new HashSet();

        System.out.println("Ausgang gefunden: " + (suchen(5, 5, l31) ? "ja" : "nein"));
        printLabyrinth(l31);
        System.out.println("Anzahl Wege: " + suchenAlle(5, 5, l3, v3, 0));
        */
    }
}