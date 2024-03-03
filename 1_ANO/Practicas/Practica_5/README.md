# Practica_5_Distribuidos
Esta práctica consistia en realizar un chat con Node y Sockets. No se ha incluido en este repositorio la carpeta node_modules debido a su tamaño, por ello, que sea necesaria su previa instalacion para poder ejecutarlo: 
```
npm install 
```

# Como correr el código
Primero necesitamos correr el servidor para poder conectar los clientes: 
```
node server.js
```
A continuación iremos a el buscador de nuestro ordenador que queramos y simplemente introduciendo [localhost:3000](http://localhost:3000) podremos crear tantos clientes como queramos.

# Como se ha realizado
Para poder empezar a trabajar, primero debimos instalar varias cosas:

Comando con el que vamos a instalar el archivo [package.json](/package.json)
```
npm init -y 
```

Comando con el cual instalaremos carperta node_modules y archivo [package-lock.json](/package-lock.json)
```
npm install express socket.io
```

# Funcionamiento
Tenemos un archivo [server.js](/server.js) contiene todas las funciones necesarias para nuestro chat, por ejemplo, contiene una funcion la cual va a recibir el nombre el cual introduce y envia un cliente. Además, contiene un array en el cual va a almacenar todos los clientes que estan conectado.

Tenemos también la carpeta public la cual hace referencia a los clientes. Esta carpeta contiene un [fondo.png](public/fondo.jpg) y un [style.css](public/style.css) cuya único funcionamiento es dejar la interfaz visualmente más bonita.

Por otra parte, tenemos el archivo [index.html](public/index.html) el cual muestra una interfaz la cual solicita el nombre y se conecta con el servidor, además de poder enviar mensajes que se van a mostrar en un chat y tambien podremos ver el nombre de los clientes que estan conectados.

Por último, tenemos el archivo [script.js](public/script.js), este archivo contiene todas las funciones necesarias para poder conectarse con el servidor 
enviandole por lo general el "username". Tambien tiene funciones las cuales se encargan de recibir datos enviados por el servidor, como el array de personas que estan en línea o los mensajes que envían otros clientes.

# Autores
| [<img src="https://avatars.githubusercontent.com/u/101803057?v=4" width=115><br><sub>Fernando Pérez Ballesteros</sub>](https://github.com/fperezb2) | [<img src="https://avatars.githubusercontent.com/u/101109006?v=4" width=115><br><sub>Marcos Pardo Zapico</sub>](https://github.com/marcos-pardo)    |[<img src="https://avatars.githubusercontent.com/u/85015693?v=4" width=115><br><sub>Pablo Rayón Zapater</sub>](https://github.com/PabloRayon)       |
| :---: | :---: | :---: | 
