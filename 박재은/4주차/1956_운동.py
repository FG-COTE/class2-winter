# 1e9
# math.inf
# float('inf')

import math
import sys
input = sys.stdin.readline

# v == 마을의 수, e == 도로의 수
v, e = map(int, input().split())

# 왜 10,000은 안 될까,,,,,
village = [[10001] * (v + 1) for _ in range(0, (v + 1))]

for _ in range(0, e):
    a, b, c = map(int, input().split())
    village[a][b] = c

# 플로이드 워셜 구현
# k = 거쳐가는 노드
for k in range(1, v + 1):
    # i = 출발하는 노드
    for i in range(1, v + 1):
       #g = 도착 노드
        for g in range(1, v + 1):
            village[i][g] = min(village[i][k] + village[k][g], village[i][g])  

answer = math.inf
for i in range(1, v + 1):
    for k in range(1, v + 1):
        if village[i][k] > 10000 or village[k][i] > 10000:
            continue
        answer = min(answer, village[i][k] + village[k][i])

if answer == math.inf:
    print(-1)
else:
    print(answer)