n = int(input())
a, b = [], []

if n % 3 == 2:
    a.append('1')
    b.append('2')

for i in range(n%3+1, n+1):
    if i % 3 != n % 3: a.append(str(i))
    else: b.append(str(i))

print(len(a), ' '.join(a), len(b), ' '.join(b), sep='\n')