package BAEKJOON.다이나믹프로그래밍;

import java.io.*;

/**
 * 문제 번호: 2839
 * 문제 이름: 설탕 배달
 * 풀이: dp[3], dp[5]를 1로 초기화하여 dp[i-3], dp[i-5] 중 더 작은 값에 1을 더해나감
 * dp[i-3], dp[i-5] 모두 0이면 3과 5로 만들 수 없는 수이므로 0으로 초기화
 */
class Q2839_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[Math.max(N + 1, 6)];
        dp[3] = 1;
        dp[5] = 1;
        for (int i = 6; i <= N; i++) {
            if (dp[i-3] != 0 && dp[i-5] != 0) {
                dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
            }
            else if (dp[i-3] != 0) dp[i] = dp[i-3] + 1;
            else if (dp[i-5] != 0) dp[i] = dp[i-5] + 1;
            else dp[i] = 0;
        }
        if (dp[N] == 0) System.out.println(-1);
        else System.out.println(dp[N]);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}