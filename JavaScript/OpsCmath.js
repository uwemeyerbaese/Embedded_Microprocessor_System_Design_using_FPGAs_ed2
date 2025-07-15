var math = require("./math.js"); 

var x = math.complex(10, 5);
var y = math.complex(3, 4);
console.log("x = ", x)
console.log("y = ", y)
console.log("real(y) =", y.re)
console.log("imag(y) =", y.im)
var p = y.toPolar();
console.log("cabs(y) =", p.r)
console.log("conj(y) = ", math.conj(y))
console.log("scale(2,y) = ", math.multiply(y, 2))
console.log("cadd(x,y) = ", math.add(x,y))
console.log("csub(x,y) = ", math.subtract(x,y))
console.log("cmul(x,y) = ", math.multiply(x,y))
console.log("cdiv(x,y) = ", math.divide(x,y))
