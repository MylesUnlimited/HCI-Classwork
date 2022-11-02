text = '''<html><body><svg width="2500" height="2500">'''

f = open("sample.html", "w")

z = open("Data.csv", "r")
y = 0
for line in z:
    values = line.split(",")
    print(values[0],values[1])
    text += '''<image href={}.svg y={} height=100 width=100 />  
    <rect x = 100 y={} height=100 width={} style="fill:blue" />
    <text x="120" y={} alignment-baseline="middle" font-size="30" stroke-width="0" fill="red" >{}</text>
    <text x={} y={} alignment-baseline="middle" font-size="50" stroke-width="0" fill="yellow">{}</text>'''.format(values[0],y,y, int(values[1])*5,y+50,values[0],int(values[1])*5,y+50,values[1])
    y += 100
text += "</svg></body></html>"

f.write(text)

f.close()