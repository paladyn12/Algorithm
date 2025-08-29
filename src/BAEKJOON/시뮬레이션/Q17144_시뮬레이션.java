import java.io.*;
import java.util.*;

class Q17144_시뮬레이션 {

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int up = 0;
        int down = 0;

        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1 && down == 0) {
                    up = i;
                    down = i + 1;
                }
            }
        }

        for (int time = 0; time < T; time++) {

            int[][] spread = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] >= 5) {
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                            if (map[nx][ny] != -1) {
                                spread[nx][ny] += map[i][j] / 5;
                                spread[i][j] -= map[i][j] / 5;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] != -1) map[i][j] += spread[i][j];
                }
            }
            
            int curX = up;
            int curY = 0;

            while (curX > 0) {
                map[curX][curY] = map[curX - 1][curY];
                curX--;
            }
            while (curY < C - 1) {
                map[curX][curY] = map[curX][curY + 1];
                curY++;
            }
            while (curX < up) {
                map[curX][curY] = map[curX + 1][curY];
                curX++;
            }
            while (curY > 0) {
                map[curX][curY] = map[curX][curY - 1];
                curY--;
            }
            
            map[up][0] = -1;
            map[up][1] = 0;

            curX = down;
            curY = 0;
            
            while (curX < R - 1) {
                map[curX][curY] = map[curX + 1][curY];
                curX++;
            }
            while (curY < C - 1) {
                map[curX][curY] = map[curX][curY + 1];
                curY++;
            }
            
            while (curX > down) {
                map[curX][curY] = map[curX - 1][curY];
                curX--;
            }
            while (curY > 0) {
                map[curX][curY] = map[curX][curY - 1];
                curY--;
            }
            
            map[down][0] = -1;
            map[down][1] = 0;
        }

        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != -1) ans += map[i][j];
            }
        }
        System.out.print(ans);
    }
}
