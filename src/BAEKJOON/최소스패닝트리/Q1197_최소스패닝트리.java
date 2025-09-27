import java.util.*;
import java.io.*;

class Q1197_최소스패닝트리 {

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int cost;
        
        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }

    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) parent[i] = i;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.offer(new Node(A, B, C));
        }

        int cnt = 0;
        long result = 0;
        while (cnt < V - 1) {
            Node cur = pq.poll();
            if (union(cur.from, cur.to)) {
                cnt++;
                result += cur.cost;
            }
        }

        System.out.print(result);
    }

    static int find(int a) {
        if (a != parent[a]) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        else {
            parent[rootA] = parent[rootB];
            return true;
        }
    }
}
