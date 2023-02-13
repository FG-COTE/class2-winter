import heapq
import sys
input = sys.stdin.readline

n = int(input())
answer = list()
gift = list()

for _ in range(0, n):
    # tmpLi에 a 입력 받기
    tmpLi = list(map(int, input().split()))

    if len(tmpLi) == 1:
        
        if len(gift) == 0:
            answer.append(-1)
        else:
            answer.append(-heapq.heappop(gift))
    else:
       for i in range(1, len(tmpLi)):
            heapq.heappush(gift, -tmpLi[i])


for i in answer:
    print(i)