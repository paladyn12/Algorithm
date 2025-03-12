import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 번호:
 * 문제 이름:
 * 풀이:
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][K + 1];
        Arrays.fill(dp[0], 1);
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {

                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
            }
        }

        System.out.println(dp[N][K]);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}