import java.util.*;
import java.io.*;

class Q7579_KnapSack {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] m = new int[N + 1];
        int[] c = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][10001];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 10000; j++) {
                if (j < c[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i]] + m[i]);
                }
                if (dp[i][j] >= M) ans = Math.min(ans, j);
            }
        }

        System.out.print(ans);
    }
}
