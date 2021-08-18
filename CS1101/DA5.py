def any_lowercase5(s):
     for c in s:
          if not c.islower():
               return False
     return True

print any_lowercase5("aaaAAa")
