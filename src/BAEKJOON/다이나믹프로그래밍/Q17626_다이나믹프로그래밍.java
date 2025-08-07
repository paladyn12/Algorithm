import java.util.*;
import java.io.*;

class Q17626_다이나믹프로그래밍 {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 10000000);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        System.out.print(dp[N]);
    }
}
