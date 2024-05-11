n, m = map(int, input().split())
chk = [-1] * (n+1)
use = [0] * m

head = [-1] * (n+1)
link = [-1] * (m*2)
to = [-1] * (m*2)
weight = [-1] * (m*2)
edge = 0

def add_edge(u, v, w):
    global edge
    link[edge], to[edge], weight[edge] = head[u], v, w
    head[u] = edge
    edge += 1

for i in range(m):
    u, v, w = map(int, input().split())
    add_edge(u, v, w)
    add_edge(v, u, w)

def bfs(pos):
    que, front = [1], 0
    chk[1] = pos
    while front < len(que):
        v = que[front]
        front += 1
        idx = head[v]
        while idx != -1:
            i, w, e = to[idx], weight[idx], idx // 2
            if chk[i] != pos and use[e] == 0 and (w >> pos & 1) == 0:
                que.append(i)
                chk[i] = pos
            idx = link[idx]
    return chk[n] == pos

res = 0
for i in range(59, -1, -1):
    if not bfs(i):
        res |= 1 << i
    else:
        for j in range(m):
            if (weight[j*2] >> i & 1) != 0: use[j] = 1

print(res)