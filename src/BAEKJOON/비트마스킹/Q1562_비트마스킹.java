import java.io.*;
import java.util.*;

public class Q1562_비트마스킹 {

    static final int mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[N + 1][10][1024];

        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                int before_down = j - 1;
                if (before_down >= 0) {
                    for (int k = 0; k < 1024; k++) {
                        if (dp[i - 1][before_down][k] != 0) {
                            dp[i][j][k | (1 << j)] += dp[i - 1][before_down][k];
                            dp[i][j][k | (1 << j)] %= mod;
                        }
                    }
                }
                int before_up = j + 1;
                if (before_up <= 9) {
                    for (int k = 1; k < 1024; k++) {
                        if (dp[i - 1][before_up][k] != 0) {
                            dp[i][j][k | (1 << j)] += dp[i - 1][before_up][k];
                            dp[i][j][k | (1 << j)] %= mod;
                        }
                    }
                }
            }
        }
      
        int ans = 0;
        for (int j = 0; j <= 9; j++) {
            ans += dp[N][j][1023];
            ans %= mod;
        }
        System.out.print(ans);
    }
}
