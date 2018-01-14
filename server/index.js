var app =  require('express')();
var server =  require('http').Server(app);
var io =  require('socket.io')(server);
var blocks = [];

var port = 8080;

server.listen(port, function () {
   console.log("Server is running on: " + port);
});

io.on('connection', function (socket) {
    console.log("Player Connected!");
    socket.emit('socketID', { id: socket.id}); //emit a socketID to the connected Client
    socket.broadcast.emit('newPlayer', { id: socket.id}); //broadcast new connection to connected Clients
    socket.on('disconnect', function () {
       console.log("Player Disconnected");
    });

});


function block(id, x, y){
    this.id = id;
    this.x = x;
    this.y = y;
}