def new_line():
	print('.')

def three_lines():
	new_line()
    	new_line()
	new_line()

def nine_lines():
	three_lines()	
	three_lines()
	three_lines()
	
def clear_screen():
	nine_lines()
	nine_lines()
	three_lines()
	three_lines()
	new_line()

nine_lines()
print "ninelines func ends here."
clear_screen()
print "clear_screen func ends here."
