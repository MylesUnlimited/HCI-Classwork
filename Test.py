from bottle import route, run, template

def is_float(element):
    try:
        float(element)
        return True
    except ValueError:
        return False

@route('/')
def index():
    return '''Append '/factors/&ltnum&gt' to the URL where &ltnum&gt is a positive integer<br> 
    Append '/sumtofrom/&ltnum1&lt/&ltnum2&lt' to the url'''

@route('/factors/<num>')
def factors(num):

    factors = ""
    counter = 0
    if is_float(num) == False:
        return "{} is not an integer".format(num)
    elif (float(num)%1>0):
        return "{} is not an integer".format(num)#template("{{num}} is not an integer",num=num)

    for n in range(1, int(num)+1):
        if (int(num)%n) == 0:
            counter += 1
            if n == int(num):
                factors+=(" "+str(n))
            else:
                factors += (" " + str(n)+",")

    if counter <=2:
        return template("<p style='color:red;'>{{num}} is prime.</p>" + "Factors of {{num}}:" + str(factors), num=num)
    else:
        return template("Factors of {{num}}:"+ str(factors), num=num)

@route('/sumtofrom/<num1>,<num2>')
def sumTo(num1,num2):
    sum = 0
    for l in range(int(num1), int(num2)+1):
        sum += l
    return template("The sum of all numbers from {{num1}} to {{num2}} is "+str(sum), num1=num1, num2=num2)

run(host='localhost', port=8080, debug=True, reloader=True)