from collections import deque
import sys
input = sys.stdin.readline

n, k = map(int, input().split())
arr = list(map(int, input().split()))
newArr = [(arr[i]-k) for i in range(0, len(arr))]
visited = [False for _ in range(0, len(arr))]

cnt, tmp = 0, 0

def bt(depth, tmp):
    
    global cnt

    # n일의 마지막 날!
    if depth == n:
        cnt += 1
        return
    # 무게가 0이하일 때
    if tmp < 0 :
        return

    # 방문 확인/처리 하기 && 탐색하기
    for i in range(0, n):
        if not visited[i]:
            visited[i] = True
            bt(depth + 1, tmp + newArr[i])
            visited[i] = False
        
bt(0, tmp)

print(cnt)


