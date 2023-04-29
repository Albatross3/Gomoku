package com.example.gomoku.presentation.gomokugame;

import com.example.gomoku.common.GameUtil;
import org.springframework.stereotype.Service;

// 돌을 놓을 때마다 게임이 이겼는지 확인해주는 클래스
@Service
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
    public boolean isGomoku(char[][] map, int[] currentLocation) {
        int currentX = currentLocation[0];
        int currentY = currentLocation[1];
        char currentColor = map[currentX][currentY];

        int rowCount = 1;
        int columnCount = 1;
        int rightDiagonalCount = 1;
        int leftDiagonalCount = 1;

        int nextX;
        int nextY;
        // 1. 가로에서 count
        // 왼쪽
        nextY = currentY - 1;
        while (nextY >= 0 && map[currentX][nextY] == currentColor) {
            rowCount++;
            nextY -= 1;
        }
        // 오른쪽
        nextY = currentY + 1;
        while (nextY < 15 && map[currentX][nextY] == currentColor) {
            rowCount++;
            nextY += 1;
        }

        // 2. 세로에서 count
        // 위쪽
        nextX = currentX - 1;
        while (nextX >= 0 && map[nextX][currentY] == currentColor) {
            columnCount++;
            nextX -= 1;
        }
        // 아래쪽
        nextX = currentX + 1;
        while (nextX < 15 && map[nextX][currentY] == currentColor) {
            columnCount++;
            nextX += 1;
        }

        // 3. 오른 대각에서 count
        // 왼쪽 아래
        nextX = currentX + 1;
        nextY = currentY - 1;
        while (nextX < 15 && nextY >= 0 && map[nextX][nextY] == currentColor) {
            rightDiagonalCount++;
            nextX += 1;
            nextY -= 1;
        }
        // 오른쪽 위
        nextX = currentX - 1;
        nextY = currentY + 1;
        while (nextX >= 0 && nextY < 15 && map[nextX][nextY] == currentColor) {
            rightDiagonalCount++;
            nextX -= 1;
            nextY += 1;
        }

        // 4. 왼쪽 대각에서 count
        // 왼쪽 위
        nextX = currentX - 1;
        nextY = currentY - 1;
        while (nextX >= 0 && nextY >= 0 && map[nextX][nextY] == currentColor) {
            leftDiagonalCount++;
            nextX -= 1;
            nextY -= 1;
        }
        // 오른쪽 아래
        nextX = currentX + 1;
        nextY = currentY + 1;
        while (nextX < 15 && nextY < 15 && map[nextX][nextY] == currentColor) {
            leftDiagonalCount++;
            nextX += 1;
            nextY += 1;
        }

        // 5개가 되는게 있는지 확인
        if (rowCount == 5 || columnCount == 5 || rightDiagonalCount == 5
            || leftDiagonalCount == 5) {
            return true;
        }
        return false;
    }
}
