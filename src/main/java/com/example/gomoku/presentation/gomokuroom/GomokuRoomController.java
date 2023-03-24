package com.example.gomoku.presentation.gomokuroom;

import com.example.gomoku.domain.gomokuroom.GomokuRoomService;
import com.example.gomoku.domain.gomokuroom.dto.request.GomokuRoomCreateReq;
import com.example.gomoku.domain.gomokuroom.dto.response.GomokuRoomCreateRes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
}
