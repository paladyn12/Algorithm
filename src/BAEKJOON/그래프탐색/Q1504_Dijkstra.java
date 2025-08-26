import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int idx;
    int cost;
    
    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    public int compareTo(Node o) {
        return Integer.compare(cost, o.cost);
    }
}

class Q1504_Dijkstra {

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] distance;
    static int N;
    static int E;

    static int v1;
    static int v2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int ans1_1 = dijkstra(1, v1);
        int ans1_2 = dijkstra(v1, v2);
        int ans1_3 = dijkstra(v2, N);

        int ans2_1 = dijkstra(1, v2);
        int ans2_2 = dijkstra(v2, v1);
        int ans2_3 = dijkstra(v1, N);

        if (ans1_1 == Integer.MAX_VALUE || ans1_2 == Integer.MAX_VALUE || ans1_3 == Integer.MAX_VALUE) {
            if (ans2_1 == Integer.MAX_VALUE || ans2_2 == Integer.MAX_VALUE || ans2_3 == Integer.MAX_VALUE) {
                System.out.print(-1);
            } else {
                System.out.print(ans2_1 + ans2_2 + ans2_3);
            }
        } else {
            if (ans2_1 == Integer.MAX_VALUE || ans2_2 == Integer.MAX_VALUE || ans2_3 == Integer.MAX_VALUE) {
                System.out.print(ans1_1 + ans1_2 + ans1_3);
            } else {
                System.out.print(Math.min(ans1_1 + ans1_2 + ans1_3, ans2_1 + ans2_2 + ans2_3));
            }
        }
    }

    static int dijkstra(int start, int end) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (distance[cur.idx] < cur.cost) continue;
            for (Node next : graph.get(cur.idx)) {
                if (distance[next.idx] > cur.cost + next.cost) {
                    distance[next.idx] = cur.cost + next.cost;
                    pq.offer(new Node(next.idx, distance[next.idx]));
                }
            }
        }
        return distance[end];
    }
}
