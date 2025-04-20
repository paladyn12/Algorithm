package GOORM.기초알고리즘챌린지;

import java.io.*;
import java.util.*;
class 구름RPG1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] isPrime = new boolean[1000001];
		Arrays.fill(isPrime, true);
		for (int i = 2; i <= 1000; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= 100000; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			int A = Integer.parseInt(br.readLine());
			if (isPrime[A]) sb.append("Yes\n");
			else sb.append("No\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}