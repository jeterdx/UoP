#A number, a, is a power of b if it is divisible by b and a/b is a power of b. Write a function called is_power that takes parameters a and b and returns True if a is a power of b. Note:
#you will have to think about the base case.

#Here is the code of is_divisible function from textbook
def is_divisible(a, b):
    if a % b == 0:
        return True
    else:
        return False

#Here is the code of is_power function
def is_power (a, b):
    if a != 1 and b == 1:  #this is the condition to expect the case if a and b are both 1
	return False
    elif is_divisible(a, b): #this calls is_devisible function to check wether a is devisible
        if a/b == 1:
            return True
        else:
            return is_power(a/b, b) #if a/b is not 1, it returns the result to is_power function again
    else:
        return False
#Test cases are below.
print("is_power(10, 2) returns: ", is_power(10, 2))
print("is_power(27, 3) returns: ", is_power(27, 3))
print("is_power(1, 1) returns: ", is_power(1, 1))
print("is_power(10, 1) returns: ", is_power(2, 1))
print("is_power(3, 3) returns: ", is_power(3, 3))
