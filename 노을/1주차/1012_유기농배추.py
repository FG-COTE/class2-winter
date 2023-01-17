from collections import deque


def initialize(m, n, count):
    graph = [] 
    for i in range(m):
        graph.append([0] * (n))
        
    for i in range(count):
        x, y = map(int, input().split())
        graph[x][y] = 1
    return graph
    

def bfs(x, y, graph):
    graph[x][y] = 0
    q = deque()
    q.append((x, y))
    while len(q) > 0:
        x, y = q.popleft()
        if x+1<m and graph[x+1][y] == 1:
            q.append((x+1, y))
            graph[x+1][y] = 0
        if y+1<n and graph[x][y+1] == 1:
            q.append((x, y+1))
            graph[x][y+1] = 0
        if x-1>=0 and graph[x-1][y] == 1:
            q.append((x-1, y))
            graph[x-1][y] = 0
        if y-1>=0 and graph[x][y-1] == 1:
            q.append((x, y-1))
            graph[x][y-1] = 0
    

if __name__ == "__main__":
    test_case = int(input())
    for i in range(test_case):
        m, n, count = map(int, input().split())
        graph = initialize(m, n, count)
        result = 0
        for x in range(m):
            for y in range(n):
                if graph[x][y] == 1:
                    result += 1
                    bfs(x, y, graph)
        print(result)
    