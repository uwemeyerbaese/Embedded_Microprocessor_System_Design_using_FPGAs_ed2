// ES3: no =>; no keyword argument; no multi export
// Public constants that will be exported
const NUM1 = 9783030505325;
const NUM2 = 9783030505332;

// Utility functions private to the module
//const sum = (x, y) => x + y;
function sum(x, y) { return (x+y);}
//const dif = (x, y) => x - y;
function dif(x, y) { return (x-y);}

// A public function that will be exported
function calc(a, b, op) {
/* Small calculator for add and sub
   default are used of op and b */
  switch (op) {
    case 'add':  return sum(a,b); break;
    case 'sub':  return dif(a,b); break;
    default:     console.log(op, 'is not a valid operation');
                 return undefined;
                   break;
  }
}
// Replacing 3x single exports:
//module.exports = { NUM1, NUM2, calc };
exports.NUM1 = NUM1;
exports.NUM2 = NUM2;
exports.calc = calc;




