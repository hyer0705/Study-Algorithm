# 1. 입력 받은 설탕을 모두 5kg 포대에 넣기
# 2. 남은 설탕(x))이 3kg 포대에 넣을 수 없을 때 5kg 포대에서 1 포대씩 풀어서 x+5kg 이 3 kg 포대에 넣기

n = int(input())
f_jaru = n // 5
t_jaru = (n % 5) // 3
nmg = (n % 5) % 3

result = 0

if nmg != 0:
  for i in range(f_jaru):
    f_jaru -= 1
    nmg += 5
    if nmg % 3 == 0:
      t_jaru = t_jaru + (nmg // 3)
      result = f_jaru + t_jaru
      break
else:
  result = f_jaru + t_jaru

if result == 0:
  result = -1

print(result)