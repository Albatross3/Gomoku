package com.example.gomoku.presentation;

import com.example.gomoku.presentation.dto.StonePlaceReq;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GomokuGameController {

  private final SimpMessagingTemplate template;

  public GomokuGameController(SimpMessagingTemplate template) {
    this.template = template;
  }

  @MessageMapping("/stone")
  public void sendLocationOfStone(StonePlaceReq stonePlaceReq) {
    template.convertAndSend("/subscribe/gomoku-room/"+stonePlaceReq.roomId(), stonePlaceReq);
  }

}
