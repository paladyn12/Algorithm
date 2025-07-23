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

class Q1167_DFS {

    static int N;
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visit;

    static int maxIdx = 0;
    static long maxCost = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int node_number = Integer.parseInt(st.nextToken());
            while (true) {
                int idx = Integer.parseInt(st.nextToken());
                if (idx == -1) break;

                int cost = Integer.parseInt(st.nextToken());
                graph.get(node_number).add(new Node(idx, cost));
            }
        }

        visit = new boolean[N + 1];
        visit[1] = true;
        dfs(1, 0);

        visit = new boolean[N + 1];
        maxCost = 0;
        visit[maxIdx] = true;
        dfs(maxIdx, 0);

        System.out.print(maxCost);
    }

    static void dfs(int idx, long currentValue) {
        if (maxCost < currentValue) {
            maxCost = currentValue;
            maxIdx = idx;
        }

        for (int i = 0; i < graph.get(idx).size(); i++) {
            Node next = graph.get(idx).get(i);
            if (!visit[next.idx]) {
                visit[next.idx] = true;
                dfs(next.idx, currentValue + next.cost);
            }
        }
    }
}
