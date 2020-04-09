x = int(input())

# 수열을 이용하여 각 행의 첫 번째 요소와 마지막 요소를 저장하는 변수
# n은 행이 몇 번째인지 저장하는 변수
first = 0
last = 0
n = 0

# 분수를 나타내는 변수
child = 0
parent = 0

for i in range(1, x+1):
  if(x >= first and x <= last) :
    break
  first = int((i ** 2 - i + 2) / 2)
  last = int((i ** 2 + i + 2) / 2) - 1
  n += 1

# print(first, last, n)

cha = int(x - first)

# 분수를 구한다
if (n % 2) == 0:
  child = 1 + cha
  parent = n - cha
else :
  child = n - cha
  parent = 1 + cha

print(f'{child}/{parent}')