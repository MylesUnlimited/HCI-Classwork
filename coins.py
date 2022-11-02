from bottle import route, run, static_file


@route('/')
def index():
    return '''<font size="15">Append '/&ltnum&gt' to the URL where &ltnum&gt is a positive integer to 
    see that number in coins/></font>'''

@route('/change/<num>')
def change(num):

    num = int(num)
    cents = [25, 10, 5, 1]
    result=[]
    ind = 0
    text = ''''''
    while ind < len(cents):
        if num - cents[ind] >= 0:
            num = num - cents[ind]
            result.append(cents[ind])
        else:
            ind += 1

    for v in range(len(result)):
        text += '''<img src='{}.jpg' height="100" width="100" />'''.format(result[v])
    return text

@route('/images/<filename>', name = 'images')
def _shared(filename):
    return static_file(filename, root='/Users/mcdavie20@students.desu.edu/BottleWebFramework/images/' )

run(host='localhost', port=8080, debug=True, reloader=True)