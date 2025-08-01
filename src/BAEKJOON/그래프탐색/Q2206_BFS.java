import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    int cnt;
    boolean destroyed;
    public Point(int x, int y, int cnt, boolean destroyed) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.destroyed = destroyed;
    }
}

class Q2206_BFS {

    static int result;
    static boolean[][][] visit;
    static int N;
    static int M;
    static int[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        result = N * M + 1;
        
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();
        
        if (result == N * M + 1) System.out.print(-1);
        else System.out.print(result);
    }

    static void bfs() {
        visit = new boolean[N][M][2];
        ArrayDeque<Point> dq = new ArrayDeque<>();
        dq.addLast(new Point(0, 0, 1, false));
        visit[0][0][0] = true;

        while (!dq.isEmpty()) {
            
            Point cur = dq.pollFirst();

            if (cur.x == N - 1 && cur.y == M - 1) {
                result = cur.cnt;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (cur.destroyed) {
                    if (map[nx][ny] == 0 && !visit[nx][ny][1]) {
                        visit[nx][ny][1] = true;
                        dq.addLast(new Point(nx, ny, cur.cnt + 1, true));
                    }
                } else {
                    if (map[nx][ny] == 1) {
                        visit[nx][ny][1] = true;
                        dq.addLast(new Point(nx, ny, cur.cnt + 1, true));
                    } else if (!visit[nx][ny][0]) {
                        visit[nx][ny][0] = true;
                        dq.addLast(new Point(nx, ny ,cur.cnt + 1, false));
                    }
                }
            }
        }

    }
}
