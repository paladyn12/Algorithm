import java.util.*;
import java.io.*;

class Main {

    static int[] dx = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
    static boolean[][] star;
    
    public static void Q2447(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int k = 0;
        for (int i = 1; i < N; i *= 3) {
            k++;
        }

        star = new boolean[N][N];
        recursion(N/2, N/2, k);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (star[i][j]) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void recursion(int x, int y, int k) {
        if (k == 1) {
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                star[nx][ny] = true;
            }
        } else {
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i] * (int) Math.pow(3, k - 1);
                int ny = y + dy[i] * (int) Math.pow(3, k - 1);
                recursion(nx, ny, k - 1);
            }
        }
    }
}