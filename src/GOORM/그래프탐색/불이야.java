package GOORM.그래프탐색;

import java.io.*;
import java.util.*;

/**
 * 현 위치의 주변 까지 불이 번지는 시간을 구하는 문제
 * 모든 지점에 불이 번지는 시간을 -1로 초기화
 * 화재 시작점으로부터 bfs 방식으로 불을 넓히고 번지는 시간은 불을 넓힌 지역의 번지는 시간 + 1로 초기화
 * 최종적으로 현 위치 주변에 불이 번지는 시간을 구해 정답 출력
 */
class 불이야 {

    // 현 위치
    static Point goorm;
    // 연구실의 각 지점에 불이 번지는 시간
    static int[][] fireTime;
    static char[][] lab;
    static int R;
    static int C;

    static class Point {
        int x, y, time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public Point(int x, int y) {
            this(x, y, 0);
        }
    }

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 모든 지점에 불이 붙는 시간을 -1로 초기화
        fireTime = new int[R][C];
        for (int i = 0; i < R; i++) Arrays.fill(fireTime[i], -1);

        // 불이 번지기 시작하는 지점을 queue에 넣고 bfs 방식으로 넓힘
        ArrayDeque<Point> queue = new ArrayDeque<>();
        lab = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (charArray[j] == '@') {
                    queue.addLast(new Point(i, j, 0));
                    fireTime[i][j] = 0;
                }
                else if (charArray[j] == '&') {
                    goorm = new Point(i, j);
                }
                lab[i][j] = charArray[j];
            }
        }

        // 불 BFS
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            Point curr = queue.removeFirst();
            for (int d = 0; d < 4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];
                if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                    if (lab[nx][ny] == '.' && fireTime[nx][ny] == -1) {
                        fireTime[nx][ny] = curr.time + 1;
                        queue.addLast(new Point(nx, ny, curr.time + 1));
                    }
                }
            }
        }

        // 현 위치 주변 확인 후 정답 출력
        int minTime = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            int nx = goorm.x + dx[d];
            int ny = goorm.y + dy[d];
            if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                if (fireTime[nx][ny] != -1) {
                    minTime = Math.min(minTime, fireTime[nx][ny]);
                }
            }
        }
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }
}