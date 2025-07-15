//function grades(formId) {
N = 10;
// try this, but watch for errors
var result = "";
// Get the input value
//  let N = formId.textin.value;

// Note the JS random does not has a seed option !
// RANDLC, a C library which implements a version of the pseudorandom
// number generator used by the NAS Parallel Benchmarks.
// The generator has the form
//
//    X(K+1) = A * X(K) mod 2^46
//
// where the suggested value of the multiplier A is 5^13 = 1220703125.
//
// This scheme generates 2^44 numbers before repeating.
// The web site for the NAS Parallel Benchmarks is
// http://www.nas.nasa.gov/Resources/Software/npb.html.

A = Math.pow(5, 13);
console.log("A = " + A);
M = Math.pow(2, 46);
console.log("M = " + M);
X = N; // seed > 0
data = [];
str = [];
for (k = 0; k < N; k++) {
  X = Math.floor((X * A) % M);
  str += X + " ";
  data.push(X % 101); // values in range 0...100
}
console.log("X = " + str);
console.log("Original = " + data);
result += "Data = " + data + "\n";
data.sort();
console.log("Default sort = " + data);

data.sort(function (n, m) {
  return m - n;
});
console.log("Decending = " + data);

data.sort(function (n, m) {
  return n - m;
});
console.log("Ascending = " + data);

L = data.length;
console.log("Length = " + L);

//ma=Math.max(data)
ma = data[L - 1];
console.log("Max = " + ma);
result += "Maximum = " + ma + "\n";

//mi=Math.min(data)
mi = data[0];
console.log("Min = " + mi);
result += "Minimum = " + mi + "\n";

mean = 0;
for (k = 0; k < L; k++) mean += data[k];
mean /= L;
console.log("Mean = " + mean);
result += "Mean = " + mean + "\n";

if (L % 2 == 1) {
  // N is odd
  med = data[(L - 1) / 2];
} else {
  med = (data[L / 2] + data[L / 2 - 1]) / 2;
}
console.log("Median  = ", med);
result += "Sorted = " + data + "\n";
result += "Median = " + med + "\n";

A = 0; B = 0; C = 0; D = 0; F = 0;
for (k = 0; k < L; k++) {
  if (data[k] >= 90) A += 1;
  else if (data[k] >= 80) B += 1;
  else if (data[k] >= 70) C += 1;
  else if (data[k] >= 60) D += 1;
  else F += 1;
}
console.log("Grade distribution:");
console.log("A=" + A + " B= " + B + " C=" + C + " D=" + D + " F=" + F);
result += "Grade distribution:\n";
result += "A=" + A + " B= " + B + " C=" + C + " D=" + D + " F=" + F;
console.log(result);