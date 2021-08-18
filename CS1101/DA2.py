#Example 1
#def doubler(object):
#	result = object * 2
#	print (result)

#doubler("san")
#doubler(22)
#doubler(True)

#Example 2
#x = 50
#doubler(x) #variable

#doubler(60) #value

#doubler(x+60) #expression

#Example 3
#def local_doubler():
#	local_object = 55
#	result = object * 2
#	return result
#print local_object

#Example 4: Notice the difference btw Parameter and Argument
#def unique_doubler(unique_parameter):
#	result = unique_parameter * 2
#	return result
#unique_doubler (421)
#print (unique_parameter)

#Exmple 5
def same_variable():
	x = True
	print x
same_variable()

x = False
print x
