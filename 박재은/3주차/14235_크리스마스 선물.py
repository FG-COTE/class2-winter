import heapq
import sys
input = sys.stdin.readline

n = int(input())
answer = list()
gift = list()

for _ in range(0, n):
    # tmpLi에 a 입력 받기
    tmpLi = list(map(int, input().split()))

    # a가 0일 때
    if len(tmpLi) == 1:
        # 선물 주머니에 아무것도 없을 때
        if len(gift) == 0:
            answer.append(-1)
        # 선물 주머니에 있는 제일 좋은 것을 줄 때
        else:
            answer.append(-heapq.heappop(gift))
            
    # 선물 주머니에 채워 넣을 때
    else:
       for i in range(1, len(tmpLi)):
            heapq.heappush(gift, -tmpLi[i])


for i in answer:
    print(i)