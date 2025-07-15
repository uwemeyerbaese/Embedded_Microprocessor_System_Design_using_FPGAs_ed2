"use strict";
try { 
console.log("*** Check ES support by year");

let t=3.14;
const PI = 3.14
console.log("ES5: let and const: PI=" + t + "=" + PI);
let j = JSON.stringify({ x: 5, y: 6 });
// expected output: "{"x":5,"y":6}"
const obj = JSON.parse(j);
console.log("ES5: JSON x=" + obj.x + " y=" + obj.y);
//-------------------------
 
} catch (err) {
  console.log(err.message);
}
