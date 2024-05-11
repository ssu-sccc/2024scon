def f(x, y, op):
    return x & y if op == 0 else x | y

n = int(input()) // 2
a = [[0, 0] for _ in range(n+1)]
dp = [[10*n, 10*n] for _ in range(n+1)]

s = list(input().split())

for i in range(len(s)):
    a[(i+1)//2][(i+1)%2] = 1 if s[i] == 'T' or s[i] == '|' else 0

dp[0][a[0][1]] = 0
dp[0][1-a[0][1]] = 1
for i in range(1, n+1):
    for j in range(2):
        for k in range(2):
            for op in range(2):
                dp[i][f(j, k, op)] = min(dp[i][f(j, k, op)], dp[i-1][j] + (k != a[i][1]) + (op != a[i][0]))

c = input()
print(dp[n][1 if c=='T' else 0])
