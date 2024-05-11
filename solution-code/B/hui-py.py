n = int(input())
for _ in range(n):
    s = input()
    upper, lower, digit = 0, 0, 0
    for c in s:
        if c.isupper(): upper += 1
        if c.islower(): lower += 1
        if c.isdigit(): digit += 1
    if upper <= lower and len(s) <= 10 and digit < len(s):
        print(s)