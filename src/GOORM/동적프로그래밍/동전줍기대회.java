package GOORM.동적프로그래밍;

import java.io.*;
import java.util.*;

/**
 * 연속된 동전을 줍는 최선의 경우의 수를 구하는 문제
 * dp[i] : i번째까지 동전을 주웠을 때의 최대 상금
       이 전 동전에 이어서 동전을 줍거나 처음으로 i번째 동전을 줍는 경우 중 최선을 선택
       dp[i] = Math.max(dp[i-1], 0) + C[i]
 */

class 동전줍기대회 {
    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] C = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            C[i] = Integer.parseInt(st.nextToken());
        }

        // dp 배열 채우기
        long[] dp = new long[N + 1];
        dp[1] = C[1];
        if (N >= 2) {
            for (int i = 2; i <= N; i++) {
                dp[i] = Math.max(dp[i-1], 0) + C[i];
            }
        }



        // dp 배열의 최대값이 음수이면 동전을 아예 줍지 않는 것이 최대 상금
        long result = 0;
        for (long l : dp) {
            result = Math.max(result, l);
        }
        System.out.print(result);
    }
}