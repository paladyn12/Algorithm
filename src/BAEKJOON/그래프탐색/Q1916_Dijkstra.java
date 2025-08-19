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
        return cost - o.cost;
    }
}

class Q1916_Dijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, w));
        }

        st = new StringTokenizer(br.readLine());
        int start_node = Integer.parseInt(st.nextToken());
        int end_node = Integer.parseInt(st.nextToken());

        int[] visit = new int[N + 1];
        Arrays.fill(visit, Integer.MAX_VALUE);

        visit[start_node] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start_node, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visit[cur.idx] < cur.cost) continue;
            for (int i = 0; i < graph.get(cur.idx).size(); i++) {
                Node next = graph.get(cur.idx).get(i);
                if (visit[next.idx] > cur.cost + next.cost) {
                    visit[next.idx] = cur.cost + next.cost;
                    pq.offer(new Node(next.idx, visit[next.idx]));
                }
            }
        }

        System.out.print(visit[end_node]);
    }
}
