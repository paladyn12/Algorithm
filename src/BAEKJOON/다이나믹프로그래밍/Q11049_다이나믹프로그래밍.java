import java.io.*;
import java.util.*;

public class Q11049_다이나믹프로그래밍 {

    static class Matrix {
        int a;
        int b;
        public Matrix(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Matrix[] matrices = new Matrix[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrices[i] = new Matrix(a, b);
        }
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) dp[i][j] = 0;
                else dp[i][j] = Integer.MAX_VALUE;
            }
        }

       for (int len = 1; len < N; len++) { // len: 구간 길이
            for (int i = 0; i + len < N; i++) {
                int j = i + len;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                        dp[i][k] + dp[k + 1][j] + matrices[i].a * matrices[k].b * matrices[j].b);
                }
            }
        }


        System.out.print(dp[0][N - 1]);
    }
}
