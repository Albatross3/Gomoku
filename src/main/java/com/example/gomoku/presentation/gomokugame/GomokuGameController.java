package com.example.gomoku.presentation.gomokugame;

import com.example.gomoku.common.GameUtil;
import com.example.gomoku.presentation.dto.StonePlaceReq;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GomokuGameController {

  private final GomokuGameService gomokuGameService;
  private final SimpMessagingTemplate template;

  public GomokuGameController(GomokuGameService gomokuGameService, SimpMessagingTemplate template) {
    this.gomokuGameService = gomokuGameService;
    this.template = template;
  }

  @MessageMapping("/stone")
  public void sendLocationOfStone(StonePlaceReq stonePlaceReq) {
    Long roomId = stonePlaceReq.getRoomId();


    // 서로 시작한다는 요청없이 시작된다면 아래와 같은 로직
    // 새로운 대국이면 roomId : map 만들기
    if (GameUtil.mapPerRoomId.get(roomId) == null) {
      GameUtil.mapPerRoomId
          .put(roomId, new char[15][15]);
    }

    // 흑 -> '0' , 백 -> '1'
    String color = stonePlaceReq.getColor();
    int[] loc = stonePlaceReq.getLocation();
    GameUtil.mapPerRoomId
        .get(roomId)[loc[0]][loc[1]] = color.equals("B") ? '0' : '1';

    // 게임이 끝났는지 확인
    if (gomokuGameService.isGomoku(GameUtil.mapPerRoomId.get(roomId), loc)) {
      stonePlaceReq.setWinColor(color);
    }

    // socket 통신
    template.convertAndSend("/subscribe/gomoku-room/" + roomId, stonePlaceReq);

    // 오목판 출력
//    GomokuGameService.print(roomId);
//    System.out.println();

  }
}
