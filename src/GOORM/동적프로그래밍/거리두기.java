package GOORM.동적프로그래밍;

import java.io.*;

/**
 * Nx3 테이블에서 상하좌우로 인접하지 않도록 선택하는 경우의 수
 * 테이블의 각 줄에선 {선택 X, 왼쪽 선택, 가운데 선택, 오른쪽 선택, 양쪽 선택} 의 5가지 선택지가 있음
 * dp[i][0..4] : i 번째 줄의 경우의 수
 * - dp[i][0] : i 번째 줄에 아무것도 선택하지 않는 경우
 *  >> dp[i-1]의 모든 경우를 더함
 * - dp[i][1] : i 번째 줄에 왼쪽을 하나 선택하는 경우
 *  >> 이전 줄 (dp[i-1]) 에서 왼쪽, 양쪽을 선택한 경우는 제외
 * - dp[i][2] : i 번째 줄에 가운데 하나를 선택하는 경우
 *  >> 이전 줄 (dp[i-1]) 에서 가운데를 선택한 경우는 제외
 * - dp[i][3] : i 번째 줄에 오른쪽 하나를 선택하는 경우
 *  >> 이전 줄 (dp[i-1]) 에서 오른쪽, 양쪽을 선택한 경우는 제외
 * - dp[i][4] : i 번째 줄에 양쪽을 선택한 경우
 *  >> 이전 줄 (dp[i-1]) 에서 왼쪽, 오른쪽, 양쪽을 선택한 경우는 제외
 */

class 거리두기 {

    // 결과를 나눌 나머지
    static int div = 100000007;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [][] dp = new long[N + 1][5];
        dp[1] = new long[]{1, 1, 1, 1, 1};

        long result = 0;

        // N == 1 인 경우 예외 처리
        if (N == 1) {
            result = 5L;
        } else {
            for (int i = 2; i <= N; i++) {
                // 이전 줄의 모든 경우를 더함
                dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2] + dp[i-1][3] + dp[i-1][4]) % div;
                // 이전 줄에서 왼쪽, 양쪽 선택한 경우 제외
                dp[i][1] = (dp[i-1][0] + dp[i-1][2] + dp[i-1][3]) % div;
                // 이전 줄에서 가운데 선택한 경우 제외
                dp[i][2] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][3] + dp[i-1][4]) % div;
                // 이전 줄에서 오른쪽, 양쪽 선택한 경우 제외
                dp[i][3] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % div;
                // 이전 줄에서 왼쪽, 오른쪽, 양쪽 선택한 경우 제외
                dp[i][4] = (dp[i-1][0] + dp[i-1][2]) % div;
            }

            for (int i = 0; i < 5; i++) {
                result += dp[N][i];
            }
            result %= div;
        }

        // 결과 출력
        System.out.print(result);
    }
}