import java.util.*;
import java.io.*;

class Node {
    int to;
    int cost;
    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

class Q1967_DFS {

    static int N;
    static ArrayList<Node>[] graph;
    static boolean[] visit;
    static int result = 0;
    static int maxIdx = 0;
    static int maxCost = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if (N == 1) System.out.print(0);
        else {
            int[] distance = new int[N + 1];
    
            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
        
            StringTokenizer st;
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                graph[s].add(new Node(e, w));
                graph[e].add(new Node(s, w));
            }

            for (int i = 1; i <= N; i++) {
                if (distance[i] > maxCost) {
                    maxIdx = i;
                    maxCost = distance[i];
                }
            }

            visit = new boolean[N + 1];
            visit[1] = true;
            dfs(1, 0);

            visit = new boolean[N + 1];
            visit[maxIdx] = true;
            dfs(maxIdx, 0);
        
            System.out.print(maxCost);
            
        }
    }

    static void dfs(int idx, int currentSum) {
        if (maxCost < currentSum) {
            maxCost = currentSum;
            maxIdx = idx;
        }

        for (Node node : graph[idx]) {
            if (!visit[node.to]) {
                visit[node.to] = true;
                dfs(node.to, currentSum + node.cost);
                visit[node.to] = false;
            }
        }
    }
}
