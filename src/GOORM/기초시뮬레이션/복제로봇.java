package GOORM.기초시뮬레이션;

import java.io.*;
import java.util.*;

/**
 * 입력받은 좌표 x, y를 static 변수로 저장
 * 웅덩이가 있는 곳을 boolean water[][]배열에 true 값으로 저장
 * 입력이 -2000 부터 시작 되므로 배열 인덱스 접근을 위해 모든 좌표는 +2000, +2000 으로 관리
 */

class 복제로봇 {

	static boolean[][] water = new boolean[4001][4001];
	static int x;
	static int y;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 초기 좌표 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken()) + 2000;
		y = Integer.parseInt(st.nextToken()) + 2000;

		// 웅덩이가 있는 좌표 true
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int xi = Integer.parseInt(st.nextToken()) + 2000;
			int yi = Integer.parseInt(st.nextToken()) + 2000;
			water[yi][xi] = true;
		}

		// L, R, U, D 개수 입력
		int Q = Integer.parseInt(br.readLine());

		// 입력받은 L, R, U, D를 하나씩 순회하며 처리
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			char LRUD = st.nextToken().charAt(0);
			switch (LRUD) {
				case 'L':
					if (!water[y][x-1]) x -= 1;
					break;
				case 'R':
					if (!water[y][x+1]) x += 1;
					break;
				case 'U':
					if (!water[y+1][x]) y += 1;
					break;
				case 'D':
					if (!water[y-1][x]) y -= 1;
					break;
			}
		}
		System.out.print((x-2000) + " " + (y-2000));
	}
}