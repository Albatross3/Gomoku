package com.example.gomoku.presentation.gomokugame;

import com.example.gomoku.common.GameUtil;

// 돌을 놓을 때마다 게임이 이겼는지 확인해주는 클래스
public class GomokuGameService {

    public static void print(Long roomId) {
        char[][] temp = GameUtil.mapPerRoomId.get(roomId);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }
    }

    // 돌이 들어올때마다 오목이 완성되었는지 확인하는 메서드
}
