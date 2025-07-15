# inside interpreter: >>> exec(open("my_module_tb.py").read())
import my_module
my_module.calc(my_module.NUM2, my_module.NUM1, 'sub')

from my_module import *
calc(NUM2, NUM1, 'sub')

import my_module as mm
mm.calc(mm.NUM2, mm.NUM1, 'sub')

import my_module
help(my_module)
