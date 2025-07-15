// cd /home/root/Linux_Libraries/drivers 
// then ./load_drivers 
console.log("Demo for AUP child_process library:");
var exec = require("child_process").exec;
var cmd = "cat /dev/IntelFPGAUP/SW";
exec(cmd, function (error, stdout, stderr) {
  console.log("stdout =", stdout);
  console.error("stderr =", stderr);
  if (error !== null) {
    console.log("exec error: ", error);
  }
});
