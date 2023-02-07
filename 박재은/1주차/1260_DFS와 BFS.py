from collections import deque
import queue
import sys
input = sys.stdin.readline

n, m, v = map(int, input().split())

li = [list() for k in range(0, n + 1)]

for i in range(0, m):
    a, b = map(int, input().split())
    # (a,b)가 li에 있는지 확인
    if a not in li:
        li[a].append(b)
    elif b not in li[a]:
        li[b].append(a)
    # (b,a)가 li에 있는지 확인 (양방향으로 넣어줘야함.)      
    if b not in li:
        li[b].append(a)
    elif a not in li[b]:
        li[a].append(b)

for i in range(0, len(li)):
    li[i].sort()

global visitedDfs
visitedDfs = [] 

def dfs(list, start):
    stack = [start]
    while stack:
        t = stack.pop()
        if t not in visitedDfs:
            visitedDfs.append(t)
            for g in list[t]:
                dfs(list, g)

global visitedBfs
visitedBfs = [] 

def bfs(list, start):
    deq = deque([start])
    while deq:
        t = deq.popleft()
        if t not in visitedBfs:
            visitedBfs.append(t)
            for g in list[t]:
                deq.append(g)



dfs(li, v)
bfs(li, v)

for i in visitedDfs:
    print(i, end=" ")     
print()
for i in visitedBfs:
    print(i, end=" ")   