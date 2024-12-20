package BAEKJOON.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 번호: 16194
 * 문제 이름: 카드 구매하기 2
 * 풀이: 카트 구매하기 문제의 최솟값 형태
 */
class Q16194_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        int[] pack = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            pack[i] = Integer.parseInt(st.nextToken());
            dp[i] = pack[i];
        }
        dp[0] = 0;
        dp[1] = pack[1];
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j] + pack[j]);
            }
        }

        System.out.println(dp[N]);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}
