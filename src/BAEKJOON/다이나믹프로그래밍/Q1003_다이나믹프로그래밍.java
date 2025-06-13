package BAEKJOON.다이나믹프로그래밍;

import java.io.*;

/**
 * 문제 번호: 1003
 * 문제 이름: 피보나치 함수
 * 풀이 : dp로 0 ~ 40 까지 0과 1의 빈도를 구하고 입력값에 대한 개수를 출력
 */

class Q1003_다이나믹프로그래밍 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringBuilder sb = new StringBuilder();

        long[][] dp = new long[41][2];
        dp[0] = new long[]{1, 0};
        dp[1] = new long[]{0, 1};
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        int test_case = Integer.parseInt(br.readLine());
        while (test_case-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}