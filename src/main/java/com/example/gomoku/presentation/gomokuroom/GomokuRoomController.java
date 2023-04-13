package com.example.gomoku.presentation.gomokuroom;

import com.example.gomoku.domain.gomokuroom.GomokuRoomService;
import com.example.gomoku.domain.gomokuroom.dto.request.GomokuRoomCreateReq;
import com.example.gomoku.domain.gomokuroom.dto.response.GomokuRoomCreateRes;
import com.example.gomoku.domain.gomokuroom.dto.response.GomokuRoomListRes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class GomokuRoomController {

  private final GomokuRoomService gomokuRoomService;

  public GomokuRoomController(GomokuRoomService gomokuRoomService) {
    this.gomokuRoomService = gomokuRoomService;
  }

  @PostMapping("/gomoku-room")
  public ResponseEntity<GomokuRoomCreateRes> createGomokuRoom(@RequestBody GomokuRoomCreateReq gomokuRoomCreateReq) {
    GomokuRoomCreateRes gomokuRoomCreateRes = gomokuRoomService.createGomokuRoom(gomokuRoomCreateReq);
    return ResponseEntity.ok(gomokuRoomCreateRes);
  }

  // TODO 오목 방 불러오기 -> 무한스크롤로 구현
  @GetMapping("/gomoku-room")
  public ResponseEntity<GomokuRoomListRes> getGomokuRoomList() {
    GomokuRoomListRes gomokuRoomListRes = gomokuRoomService.findGomokuRoom();
    return ResponseEntity.ok(gomokuRoomListRes);
  }
}
