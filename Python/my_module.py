# This is my_module.py
NUM1 = 9783030505325
NUM2 = 9783030505332

def swap_ok(a,b): # Python multiple return recommended
    """Exchange two values"""
    return b, a;

def calc(a, b = 4, op = 'add'):
    """Small calculator for add and sub
    defaults are used of op and b"""
    if op == 'add':
        return a + b
    elif op == 'sub':
        return a - b
    else:
        print(op, 'is not a valid operation')
        return ' '
