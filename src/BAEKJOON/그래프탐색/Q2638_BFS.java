import java.util.*;
import java.io.*;

class Q2638_BFS {

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cheeseCnt = 0;
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheeseCnt++;
            }
        }
        
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.addLast(new Node(0, 0));
        map[0][0] = -1;
        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] == 0) {
                    map[nx][ny] = -1;
                    dq.addLast(new Node(nx, ny));
                }
            }
        }

        int time = 0;
        while (cheeseCnt > 0) {
            time++;
            boolean[][] delete = new boolean[N][M];
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (map[i][j] == 1) {
                        int cnt = 0;
                        for (int d = 0; d < 4; d++) {
                            if (map[i + dx[d]][j + dy[d]] == -1) cnt++;
                        }
                        if (cnt >= 2) {
                            delete[i][j] = true;
                            dq.addLast(new Node(i, j));
                        }
                    }
                }
            }
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (delete[i][j]) {
                        map[i][j] = -1;
                        cheeseCnt--;
                    }
                }
            }

            if (cheeseCnt == 0) break;
            while (!dq.isEmpty()) {
                Node cur = dq.pollFirst();
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = -1;
                        dq.addLast(new Node(nx, ny));
                    }
                }
            }
        }
        System.out.print(time);
    }
}
