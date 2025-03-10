package BAEKJOON.다이나믹프로그래밍;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 번호: 9465
 * 문제 이름: 스티커
 * 풀이: dp[i][0..2]를 i번째 까지의 스티커 총 합으로 하여
 * dp[i][0]는 i번째에 스티커를 붙이지 않은 경우
 * dp[i][1]는 i번째에 아래 스티커를 붙이는 경우
 * dp[i][2]는 i번째에 위 스티커를 붙이는 경우로 하여 적절한 값을 더해나감
 */
class Q9465_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (test_case-- > 0) {

            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                sticker[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                sticker[1][i] = Integer.parseInt(st.nextToken());
            }
            int[][] dp = new int[N][3];
            dp[0][0] = 0;
            dp[0][1] = sticker[1][0];
            dp[0][2] = sticker[0][0];
            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + sticker[1][i];
                dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + sticker[0][i];
            }

            sb.append(Arrays.stream(dp[N-1]).max().getAsInt()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}