#The difference btw nested conditions and chained conditions.
#While chained condition has one depeth of conditions with if/else/elif statement, nested condition has more than two depth expressed by conditional statement inside condition.

def chained_condition (x) : 
	if x == "Microsoft":
		print "You should use Surface"
	elif x == "Apple":
		print "You should use MacBook"
	elif x == "Google":
		print "You should use ChromeBook"
	else:
		print "Use whatever computer you want to use"

chained_condition("Microsoft")

def nested_condition(x, y):
	if x == "Microsoft":
		if y == "Student":
			print "You should use Surface Go"
		elif y == "Engineer":
			print "You should use Surface Book"
		elif y == "Business Man":
			print "You should use Surface Pro"
		else:
			print "Ask to anyone who are familiar with PC"
	elif x == "Apple":
		if y == "Student":
                        print "You should use MacBook Air"
                elif y == "Engineer":
                        print "You should use MacBook Pro"
                elif y == "Business Man": 
                        print "You should use IPad"
                else:
                        print "Ask to anyone who are familiar with PC"
	else:
                print "Use whatever computer you want to use"

nested_condition("Microsoft", "Engineer")

#Here is the example of how to avoid the deeply nested conditions.
#The simple way to avoid them is aggregate the conditions with one statement like below.

def deeply_nested_conditions(x):
	if x != "Microsoft":
		if x != "Apple":
			if x != "Google":
				print "Use whatever computer you want to use"

def unnested_condition(x):
	if x != "Microsoft" and x != "Apple" and x != "Google":
		print "Use whatever computer you want to use"
unnested_condition("Fujitsu")
