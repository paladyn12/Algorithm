import java.io.*;
import java.util.*;

public class Q2805_이분탐색 {

    static int N;
    static int M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        long left = 0;
        long right = 2000000000;
        long mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) sum += trees[i] - mid;
            }
            if (sum >= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.print((left + right) / 2);
    }
}
