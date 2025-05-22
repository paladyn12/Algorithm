package GOORM.동적프로그래밍;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * 구름이가 가진 구슬의 개수 별 경우의 수를 구해나가는 문제
 * 매 가위바위보 마다 승리, 무승부, 패배에 대해 dp 배열을 채움
 * - 승리
 *   dp[i][j+1] = dp[i][j+1] + dp[i-1][j]
 * - 무승부
 *   dp[i][j] = dp[i][j] + dp[i-1][j]
 * - 패배
 *   dp[i][j-1] = dp[i][j-1] + dp[i-1][j]
 * dp 배열을 순회하며 index가 0(구름이 패배) 인 경우와 N+M(구름이 승리) 인 경우를 모두 더하면 정답
 */

class 구슬게임 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // K번째 가위바위보 후 구름이의 구슬 개수 별 경우의 수
        BigInteger[][] dp = new BigInteger[K + 1][N + M + 1];

        // 배열 초기화
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N + M; j++) {
                dp[i][j] = BigInteger.ZERO;
            }
        }

        // 시작 시 구름이는 N개의 구슬을 가지고 있음
        dp[0][N] = BigInteger.ONE;

        // K번 가위바위보 반복
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j < N + M; j++) {
                // 구름이 패배 시 이전 단계의 구슬이 하나 많은 경우의 수를 더함
                dp[i][j - 1] = dp[i][j - 1].add(dp[i - 1][j]);
                // 무승부 시 이전 단계의 구슬이 현재와 같은 경우의 수를 더함
                dp[i][j] = dp[i][j].add(dp[i - 1][j]);
                // 구름이 승리 시 이전 단계의 구슬이 하나 적은 경우의 수를 더함
                dp[i][j + 1] = dp[i][j + 1].add(dp[i - 1][j]);
            }
        }
        BigInteger ans = BigInteger.ZERO;
        for (int i = 1; i <= K; i++) {
            // 매 가위바위보마다 구름이의 구슬 개수가 0개(패배)인 경우와 N+M개(승리) 한 경우를 더함
            ans = ans.add(dp[i][0]).add(dp[i][N + M]);
        }

        System.out.println(ans);
    }
}
