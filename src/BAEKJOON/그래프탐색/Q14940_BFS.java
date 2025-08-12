import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Q14940_BFS {

    static int[] dx = {-1 ,0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visit[i], -1);
        }
        ArrayDeque<Node> dq = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    dq.addLast(new Node(i, j));
                    visit[i][j] = 0;
                }
            }
        }

        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visit[nx][ny] == -1 && map[nx][ny] != 0) {
                    visit[nx][ny] = visit[cur.x][cur.y] + 1;
                    dq.addLast(new Node(nx, ny));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) sb.append("0 ");
                else sb.append(visit[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
