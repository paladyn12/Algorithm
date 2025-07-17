import java.util.*;
import java.io.*;

class Q12865_다이나믹프로그래밍 {

    static int N;
    static int K;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);
        int[][] stub = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            String[] WV = br.readLine().split(" ");
            stub[i][0] = Integer.parseInt(WV[0]);
            stub[i][1] = Integer.parseInt(WV[1]);
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            int weight = stub[i][0];
            int value = stub[i][1];
            for (int j = 1; j <= K; j++) {
                if (j < weight) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                }
            }
        }
        
        System.out.print(dp[N][K]);
    }
}