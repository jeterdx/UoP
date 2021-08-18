import os

#Catching an exception with no file.
try:
    file = open("nofile.py")
except IOError:
    print ("The file you try to open does not exist or it is directory.")


#Catching an exception with no directory.
try:
    dir = open("/CS1101")
except IOError:
    print ("The file you try to open does not exist or it is directory.")

try:
    alreadyexist = open("DA8.py", "x")
    alreadyexist.write("print Hello World!")
except FileExistsError:
    print ("The file name you try to create already exists, and mode x cannot override it.")

print ("All program is executed")
