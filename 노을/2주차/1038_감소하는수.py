n = int(input())

decrease_num = []

def dfs(depth, count):
    if count==depth:
        num = ""
        for i in result:
            num += str(i)
        decrease_num.append(int(num))
        if len(decrease_num) < n:
            return
        return
    for i in range(0, 10):
        if len(result) > 0 :
            if result[len(result)-1] > i:
                result.append(i)
                dfs(depth, count+1)
                result.pop(-1)
        elif len(result) == 0:
            result.append(i)
            dfs(depth, count+1)
            result.pop(-1)
            
depth = 1
while len(decrease_num) <= n:
    if depth > 10:
        print(-1)
        exit()
    result = []
    dfs(depth, 0)
    depth += 1 

print(decrease_num[n])
