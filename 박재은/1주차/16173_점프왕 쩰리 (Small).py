from collections import deque
import sys
input = sys.stdin.readline

global jelly
global dx
global dy
global n

n = int(input())

# jelly 지도 만들기
jelly = []
for i in range(0, n):
    jelly.append(list(map(int, input().split())))

# 방문 여부 확인
visited = []
for i in range(0, n):
    visited.append([False] * n)

# 움직이기 dx -> (x좌표 + 1), dy -> (y좌표 + 1)
dx = [1, 0]
dy = [0, 1]

queue = deque()
queue.append((0, 0))
visited[0][0] = True


def bfs(x, y, visited):

    while queue:
        x, y = queue.popleft()

        if jelly[x][y] == -1:
            return 'HaruHaru'
        
        for i in range(0, 2):
            nx = x + dx[i] * jelly[y][x]
            ny = y + dy[i] * jelly[y][x]
            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            if visited[nx][ny]:
                continue
            if not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny))
    return 'Hing'
print(bfs(0, 0, visited))