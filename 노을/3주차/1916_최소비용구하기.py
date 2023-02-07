import heapq
import sys


n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
graph = [[] for i in range(n+1)]
distance = [1e9 for i in range(n+1)]

for i in range(m):
    a, b, c = map(int, sys.stdin.readline().split())
    graph[a].append((b, c))
    
start, end = map(int, sys.stdin.readline().split())


hq = []
def dijkstra(start):
    distance[start] = 0
    heapq.heappush(hq, (start, 0))
        
    while hq:
        b, c = heapq.heappop(hq)
        if c > distance[b]:
            continue
        for j in graph[b]:
            update_distance = distance[b] + j[1]
            if update_distance < distance[j[0]]:
                distance[j[0]] = update_distance
                heapq.heappush(hq, (j[0], update_distance ))
dijkstra(start)
print(distance[end])
        