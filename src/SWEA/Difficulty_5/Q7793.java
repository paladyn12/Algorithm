import java.io.*;
import java.util.*;

class Q7793 {

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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[][] map = new char[N][M];
            int[][] demon = new int[N][M];
            for (int i = 0; i < N; i++) Arrays.fill(demon[i], Integer.MAX_VALUE);
            Node start = null;
            Node goal = null;
            
            ArrayDeque<Node> dq = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = input.charAt(j);
                    if (map[i][j] == '*') {
                        dq.addLast(new Node(i, j));
                        demon[i][j] = 0;
                    }
                    else if (map[i][j] == 'S') start = new Node(i, j);
                    else if (map[i][j] == 'D') goal = new Node(i, j);
                }
            }

            while (!dq.isEmpty()) {
                Node cur = dq.pollFirst();
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (map[nx][ny] != 'X' && map[nx][ny] != 'D' && demon[nx][ny] > demon[cur.x][cur.y] + 1) {
                        demon[nx][ny] = demon[cur.x][cur.y] + 1;
                        dq.addLast(new Node(nx, ny));
                    }
                }
            }

            int[][] visit = new int[N][M];
            for (int i = 0; i < N; i++) Arrays.fill(visit[i], -1);
            dq.addLast(start);
            visit[start.x][start.y] = 0;
            while (!dq.isEmpty()) {
                Node cur = dq.pollFirst();
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (map[nx][ny] != 'X' && visit[nx][ny] == -1 && demon[nx][ny] > visit[cur.x][cur.y] + 1) {
                        visit[nx][ny] = visit[cur.x][cur.y] + 1;
                        dq.addLast(new Node(nx, ny));
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(visit[goal.x][goal.y] == -1 ? "GAME OVER" : visit[goal.x][goal.y]).append("\n");
        }
        System.out.print(sb);
    }
}
