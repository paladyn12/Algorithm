import java.util.*;
import java.io.*;

class Q2448_재귀 {

    static char[][] chars;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        chars = new char[N + 1][N * 2 + 1];
        recursion(N, N, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N * 2; j++) {
                if (chars[i][j] == '*') sb.append(chars[i][j]);
                else sb.append(' ');
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void recursion(int x, int y, int depth) {
        if (depth == 3) {
            chars[x - 2][y] = '*';
            chars[x - 1][y - 1] = '*';
            chars[x - 1][y + 1] = '*';
            chars[x][y - 2] = '*';
            chars[x][y - 1] = '*';
            chars[x][y] = '*';
            chars[x][y + 1] = '*';
            chars[x][y + 2] = '*';
            return;
        }

        recursion(x - depth / 2, y, depth / 2);
        recursion(x, y - depth / 2, depth / 2);
        recursion(x, y + depth / 2, depth / 2);
    }
}
