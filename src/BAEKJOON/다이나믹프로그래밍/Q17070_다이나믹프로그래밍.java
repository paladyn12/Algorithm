import java.util.*;
import java.io.*;

class Q17070_다이나믹프로그래밍 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N][N][3];
        dp[0][1][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (house[i][j] == 1) continue;
                if (j - 1 >= 0) {
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                }
                if (i - 1 >= 0) {
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                    if (house[i-1][j-1] == 1 || house[i-1][j] == 1 || house[i][j-1] == 1) dp[i][j][2] = 0;
                }
            }
        }
        
        System.out.print(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);        
    }
}
