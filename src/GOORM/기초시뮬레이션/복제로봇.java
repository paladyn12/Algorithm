package GOORM.기초시뮬레이션;

import java.io.*;
import java.util.*;

class 복제로봇 {
	static int x;
	static int y;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int[] px = new int[N];
		int[] py = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			px[i] = Integer.parseInt(st.nextToken());
			py[i] = Integer.parseInt(st.nextToken());
		}
		
		int Q = Integer.parseInt(br.readLine());
		String[] LRUDs = br.readLine().split(" ");
		for (int i = 0; i < Q; i++) {
			String LRUD = LRUDs[i];
			int next_x = x;
			int next_y = y;
			
			if (LRUD.equals("U")) {
				next_y = y+1;
			} else if (LRUD.equals("D")) {
				next_y = y-1;
			} else if (LRUD.equals("L")) {
				next_x = x-1;
			} else if (LRUD.equals("R")) {
				next_x = x+1;
			}
			
			boolean flag = true;
			for (int j = 0; j < N; j++) {
				if (px[j] == next_x && py[j] == next_y) {
					flag = false;
					break;
				}
			}
			if (flag) {
				x = next_x;
				y = next_y;
			}
		}
		
		System.out.print(x + " " + y);
	}
}