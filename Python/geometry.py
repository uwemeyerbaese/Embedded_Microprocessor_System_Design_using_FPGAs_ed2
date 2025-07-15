class QuadriLateral:
    def __init__(self, a, b, c, d):
        self.side1=a
        self.side2=b
        self.side3=c
        self.side4=d
    def perimeter(self):
        p = self.side1 + self.side2 + self.side3 + self.side4
        print('Perimeter =',p)

class Rectangle(QuadriLateral):
    def __init__(self, a,b):
        QuadriLateral.__init__(self,a, b, a, b)
    def area(self):
        a = self.side1 * self.side2
        print('Area of rectangle =', a)


