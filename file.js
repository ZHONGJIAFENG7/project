var fx = require("fs");
fx.readFile("file.txt", "utf-8",function(error,data){
	if (error){
		console.log(error);
	} else {
		console.log(data);
	}
})
console.log('end');
