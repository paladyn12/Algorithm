package BAEKJOON.다이나믹프로그래밍;

import java.io.*;

/**
 * 문제 번호: 15990
 * 문제 이름: 1, 2, 3 카드 더하기 5
 * 풀이
 * 각 숫자 n에 대한 경우의 수는
 * n-1의 경우의 수 중 마지막이 2, 3인 경우에 + 1
 * n-2의 경우의 수 중 마지막이 1, 3인 경우에 + 2
 * n-3의 경우의 수 중 마지막이 1, 2인 경우에 + 3
 */
class Q15990_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long[][] dp = new long[100001][3];
        dp[1] = new long[]{1, 0, 0};
        dp[2] = new long[]{0, 1, 0};
        dp[3] = new long[]{1, 1, 1};
        for (int i = 4; i <= 100000; i++) {
            dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % 1000000009;
            dp[i][1] = (dp[i-2][0] + dp[i-2][2]) % 1000000009;
            dp[i][2] = (dp[i-3][0] + dp[i-3][1]) % 1000000009;
        }

        while (test_case-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append((dp[n][0] + dp[n][1] + dp[n][2]) % 1000000009).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}
