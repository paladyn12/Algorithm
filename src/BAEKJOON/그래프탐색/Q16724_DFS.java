import java.io.*;
import java.util.*;

public class Q16724_DFS {

    static int ans = 0;
    static char[][] map;
    static boolean[][] visit;
    static boolean[][] bfsCheck;
    
    static int N;
    static int M;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        bfsCheck = new boolean[N][M];
        
        for (int i = 0 ; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j]) {
                    dfs(i, j);
                    ans++;
                }
            }
        }
        System.out.print(ans);
    }

    static void dfs(int x, int y) {
        while (!visit[x][y]) {
            visit[x][y] = true;
            switch (map[x][y]) {
                case 'L': y--; break;
                case 'R': y++; break;
                case 'U': x--; break;
                case 'D': x++; break;
            }
        }
        bfs(x, y);
    }

    static void bfs(int x, int y) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(x, y));
        bfsCheck[x][y] = true;
        while (!dq.isEmpty()) {
            Node cur = dq.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (bfsCheck[nx][ny]) continue;
    
                if ((d == 0 && map[nx][ny] == 'R') ||
                    (d == 1 && map[nx][ny] == 'L') ||
                    (d == 2 && map[nx][ny] == 'D') ||
                    (d == 3 && map[nx][ny] == 'U')) {
                    bfsCheck[nx][ny] = true;
                    visit[nx][ny] = true;
                    dq.add(new Node(nx, ny));
                }
            }
        }
    }
}
