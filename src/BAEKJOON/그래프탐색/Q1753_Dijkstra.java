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

class Q1753_Dijkstra {

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start_node = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        // 시작 노드로부터의 거리를 저장할 distance 배열
        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Node 들을 가중치가 낮은 순으로 정렬
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        // 시작 node를 넣고 탐색 시작
        pq.offer(new Node(start_node, 0));
        distance[start_node] = 0;
        while (!pq.isEmpty()) {

            // pq에서 가중치가 가장 낮은 Node poll
            Node curNode = pq.poll();

            // 꺼내진 Node는 이미 현재 최소 비용을 갖는 Node (Dijkstra Algorithm)
            // 즉, 현재 꺼낸 Node의 비용이 distance 배열에 들어가있는 값보다 크다면 Skip
            if (curNode.cost > distance[curNode.idx]) continue;

            // 현재 Node와 이어진 Node들을 탐색
            // 현재 Node를 거쳐 가는 거리가 기존에 저장된 거리보다 짧다면 초기화 후 offer
            for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
				Node nextNode = graph.get(curNode.idx).get(i);
                if (curNode.cost + nextNode.cost < distance[nextNode.idx]) {
                    distance[nextNode.idx] = distance[curNode.idx] + nextNode.cost;
                    pq.offer(new Node(nextNode.idx, distance[nextNode.idx]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                sb.append("INF\n");
            else
                sb.append(distance[i]).append("\n");
        }
        
        System.out.print(sb);   
    }
}