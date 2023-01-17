from collections import deque
import sys

def initialize(h):
    graph = []
    for i in range(h):
        graph.append(list(map(int, sys.stdin.readline().split())))
    return graph


def bfs(x, y, graph):
    q = deque()
    q.append((x, y))
    graph[x][y] = 0
    while len(q) > 0:
        a, b = q.popleft()
        dx = [1, 0, -1, 0, 1, 1, -1, -1]
        dy = [0, 1, 0, -1, 1, -1, -1, 1]
        
        for i in range(8):
            if a+dx[i]<len(graph) and b+dy[i]<len(graph[0]) and a+dx[i]>=0 and b+dy[i]>=0:
                if graph[a+dx[i]][b+dy[i]] == 1:
                    graph[a+dx[i]][b+dy[i]] = 0
                    q.append((a+dx[i], b+dy[i]))
                    
    
if __name__ == "__main__":
    while True:
        w, h = map(int, sys.stdin.readline().split())
        if w == 0 and h == 0:
            break
    
        graph = initialize(h)
        count = 0
        for i in range(h):
            for j in range(w):
                if graph[i][j] == 1:
                    bfs(i, j, graph)
                    count += 1
        print(count)
        