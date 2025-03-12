package BAEKJOON.다이나믹프로그래밍;

import java.io.*;

/**
 * 문제 번호: 2133
 * 문제 이름: 타일 채우기
 * 풀이: 마지막 타일을 배치하는 경우가 三, ㄱ, ㅢ 모양의 3 경우인 것을 감안해
 * 三 모양일 때는 dp[i-2]
 * ㄱ이나 ㅢ 모양일 땐 dp[i-2]+dp[i-4]+...를 반복하면 된다.
 */
class Q2133_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        int[] dp;
        if (N <= 3) dp = new int[4];
        else dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;
        dp[3] = 0;
        for (int i = 4; i <= N; i+=2) {
            dp[i] = dp[i-2];
            for (int j = 2; j <= i; j++) {
                dp[i] += 2 * dp[i-j];
            }
        }

        System.out.println(dp[N]);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}