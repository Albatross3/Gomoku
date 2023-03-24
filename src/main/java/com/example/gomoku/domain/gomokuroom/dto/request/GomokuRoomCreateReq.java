package com.example.gomoku.domain.gomokuroom.dto.request;

import com.example.gomoku.domain.gomokuroom.GomokuRoom;

public record GomokuRoomCreateReq(String roomName) {

  public static GomokuRoom toGomokuRoom(GomokuRoomCreateReq gomokuRoomCreateReq) {
    return new GomokuRoom(gomokuRoomCreateReq.roomName());
  }

}
