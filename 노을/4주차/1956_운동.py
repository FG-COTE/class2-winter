import sys

v, e = map(int, sys.stdin.readline().split())
distance = [[1e9 for j in range(v+1)] for i in range(v+1)]

for i in range(e):
    a, b, c = map(int, sys.stdin.readline().split())
    distance[a][b] = c

    
for i in range(1, v+1):
    for j in range(1, v+1):
        if i==j:
            distance[i][j] = 0
            
    
for a in range(1, v+1):
    for b in range(1, v+1):
        for c in range(1, v+1):
            if distance[a][c] > distance[a][b] + distance[b][c]:
                distance[a][c] = distance[a][b] + distance[b][c]
                
result = 1e9        
for i in range(1, v+1):
    for j in range(i+1, v+1):
        if distance[i][j] + distance[j][i] < result:
            result = distance[i][j] + distance[j][i]
            
if result == 1e9:
    print(-1)
else:
    print(result)