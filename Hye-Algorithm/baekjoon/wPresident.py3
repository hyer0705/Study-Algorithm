t_list = [[0 for j in range(14)] for i in range(15)]

for i in range(14):
  t_list[0][i] = i+1

for k in range(1,15):
  for i in range(14):
    for j in range(i+1):
      t_list[k][i] += t_list[k-1][j]

T = int(input())

for i in range(T):
  k = int(input())
  n = int(input())
  print(t_list[k][n-1])