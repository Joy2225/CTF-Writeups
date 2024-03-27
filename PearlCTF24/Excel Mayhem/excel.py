with open('excel.txt','r') as f:
    a=f.read().split("\t")
for i in a:
    if 'fake_flag' not in i:
        print(i)