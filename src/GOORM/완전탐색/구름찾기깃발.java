package GOORM.완전탐색;

import java.io.*;
import java.util.*;

class 구름찾기깃발 {
    /**
     * 구름이 없는 각 위치에서 상하좌우, 대각선의 구름 개수를 찾고 그것이 K와 동일하면 결과값 + 1
     * 이차원 배열을 [N][N]이 아닌 [N+2][N+2]로 생성
     * 배열의 테두리는 0으로 초기화하여 경계값 검사 로직 무시
     * 배열 정보를 인덱스 1부터 N에 넣음 (테두리는 0, 그 내부에 격자판 내용이 들어감)
     *
     *                        0 0 0 0 0 0
     *    0 0 0 1             0 0 0 0 1 0
     *    0 0 1 0     >>      0 0 0 1 0 0
     *    0 0 1 0     >>      0 0 0 1 0 0
     *    0 1 1 1             0 0 1 1 1 0
     *                        0 0 0 0 0 0
     */
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        board = new int[N+2][N+2];

        // 배열 테두리를 0으로 만들면서 초기화
        for (int i = 0; i < N+2; i++) {
            if (i == 0 || i == N+1) {
                board[i] = new int[N+2];
            }
            else {
                st = new StringTokenizer(br.readLine());
                board[i][0] = 0;
                board[i][N+1] = 0;
                for (int j = 1; j <= N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // 상하좌우, 대각선의 구름 합이 K 이면 result++
        // 구름이 있는 위치는 무시
        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (board[i][j] != 1 && logic(i, j) == K) result++;
            }
        }

        System.out.print(result);
    }

    // x, y 좌표의 상하좌우, 대각선 구름 개수 반환
    static int logic(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                count += board[x + i][y + j];
            }
        }
        return count;
    }
}