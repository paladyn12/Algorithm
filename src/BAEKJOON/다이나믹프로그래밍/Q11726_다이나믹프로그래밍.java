package BAEKJOON.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 번호: 11726
 * 문제 이름: 2×n 타일링
 * 풀이: 타일의 남은 길이를 N이라 했을 때
 * N이 1, 2 일 때 각각 가능한 타일의 가짓수는 1, 2 가지
 * N이 3 이상일 때 가능한 경우의 수는 세로로 깐 뒤 N-1의 경우의 수 + 가로로 깐 뒤 N-2의 경우의 수
 */
class Q11726_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        int[] dp;
        if (N == 1) dp = new int[N+2];
        else dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }

        System.out.println(dp[N]);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}