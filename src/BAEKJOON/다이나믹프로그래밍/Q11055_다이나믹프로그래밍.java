package BAEKJOON.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 11055
 * 문제 이름: 가장 큰 증가하는 부분 수열
 * 풀이: dp[i]를 i번째 수 기준으로 증가하는 부분 수열의 최대 합으로 하고
 * dp[0..N-1] 중 가장 큰 수를 반환
 */
class Q11055_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = array[0];

        for (int i = 1; i < N; i++) {
            dp[i] = array[i];

            for (int j = i - 1; j >= 0; j--) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + array[i]);
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