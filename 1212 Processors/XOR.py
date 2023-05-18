a = [1,0,0,1,0,0,1,1,1,0,0,1,1,1,0,1]
b = [1,1,0,0,0,0,1,1,1,0,1,0,1,0,1,0]
c = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
tst = [0,1,0,1,0,0,0,0,0,0,1,1,0,1,1,1]

i = 0

while i < 16:
    if a[i] == 1 :
        if b[i] == 0:
            # jump to end of loop, increment
            c[i] = 1
            break
        # both are 1, redundant

    # a[i] presumed 0
    if b[i] == 1:
        c[i] == 1
    

    i += 1

print(c)
print(tst)