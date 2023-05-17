package com.example.gomoku.presentation.dto;

import lombok.Getter;

/*
 winColor 를 변경해주어야 하기 때문에
 record 에서 일반 class 로 변경하였다 (record 는 모든 필드가 private final)
 */
@Getter
public class StonePlaceReq {
  private final String userId;
  private final Long roomId;
  private final String color;
  private final int[] location;
  String winColor;

  public StonePlaceReq(String userId, Long roomId, String color, int[] location) {
    this.userId = userId;
    this.roomId = roomId;
    this.color = color;
    this.location = location;
  }

  public void setWinColor(String color) {
    winColor = color;
  }
}
