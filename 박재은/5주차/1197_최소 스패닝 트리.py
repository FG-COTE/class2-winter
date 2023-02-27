import sys
input = sys.stdin.readline

# 1. 입력 받기
v, e = map(int, input().split())
distance = []
tree = []
global parent
parent = [i for i in range(0, v + 1)]

for _ in range(0, e):
    distance.append(list(map(int, input().split())))
# 2. 거리를 기준으로 정렬하기
distance.sort(key=lambda x:x[2])

# 부모 노드를 찾는 함수
def getParent(parent, x):
    if parent[x] == x:
        return x
    else:
        # ex) a의 부모가 b일 때 b의 부모를 가져오는 것.
        parent[x] = getParent(parent, parent[x])
        return parent[x]

def unionParent(parent, a, b):
    a = getParent(parent, a)
    b = getParent(parent, b)
    if a == b:
        return False
    elif a < b:
        parent[b] = a
    else:
        parent[a] = b
    return True

for i in range(0, len(distance)):
    if len(tree) >= (v - 1):
        break
    if unionParent(parent, distance[i][0], distance[i][1]):
        tree.append(distance[i][2])
        
print(sum(tree))


# 틀린 코드
# import sys
# input = sys.stdin.readline

# # 1. 입력 받기
# v, e = map(int, input().split())
# distance = []
# tree = []
# global cycle


# for _ in range(0, e):
#     distance.append(list(map(int, input().split())))
# # 2. 거리를 기준으로 정렬하기
# distance.sort(key=lambda x:x[2])

# # 3. cycle table 생성하기
# cycle=[0] * (v + 1)
# for i in range(1, v + 1):
#     cycle[i] = i

# # 4. cycle 확인하기
# def cycleCheck(cycle, a, b):
#     if cycle[a] == cycle[b]:
#         return False
#     elif cycle[a] > cycle[b]:
#         cycle[a] = cycle[b]
#     elif cycle[b] > cycle[a]:
#         cycle[b] = cycle[a]
#     return True

# # 5. 최소 스패닝 트리 만들기
# for i in range(0, len(distance)):
#     if len(tree) >= (v - 1):
#         break
#     if cycleCheck(cycle, distance[i][0], distance[i][1]):
#         tree.append(distance[i][2])
    
# print(sum(tree))
    
    
