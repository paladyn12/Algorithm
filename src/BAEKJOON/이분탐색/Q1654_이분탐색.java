import java.io.*;
import java.util.*;

public class Q1654_이분탐색 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

        int[] lines = new int[K];
        long sum = 0;
        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            lines[i] = n;
            sum += n;
        }
        sum /= N;
        long left = 1;
        long right = sum;
        while (left <= right) {
            
            long mid = (left + right) / 2;
            int cnt = 0;
            for (int j = 0; j < K; j++) {
                cnt += lines[j] / mid;
            }
            if (cnt >= N) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.print((left + right) / 2);
    }
}
