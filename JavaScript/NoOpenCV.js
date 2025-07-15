document.querySelector("#runButton")
        .addEventListener("click", imagePlot);

function imagePlot() {
  const N = 256; // number of x/y points in image
  const R = 20; // Radius of circles
  let canvas = document.querySelector("#myCanvas");
  let context = canvas.getContext("2d");
  context.fillStyle = "#000000";
  context.fillRect(0, 0, 256, 256);
  for (let i = 0; i < 10; i++) {
    // Rectangle upper left x/y corner
    let x = Math.floor(Math.random() * (N - 2*R)); 
    let y = Math.floor(Math.random() * (N - 2*R)); 
    // circle center x and y
    let xc = Math.floor(R + Math.random() * (N - 2*R)); 
    let yc = Math.floor(R + Math.random() * (N - 2*R)); 
    context.fillStyle = "rgb("+
      Math.floor(Math.random() * 256) + "," +
      Math.floor(Math.random() * 256) + "," +
      Math.floor(Math.random() * 256) + ")";
    context.fillRect(x, y, 2*R, 2*R); // Draw rectangle
    context.beginPath();
    context.arc(xc, yc, R, 0, 2 * Math.PI);//Draw circle
    context.fill();
  }
}