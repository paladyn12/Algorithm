import java.io.*;
import java.util.*;

public class Q10830_BFS {

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        st = new StringTokenizer(br.readLine());
        Node start = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        Node end = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        int[][] distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], -1);
        }

        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.addLast(start);
        distance[start.x][start.y] = 0;

        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();

            if (cur.x == end.x && cur.y == end.y) {
                System.out.print(distance[end.x][end.y]);
                return;
            }

            for (int d = 0; d < 4; d++) {
                for (int k = 1; k <= K; k++) {
                    int nx = cur.x + dx[d] * k;
                    int ny = cur.y + dy[d] * k;

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == '#') {
                        break;
                    }
                    
                    if (distance[nx][ny] != -1) {
                        if (distance[nx][ny] <= distance[cur.x][cur.y]) {
                             break;
                        }
                        continue;
                    }

                    distance[nx][ny] = distance[cur.x][cur.y] + 1;
                    dq.addLast(new Node(nx, ny));
                }
            }
        }

        System.out.print(distance[end.x][end.y]);
    }
}
