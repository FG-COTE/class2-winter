from collections import deque
import sys


# 초기화
def initialize():
    n = int(sys.stdin.readline())
    for i in range(n):
        graph.append(list(map(int, sys.stdin.readline().split())))
    return n

# bfs
def bfs(x, y):
    q = deque()
    q.append([x, y])
    while len(q) != 0:
        x, y = q.popleft()
        distance = graph[x][y]
        if distance == -1:
            return "HaruHaru"
        if distance == 0:
            continue
        if x+distance < n:
            q.append([x+distance, y])
        if y+distance < n:
            q.append([x, y+distance])
    return "Hing"
        
   
# dfs 
def dfs(x, y):
    distance = graph[x][y]
    if distance == -1:
        global is_valid
        is_valid = True
        return
    if distance == 0:
        return
    if x+distance < n:
        dfs(x+distance, y)
    if y+distance < n:
        dfs(x, y+distance)
    return


if __name__ == "__main__":
    
    graph = []
    is_valid = False
    n = initialize()
    
    #dfs
    dfs(0, 0)
    if is_valid == True:
        print("HaruHaru")
    else:
        print("Hing")
        
    #bfs
    # print(bfs(0, 0))