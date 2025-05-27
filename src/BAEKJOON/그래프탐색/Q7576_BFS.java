package BAEKJOON.그래프탐색;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 문제 번호: 7576
 * 문제 이름: 토마토
 * 풀이 : bfs로 탐색하며 방문하지 않은 곳은 -1, -1인 곳을 탐색하면 값 초기화
 */

class Q7576_BFS {

    static int N;
    static int M;

    static int[][] map;
    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, 1 , 0, -1};

    static class Point {
        int r;
        int c;
        int depth;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
            depth = 1;
        }
        public Point(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        ArrayDeque<Point> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                String s = input[j];
                switch (s) {
                    case "-1":
                        map[i][j] = 0;
                        break;
                    case "0":
                        map[i][j] = -1;
                        break;
                    case "1":
                        map[i][j] = 1;
                        queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point cur = queue.removeFirst();
            int curR = cur.r;
            int curC = cur.c;
            int curDepth = cur.depth;

            for (int i = 0; i < 4; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];
                int nextDepth = curDepth + 1;
                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;
                if (map[nextR][nextC] == -1) {
                    map[nextR][nextC] = nextDepth;
                    queue.add(new Point(nextR, nextC, nextDepth));
                }
            }
        }

        int max = 0;
        boolean fail = false;

        for (int[] ints : map) {
            for (int anInt : ints) {
                if (anInt == -1) {
                    fail = true;
                    break;
                }
                max = Math.max(max, anInt);
            }
            if (fail) break;
        }

        if (fail) sb.append("-1");
        else sb.append(max - 1);

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

//    static void bfs(int r, int c) {
//        ArrayDeque<Point> queue = new ArrayDeque<>();
//        queue.addLast(new Point(r, c));
//
//        while (!queue.isEmpty()) {
//            Point cur = queue.removeFirst();
//            int curR = cur.r;
//            int curC = cur.c;
//            int curDepth = cur.depth;
//
//            for (int i = 0; i < 4; i++) {
//                int nextR = curR + dr[i];
//                int nextC = curC + dc[i];
//                int nextDepth = curDepth + 1;
//                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;
//                if (map[nextR][nextC] == -1) {
//                    map[nextR][nextC] = nextDepth;
//                    queue.add(new Point(nextR, nextC, nextDepth));
//                }
//            }
//        }
//    }
}