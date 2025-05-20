package GOORM.동적프로그래밍;

import java.io.*;

/**
 * 동적 프로그래밍으로 피보나치 수열을 구하는 문제
 * dp[i] = (dp[i-1] + dp[i-2]) % div
 */

class 피보나치수열 {

    static int div = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % div;
        }
        System.out.print(dp[N]);
    }
}