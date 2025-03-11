package BAEKJOON.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 13398
 * 문제 이름: 연속합 2
 * 풀이: dp[i]를 i번째 수 까지의 최대 연속합을 저장하는 배열로 하고
 *  * dp[i][0]는 i번째 수 까지 빠진 수 없이 연속합을 구한 경우,
 *  * dp[i][1]는 i번째 수 까지 어떠한 수 하나가 빠진 상황에 연속합을 구한 경우로 하여 최대값 반환
 */
class Q13398_다이나믹프로그래밍 {
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

        int[][] dp = new int[2][N];
        dp[0][0] = array[0];
        dp[1][0] = array[0];

        for (int i = 1; i < N; i++) {
            dp[0][i] = Math.max(dp[0][i-1] + array[i], array[i]);
            dp[1][i] = Math.max(dp[1][i-1] + array[i], dp[0][i-1]);

        }

        int max = Integer.MIN_VALUE;
        for (int[] ints : dp) {
            for (int anInt : ints) {
                max = Math.max(max, anInt);
            }
        }

        System.out.println(max);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}