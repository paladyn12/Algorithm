package BAEKJOON.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 번호: 2193
 * 문제 이름: 이친수
 * 풀이: 이 전 자리수가 0으로 끝났으면 1과 0 모두 가능
 * 이 전 자리수가 1로 끝났으면 0만 가능
 */
class Q2193_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][2];
        dp[1] = new long[]{0, 1};
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }
        System.out.println(dp[N][0] + dp[N][1]);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}