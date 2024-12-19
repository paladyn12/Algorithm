package BAEKJOON.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 번호: 11727
 * 문제 이름: 2×n 타일링 2
 * 풀이: 2×n 타일링 문제와 유사하나 2칸을 채우는 경우가 2가지이므로 dp[i-2]를 더할 때 2배해서 더함
 */
class Q11727_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        int[] dp;
        if (N == 1) dp = new int[N+2];
        else dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
        }

        System.out.println(dp[N]);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}
