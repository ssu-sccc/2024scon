import sys
input = lambda: sys.stdin.readline().rstrip("\n")

T = int(input())
for _ in range(T):
    a, b = map(int, input().split())
    print(a + b)
