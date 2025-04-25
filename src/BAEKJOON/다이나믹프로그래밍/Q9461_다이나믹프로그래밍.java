package BAEKJOON.다이나믹프로그래밍;

import java.io.*;

/**
 * 문제 번호: 9461
 * 문제 이름: 파도반 수열
 * 풀이: dp[i] = dp[i-1] + dp[i-5]
 */
class Q9461_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i-1] + dp[i-5];
        }

        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (test_case-- > 0) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}