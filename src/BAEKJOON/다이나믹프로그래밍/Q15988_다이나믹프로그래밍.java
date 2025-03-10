package BAEKJOON.다이나믹프로그래밍;

import java.io.*;

/**
 * 문제 번호: 15988
 * 문제 이름: 1, 2, 3 더하기
 * 풀이: 정수 n을 1, 2, 3의 합으로 나타내는 경우의 수는
 * n-1을 나타내는 경우의 수 + n-2을 나타내는 경우의 수 + n-3을 나타내는 경우의 수
 */
class Q15988_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long[] dp = new long[1000001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1000000009;
        }

        while (test_case-- > 0) {

            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}