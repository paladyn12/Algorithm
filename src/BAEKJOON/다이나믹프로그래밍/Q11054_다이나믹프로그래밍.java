package BAEKJOON.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 11054
 * 문제 이름: 가장 긴 바이토닉 부분 수열
 * 풀이: 증가하는 부분 수열과 감소하는 부분 수열을 따로 구해 합을 계산
 */
class Q11054_다이나믹프로그래밍 {
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

        int[][] dp = new int[N][2];
        dp[0][0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i][0] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (array[i] > array[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                }
            }
        }

        dp[N-1][1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            dp[i][1] = 1;

            for (int j = i + 1; j < N; j++) {
                if (array[i] > array[j]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int[] ints : dp) {
            max = Math.max(max, ints[0] + ints[1] - 1);
        }

        System.out.println(max);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}