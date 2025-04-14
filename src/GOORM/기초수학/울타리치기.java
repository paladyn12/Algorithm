package GOORM.기초수학;

import java.io.*;
import java.util.*;
class 울타리치기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		System.out.print(logic(A));
	}

	static int logic(int[] array) {
		int sum = 1 + 1 + array[0];
		int before = array[0];
		for (int i = 1; i < array.length; i++) {
			sum += 2;
			sum += Math.abs(array[i] - before);
			before = array[i];
		}
		sum += array[array.length-1];
		return sum;
	}
}