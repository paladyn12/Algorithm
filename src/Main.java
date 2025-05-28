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

        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long[] dp = new long[1000001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1000000009;
        }

        while (test_case-- > 0) {

            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }

}