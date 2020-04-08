t = int(input())

mok = 0
nmg = 0

for i in range(t):
  h,w,n = map(int, input().split())
  if n == h:
    print(f'{h}01')
    continue

  if n%h == 0:
    small = "0"+str(n//h)
    big = str(n//h)
    print(f'{h}{small if n//h < 10 else big}')
    continue

  mok = n // h
  nmg = n % h
  if (mok+1) < 10:
    mok = "0" + str(mok+1)
  else:
    mok = str(mok+1)
  
  print(str(nmg)+str(mok))