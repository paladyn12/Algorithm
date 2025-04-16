package GOORM.기초시뮬레이션;

import java.io.*;
import java.util.*;

class 빵야 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] Hs = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Hs[i] = Integer.parseInt(st.nextToken());
		}
		
		long result = 0;
		int count = 0;
		for (int i = 0; i < N; i++) {
			while (count > 0 && Hs[i] > 0) {
				Hs[i] -= count + 1;
				count = (count + 1) % 4;
				result++;
			}
			if (Hs[i] <= 0) continue;
			if (Hs[i] > 10) {
				result += (Hs[i]/10) * 4;
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