package BAEKJOON.그래프탐색;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 문제 번호: 1012
 * 문제 이름: 유기농 배추
 * 풀이: 배추가 심어져 있고 방문하지 않은 지역을 만나면 count++ (지렁이 심기)
 * 지렁이를 심은 지역으로부터 이어진 부분은 모두 방문하여 추가적으로 지렁이를 심지 않도록 함
 */
class Q1012_BFS {

    static int M;
    static int N;
    static int K;
    static int[][] map;
    static boolean[][] visit;
    static int count;

    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int cx, cy;

    static ArrayDeque<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (test_case-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visit = new boolean[M][N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }
            count = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j] && map[i][j] == 1) {
                        count++;
                        bfs(i, j);
                    }
                }
            }

            sb.append(count).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
    static void bfs(int x, int y) {
        visit[x][y] = true;
        queue.addLast(new Node(x, y));
        while (!queue.isEmpty()) {

            Node node = queue.removeFirst();

            for (int i = 0; i < 4; i++) {
                cx = node.x + dirX[i];
                cy = node.y + dirY[i];
                if (rangeCheck() && !visit[cx][cy] && map[cx][cy] == 1) {
                    queue.addLast(new Node(cx, cy));
                    visit[cx][cy] = true;
                }
            }
        }
    }
    static boolean rangeCheck() {
        return cx >= 0 && cx < M && cy >= 0 && cy < N;
    }
}