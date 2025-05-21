package GOORM.동적프로그래밍;

import java.io.*;
import java.util.*;

/**
 * 휴식 칸을 거치지 않고 N, M 칸에 도달할 수 있는 경우의 수를 찾는 문제
 * dp[i][j] : (i, j) 칸에 도달할 수 있는 경우의 수
 *  - dp[i][j] = dp[i-1][j] + dp[i-2][j] + ... + dp[i-6][j]
 *             + dp[i][j-1] + dp[i][j-2] + ... + dp[i][j-6]
 *  - rest[i][j] == true 이면 dp[i][j] = 0 으로 초기화
 * dp[N][M] 출력
 */

class 주사위여행 {

	static int N;
	static int M;
	static long[][] dp;
	static boolean[][] rest;
	static int div = (int) Math.pow(10, 9) + 7;
	
	public static void main(String[] args) throws Exception {

		// 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 휴식 칸 : true
		rest = new boolean[N+1][M+1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			rest[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		}

		// dp[1][1] 부터 값을 채우기 시작
		dp = new long[N+1][M+1];
		dp[1][1] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {

				// (1, 1) 칸은 pass
				if (i + j == 2) continue;

				// 휴식하는 칸이면 0으로 초기화
				if (rest[i][j]) dp[i][j] = 0;
				else {

					// 해당 칸에서 가로 세로로 1~6칸 이전의 dp 값을 더함
					dp[i][j] = (sumR(i, j) + sumC(i, j)) % div;
				}
			}
		}

		// 결과 출력
		System.out.print(dp[N][M]);
	}

	// 행을 기준으로 1~6 칸 이전의 dp 값 더하기
	static long sumR(int r, int c) {
		long sum = 0;
		for (int i = 1; i <= 6; i++) {
			if (c - i == 0) break;
			if (rest[r][c - i]) continue;
			sum += dp[r][c - i];
		}
		return sum;
	}

	// 열을 기준으로 1~6 칸 이전의 dp 값 더하기
	static long sumC(int r, int c) {
		long sum = 0;
		for (int i = 1; i <= 6; i++) {
			if (r - i == 0) break;
			if (rest[r - i][c]) continue;
			sum += dp[r - i][c];
		}
		return sum;
	}
}