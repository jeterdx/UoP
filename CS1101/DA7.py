#Tuple is very powerful tool because of its immutable feature. As it is immutable, it can be used for the key element which coders do not hope to change. Tuple can be made from list or dictonary type, so once coders hope to fix the value, they can be changed to tuple to avoide the risk of unintentional change.

mynumber = ( 1, 2, 3, 4)
name = ["John", "Gota", "Haruna", "George", "Anna", "Ken"]
personalinfo = dict(zip(mynumber, name))
print personalinfo #The name Ken is abondoned as no mynumber is issued to Anna and Ken.

for x, (key, value) in enumerate(personalinfo.items()): #This loops take both keys and value of dictionary with the loop index because if we need the certain number of index, the key of dictionary is not numerically ordered.
    print (x, key, value )
