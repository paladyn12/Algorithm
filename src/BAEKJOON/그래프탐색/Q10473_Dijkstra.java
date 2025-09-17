import java.io.*;
import java.util.*;

public class Q10473_Dijkstra {

    static class Node implements Comparable<Node> {
        int idx;
        double cost;
        public Node(int idx, double cost) {
            this.idx = idx;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return Double.compare(cost, o.cost);
        }
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        StringTokenizer st = new StringTokenizer(br.readLine());
        double startX = Double.parseDouble(st.nextToken());
        double startY = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double endX = Double.parseDouble(st.nextToken());
        double endY = Double.parseDouble(st.nextToken());
        
        int N = Integer.parseInt(br.readLine());
        double[] Xs = new double[N + 2];
        double[] Ys = new double[N + 2];
        Xs[0] = startX;
        Ys[0] = startY;
        Xs[N + 1] = endX;
        Ys[N + 1] = endY;
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            Xs[i] = Double.parseDouble(st.nextToken());
            Ys[i] = Double.parseDouble(st.nextToken());
        }

        double[][] cost = new double[N + 2][N + 2];
        for (int i = 0; i <= N + 1; i++) {
            for (int j = 0; j <= N + 1; j++) {
                if (i == j) continue;
                
                double distance = getDistance(Xs[i], Xs[j], Ys[i], Ys[j]);
                if (i == 0) {
                    cost[i][j] = distance / 5;
                } else {
                    double walk = distance / 5;
                    double jump = 2 + Math.abs(50 - distance) / 5;
                    cost[i][j] = Math.min(walk, jump);
                }
            }
        }

        double distance[] = new double[N + 2];
        Arrays.fill(distance, Double.MAX_VALUE);
        distance[0] = 0.0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > distance[cur.idx]) continue;

            for (int i = 0; i <= N + 1; i++) {
                if (i == cur.idx) continue;
                if (distance[i] > cur.cost + cost[cur.idx][i]) {
                    distance[i] = cur.cost + cost[cur.idx][i];
                    pq.offer(new Node(i, distance[i]));
                }
            }
        }
        System.out.print(distance[N + 1]);
    }

    static double getDistance(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}

