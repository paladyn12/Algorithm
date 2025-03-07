import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 2225
 * 문제 이름: 합분해
 * 풀이: 점화식 dp[N][K] = dp[N][K-1] + dp[N-1][K]
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= K; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= N; i++) {

            for (int j = 2; j <= K; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
            }
        }

        System.out.println(dp[N][K]);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}