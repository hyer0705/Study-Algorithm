n = int(input())

first = 1
last = 1
cnt = 1

for i in range(1, n+1):
  if (n >= first and n <= last):
    break
  first = int(3* (i**2) - 3 * i + 2)
  last = int(3 * i * (i + 1) + 1)
  cnt += 1
print(cnt)