def readTime(s):
    h = int(s[0:2])
    m = int(s[3:5])
    return h * 60 + m

n = int(input())
g, c, d, s, e, cnt = [], [], [], [], [], 0

for i in range(n):
    sz = int(input())
    for j in range(sz):
        line = input().split()
        g.append(i)
        c.append(int(line[0]))
        d.append(int(line[1]))
        s.append(d[-1] * 1440 + readTime(line[2]))
        e.append(d[-1] * 1440 + readTime(line[3]))
        cnt += 1

res = 0
for bit in range(1 << cnt):
    sum, mx = 0, 0
    chk, use = [False] * cnt, [0] * n
    for i in range(cnt): chk[i] = (bit >> i & 1) != 0

    for i in range(cnt):
        if chk[i]:
            sum += c[i]
            use[g[i]] += 1
    if sum != 22 or max(use) > 1: continue

    flag = True
    for i in range(cnt):
        if not chk[i]: continue
        for j in range(i + 1, cnt):
            if not chk[j]: continue
            now = e[i] <= s[j] or e[j] <= s[i]
            if not now: flag = False
    if flag:
        res += 1

print(res)
