// Summarizing traffic rolling frequencies with an array instead of switch
//L=[4,11,59,77];
var loop = 0;
let url1 = 'https://talgovsvcp.talgov.net/TallahasseeAtmsWeb/cctvimages/video004.jpg'
let url2 = 'https://talgovsvcp.talgov.net/TallahasseeAtmsWeb/cctvimages/video011.jpg'
let url3 = 'https://talgovsvcp.talgov.net/TallahasseeAtmsWeb/cctvimages/video059.jpg'
let url4 = 'https://talgovsvcp.talgov.net/TallahasseeAtmsWeb/cctvimages/video077.jpg'
var trafficImages = new Array(4); // array to store img elements

// get traffic img elements
function start() {
  var button = document.getElementById("rollButton");
  button.addEventListener("click", setImage, false);
  var length = trafficImages.length; // get array's length once before loop

  for (var i = 0; i < length; ++i) {
    trafficImages[i] = document.getElementById("traffic" + (i + 1));
    trafficImages[i].setAttribute("src", "blank.png");
  } // end for
} // end function start

// set image source for a traffic
function setImage() {
  let x = setInterval(function () {
    let d = new Date();
    let str = "Time = " + d.toLocaleTimeString();
    document.getElementById("p1").innerHTML = str;
    trafficImages[0].setAttribute("src", url1);
    trafficImages[0].setAttribute("alt", " BLAR/MAHN WEST");
    trafficImages[1].setAttribute("src", url2);
    trafficImages[1].setAttribute("alt", " APKW/BLAR SOUTH");
    trafficImages[2].setAttribute("src", url3);
    trafficImages[2].setAttribute("alt", " CCNE-PARK SOUTH");
    trafficImages[3].setAttribute("src", url4);
    trafficImages[3].setAttribute("alt", " MAGN/MAHN EAST");
  }, 5000); // Update every 5000ms
} // end function setImage

window.addEventListener("load", start, false);
