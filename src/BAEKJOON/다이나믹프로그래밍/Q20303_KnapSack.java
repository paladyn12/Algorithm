import java.io.*;
import java.util.*;

public class Q20303_KnapSack {

    static class Node {
        int size;
        int candy;
        public Node(int size, int candy) {
            this.size = size;
            this.candy = candy;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] child = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) child[i] = Integer.parseInt(st.nextToken());
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        ArrayList<Node> nodes = new ArrayList<>();
        boolean[] visit = new boolean[N + 1];
        ArrayDeque<Integer> dq;
        
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                Node node = new Node(1, child[i]);
                visit[i] = true;
                dq = new ArrayDeque<>();
                dq.addLast(i);
                
                while (!dq.isEmpty()) {
                    int cur = dq.pollFirst();
                    for (int next : graph.get(cur)) {
                        if (!visit[next]) {
                            visit[next] = true;
                            node.size++;
                            node.candy += child[next];
                            dq.addLast(next);
                        }
                    }
                }

                nodes.add(node);
            }
        }

        int[][] dp = new int[2][K + 1];
        
        Node n = nodes.get(0);
        for (int i = 0; i <= K; i++) {
            if (i >= n.size) dp[0][i] = n.candy;
        }

        for (int i = 1; i < nodes.size(); i++) {
            n = nodes.get(i);
            for (int j = 0; j <= K; j++) {
                if (j >= n.size) {
                    dp[i % 2][j] = Math.max(dp[(i + 1) % 2][j - n.size] + n.candy, dp[(i + 1) % 2][j]);
                } else {
                    dp[i % 2][j] = dp[(i + 1) % 2][j];
                }
            }
        }
        System.out.print(Math.max(dp[0][K - 1], dp[1][K - 1]));
    }
}
