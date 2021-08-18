#Part1
ownstrings = "Mcirosft Google IBM  Dell Facebook Apple Salesforce Slack"
splitedstrings = ownstrings.split()
print splitedstrings

del splitedstrings[0]
print splitedstrings

splitedstrings.remove("Apple")
print splitedstrings

splitedstrings.pop()
print splitedstrings

splitedstrings.sort()
print splitedstrings

splitedstrings.append("Unity") 
print splitedstrings

splitedstrings.extend(["Box","Zoom","Veeam"])
print splitedstrings

splitedstrings.insert(3, "Amazon")
print splitedstrings

joinedstrings = "".join(splitedstrings)
print joinedstrings

#Part2
countries = [["Japan","Taiwan","Vietnam"],["Germany","France"],["Egypt","DRC", "Nigeria"]]
countries += ["Argentine","Brazil","Chile"]
Eurasia = countries[0:2]
Eurasias = 3*Eurasia

print Eurasias
def isJapan(country):
    return country == "Japan"

filtered = filter(isJapan, Eurasia)
print filtered

