import argparse
import time
from copy import copy

"""
    @author 9039
"""

"""
    Variable für die Paths, die gefunden werden
"""
paths = []

def dfs(zeile, spalte, lab, visited, path=[]):
    """
    Eine Methode, die zurückliefert wie viele einzigartige Wege das Labyrinth hat, es wird DFS (Tiefensuche, Depth-First-Search) verwendet
    :param zeile: derzeitiger x Wert
    :param spalte: derzeitiger y Wert
    :param lab: labyrinth
    :param visited: besuchte Koordinaten
    :param path: Pfad des Weges
    :return: Anzahl der möglichen Wege durch das Labyrinth
    """
    count = 0

    if visited[zeile][spalte] or lab[zeile][spalte] == '#':
        return 0
    if lab[zeile][spalte] == 'A':
        paths.append(copy(path))
        return 1

    path.append((zeile, spalte))
    visited[zeile][spalte] = True
    count = (dfs(zeile + 1, spalte, lab, visited, path) + dfs(zeile - 1, spalte, lab, visited, path)
             + dfs(zeile, spalte + 1, lab, visited, path) + dfs(zeile, spalte - 1, lab, visited, path))
    visited[zeile][spalte] = False
    del path[-1]

    return count

def printPaths(lab):
    """
    Printet die verschiedenen Paths des Labyrinths
    :param lab: Labyrinth
    """
    modified_lab = copy(lab)
    for i in range(len(lab)):
        modified_lab[i] = list(lab[i])

    for path in paths:
        for x, y in path:
            modified_lab[x][y] = 'X'

        for i in modified_lab:
            print(''.join(i))

        modified_lab = copy(lab)
        for i in range(len(lab)):
            modified_lab[i] = list(lab[i])


parser = argparse.ArgumentParser(description='calculate number of ways through a labyrinth', add_help=True)

# cords
parser.add_argument('--xstart', '-x', default=1, type=int, help='x-coordinate to start')
parser.add_argument('--ystart', '-y', default=1, type=int, help='y-coordinate to start')

# print
parser.add_argument('--print', '-p', action="store_true", help='print output of every solution')
parser.add_argument('--time', '-t', action="store_true", help='print total calculation time (in milliseconds)')
parser.add_argument('--delay', '-d', default=None, type=int, help='delay after printing a solution (in milliseconds)')

# input-file VERPFLICHTEND
parser.add_argument('input_file', help='Pfad zur Eingabedatei')

# Parsing der Befehlszeilenargumente
args = parser.parse_args()

# Zugriff auf die Argumente
input_file = args.input_file
x = args.xstart
y = args.ystart
p = args.print
t = args.time
d = args.delay

start_time, end_time = 0, 0

lab = open(input_file).read().strip().split('\n')
vis = [[False for _ in range(len(lab))] for _ in range(len(lab[0]))]

if t:
    start_time = time.time()

print(f'Anzahl Wege: {dfs(x, y, lab, vis)}')

if p:
    printPaths(lab)

if t:
    end_time = time.time()
    print(f'Time: {round((end_time - start_time) * 1000, 2)}ms')