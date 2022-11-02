def change(num):

    cents = [25, 10, 5, 1]
    result=[]
    ind = 0
    while ind < len(cents):
        if num - cents[ind] >= 0:
            num = num - cents[ind]
            result.append(cents[ind])
        else:
            ind += 1
    return result


print(change(144))