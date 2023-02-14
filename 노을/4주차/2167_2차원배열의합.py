import sys


n, m = map(int, sys.stdin.readline().split())
graph = []
for i in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))

sum_list = [[] for i in range(n)]
for i in range(n):
    sum = 0
    for j in range(m):
        sum += graph[i][j]
        sum_list[i].append(sum)
    

count = int(sys.stdin.readline())
for i in range(count):
    i, j, x, y = map(int, sys.stdin.readline().split())
    result = 0
    for a in range(i-1, x):
        if j==1:
            result += sum_list[a][y-1]
        else:
            result += sum_list[a][y-1] - sum_list[a][j-2]
    print(result)