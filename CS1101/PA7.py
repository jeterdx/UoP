alphabet = "abcdefghijklmnopqrstuvwxyz"   
test_dups = ["zzz","dog","bookkeeper","subdermatoglyphic","subdermatoglyphics"] 
test_miss = ["zzz","subdermatoglyphic","the quick brown fox jumps over the lazy dog"] 

# From Section 11.2 of: 
# Downey, A. (2015). Think Python: How to think like a computer scientist. Needham, Massachusetts: Green Tree Press. 
def histogram(s):
     d = dict()
     for c in s:
          if c not in d:
               d[c] = 1
          else:
               d[c] += 1
     return d

def has_duplicates2(param):
    prural = [2,3,4,5,6,7,8,9,10]
    for i in param:
         result = histogram(i)
         lists = result.values()
	 if set(prural).isdisjoint(set(lists)):
             print i + " has no duplicates"
         else:  
             print i + " has duplicates"
has_duplicates2(test_dups)


#Normal duplicates function without histograms.
#def has_duplicates1(strings):
#    dictionary = {}
#    count = 0
#    for i in strings:
#        if i in dictionary.values():
#            return True
#        else:
#	    dictionary[count] = i
#        count += 1
#    return False
#print has_duplicates1("GotaMimure")

    
