package GOORM.기초알고리즘챌린지;

import java.io.*;
import java.util.*;

class GameJam {

    static class Point {
        int x;
        int y;
        int count;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            count = 0;
        }
    }

    static String[][] board;
    static boolean[][] visit;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};
    static int N;

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new String[N][N];
        visit = new boolean[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Point goorm = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1); // Point(3, 1)
        st = new StringTokenizer(br.readLine());
        Point player = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1); // Point(1, 3)

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = st.nextToken();
            }
        }

        // 메인 로직
        visited(goorm);
        while (true) {
            if (move(goorm)) break;
        }
        System.out.println();

        visit = new boolean[N][N];
        visited(player);
        while (true) {
            if (move(player)) break;
        }

        // 출력
        if (goorm.count > player.count) System.out.print("goorm " + goorm.count);
        else System.out.print("player " + player.count);
    }

    static boolean move(Point p) {
        // 움직이고 만약 visit이 true인 곳을 방문하면 true 반환하면 exit

        String commandAndCount = board[p.x][p.y];
        int dir = 0;
        switch (commandAndCount.charAt(commandAndCount.length() - 1)) {
            case 'R':
                dir = 0;
                break;
            case 'L':
                dir = 1;
                break;
            case 'U':
                dir = 2;
                break;
            case 'D':
                dir = 3;
                break;
        }
        int count = Integer.parseInt(commandAndCount.substring(0, commandAndCount.length() - 1));
        for (int i = 0; i < count; i++) {
            int nextX = (N + p.x + dirX[dir]) % N;
            int nextY = (N + p.y + dirY[dir]) % N;
            if (visit[nextX][nextY]) return true;
            p.x = nextX;
            p.y = nextY;
            visited(p);
        }
        return false;
    }

    static void visited(Point p) {
        visit[p.x][p.y] = true;
        p.count++;
    }
}