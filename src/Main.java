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

        int test_case = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int N;
        int M;
        StringBuilder sb = new StringBuilder();
        while (test_case-- > 0) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            long[][] dp = new long[M+1][M+1];

            for (int i = 0; i <= M; i++) {
                dp[i][0] = 1;
                dp[i][i] = 1;
            }
            for (int i = 2; i <= M; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }

            sb.append(dp[M][N]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

}