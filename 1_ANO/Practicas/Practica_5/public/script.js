// Creación de una instancia de socket.io y asignación a la variable socket
const socket = io();

// Obtención de referencias a elementos HTML relevantes
const messageForm = document.getElementById('message-form');
const messageInput = document.getElementById('input-message');
const messagesList = document.getElementById('messages');
const usernameForm = document.getElementById('username-form');
const usernameInput = document.getElementById('input-username');
const chatContainer = document.getElementById('chat-container');

// Inicialización de la variable username
let username = '';

// Evento 'submit' en el formulario de username
usernameForm.addEventListener('submit', (e) => {
  e.preventDefault();
  // Asignación del valor del input de username a la variable username
  username = usernameInput.value;
  if (username) {
    // Emitir el evento 'user joined' con el username al servidor
    socket.emit('user joined', username);
    // Ocultar el formulario de username y mostrar el contenedor de chat
    usernameForm.style.display = 'none';
    chatContainer.style.display = 'block';
  }
});

// Evento 'submit' en el formulario de mensajes
messageForm.addEventListener('submit', (e) => {
  e.preventDefault();
  // Obtención del mensaje del input de mensaje
  const message = messageInput.value;
  if (message) {
    // Emitir el evento 'chat message' con el mensaje al servidor
    socket.emit('chat message', message);
    // Limpiar el input de mensaje
    messageInput.value = '';
  }
});

// Evento 'user joined' recibido desde el servidor
socket.on('user joined', (username) => {
  // Crear un elemento de div para mostrar el mensaje de usuario que se ha unido
  const message = document.createElement('div');
  message.classList.add('user-joined');
  messagesList.appendChild(message);
});

// Evento 'user left' recibido desde el servidor
socket.on('user left', (username) => {
  // Crear un elemento de div para mostrar el mensaje de usuario que se ha ido
  const message = document.createElement('div');
  message.classList.add('user-left');
  messagesList.appendChild(message);
});

// Evento 'chat message' recibido desde el servidor
socket.on('chat message', ({ username, message }) => {
  // Crear un elemento de div para mostrar el mensaje de chat
  const messageDiv = document.createElement('div');
  messageDiv.classList.add('message');
  // Agregar la clase 'own-message' al div de mensaje si el username coincide con el input de username actual
  if (username === usernameInput.value) {
    messageDiv.classList.add('own-message');
  }
  // Configuración del contenido HTML del div de mensaje
  messageDiv.innerHTML = `
    <div class="message">
      <div class="sender">${username}</div>
      <div class="content">${message}</div>
      <div class="timestamp">${getCurrentTime()}</div>
    </div>
  `;
  messagesList.appendChild(messageDiv);
  // Desplazamiento automático al final de la lista de mensajes
  messagesList.scrollTop = messagesList.scrollHeight;
});

// Función para obtener la hora actual en formato HH:mm
function getCurrentTime() {
  const now = new Date();
  const hours = now.getHours().toString().padStart(2, '0');
  const minutes = now.getMinutes().toString().padStart(2, '0');
  return `${hours}:${minutes}`;
}

// Evento 'DOMContentLoaded' para abrir el popup (suponiendo que hay un elemento con el id 'popup')
document.addEventListener('DOMContentLoaded', function () {
  openPopup();
});

// Función para abrir el popup (suponiendo que hay un elemento con el id 'popup')
function openPopup() {
  document.getElementById('popup').style.display = 'block';
}

// Función para cerrar el popup (suponiendo que hay un elemento con el id 'popup')
function closePopup() {
  document.getElementById('popup').style.display = 'none';
}


// Función para imprimir la lista de usuarios conectados
function printConnectedUsers(users) {
  const usersContainer = document.getElementById('users-container');
  const usersList = usersContainer.querySelector('.users-list');

  // Eliminar usuarios anteriores
  while (usersList.firstChild) {
    usersList.firstChild.remove();
  }

  // Agregar usuarios a la lista
  users.forEach((user) => {
    const listItem = document.createElement('div');
    listItem.classList.add('user-item');

    // Agregar circulito verde
    const indicator = document.createElement('div');
    indicator.classList.add('indicator');
    listItem.appendChild(indicator);

    // Agregar nombre de usuario
    const username = document.createElement('div');
    username.textContent = user;
    listItem.appendChild(username);

    usersList.appendChild(listItem);
  });
}


// Evento para recibir la lista de usuarios conectados
socket.on('connected users', (users) => {
  printConnectedUsers(users);
});
