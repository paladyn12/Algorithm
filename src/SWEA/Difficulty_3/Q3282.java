import java.io.*;
import java.util.*;

public class Q3282 {

    static int N;
    static int K;
    static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
        
		for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            arr = new int[N + 1][2];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[2][K + 1];
            for (int i = 1; i <= K; i++) {
                if (arr[1][0] <= i) dp[1][i] = arr[1][1];
            }
            for (int i = 2; i <= N; i++) {
                int curRow = i % 2;
                int prevRow = (i - 1) % 2;
                for (int j = 1; j <= K; j++) {
                    if (arr[i][0] <= j) {
                        dp[curRow][j] = Math.max(arr[i][1] + dp[prevRow][j - arr[i][0]], dp[prevRow][j]);
                    } else {
                        dp[curRow][j] = dp[prevRow][j];
                    }
                }
            }
			
			sb.append("#").append(test_case).append(" ").append(dp[N%2][K]).append("\n");
		}
		System.out.print(sb);
	}
}
