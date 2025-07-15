console.log("Demo for child_process library:");
var exec = require("child_process").exec;
exec("gpio-demo -g 1003 -i", function (error, stdout, stderr) {
  console.log("stdout =", stdout);
  console.error("stderr =", stderr);
  if (error !== null) {
    console.log("exec error: ", error);
  }
});
