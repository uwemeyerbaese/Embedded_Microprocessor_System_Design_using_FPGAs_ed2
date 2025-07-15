"use strict";
try { 
console.log("*** Check ES support by year");

var phoneText = "My office phone number is (850) 410-6220 and \
my cell phone number is (123) 456-7890"
var m=phoneText.match(/\b \(\d{3}\) \d{3}-\d{4}\b/g)
console.log("ES3: regular expression; numbers = " + m);
//-------------------------
 
} catch (err) {
  console.log(err.message);
}
