"use strict";
try { 
console.log("*** Check ES support by year");

// Possible Function Notations
// Familiar Function declaration syntax
function sqr2(x) { return x * x; }
// anonymous (short version) aka arrow type function:
const sqr4 = x => x * x; 
console.log('ES6: arrow function  4^2='+sqr2(4)+'='+sqr4(4));
let r = `JS is ${2*2} you`;  console.log('ES6: backticks = `JS is ${2*2} you` = ' + r)
let bin = 0b1010; // Binary Base
let oct = 0o12;   // Octal Base (not in strict mode)
console.log("ES6: binary and octal  10=" + bin + "=" + oct);
//-------------------------


} catch (err) {
  console.log(err.message);
}
