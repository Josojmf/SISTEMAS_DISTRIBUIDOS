const express = require('express'); // Importa el módulo 'express'
const app = express(); // Crea una instancia de la aplicación Express

const http = require('http').createServer(app); // Crea un servidor HTTP utilizando la aplicación Express
const io = require('socket.io')(http); // Crea una instancia de Socket.IO asociada al servidor HTTP

app.use(express.static(__dirname + '/public')); // Configura Express para servir archivos estáticos desde el directorio 'public'

const connectedUsers = []; // Array para almacenar los nombres de usuario de los usuarios conectados al chat

io.on('connection', (socket) => { // Manejador de eventos cuando se establece una conexión con el servidor
  console.log('Un usuario se ha conectado'); // Imprime un mensaje en la consola cuando un usuario se conecta

  socket.on('disconnect', () => { // Manejador de eventos cuando un cliente se desconecta
    if (connectedUsers[socket.id]) { // Verifica si el usuario estaba registrado en 'connectedUsers'
      const username = connectedUsers[socket.id]; // Obtiene el nombre de usuario asociado al cliente
      delete connectedUsers[socket.id]; // Elimina la entrada del usuario en 'connectedUsers'
      io.emit('user left', username); // Emite un evento 'user left' a todos los clientes conectados
    }
    console.log('El usuario se ha desconectado'); // Imprime un mensaje en la consola cuando un usuario se desconecta
  });

  socket.on('chat message', (message) => { // Manejador de eventos cuando un cliente envía un mensaje de chat
    const username = connectedUsers[socket.id]; // Obtiene el nombre de usuario asociado al cliente
    io.emit('chat message', { username, message }); // Emite un evento 'chat message' a todos los clientes conectados junto con el nombre de usuario y el mensaje
  });

  socket.on('user joined', (username) => { // Manejador de eventos cuando un nuevo usuario se une al chat
    connectedUsers[socket.id] = username; // Almacena el nombre de usuario en 'connectedUsers'
    io.emit('connected users', Object.values(connectedUsers));//Emite el array de los usuarios actualizados a los clientes
    io.emit('user joined', username); // Emite un evento 'user joined' a todos los clientes conectados
  });

});

http.listen(3000, () => { // El servidor comienza a escuchar en el puerto 3000
  console.log('Servidor escuchando en el puerto 3000'); // Imprime un mensaje en la consola cuando el servidor está listo
});

