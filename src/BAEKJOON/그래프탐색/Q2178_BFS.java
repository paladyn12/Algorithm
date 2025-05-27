package BAEKJOON.그래프탐색;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 문제 번호: 2178
 * 문제 이름: 미로 탐색
 * 풀이: BFS 알고리즘으로 map[N-1][M-1] 까지 경로 길이를 추적해나감
 */
class Q2178_BFS {

    static int M;
    static int N;
    static int[][] map;
    static boolean[][] visit;

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

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == '1')
                    map[i][j] = 1;
            }
        }

        bfs(0, 0);

        System.out.println(map[N-1][M-1]);

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
                    map[cx][cy] = map[node.x][node.y] + 1;
                }
            }
        }
    }
    static boolean rangeCheck() {
        return cx >= 0 && cx < N && cy >= 0 && cy < M;
    }
}