import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = [0] * n

for i in range(0, n):
    arr[i] = list(map(int, input().split()))

k = int(input())
answer = [0] * k
for k in range(0, k):
    i, j, x, y = map(int, input().split())
    i -= 1
    j -= 1
    for nx in range(i, x):
        if j == 0:
            answer[k] += sum(arr[nx][0:y])
        else:
            answer[k] += (sum(arr[nx][0:y]) - sum(arr[nx][0:j]))
for res in answer:
    print(res)

