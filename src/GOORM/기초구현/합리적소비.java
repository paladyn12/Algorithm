package GOORM.기초구현;

import java.io.*;
import java.util.*;
class 합리적소비 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] Ss = new String[T];
		int i = 0;
		StringTokenizer st;
		int maxIdx = -1;
		int minIdx = -1;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			Ss[i] = st.nextToken();
			int p = Integer.parseInt(st.nextToken());
			if (p > max) {
				maxIdx = i;
				max = p;
			}
			if (p < min) {
				minIdx = i;
				min = p;
			}
			i++;
		}
		System.out.println(Ss[maxIdx] + " " + max);
		System.out.println(Ss[minIdx] + " " + min);
	}
}