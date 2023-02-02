n = int(input())

decrease_num = [] # 감소하는 수가 들어갈 리스트

def dfs(depth, count):
    if count==depth:
        num = ""
        for i in result:
            num += str(i)
        decrease_num.append(int(num))
        return

    for i in range(0, 10):
        if len(result) > 0 : # 만약 i가 처음 들어가는 수가 아니면, 마지막 수를 살펴본다.
            if result[len(result)-1] > i: # i가 마지막 수보다 작은 경우만 넣는다. 
                result.append(i)
                dfs(depth, count+1)
                result.pop(-1)
        elif len(result) == 0: # 만약 i가 처음 들어가는 수라면 그냥 넣는다.
            result.append(i)
            dfs(depth, count+1)
            result.pop(-1)
            
depth = 1
while len(decrease_num) <= n:
    if depth > 10: # 감소하는 수 중에 가장 큰 수는 "987654321"이므로 depth가 10보다 클 수 없다. 
        print(-1)
        exit()
    result = []
    dfs(depth, 0)
    depth += 1 

print(decrease_num[n])