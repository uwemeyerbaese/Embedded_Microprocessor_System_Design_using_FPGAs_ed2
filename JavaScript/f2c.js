// attach an eventListener to our button that has an id
document.querySelector("#runButton").addEventListener("click", convertF2C);

function convertF2C() {
  var result; // globale scope var
  // try this, but watch for errors
  try {
    // Get the input value; convert string to floating-point
    const inputNum = parseFloat(document.querySelector("#textIn").value);

    // Compute the output display
    let c = ((inputNum - 32) * 5 / 9); // Apply conversion formular
    c = c.toFixed(2); // Round to 2 fractional digits
    result = inputNum + "&#176; Fahrenheit = " + c + "&#176; Celsius";
  } catch(err) {
    result = err.message;
  }
  // Display the result or error message
  document.querySelector(".textOut").innerHTML = result;
  document.querySelector("h1").style.backgroundColor = "lightgreen";
} 

