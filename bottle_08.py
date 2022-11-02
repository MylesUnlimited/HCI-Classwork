from bottle import route, run

@route('/')
def index():
    sum="<h1>Imperial (ft/in) to Metric (cm) Length Conversion Table</h><table border = 1>"
    nStart = 3
    nEnd = 8
    kStart = 0
    kEnd = 11
    for n in range(nStart-1,nEnd +1,1):
        sum +="<tr>"
        for k in range(kStart-1,kEnd+1,1):
            if n == nStart-1 and k == kStart-1:
                sum += "<td style= 'background-color:FFFFFF;'></td>"
            elif n == nStart-1:
                sum += "<td style= 'background-color:#ff0000;'><p style='color:yellow;'>" + (str(int((n * k)/2))) + " in</td>"
            elif k == kStart-1:
                sum += "<td style= 'background-color:#ff0000;'><p style='color:#301934;'>" + (str((n * k)*-1)) + " ft</td>"
            else:
                sum += "<td style= 'background-color:#89cff0;'><p style='color:purple;'>" + (str(round((n * 30.48) + (k * 2.54)))) + "</td>"

        sum += "</tr>"

    return sum +"</table>"
index()

run(host='localhost', port=8080, debug=True, reloader=True)