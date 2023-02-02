from collections import deque
import sys
input = sys.stdin.readline
queue = deque()

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
answer = list()
t = int(input())

def bfs(x, y, cabbage):
    queue = [(x, y)]
    while queue:
        x, y = queue.pop()
        for i in range(0, 4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= m or nx < 0:
                continue
            if ny >= n or ny < 0:
                continue
            if cabbage[ny][nx] == 1:
                cabbage[ny][nx] = 0
                queue.append((nx, ny))
    return
        

# 테스트 케이스의 수 만큼 반복
for _ in range(0, t):
    m, n, k = map(int, input().split())
    cabbage = [[0] * m for s in range(0, n)]
    worm = 0

    # 배추 지도 입력 받기
    for _ in range(0, k):
        a, b = map(int, input().split())
        cabbage[b][a] = 1
    
    for a in range(0, n):
        for b in range(0, m):
            if cabbage[a][b] == 1:
                cabbage[a][b] = 0
                bfs(a, b, cabbage)
                worm += 1
    answer.append(worm)
 
for i in answer:
    print(i)
