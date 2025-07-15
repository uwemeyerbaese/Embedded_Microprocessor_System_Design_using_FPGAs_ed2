# Clock example with a quit button
import tkinter as tk
import time

class App():
    def __init__(self):
        self.root = tk.Tk()
        self.label = tk.Label(text="")
        self.quit_button = tk.Button(self.root,
                           text = 'Quit',
                           command = self.root.destroy)
        self.label.pack()
        self.quit_button.pack()
        self.root.wm_title('Clock')
        self.update_clock()
        self.root.mainloop()

    def update_clock(self):
        now = time.strftime("%b %d, %Y  %r")
        self.label.configure(text = now,\
                font = 'Times 14', bg = '#00FFFF')
        self.root.after(1000, self.update_clock)

app = App()
