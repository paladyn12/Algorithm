import java.util.*;
import java.io.*;

class Edge {
    int from;
    int to;
    int cost;
    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

class Q1865_BellmanFord {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (TC-- > 0) {
            //------------------------------------------------------
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int[] distance = new int[N + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            
            ArrayList<Edge> edges = new ArrayList<>();
            
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, t));
                edges.add(new Edge(e, s, t));
            }
            
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, (-1) * t));
            }

            // 임의의 0번 노드에서 모든 노드로 이동하는 임의의 간선 생성
            // N 번의 edge relaxing 후에도 0번 노드와 관련해 값 초기화가 일어나면 어떤 노드는 음의 cycle을 가지는 것
            distance[0] = 0;
            for (int i = 1; i <= N; i++) {
                edges.add(new Edge(0, i, 0));
            }
            
            // N 번 edge relaxing (원래 Bellman-Ford는 N - 1 이지만 임의의 노드 0을 추가했으므로)
            for (int i = 0; i < N; i++) {
                for (Edge edge : edges) {
                    if (distance[edge.from] != Integer.MAX_VALUE &&
                       distance[edge.to] > distance[edge.from] + edge.cost) {
                        distance[edge.to] = distance[edge.from] + edge.cost;
                       }
                }
            }

            // 만약 이번 edge relaxing에서도 최소값 초기화가 일어난다면 이는 음의 가중치로 이루어진 cycle이 있음을 의미
            boolean hasNegativeCycle = false;

            for (Edge edge : edges) {
                if (distance[edge.from] != Integer.MAX_VALUE &&
                    distance[edge.to] > distance[edge.from] + edge.cost) {
                    hasNegativeCycle = true;
                    break;
                }
            }
            
            if (hasNegativeCycle) sb.append("YES\n");
            else sb.append("NO\n");
            //------------------------------------------------------
        }
        System.out.print(sb);
    }
}
