package GOORM.기초시뮬레이션;

import java.io.*;
import java.util.*;

class 나무꾼구름이 {

	static int N; // 나무의 수
	static int M; // 벌목 가능한 나무 높이
	static int x; // 현재 위치
	static int[] trees; // 각 나무의 높이
	static long sum = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N, M, x 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken()) - 1;

		// trees 입력
		trees = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}

		// L, R, S 입력
		int Q = Integer.parseInt(br.readLine());
		char[] LSR = new char[Q];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			LSR[i] = st.nextToken().charAt(0);
		}

		// 메인 로직
		for (char c : LSR) {
			cut();
			logic(c);
			grow();
		}
		System.out.print(sum);
	}
	
	static void cut() {
		if (M <= trees[x]) {
			sum += trees[x];
			trees[x] = 0;
		}
	}
	static void logic(char c) {
		switch (c) {
			case 'L':
				x = (N + x - 1) % N;
				break;
			case 'R':
				x = (x + 1) % N;
				break;
			case 'S':
				x = x;
				break;
		}
	}
	static void grow() {
		for (int i = 0; i < N; i++) {
			trees[i]++;
		}
	}
}