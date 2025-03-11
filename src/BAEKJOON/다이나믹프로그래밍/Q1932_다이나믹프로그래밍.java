package BAEKJOON.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 1932
 * 문제 이름: 정수 삼각형
 * 풀이: dp[i][j]를 i번째 층의 j번째 수의 최대 합으로 dp[i-1][j-1]과 dp[i-1][j]를 비교해 더 큰 값을 구해나감
 */
class Q1932_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i : dp[n-1]) {
            max = Math.max(i, max);
        }
        System.out.println(max);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}