// Load our user library from local aka current directory
const my_module = require("./myNodeModule.js"); 

// Run some tests for the user library
console.log('NUM1 =',my_module.NUM1)
console.log('NUM2 =',my_module.NUM2)
r = my_module.calc(my_module.NUM2, my_module.NUM1, 'sub');
console.log('NUM2 - NUM1 =',r);
r = my_module.calc(3, 5, 'mul');

//r = my_module.sum(3, 5) // => TypeError: my_module.sum is not a function
console.log("Done with node style export/require");

                    


