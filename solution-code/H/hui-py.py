n, k = map(int, input().split())
a = list(map(int, input().split()))
a = [0]*(n+1) + a + [0]*n

dp, mx = [0] * (3*n+1), [0] * (3*n+1)
for i in range(1, n*3+1): a[i] += a[i-1]

for i in range(1, 3*n+1):
    dp[i] = dp[i-1]
    if i >= k: dp[i] = max(dp[i], mx[i-k] + a[i])
    mx[i] = max(mx[i-1], dp[i] - a[i])

print(dp[-1])