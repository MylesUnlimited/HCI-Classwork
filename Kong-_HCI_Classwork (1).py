text = '''
<html>
<body>

<svg width="1500" height="1500">
 

</svg>

</body>
</html>
'''

f = open("sample.html","w")

f.write(text)

f = open('sample.html','r')

contents = f.readlines()

f = open("sample.html","w")

baseX = 50 + 40 + 50
baseY = 50 + 40 + 50
D = 40
for y in range(1, 7):
    for x in range(1,3):
        if y % 2 ==0:
            string = '''<rect y = {} x = {} width= "50" height ="50" fill="yellow" /> \n'''.format(baseY, baseX+ D + 50)
            string2 = '''<rect y = {} x = {} width="50" height ="50" fill="blue" /> \n'''.format(baseY, baseX-50)
        else:
            string = '''<rect y = {} x = {} width="50" height ="50" fill="yellow" /> \n'''.format(baseY, baseX-50)
            string2 = '''<rect y = {} x = {} width="50" height ="50" fill="blue" /> \n'''.format(baseY, baseX+ D + 50)
        contents.insert(6, string)
        contents.insert(7,string2)
        baseX += 100 + (D*2 + (50*2))
    baseX = 50 + D + 50
    baseY += 50 + D + 0

f.writelines(contents)
f.close()
