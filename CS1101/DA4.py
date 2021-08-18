#The first possibility is about the issue about argument itself that the function is taking, which is called "precondition" violation as this happens "Before" the function is called. The second one is about the problem about the function itself, which is called "postcondition" violation as this happens "After" the function is called. The third one is about the function's return value. For instance, the function returns None value despite function defines its return value in a correct way. I experienced this bug throughout Programming Assignment Unit4.

#Here is the code for precondition bug
#def pre_condition(x):
#    return x
#pre_condition(y)

#Here is the code for postcondition bug
#def post_condition(x):
#    if a == 1:
#	return True
#post_condition("y")

#Here is the code for return value bug
def return_value(x):
    return y
return_value("y")
