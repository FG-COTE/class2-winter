from collections import deque

# 익은 토마토는 1이 된다. 
# 모든 토마토를 탐색해서 마지막에 0이 있다면, 모두 익지는 못하는 상황

def get_tomato(n):
    tomatoes = []
    for i in range(n):
        tomatoes.append(list(map(int, input().split())))
    return tomatoes
    
def bfs(tomatoes):
    for i in range(len(q)):
        x, y = q.popleft()
        dx = [1, 0, -1, 0]
        dy = [0, 1, 0, -1]
        for i in range(4):
            if 0 <= x+dx[i]< n and 0 <= y+dy[i]< m:
                if tomatoes[x+dx[i]][y+dy[i]] == 0:
                    tomatoes[x+dx[i]][y+dy[i]] = 1
                    q.append((x+dx[i], y+dy[i]))
                


if __name__ == "__main__":
    m, n = map(int, input().split())
    tomatoes = get_tomato(n)
    result = 0
    q = deque()
    
    # 처음에 익은 토마토가 있는 위치를 큐에 넣기
    for i in range(n):
        for j in range(m):
            if tomatoes[i][j] == 1:
                q.append((i, j))
                
    # 큐에 무언가 있다면 bfs() 호출
    while len(q) > 0:
        bfs(tomatoes)
        result += 1
    
    # 상자에 0이 있다면 -1 출력, 0이 없다면 최소일수 출력
    for i in tomatoes:
        for j in i:
            if j == 0:
                result = 0
                break
    print(result-1)