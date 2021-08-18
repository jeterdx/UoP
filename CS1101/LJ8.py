ITBrand = dict({"Microsoft": ("Note PC", "Cloud Platform","CRM","MR") ,"Apple" :("MR","Smart Phone","Music Store"),"Google":("Cloud Platform","Note PC","Smart Phone","Search Engine")})

def invert_dict(d):
    inverse = dict()
    for key in d:
        for a in d[key]:
            if a not in inverse:
                inverse[a] = [key]
            else:
                inverse[a].append(key)
    return inverse
print ("Original Dictionary: ")
for key in ITBrand:
    print (key, ITBrand[key])

print ("Inverted Dictionary: ")
inverse = invert_dict(ITBrand)
for key in inverse:
    print (key, inverse[key])

#Program to change dictionary to text file
filemaker = open("input.txt", "w")
for k, v in ITBrand.items():
    data1 = str(k)
    data2 = str(v)
    data3 = data1 + data2 + "\n"
    filemaker.write(data3)

#Program to add new elements in text file
f = open('input.txt', 'a')
f.write("Hitachi('Cloud Platform', 'Note PC')\nFujistu('Note PC')\nNTT('Network')\n")
f.close

