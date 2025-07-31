import java.util.*;
import java.io.*;

class Node {
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}

class Q1238_Dijkstra {

    static int N;
    static int M;
    static int X;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] fromX;
    static int[] toX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, t));
        }

        fromX = new int[N + 1];
        Arrays.fill(fromX, Integer.MAX_VALUE);

        getFromX();
        
        toX = new int[N + 1];
        Arrays.fill(toX, Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            toX[i] = getToX(i);
        }

        int maxDistance = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            maxDistance = Math.max(maxDistance, toX[i] + fromX[i]);
        }

        System.out.print(maxDistance);
    }

    static void getFromX() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        fromX[X] = 0;
        pq.offer(new Node(X, 0));
        while (!pq.isEmpty()) {

            Node cur = pq.poll();
            if (fromX[cur.idx] < cur.cost) continue;
            
            for (int i = 0; i < graph.get(cur.idx).size(); i++) {
                Node next = graph.get(cur.idx).get(i);
                if (fromX[next.idx] > cur.cost + next.cost) {
                    fromX[next.idx] = cur.cost + next.cost;
                    pq.offer(new Node(next.idx, cur.cost + next.cost));
                }
            }
        }
    }

    static int getToX(int index) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[index] = 0;
        
        pq.offer(new Node(index, 0));
        while (!pq.isEmpty()) {

            Node cur = pq.poll();
            if (distance[cur.idx] < cur.cost) continue;
            
            for (int i = 0; i < graph.get(cur.idx).size(); i++) {
                Node next = graph.get(cur.idx).get(i);
                if (distance[next.idx] > cur.cost + next.cost) {
                    distance[next.idx] = cur.cost + next.cost;
                    pq.offer(new Node(next.idx, cur.cost + next.cost));
                }
            }
        }
        return distance[X];
    }
}
