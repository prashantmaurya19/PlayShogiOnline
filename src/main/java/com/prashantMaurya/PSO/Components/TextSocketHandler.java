package com.prashantMaurya.PSO.Components;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@Slf4j
public class TextSocketHandler extends TextWebSocketHandler {
  private String notMatchedPlayer = "";
  private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
  private final Map<String, String> player_pair = new ConcurrentHashMap<>();

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    sessions.put(session.getId(), session);
    if (notMatchedPlayer == "") {
      notMatchedPlayer = session.getId();
    } else {
      player_pair.put(notMatchedPlayer, session.getId());
      player_pair.put(session.getId(), notMatchedPlayer);
      notMatchedPlayer = "";
    }
    log.info("WebSocket connection established: " + session.getId());
  }

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    String payload = message.getPayload();
    // log.info("Received message: " + payload);
    if (notMatchedPlayer != "") {
      return;
    }
    sessions.get(player_pair.get(session.getId())).sendMessage(new TextMessage(payload));
  }

  @Override
  public void afterConnectionClosed(
      WebSocketSession session, org.springframework.web.socket.CloseStatus status)
      throws Exception {
    sessions.remove(session.getId());
    System.out.println("WebSocket connection closed: " + session.getId());
  }
}
