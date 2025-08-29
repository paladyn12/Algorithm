import java.io.*;
import java.util.*;

class Q4014 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] ground;
    static int N;
    static int X;

    static boolean[] horizontal;
    static boolean[] vertical;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            ground = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    ground[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            horizontal = new boolean[N];
            vertical = new boolean[N];

            int ans = 0;
            for (int i = 0; i < N; i++) {
                if(check_horizontal(i)) ans++;
                if(check_vertical(i)) ans++;
            }

            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static boolean check_vertical(int y) {

        boolean[][] visit = new boolean[N][N];
        // 아래 탐색
        int curX = 0;
        while (curX < N - 1) {
            int nx = curX + 1;

            if (ground[nx][y] - ground[curX][y] >= 2) return false;
            if (ground[nx][y] == ground[curX][y]) {
                curX++;
            } else if (ground[nx][y] == ground[curX][y] - 1) {
                if (!place(curX, y, 2, visit)) {
                    return false;
                } else {
                    curX += X;
                }
            } else {
                if (!place(nx, y, 0, visit)) {
                    return false;
                } else {
                    curX++;
                }
            }
        }
        return true;
    }
    
    static boolean check_horizontal(int x) {

        boolean[][] visit = new boolean[N][N];
        // 오른쪽 탐색
        int curY = 0;
        while (curY < N - 1) {
            int ny = curY + 1;

            if (ground[x][ny] - ground[x][curY] >= 2) return false;
            if (ground[x][ny] == ground[x][curY]) {
                curY++;
            } else if (ground[x][ny] == ground[x][curY] - 1) {
                if (!place(x, curY, 1, visit)) {
                    return false;
                } else {
                    curY += X;
                }
            } else {
                if (!place(x, ny, 3, visit)) {
                    return false;
                } else {
                    curY++;
                }
            }
        }
        return true;
    }

    static boolean place(int x, int y, int dir, boolean[][] visit) {
        for (int i = 1; i <= X; i++) {
            int nx = x + dx[dir] * i;
            int ny = y + dy[dir] * i;
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) return false;
            if (ground[nx][ny] != ground[x][y] - 1 || visit[nx][ny]) return false;
        }
        for (int i = 1; i <= X; i++) {
            visit[x + dx[dir] * i][y + dy[dir] * i] = true;
        }
        return true;
    }
}
