import java.util.*;
import java.io.*;

class Q4796 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {

            int N = sc.nextInt();
            int[] H = new int[N];

            for (int i = 0; i < N; i++) {
                H[i] = sc.nextInt();
            }

            int[] dp = new int[N];
            int cnt = 0;
            boolean rising = H[1] > H[0];
            for (int i = 1; i < N; i++) {
                int current = H[i];
                int before = H[i - 1];
                if (before < current) {
                    dp[i] = dp[i - 1];
                    if (!rising) {
                        rising = true;
                        cnt = 1;
                    }
                    else cnt++;
                }
                if (before > current) {
                    if (rising) rising = false;
                    dp[i] = dp[i - 1] + cnt;
                }
            }

            sb.append("#").append(test_case).append(" ").append(dp[N - 1]).append("\n");
        }
        System.out.print(sb);
    }
}
