AbbreviatedJargon = dict([("DX", "Digital Transformation"),("IaaS", "Infra as a service"),("IoT", "Internet of things"),("OS","Operational System"),("FTP","File transfer Protocol")])

def invert_dict(d):
    inverse = dict()
    for key in d:
        val = d[key]
        if val not in inverse:
            inverse[val] = [key]
        else:
	    inverse[val].append(key)
    return inverse

print AbbreviatedJargon
print invert_dict(AbbreviatedJargon)
