from bottle import route, run

@route('/')
def index():
    sum=0
    for n in range(1, 15):
        sum +=n
    return '1 + 2 + 3 + ... + 100 = '+str(sum) +'  yay!'

run(host='localhost', port=8080, debug=True, reloader=True)
