import java.util.*;
import java.io.*;

class Q3124 {

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;
        
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        // 가중치 오름차순
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }

    static Edge[] edgeList;
    static int[] parent;
    static int V, E;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            parent = new int[V + 1];
            edgeList = new Edge[E];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edgeList[i] = new Edge(from, to, weight);
            }
        
            Arrays.sort(edgeList);
            make();
    
            int cnt = 0;
            long ans = 0;
            for (Edge edge : edgeList) {
                if (!union(edge.from, edge.to)) continue; // union 실패
                ans += edge.weight;
                cnt++;
                if (cnt == V - 1) break;
            }

            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static void make() {
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false; // union 불가

        // 한 쪽으로 치우치는 걸 방지하는 요소
        if (rootA > rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
        return true;
    }
}
