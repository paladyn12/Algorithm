package BAEKJOON.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 17404
 * 문제 이름: RGB거리 2
 * 풀이: 처음 칠하는 색상 대해 마지막 집을 다른 색으로 칠한 경우의 최소를 구함
 */
class Q17404_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        int[][] price = new int[N+1][3];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
            price[i][2] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N+1][3];
        int max = 1000 * 1000;
        int answer = 1000 * 1000;
        for (int color = 0; color < 3; color++) {

            for (int i = 0; i < 3; i++) {
                if (i == color) dp[1][i] = price[1][i];
                else dp[1][i] = max;
            }

            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + price[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + price[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + price[i][2];
            }

            for (int i = 0; i < 3; i++) {
                if (i != color) {
                    answer = Math.min(answer, dp[N][i]);
                }
            }
        }

        System.out.println(answer);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}