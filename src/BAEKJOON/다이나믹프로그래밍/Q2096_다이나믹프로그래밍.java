import java.util.*;
import java.io.*;

class Q2096_다이나믹프로그래밍 {
    
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N + 1][3];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxResult = 0;
        int minResult = Integer.MAX_VALUE;
        int[][][] dp = new int[N + 1][3][2];

        for (int i = 1; i <= N; i++) {
            dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][1][0]) + array[i][0];
            dp[i][1][0] = Math.max(dp[i-1][0][0], Math.max(dp[i-1][1][0], dp[i-1][2][0])) + array[i][1];
            dp[i][2][0] = Math.max(dp[i-1][1][0], dp[i-1][2][0]) + array[i][2];

            dp[i][0][1] = Math.min(dp[i-1][0][1], dp[i-1][1][1]) + array[i][0];
            dp[i][1][1] = Math.min(dp[i-1][0][1], Math.min(dp[i-1][1][1], dp[i-1][2][1])) + array[i][1];
            dp[i][2][1] = Math.min(dp[i-1][1][1], dp[i-1][2][1]) + array[i][2];
        }

        for (int i = 0; i < 3; i++) {
            maxResult = Math.max(maxResult, dp[N][i][0]);
            minResult = Math.min(minResult, dp[N][i][1]);
        }
        

        System.out.print(maxResult + " " + minResult);
    }
}
