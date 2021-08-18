#prefixes = 'JKLMNOPQ'
#suffix = 'ack'

#for letter in prefixes:
#     if letter == "O" or letter == "Q":
#         print (letter + "u" + suffix)
#     else:
#         print(letter + suffix)

"""
beingsliced = "AaBbCcDdEeFfGgHhIiJjKk"
index = 1
output = ""
for i in beingsliced:
    if index % 2 == 0:
        output = output + beingsliced[index-1] 
    index = index + 1
print output
"""

"""
beingsliced = "AaBbCcDdEeFfGgHhIiJjKk"
index = 1
output = ""
while index-1 < len(beingsliced):
    if index % 2 == 0:
        output = output + beingsliced[index-1]
    index = index + 1
print output
"""

beingsliced = "AaBbCcDdEeFfGgHhIiJjKk"
print beingsliced[1:len(beingsliced):2]

