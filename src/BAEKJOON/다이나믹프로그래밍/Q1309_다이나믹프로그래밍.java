package BAEKJOON.다이나믹프로그래밍;

import java.io.*;

/**
 * 문제 번호: 1309
 * 문제 이름: 동물원
 * 풀이: dp[i][0..2]를 i번째 우리까지 사자를 배치하는 경우의 수로 하고
 * dp[i][0]는 i번째 우리에 사자를 배치하지 않는 경우
 * dp[i][1]는 i번째 우리에 사자를 왼쪽에 배치하는 경우
 * dp[i][2]는 i번째 우리에 사자를 오른쪽에 배치하는 경우로 하여 dp를 적절히 구해나감
 */
class Q1309_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3];
        dp[1] = new int[]{1,1,1};
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 9901);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}