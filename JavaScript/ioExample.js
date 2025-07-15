// Read the Verilog file, replace CLK-> CLOCK, 
// and save new file
"use strict";
try {
  var fs = require("fs");

  fs.readFile("d_ff.v", "utf-8", function (err, data) {
    //if (err) throw err;
    //var revisedData = data.replaceAll("CLK", "CLOCK");
    while (data.indexOf("CLK") != -1) {
     data = data.replace("CLK", "CLOCK");
    }
    var revisedData = data;
    fs.writeFile("d_ff_rev.v", revisedData, "utf-8", function (err, data) {
      if (err) throw err;
      console.log("Done with replacements!");
      console.log("--------------------------------------");
      // Read + display the new file
      fs.readFile("d_ff_rev.v", "utf-8", function (err, fileData) {
        if (err) throw err;
        console.log("Display revised file:");
        console.log(fileData);
        console.log("-----------------------------------");
      });
    });
  });
} catch (err) {
  console.log(err.message);
}
