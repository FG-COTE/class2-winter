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
        dx = [0, 1, -1, 0]
        dy = [1, 0, 0, -1]
        for i in range(4):
            if x+dx[i]<m and x+dx[i]>=0 and y+dy[i]<n and y+dy[i]>=0:
                if graph[x+dx[i]][y+dy[i]] == 1:
                    q.append((x+dx[i], y+dy[i]))
                    graph[x+dx[i]][y+dy[i]] = 0
    

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
    