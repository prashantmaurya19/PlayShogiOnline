const socket = new WebSocket("ws://" + window.location.host + "/game-ws"); // Adjust for https if needed

socket.onopen = function (event) {
  console.log("WebSocket connection opened");
};

socket.onmessage = function (event) {
  const message = document.createElement("p");
  message.textContent = event.data;
  message.style.alignSelf = "start";
  document
    .getElementById("chatbox")
    .insertBefore(message, document.getElementById("chat"));
  console.log(event);
};

socket.onclose = function (event) {
  console.log("WebSocket connection closed");
};

document.getElementById("chat").addEventListener("keypress", (e) => {
  if (e.key == "Enter") {
    socket.send(e.target.value);
    const message = document.createElement("p");
    message.textContent = e.target.value;
    message.style.alignSelf = "end";
    document
      .getElementById("chatbox")
      .insertBefore(message, document.getElementById("chat"));
    e.target.value = "";
  }
});
