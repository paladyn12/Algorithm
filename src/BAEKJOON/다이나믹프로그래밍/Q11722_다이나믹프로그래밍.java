package BAEKJOON.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 11722
 * 문제 이름: 가장 긴 감소하는 부분 수열
 * 풀이: dp[i]를 i번째 수를 기준으로 가장 긴 감소하는 부분 수열의 길이로 하여 계산해나감
 */
class Q11722_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (array[i] < array[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            max = Math.max(max, i);
        }

        System.out.println(max);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}