from itertools import combinations
import sys
input = sys.stdin.readline

n = int(input())

li = list()

if n < 11:
    print(n)
elif n >= 1023:
    print(-1)
else:
    for i in range(1, 11):
        for k in combinations(range(0, 10), i) :
            k = list(k)
            k.sort(reverse=True) 
            tmp = ""
            for g in k:
                tmp += str(g)
            tmp = int(tmp)
            li.append(tmp)
    li.sort()
    print(li[n])

    