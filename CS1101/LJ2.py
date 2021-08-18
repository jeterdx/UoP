#Part1
import math
def print_volume (r):
	volume = 4/3*math.pi*r**3
	print volume

print_volume(3)
print_volume(5)
print_volume(7)


#Part2
def golf_score_calc(par, score):
	if par == 3:
		if score == 1:
			print "Eagle"
		elif score == 2:
			print "Birdie"
		elif score == 3:
			print "Par"
		elif score == 4:
			print "Boggy"
                elif score == 5:
                        print "Double Boggy"
                elif score == 6:
                        print "Tripple Boggy"
                elif score > 6:
                        print "+" + str(score - 3)
	elif par == 4:
               	if score == 1:
                       	print "Albatross"
               	elif score == 2:
                       	print "Eagle"
               	elif score == 3:
                   	print "Birdie"
                elif score == 4:
                        print "Par"
                elif score == 5:
                        print "Boggy"
                elif score == 6:
                        print "Double Boggy"
		elif score == 7:
			print "Tripple Boggy"
                elif score > 7:
                        print "+" + str(score - 3)
	elif par == 5:
                if score == 1:
                        print "Condor, but that cannot be happen if you are human-being..."
                elif score == 2:
                        print "Albatross"
                elif score == 3:
                        print "Eagle"
                elif score == 4:
                        print "Birdie"
                elif score == 5:
                        print "Par"
                elif score == 6:
                        print "Boggy"
                elif score == 7: 
                        print "Double Boggy"
                elif score == 8: 
                        print "Tripple Boggy"
                elif score > 8:
                        print "+" + str(score - 3)
	else:
		print "Input a valid par number."
		
golf_score_calc(3, 10)

#The function above takes the score and par number as inputs to calculate the appropreate score based on inputs.The outputs include string values and also the combination of expression when the score cannot be named. Using if statements so many times might be inefficient way so there is a more room for imoprovment.
