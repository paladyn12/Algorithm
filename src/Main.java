import java.io.*;
import java.util.*;

/**
 * 문제 번호:
 * 문제 이름:
 * 풀이 :
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        int[][] price = new int[N + 1][3];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
            price[i][2] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N + 1][3];
        dp[1] = new int[]{price[1][0], price[1][1], price[1][2]};
        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + price[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + price[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + price[i][2];
        }

        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}