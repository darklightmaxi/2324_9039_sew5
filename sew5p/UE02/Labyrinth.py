import argparse
import time

def dfs(zeile, spalte, lab, visited, path=[], p=(False,0)):
    count = 0

    if visited[zeile][spalte]:
        return 0
    if lab[zeile][spalte] == '#':
        return 0
    if lab[zeile][spalte] == 'A':
        if p:
            print(path)
        return 1

    path.append((zeile, spalte))
    visited[zeile][spalte] = True
    count = (dfs(zeile + 1, spalte, lab, visited, path, p) + dfs(zeile - 1, spalte, lab, visited, path, p)
             + dfs(zeile, spalte + 1, lab, visited, path, p) + dfs(zeile, spalte - 1, lab, visited, path, p))
    visited[zeile][spalte] = False
    del path[-1]

    return count

parser = argparse.ArgumentParser(description='calculate number of ways through a labyrinth', add_help=True)

# cords
parser.add_argument('--xstart', '-x', default=1, type=int, help='x-coordinate to start')
parser.add_argument('--ystart', '-y', default=1, type=int, help='y-coordinate to start')

# print
parser.add_argument('--print', '-p', default=False, type=bool, help='print output of every solution')
parser.add_argument('--time', '-t', default=None, type=int, help='print total calculation time (in milliseconds)')
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

if p:
    p=True

print(f'Anzahl Wege: {dfs(x, y, lab, vis, p=(p,d))}')

if t:
    end_time = time.time()
    print(f'Time: {round((end_time-start_time)*1000, 2)}ms')