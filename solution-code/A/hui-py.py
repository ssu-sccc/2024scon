n, m = map(int, input().split())
a = list(map(int, input().split()))

res = 0
a[0] = max(0, a[0])
for i in range(1, n):
    a[i] = max(0, a[i-1] + a[i])
for i in range(0, n):
    if a[i] >= m: res += 1

print(res)