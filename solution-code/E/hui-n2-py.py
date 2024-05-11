def check(s):
    res = s[0] == 'T'
    for i in range(2, len(s)):
        if s[i-1] == '&':
            res = res and (s[i] == 'T')
        else:
            res = res or (s[i] == 'T')
    return 'T' if res else 'F'

n = int(input())
s = list(input().split())
c = input()
if check(s) == c:
    print(0)
else:
    for i in range(n):
        if s[i] == 'T': s[i] = 'F'
        elif s[i] == 'F': s[i] = 'T'
        elif s[i] == '&': s[i] = '|'
        else: s[i] = '&'
        if check(s) == c:
            print(1)
            break
        if s[i] == 'T': s[i] = 'F'
        elif s[i] == 'F': s[i] = 'T'
        elif s[i] == '&': s[i] = '|'
        else: s[i] = '&'
    else:
        print(2)