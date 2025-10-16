import java.util.*;
import java.io.*;

class Q10942_다이나믹프로그래밍 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());
        
        boolean[][] dp = new boolean[N + 1][N + 1];
        for (int i = 0; i <= N; i++) for (int j = 0; j <= N; j++) if (i >= j) dp[i][j] = true;
        
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                dp[j][i] = (dp[j + 1][i - 1] && nums[i] == nums[j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(dp[S][E] ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }
}
