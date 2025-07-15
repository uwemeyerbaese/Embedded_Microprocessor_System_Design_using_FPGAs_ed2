"use strict";
try { 
console.log("*** Check ES support by year");

let pow = 2 ** 30; 
let shift = 1 << 30;
console.log("ES2016: powerof 2^30 = 2**30 =  1 << 30 = " + pow + ' = ' + shift);
// => ES2016: powerof 2^30 =  1 << 30 = 1073741824 = 1073741824
//-------------------------
// Open a web page and count characters
url_list = [
    'https://web1.eng.famu.fsu.edu/~umb/', //  My Homepage
    'https://github.com/uwemeyerbaese', //My github book page
    'https://developer.mozilla.org/en-US/' //MDN source page
]
//using async/await
async function fetchURLs(url) {
  response = await fetch(url);
  stuff = await response.text();
  console.log('ES2017: open:' , url);
  console.log('ES2017: async/await length:' , stuff.length)
}
for (url of url_list) {  fetchURLs(url) }

//-------------------------

function mean(...args) {
  let L = args.length;
  let total = 0;
  for (let i = 0; i < L; i++) {
    total += args[i];
  }
  return total / L;
}
let eight = [1, 2, 3, 4, 5, 6, 7, 8];
console.log("ES2018: Spread ... Mean 1,2,...,8 = " + mean(...eight));
//-------------------------

let twoDim = [[1,2],[3,4]]; // 2D matrix
console.table(twoDim);
oneDim = twoDim.flat(); // make it a 1D array
console.log("ES2019: Flat = " + oneDim);
//-------------------------

let b =BigInt(2); e= BigInt(1024); 
bigInt = b ** e;  // This is a very large integer > 1.7e+308
fp = Number(bigInt); // Convert to float i.e. 64 IEEE 754 FP format
console.log('ES2020:  bigInt =' + bigInt + ' float = ' + fp);
// => ES2020:  bigInt =17976931348...7216 float = Infinity
//-------------------------

let str = "javascript";
console.log('ES2021:  replaceALL = ' + str.replaceAll('a','@'));
// => ES2021:  replaceALL = j@v@script
//-------------------------

const arr = [3, 5, 7];
console.log(`ES2022: Last element .at(-1) old ${arr[arr.length-1]} new style  ${arr.at(-1)}`);
// => Last element .at(-1) old 7 new style  7
 
} catch (err) {
  console.log(err.message);
}
