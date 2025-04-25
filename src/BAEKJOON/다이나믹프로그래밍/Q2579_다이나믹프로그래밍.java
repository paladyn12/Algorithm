package BAEKJOON.다이나믹프로그래밍;

import java.io.*;

/**
 * 문제 번호: 2579
 * 문제 이름: 계단 오르기
 * 풀이: dp를 이차원 배열로 설정하여 연속으로 계단을 오를 경우 두 번째 값에 넣음
 * 즉, dp[i][0]은 계단을 두 단계 올라 연속으로 계단을 오르지 않은 경우의 socre 합
 * dp[i][1]은 이전 계단으로부터 연속적으로 계단을 오른 경우의 score 합
 * dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) 를 계산해 현재 계단의 score를 더함
 * dp[i][1] = dp[i-1][0] 에 현재 계단의 score를 더함
 */
class Q2579_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[Math.max(N + 1, 3)];
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[Math.max(N + 1, 3)][2];
        dp[1][0] = score[1];
        dp[2][0] = score[2];
        dp[2][1] = score[1] + score[2];
        for (int i = 3; i <= N; i++) {
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + score[i];
            dp[i][1] = dp[i-1][0] + score[i];
        }

        System.out.println(Math.max(dp[N][0], dp[N][1]));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}