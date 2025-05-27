package BAEKJOON.그래프탐색;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 문제 번호: 16929
 * 문제 이름: Two Dots
 * 풀이 : bfs에 탐색하려는 값을 넣음
 * 탐색한 depth 기록
 * 만약 탐색하는 노드의 depth가 nextDepth이면 (같은 depth의 노드) 순환
 */

class Q16929_BFS {

    static int N;
    static int M;
    static int[][] visit;

    static char[][] map;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};

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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new int[N][M];
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        boolean success = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j] == 0) {
                    visit[i][j] = 1;
                    if (bfs(i, j, map[i][j])) success = true;
                }
                if (success) break;
            }
            if (success) break;
        }

        String result = success ? "Yes" : "No";
        sb.append(result);

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    static boolean bfs(int r, int c, char alphabet) {

        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(r, c));

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
                if (map[nextR][nextC] == alphabet) {
                    if (visit[nextR][nextC] == 0) {
                        visit[nextR][nextC] = nextDepth;
                        queue.addLast(new Point(nextR, nextC, nextDepth));
                    } else if (visit[nextR][nextC] == nextDepth){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}