package BAEKJOON.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 번호: 10844
 * 문제 이름: 쉬운 계단 수
 * 풀이: dp[i][j]에서 i는 길이, j는 마지막 계단
 * dp[i][j]는 이전 길이의 j+1, j-1 경우의 수를 합한 것 (4는 이전 단계에서 3인 경우와 5인 경우를 합한 것)
 * 이 때 0은 1에서만, 9는 8에서만 갈 수 있으므로 따로 처리
 */
class Q10844_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        long[][] dp = new long[101][10];
        dp[1] = new long[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int MOD = 1000000000;
        int n = Integer.parseInt(br.readLine());
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % MOD;
            dp[i][3] = (dp[i-1][2] + dp[i-1][4]) % MOD;
            dp[i][4] = (dp[i-1][3] + dp[i-1][5]) % MOD;
            dp[i][5] = (dp[i-1][4] + dp[i-1][6]) % MOD;
            dp[i][6] = (dp[i-1][5] + dp[i-1][7]) % MOD;
            dp[i][7] = (dp[i-1][6] + dp[i-1][8]) % MOD;
            dp[i][8] = (dp[i-1][7] + dp[i-1][9]) % MOD;
            dp[i][9] = dp[i-1][8];
        }

        long sum = 0;
        for (long l : dp[n]) {
            sum += l;
        }

        System.out.println(sum % 1000000000);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}