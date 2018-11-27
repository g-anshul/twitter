var http = require('http');
var fs = require('fs');

http.createServer(function(request,response) {
fs.readFile('../../src/index.html',function(err,data){
if (err) return console.error(err);
   console.log(data.toString());

   response.writeHead(200, {'Content-type': 'text/html'});
   response.write(data);
   return response.end();
   });
}).listen(9000);

console.log('Server running at http://127.0.0.1:9000/');