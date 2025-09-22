import java.io.*;
import java.util.*;

public class Q16156_Dijkstra {

    // 어떤 도착점(startRow)에서 출발했는지 기록하기 위한 필드 추가
    static class Node implements Comparable<Node> {
        int r, c, cost, startRow;

        public Node(int r, int c, int cost, int startRow) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.startRow = startRow;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] distance = new int[N][M]; // 각 칸까지의 최단 거리
        int[][] optimalDest = new int[N][M]; // 각 칸에 최단 경로를 제공한 도착점의 행(row)
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            distance[i][M - 1] = map[i][M - 1];
            optimalDest[i][M - 1] = i;
            pq.offer(new Node(i, M - 1, distance[i][M - 1], i));
        }

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.cost > distance[current.r][current.c]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    int nextCost = current.cost + map[nr][nc];

                    if (distance[nr][nc] > nextCost) {
                        distance[nr][nc] = nextCost;
                        optimalDest[nr][nc] = current.startRow;
                        pq.offer(new Node(nr, nc, distance[nr][nc], current.startRow));
                    }
                }
            }
        }
        
        int[] water = new int[N];
        for (int i = 0; i < N; i++) {
            int destRow = optimalDest[i][0];
            water[destRow]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int count : water) {
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
