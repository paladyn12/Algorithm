import java.io.*;
import java.util.*;

public class Q1953 {

    static int N;
    static int M;
    static int L;
    static int[][] map;
    static int[][] arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            arrive = new int[N][M];
            for (int i = 0; i < N; i++) Arrays.fill(arrive[i], Integer.MAX_VALUE);
            dfs(R, C, 1);

            int ans = 0;
            for (int i = 0; i < N; i++) for (int flag : arrive[i]) if (flag <= L) ans++;
            
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        
        System.out.print(sb);
    }

    static void dfs(int x, int y, int time) {
        arrive[x][y] = time;
        if (time == L) {
            return;
        }

        int type = map[x][y];
        switch (type) {
            case 1:
                if (check(x, y, 0)) dfs(x - 1, y, time + 1);
                if (check(x, y, 1)) dfs(x, y + 1, time + 1);
                if (check(x, y, 2)) dfs(x + 1, y, time + 1);
                if (check(x, y, 3)) dfs(x, y - 1, time + 1);
                break;
            case 2:
                if (check(x, y, 0)) dfs(x - 1, y, time + 1);
                if (check(x, y, 2)) dfs(x + 1, y, time + 1);
                break;
            case 3:
                if (check(x, y, 1)) dfs(x, y + 1, time + 1);
                if (check(x, y, 3)) dfs(x, y - 1, time + 1);
                break;
            case 4:
                if (check(x, y, 0)) dfs(x - 1, y, time + 1);
                if (check(x, y, 1)) dfs(x, y + 1, time + 1);
                break;
            case 5:
                if (check(x, y, 1)) dfs(x, y + 1, time + 1);
                if (check(x, y, 2)) dfs(x + 1, y, time + 1);
                break;
            case 6:
                if (check(x, y, 2)) dfs(x + 1, y, time + 1);
                if (check(x, y, 3)) dfs(x, y - 1, time + 1);
                break;
            case 7:
                if (check(x, y, 0)) dfs(x - 1, y, time + 1);
                if (check(x, y, 3)) dfs(x, y - 1, time + 1);
                break;
        }
        
    }

    static boolean check(int x, int y, int dir) {
        switch (dir) {
            case 0:
                if (x - 1 < 0) return false;
                if (arrive[x - 1][y] <= arrive[x][y] + 1) return false;
                if (map[x - 1][y] == 1 || map[x - 1][y] == 2 || map[x - 1][y] == 5 || map[x - 1][y] == 6) return true;
                else return false;
            case 1:
                if (y + 1 >= M) return false;
                if (arrive[x][y + 1] <= arrive[x][y] + 1) return false;
                if (map[x][y + 1] == 1 || map[x][y + 1] == 3 || map[x][y + 1] == 6 || map[x][y + 1] == 7) return true;
                else return false;
            case 2:
                if (x + 1 >= N) return false;
                if (arrive[x + 1][y] <= arrive[x][y] + 1) return false;
                if (map[x + 1][y] == 1 || map[x + 1][y] == 2 || map[x + 1][y] == 4 || map[x + 1][y] == 7) return true;
                else return false;
            case 3:
                if (y - 1 < 0) return false;
                if (arrive[x][y - 1] <= arrive[x][y] + 1) return false;
                if (map[x][y - 1] == 1 || map[x][y - 1] == 3 || map[x][y - 1] == 4 || map[x][y - 1] == 5) return true;
                else return false;
        }
        return true;
    }
}
