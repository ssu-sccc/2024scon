for _ in range(int(input())):
    n, s, e = map(int, input().split())
    if abs(s-e) + 1 == n: print(0)
    elif s == 1 or s == n or abs(s-e) == 1: print(1)
    else: print(2)