package BAEKJOON.다이나믹프로그래밍;

import java.io.*;

/**
 * 문제 번호: 2156
 * 문제 이름: 포도주 시식
 * 풀이: dp[i][0..2]를 i번째 포도주까지 갔을 때의 최대치를 담는 배열로 만들고
 * dp[i][0]는 i번째 포도주를 마시지 않았을 때
 * dp[i][1]는 i번째 포도주를 마시고 그 것이 연속으로 마신 포도주의 첫 번째 였을 때
 * dp[i][2]는 i번째 포도주를 마시고 그 것이 연속으로 마신 포도주의 두 번째 였을 때로 하여 dp를 구해나감
 */
class Q2156_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        int[] grape = new int[N+1];
        for (int i = 1; i <= N; i++) {
            grape[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N+1][3];
        dp[1] = new int[]{0, grape[1], 0};
        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.max(dp[i-1][2], Math.max(dp[i-1][0], dp[i-1][1]));
            dp[i][1] = dp[i-1][0] + grape[i];
            dp[i][2] = dp[i-1][1] + grape[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i : dp[N]) {
            max = Math.max(i, max);
        }
        System.out.println(max);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}