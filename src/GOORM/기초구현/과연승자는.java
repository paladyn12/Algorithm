package GOORM.기초구현;

import java.io.*;
import java.util.*;

class 과연승자는 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		int scoreA = 0;
		int scoreB = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			if (A[i] > B[i]) {
				if (A[i] - B[i] == 7) {
					scoreA -= 1;
					scoreB += 3;
				} else {
					scoreA += 2;
				}
			}
			else if (B[i] > A[i]) {
				if (B[i] - A[i] == 7) {
				scoreB -= 1;
				scoreA += 3;
				} else {
				scoreB += 2;
				}
			}
			else {
				scoreA++;
				scoreB++;
			}
		}
		System.out.print(scoreA + " " + scoreB);
	}
}