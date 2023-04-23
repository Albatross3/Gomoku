package com.example.gomoku.presentation.gomokugame;

import com.example.gomoku.common.GameUtil;
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
    Long roomId = stonePlaceReq.roomId();
    template.convertAndSend("/subscribe/gomoku-room/" + roomId, stonePlaceReq);

    // 서로 시작한다는 요청없이 시작된다면 아래와 같은 로직
    if (GameUtil.mapPerRoomId.get(roomId) == null) {
      GameUtil.mapPerRoomId
          .put(roomId, new char[15][15]);
    }
    // 흑 -> true , 백 -> false
    String color = stonePlaceReq.color();
    int[] loc = stonePlaceReq.location();
    GameUtil.mapPerRoomId
        .get(roomId)[loc[0]][loc[1]] = color.equals("B") ? '0' : '1';
    GomokuGameService.print(roomId);
    System.out.println();
  }

}
