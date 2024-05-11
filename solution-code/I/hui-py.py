n = int(input())
g = [[] for _ in range(n+1)]
for _ in range(n-1):
    u, v = map(int, input().split())
    g[u].append(v)
    g[v].append(u)
sz = [0] + list(map(int, input().split()))

dp, res = [0] * (n+1), [0] * (n+1)
tot = sum(sz)

def init():
    que, fr = [], 0
    ord, par = [], [0] * (n+1)
    que.append((1, 0))
    while fr < len(que):
        v, p = que[fr]
        fr += 1
        ord.append(v)
        par[v] = p
        for i in g[v]:
            if i != p: que.append((i, v))
    ord = ord[::-1]
    for i in ord:
        sz[par[i]] += sz[i]
        dp[par[i]] += sz[i] + dp[i]

def solve():
    que, fr = [], 0
    que.append((1, 0, 0))
    while fr < len(que):
        v, p, up = que[fr]
        fr += 1
        res[v] = dp[v] + up
        for i in g[v]:
            if i != p: que.append((i, v, up + dp[v]-dp[i]-sz[i] + tot-sz[i]))

init()
solve()

print(max(res))