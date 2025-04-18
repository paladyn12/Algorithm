package GOORM.기초시뮬레이션;

import java.io.*;
import java.util.*;

class 빵야 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N과 H의 값(Hs[]) 입력
		int N = Integer.parseInt(br.readLine());
		int[] Hs = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Hs[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0; // 0, 1, 2, 3, 0, ...
		long result = 0;

		// 메인 로직
		for (int i = 0; i < N; i++) {

			// 먼저 Hs[i]가 10보다 크면 10으로 나눔
			// 10은 4번의 반복 결과 이므로 나눈 값 * 4를 더함
			if (Hs[i] > 10) {
				int temp = Hs[i] / 10;
				result += temp * 4;
				Hs[i] %= 10;
			}
			while (Hs[i] > 0) {
				Hs[i] -= count + 1;
				count = (count + 1) % 4;
				result++;
			}
		}
		System.out.print(result);
	}
}