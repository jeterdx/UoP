#The difference between object and value is that an "object" is a kind of abstract container to hold some elements such as interger, string, bool, or list, so called "value".
#The code below shows the difference by using an equivalent value with indentical object and unidentical objcet both.
objectA = "Orange"
objectB = 1
objectC = 2
objectD = 1
objectE = "Orange"
objectF = True
objectG = "True"
print id(objectA)
print id(objectB)
print id(objectC)
print id(objectD)
print id(objectE)
print id(objectF)
print id(objectG)
#The code below returns True when refering to the same id.
print objectA is objectB
print objectA is objectC
print objectA is objectD
print objectA is objectE
print objectB is objectD
print objectF is objectG

#Objects with more than two different variebles are said to have a relationship called reference. In the same context, objects with the reference and variabels are being said to be aliased.
a = ["apple","banana","orange"] 
b = a
print a is b

b[0] = "pair"
print a
print b
print a is b

#Here is the code to modify the list argument within function. List argumen is called along with function and it gives the value to parameter x. x becomes an object and also y has the same value which is being called the object has reference to the same value. The relationshio stays as it is after the assignment of new element in the list.  
def modify_list(x):
    y = x
    x[0] = "Start"
    x[3] = "End"
    print x
    print y
modify_list(["dog","cat","lion","bird"])

