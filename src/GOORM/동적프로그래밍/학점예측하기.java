package GOORM.동적프로그래밍;

import java.io.*;

class 학점예측하기 {

    static int mod = 1_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[N + 1][2][3];

        // 초기 조건 설정
        dp[1][0][0] = 1; // a
        dp[1][1][0] = 1; // b
        dp[1][0][1] = 1; // c

        for (int i = 2; i <= N; i++) {
            // a를 선택하는 경우
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][k]) % mod;
                }
            }

            // b를 선택하는 경우 (아직 b를 사용하지 않은 경우에만)
            for (int k = 0; k < 3; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][k]) % mod;
            }

            // c를 선택하는 경우
            for (int j = 0; j < 2; j++) {
                dp[i][j][1] = (dp[i][j][1] + dp[i-1][j][0]) % mod;
                dp[i][j][2] = (dp[i][j][2] + dp[i-1][j][1]) % mod;
            }
        }

        int result = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                result = (result + dp[N][j][k]) % mod;
            }
        }

        System.out.print(result);
    }
}