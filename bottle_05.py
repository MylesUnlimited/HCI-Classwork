from bottle import route,run

@route('/')
def index():
    return "<h1>Bottle Web Framework is fun!</h>" + \
        "<p>I <i>like</i> <b>bottle</b> web framework.</p>"

run(host='localhost', port=8080, debug=True, reloader=True)