# A ISS for the URSIC microprocessor
import sys
import tkinter as tkinter

### Decode
def decode(iw):
    dst  = int(iw[0], 16)
    src  = int(iw[1], 16)
    imm  = int(iw[2:4], 16)
    mode = (imm & 0x0080) >> 7
    if mode==1: 
        addr = imm & 0x007F
    else:
        addr = imm & 0x003F
        sign = (imm & 0x0040) >> 6
        if sign==1:
            addr -= 64
    return dst, src, mode, addr

class App:
    def __init__(self, master):
        global prog
        global reg
        frame = tkinter.Frame(master)
        frame.pack()

        tkinter.Label(frame, text = 'Name').grid(row = 0, column = 0)
        tkinter.Label(frame, text = 'Value').grid(row = 0, column = 1)
        
        tkinter.Label(frame, text='CLK ').grid(row = 1, column = 0)
        self.clk = tkinter.IntVar(); self.clk.set(0)
        tkinter.Label(frame, textvariable=self.clk).grid(row=1, column=1)

        tkinter.Label(frame, text='PC ').grid(row=2, column=0)
        self.pc = tkinter.IntVar(); self.pc.set(0)
        tkinter.Label(frame, textvariable=self.pc).grid(row=2, column=1)

        tkinter.Label(frame, text='IW ').grid(row=3, column=0)
        self.iw = tkinter.StringVar();  self.iw.set(prog[0][0:4])
        tkinter.Label(frame, textvariable=self.iw).grid(row=3, column=1)
        
        tkinter.Label(frame, text='R[0] ').grid(row=4, column=0)
        self.r0 = tkinter.IntVar(); self.r0.set(reg[0])
        tkinter.Label(frame, textvariable=self.r0).grid(row=4, column=1)

        tkinter.Label(frame, text='R[1] ').grid(row=5, column=0)
        self.r1 = tkinter.IntVar(); self.r1.set(reg[1])
        tkinter.Label(frame, textvariable=self.r1).grid(row=5, column=1)
        
        tkinter.Label(frame, text='R[2] ').grid(row=6, column=0)
        self.r2 = tkinter.IntVar(); self.r2.set(reg[2])
        tkinter.Label(frame, textvariable=self.r2).grid(row=6, column=1)
        
        tkinter.Label(frame, text='R[3] ').grid(row=7, column=0)
        self.r3 = tkinter.IntVar(); self.r3.set(reg[3])
        tkinter.Label(frame, textvariable=self.r3).grid(row=7, column=1)

        tkinter.Label(frame, text='R[4] ').grid(row=8, column=0)
        self.r4 = tkinter.IntVar(); self.r4.set(reg[4])
        tkinter.Label(frame, textvariable=self.r4).grid(row=8, column=1)

        tkinter.Label(frame, text='R[15]').grid(row=9, column=0)
        self.r15 = tkinter.IntVar(); self.r15.set(reg[15])
        tkinter.Label(frame, textvariable=self.r15).grid(row=9, column=1)
        
        step = tkinter.Button(frame, text='STEP', command=self.step, \
                                               bg="green", fg="white")
        step.grid(row=10, column=0) 
        reset = tkinter.Button(frame, text='RESET', command=self.reset, \
                                                     bg="red", fg="white")
        reset.grid(row=10, column=1)

    def step(self):
        global prog
        global reg
    ### Fetch
        clock = self.clk.get()
        pc_now = self.pc.get()
        iw = prog[pc_now]
        dst, src, mode, addr = decode(iw)
    ### Execute
        result = reg[dst] - reg[src]
        if dst > 0:
            reg[dst] = result
        if result >= 0:
            pc_new = pc_now + 1
        elif mode == 1:
            pc_new = addr
        else:
            pc_new = pc_now + addr
        iw = prog[pc_new]
        dst, src, mode, addr = decode(iw)
        result = reg[dst] - reg[src]
        clock = clock + 1
        self.clk.set(clock);   self.pc.set(pc_new)
        self.iw.set(iw[0:4]);  self.r0.set(reg[0])
        self.r1.set(reg[1]);   self.r2.set(reg[2])
        self.r3.set(reg[3]);   self.r4.set(reg[4])
        self.r15.set(reg[15])

    def reset(self):
        global prog
        global reg 
        self.pc.set(0)
        self.clk.set(0)
        self.iw.set(prog[0][0:4])
        for k in range(16):
            reg[k]=-1
        reg[0]=in_port 
        self.r0.set(reg[0]);    self.r1.set(reg[1])
        self.r2.set(reg[2]);    self.r3.set(reg[3])
        self.r4.set(reg[4]);    self.r15.set(reg[15]) 

fin = open("io.hex", "r")
prog = fin.readlines()
fin.close()

in_port = 5
reg=[in_port]
for k in range(15):
    reg.append(-1)

root = tkinter.Tk()
root.wm_title('ISS by UMB')
root.geometry("300x300")
app = App(root)
root.mainloop()
