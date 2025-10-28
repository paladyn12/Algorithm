import java.io.*;
import java.util.*;

public class Q16946_BFS {

    static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Node o = (Node) obj;
            return (x == o.x && y == o.y);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y); 
        }
    }

    static int[][] map;
    static int[][] ans;
    static boolean[][] visit;
    static int N;
    static int M;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        ans = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
                ans[i][j] = input.charAt(j) - '0';
            }
        }
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visit[i][j]) {
                    bfs(i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(ans[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int x, int y) {
        visit[x][y] = true;
        int size = 1;
        HashSet<Node> increasePosition = new HashSet<>();
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.addLast(new Node(x, y));

        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (map[nx][ny] == 1) {
                    increasePosition.add(new Node(nx, ny));
                } else if (map[nx][ny] == 0 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    size++;
                    dq.addLast(new Node(nx, ny));
                }
            }
        }

        for (Node pos : increasePosition) {
            ans[pos.x][pos.y] += size;
            ans[pos.x][pos.y] %= 10;
        }
    }
}
