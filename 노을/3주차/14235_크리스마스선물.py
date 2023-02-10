import heapq

n = int(input())

hq = []

for i in range(n):
    num = list(map(int, input().split()))
    if num[0] == 0:
        if len(hq) == 0:
            print(-1)
        else:
            num = heapq.heappop(hq)
            print(-num)
            
    else:
        gift = list(map(int, num))
        for i in range(1, len(gift)):
            heapq.heappush(hq, -gift[i])
    