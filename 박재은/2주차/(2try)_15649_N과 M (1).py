import itertools
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

arr = []
for i in range(1, n + 1):
    arr.append(i)

npr = itertools.permutations(arr, m)
listNpr = list(npr)

for i in range(0, len(listNpr)):
    for k in range(0, len(listNpr[i])):
        print(listNpr[i][k], end=" ")
    print()