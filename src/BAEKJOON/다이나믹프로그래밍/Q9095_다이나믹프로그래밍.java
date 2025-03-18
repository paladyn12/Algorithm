package BAEKJOON.다이나믹프로그래밍;

import java.io.*;

/**
 * 문제 번호: 9095
 * 문제 이름: 1, 2, 3 더하기
 * 풀이: 1, 2, 3을 더하는 경우는 각각 1번째, 2번째, 3번째 전의 경우의 수에서 수를 더하는 것이므로 각 경우의 수를 더해 값을 구함
 */
class Q9095_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (test_case-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] dp;
            if (N <= 3) dp = new int[4];
            else dp = new int[N + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int i = 4; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
            sb.append(dp[N]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}
