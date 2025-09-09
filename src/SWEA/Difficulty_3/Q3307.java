import java.io.*;
import java.util.*;

public class Q3307 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[N];
            dp[0] = 1;
            for (int i = 1; i < N; i++) {
                dp[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[i] >= arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < N; i++) {
                ans = Math.max(ans, dp[i]);
            }
            
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
