package BAEKJOON.그래프탐색;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 번호: 7562
 * 문제 이름: 나이트의 이동
 * 풀이 : bfs로 탐색하며 나이트가 이동 가능한 반경 8가지를 queue에 넣으면서 bfs 수행
 */

class Q7562_BFS {

    static int L;

    static int[][] map;
    static int[] dr = new int[] {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dc = new int[] {1, 2, 2, 1, -1, -2, -2, -1};

    static class Point {
        int r;
        int c;
        int depth;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
            depth = 0;
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

        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());
        while (test_case-- > 0) {

            L = Integer.parseInt(br.readLine());

            map = new int[L][L];
            for (int[] ints : map) {
                Arrays.fill(ints, -1);
            }

            ArrayDeque<Point> queue = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            map[start.r][start.c] = start.depth;

            st = new StringTokenizer(br.readLine());
            Point goal = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if (start.r == goal.r && start.c == goal.c) {
                sb.append(0).append("\n");
                continue;
            }

            queue.addLast(start);

            while (!queue.isEmpty()) {
                Point cur = queue.removeFirst();
                int curR = cur.r;
                int curC = cur.c;
                int curDepth = cur.depth;

                for (int i = 0; i < 8; i++) {
                    int nextR = curR + dr[i];
                    int nextC = curC + dc[i];
                    int nextDepth = curDepth + 1;
                    if (nextR < 0 || nextR >= L || nextC < 0 || nextC >= L) continue;
                    if (map[nextR][nextC] == -1) {
                        map[nextR][nextC] = nextDepth;
                        queue.addLast(new Point(nextR, nextC, nextDepth));
                    }
                }
            }

            sb.append(map[goal.r][goal.c]).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}