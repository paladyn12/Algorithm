import java.io.*;
import java.util.*;

class Q11779_Dijkstra {

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

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        Node[] trace = new Node[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(s, e, c));
        }

        
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(-1, start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (distance[cur.to] < cur.cost) continue;
            trace[cur.to] = cur;
            for (Node next : graph.get(cur.to)) {
                if (distance[next.to] > cur.cost + next.cost) {
                    distance[next.to] = cur.cost + next.cost;
                    pq.offer(new Node(cur.to, next.to, distance[next.to]));
                }
            }
        }
        
        sb.append(distance[end]).append("\n");
        find(trace, start, end, 0);

        System.out.print(sb);
        
    }

    static void find(Node[] trace, int start, int idx, int cnt) {
        if (trace[idx].to != start) {
            find(trace, start, trace[idx].from, cnt + 1);
        } else {
        	sb.append(cnt + 1).append("\n");
        }
        sb.append(idx).append(" ");
    }
    
}
