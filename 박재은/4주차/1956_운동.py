import sys
input = sys.stdin.readline

# v == 마을의 수, e == 도로의 수
v, e = map(int, input().split())

village = [[float('inf')] * (v + 1) for _ in range(0, (v + 1))]

for _ in range(0, e):
    a, b, c = map(int, input().split())
    village[a][b] = c

# 플로이드 워셜 구현
for k in range(1, v + 1):
    for i in range(1, v + 1):
        for g in range(1, v + 1):
            village[i][g] = min(village[i][k] + village[k][g], village[i][g])  

answer = float('inf')
for i in range(1, v + 1):
    for k in range(1, v + 1):
        answer = min(answer, village[i][k] + village[k][i])

if answer == float('inf'):
    print(-1)
else:
    print(answer)