import java.util.*;
import java.io.*;

class Q1106_다이나믹프로그래밍 {

    static class Node {
        int cost;
        int customer;
        public Node(int cost, int customer) {
            this.cost = cost;
            this.customer = customer;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Node[] w = new Node[N];
        int maxCustomer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            w[i] = new Node(cost, customer);
        }

        int[] dp = new int[C + 100 + 1];
        Arrays.fill(dp, 1000000000);
        dp[0] = 0;
        for (int i = 1; i <= C + 100; i++) {
            for (int j = 0; j < N; j++) {
                Node cur = w[j];
                if (i >= cur.customer) {
                    dp[i] = Math.min(dp[i], dp[i - cur.customer] + cur.cost);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = C; i <= C + 100; i++) {
            ans = Math.min(ans, dp[i]);
        }

        System.out.print(ans);
    }
}
