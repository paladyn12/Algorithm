import java.util.*;
import java.io.*;

class Q1647_최소스패닝트리 {

    static class Road implements Comparable<Road> {
        int from;
        int to;
        int cost;
        
        public Road(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Road o) {
            return Integer.compare(cost, o.cost);
        }
    }

    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        PriorityQueue<Road> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new Road(from, to, cost));
        }

        int cnt = 0;
        int ans = 0;
        int lastCost = 0;
        while (cnt != N - 1) {
            Road cur = pq.poll();
            if (union(cur.from, cur.to)) {
                ans += cur.cost;
                cnt++;
                lastCost = cur.cost;
            }
        }
        System.out.print(ans - lastCost);
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
            parent[rootB] = rootA;
            return true;
        }
    }
}
