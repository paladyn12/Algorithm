package BAEKJOON.다이나믹프로그래밍;

import java.io.*;
import java.util.Arrays;

/**
 * 문제 번호: 11057
 * 문제 이름: 오르막 수
 * 풀이: dp[N][0..9]를 길이 N의 오르막 수가 0..9로 끝날 경우의 수라 하고
 * dp[i][j] 에는 dp[i-1][0..j]까지의 값을 더해 저장
 */
class Q11057_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];
        dp[1] = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int i = 2; i <= N; i++) {

            for (int j = 0; j < 10; j++) {

                for (int k = 0; k <= j; k++) {

                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }
        int sum = Arrays.stream(dp[N]).sum();
        System.out.println(sum % 10007);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}