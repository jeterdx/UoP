def countdown(n):
    if n < 0:
         print('Blastoff!')
    else:
         print(n)
         countdown(n-1)

def countup(n):
    if n > 0:
         print('Blastoff!')
    else:
         print(n)
         countup(n+1)

x = int(input("Enter postive or negative number : "))
if x == 0:
    print "We need more than 1 value to count"
elif x > 0:
    countdown(x)
else:
    countup(x)
